package io.github.ajcode404.taro

class DoublyLinkedNode(
    var key: Int? = null,
    var data: Int? = null,
    var prevNode: DoublyLinkedNode? = null,
    var nextNode: DoublyLinkedNode? = null
)

class LRUCache(capacity: Int) {
    private val _capacity: Int = capacity
    private val map = mutableMapOf<Int, DoublyLinkedNode>()
    private var headNode: DoublyLinkedNode? = null
    private var tailNode: DoublyLinkedNode? = null

    init {
        headNode = DoublyLinkedNode()
        tailNode = DoublyLinkedNode()
        headNode?.nextNode = tailNode
        tailNode?.prevNode = headNode
    }

    fun put(key: Int, value: Int) {
        // key already exist
        val existingData = map[key]
        if (existingData != null) {
            removeFromLinkedList(existingData)
            existingData.data = value
            addToTheFront(existingData)
            return
        }
        // if new entry
        if (map.size >= _capacity) {
            evictLeastRecentlyUsed()
        }
        val node = DoublyLinkedNode(
            key = key,
            data = value,
            prevNode = null,
            nextNode = null
        )
        addToTheFront(node)
        map.put(key, node)
        println(map)
    }

    fun get(key: Int): Int {
        val value = map[key]
        if (value == null) {
            return -1
        }
        // move to the front
        removeFromLinkedList(value)
        addToTheFront(value)
        return value.data!!
    }

    private fun addToTheFront(node: DoublyLinkedNode) {
        // moving to linked list
        val next = headNode?.nextNode
        headNode?.nextNode = node
        node.nextNode = next
        node.prevNode = headNode
        next?.prevNode = node
    }

    private fun removeFromLinkedList(node: DoublyLinkedNode) {
        // remove from linked list
        val next = node.nextNode
        val prev = node.prevNode
        node.nextNode = null
        node.prevNode = null
        next?.prevNode = prev
        prev?.nextNode = next
    }

    private fun evictLeastRecentlyUsed() {
        val node = tailNode?.prevNode!!
        removeFromLinkedList(node)
        map.remove(node.key)
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * var obj = LRUCache(capacity)
 * var param_1 = obj.get(key)
 * obj.put(key,value)
 */

fun main() {
    //[[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]
    // [[2],[2],[2,6],[1],[1,5],[1,2],[1],[2]]


    val cache = LRUCache(2)
    cache.get(2)
    cache.put(2, 6)
    cache.get(1)
    cache.put(1, 5)
    cache.put(1, 2)
    cache.get(1)
}
