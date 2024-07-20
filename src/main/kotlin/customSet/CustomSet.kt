package customSet

private class Node(val value: Int, val next: Node? = null)

class CustomSet(vararg elements: Int) : Iterable<Int> {
    private val size = 1_000
    private val data = arrayOfNulls<Node?>(size)

    init {
        for (element in elements) {
            add(element)
        }
    }

    fun isEmpty(): Boolean {
        return data.all { it == null }
    }

    fun isSubset(other: CustomSet): Boolean {
        return this.all(other::contains)
    }

    fun isDisjoint(other: CustomSet): Boolean {
        return this.none(other::contains)
    }

    fun contains(other: Int): Boolean {
        val hash = other.mod(size)
        var node = data[hash]

        while (node != null) {
            if (node.value == other) return true
            node = node.next
        }

        return false
    }

    fun intersection(other: CustomSet): CustomSet {
        val newSet = CustomSet()

        for (value in this) {
            if (other.contains(value)) newSet.add(value)
        }

        return newSet
    }

    fun add(other: Int) {
        if (contains(other)) return

        val hash = other.mod(size)
        data[hash] = Node(other, data[hash])
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is CustomSet) return false
        if (this.isEmpty() xor other.isEmpty()) return false

        return this.isSubset(other) && other.isSubset(this)
    }

    operator fun plus(other: CustomSet): CustomSet {
        val newSet = CustomSet()

        for (element in this) {
            newSet.add(element)
        }

        for (element in other) {
            newSet.add(element)
        }

        return newSet
    }

    operator fun minus(other: CustomSet): CustomSet {
        val newSet = CustomSet()

        for (element in this) {
            if (!other.contains(element)) newSet.add(element)
        }

        return newSet
    }

    override fun iterator() = object : Iterator<Int> {
        var chainIndex = 0
        var node = data[chainIndex]

        init {
            if (node == null) toNextNode()
        }

        private fun toNextNode() {
            if (node != null) node = node?.next

            while (node == null && ++chainIndex < size) {
                node = data[chainIndex]
            }
        }

        override fun hasNext() = node != null

        override fun next(): Int {
            val value = node?.value ?: throw NoSuchElementException()
            toNextNode()
            return value
        }
    }
}
