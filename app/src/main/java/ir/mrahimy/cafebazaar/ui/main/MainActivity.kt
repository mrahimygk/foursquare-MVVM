package ir.mrahimy.cafebazaar.ui.main

import android.Manifest
import android.location.Location
import android.os.Looper
import androidx.lifecycle.Observer
import com.google.android.gms.location.*
import com.google.android.material.snackbar.Snackbar
import ir.mrahimy.cafebazaar.R
import ir.mrahimy.cafebazaar.base.BaseActivity
import ir.mrahimy.cafebazaar.databinding.ActivityMainBinding
import ir.mrahimy.cafebazaar.helper.EventObserver
import ir.mrahimy.cafebazaar.network.ConnectionLiveData
import ir.mrahimy.cafebazaar.ui.details.DetailsActivity
import ir.mrahimy.cafebazaar.util.PagedRecyclerViewScrollListener
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import permissions.dispatcher.NeedsPermission
import permissions.dispatcher.RuntimePermissions

@RuntimePermissions
class MainActivity : BaseActivity<MainViewModel, ActivityMainBinding>() {

    override val layoutRes = R.layout.activity_main

    override val vm: MainViewModel by viewModel()

    private val venuesAdapter: VenuesAdapter by inject()
    private var lastLocation: Location? = null
    private var lastUpdatedLocation: Location? = null
    private lateinit var fusedLocationClient: FusedLocationProviderClient

    private lateinit var locationCallback: LocationCallback

    override fun bindObservables() {
        vm.onStartDetailsActivity.observe(this, EventObserver {
            DetailsActivity.startMe(this, it)
        })

        vm.snackMessage.observe(this, EventObserver {
            Snackbar.make(view, it, Snackbar.LENGTH_LONG).show()
        })

        ConnectionLiveData.observe(this, Observer {
            if (it.isConnected) {
                updateLocation()
            }
        })
    }

    private fun updateLocation() {
        /**
         * A trick part: we want to remove previous location's fetched data
         * But not right now, we wait until there is a good response from api
         * then we clear the local db
         */
        if (lastLocation == null) return
        if (lastUpdatedLocation == null) return

        lastLocation?.let { lastLoc ->
            val shouldUpdate = if (lastLoc.distanceTo(lastUpdatedLocation) > 100.0f) {
                lastLocation = lastUpdatedLocation
                true
            } else false

            if (shouldUpdate) vm.syncVenueList(0, lastLocation, true)
        }
    }

    override fun configCreationEvents() {
        venueList?.run {
            adapter = venuesAdapter
            layoutManager?.let {
                addOnScrollListener(object : PagedRecyclerViewScrollListener(it) {
                    override fun onLoadMore(page: Int) {
                        vm.syncVenueList(page, lastLocation)
                    }
                })
            }
            venuesAdapter.onClick = { item, _ ->
                vm.selectVenue(item)
            }
        }

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
        setupLocationRequestWithPermissionCheck()

        locationCallback = object : LocationCallback() {
            override fun onLocationResult(locationResult: LocationResult?) {
                super.onLocationResult(locationResult)
                locationResult ?: return
                lastUpdatedLocation = locationResult.lastLocation
                updateLocation()
            }
        }
    }

    @NeedsPermission(
        Manifest.permission.ACCESS_FINE_LOCATION,
        Manifest.permission.ACCESS_COARSE_LOCATION
    )
    fun setupLocationRequest() {
        fusedLocationClient.lastLocation
            .addOnSuccessListener { location: Location? ->
                lastLocation = location
                vm.syncVenueList(0, lastLocation)
            }
    }

    override fun configResumeEvents() {
        startLocationUpdates()
    }

    private fun startLocationUpdates() {
        fusedLocationClient.requestLocationUpdates(
            vm.getLocationRequest(),
            locationCallback,
            Looper.getMainLooper()
        )
    }

    override fun initBinding() {
        binding.apply {
            lifecycleOwner = this@MainActivity
            vm = this@MainActivity.vm
            executePendingBindings()
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        onRequestPermissionsResult(requestCode, grantResults)
    }
}
