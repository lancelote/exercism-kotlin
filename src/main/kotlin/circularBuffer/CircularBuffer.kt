package circularBuffer

import kotlin.collections.ArrayDeque

class EmptyBufferException : Exception()

class BufferFullException : Exception()

class CircularBuffer<T>(private val capacity: Int) {
    private val data = ArrayDeque<T>(capacity)

    fun read(): T = data.removeFirstOrNull() ?: throw EmptyBufferException()

    fun write(value: T) {
        if (data.size == capacity) throw BufferFullException()
        data.addLast(value)
    }

    fun overwrite(value: T) {
        if (data.size == capacity) data.removeFirst()
        write(value)
    }

    fun clear() {
        data.clear()
    }
}
