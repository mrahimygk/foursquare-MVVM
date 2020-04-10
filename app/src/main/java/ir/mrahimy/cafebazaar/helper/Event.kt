package ir.mrahimy.cafebazaar.helper

import androidx.lifecycle.Observer

open class Event<out T>(private val content: T) {
    private var isConsumed = false

    fun consume(): T? {
        return if (isConsumed) null
        else {
            isConsumed = true
            content
        }
    }

    fun peek(): T = content

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Event<*>

        if (content != other.content) return false
        if (isConsumed != other.isConsumed) return false

        return true
    }

    override fun hashCode(): Int {
        var result = content?.hashCode() ?: 0
        result = 31 * result + isConsumed.hashCode()
        return result
    }
}

class StatelessEvent : Event<Any>(0)

class EventObserver<T>(private val onContentUnconsumed: (T) -> Unit) : Observer<Event<T>> {
    override fun onChanged(event: Event<T>?) {
        event?.consume()?.run(onContentUnconsumed)
    }
}