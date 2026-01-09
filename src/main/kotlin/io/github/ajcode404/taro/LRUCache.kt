package io.github.ajcode404.taro

import java.util.Arrays
import java.util.Stack

data class DoublyLinkedNode(
    var key: Int? = null,
    var data: Int? = null,
    var prevNode: DoublyLinkedNode? = null,
    var nextNode: DoublyLinkedNode? = null
)

class LRUCache(capacity: Int) {
    private val _capacity: Int = capacity
    private val map = mutableMapOf<Int, DoublyLinkedNode>()
    private var headNode: DoublyLinkedNode? = DoublyLinkedNode()
    private var tailNode: DoublyLinkedNode? = DoublyLinkedNode()

    init {
        this.headNode?.nextNode = this.tailNode
        this.tailNode?.prevNode = this.headNode
    }


    fun put(key: Int, value: Int) {
        val node = map[key]
        if (node != null) {
            node.data = value
            moveToFront(node)
        }
    }

    private fun moveToFront(node: DoublyLinkedNode) {
        removeNode(node)
        addToFront(node)
    }

    private fun addToFront(node: DoublyLinkedNode) {
        val currentHead = headNode
        currentHead?.prevNode = node
        node.nextNode = currentHead
        node.prevNode = null
        headNode = node
    }

    // null <- 1 <-> 2 <-> 3 <-> null
    //               |
    private fun removeNode(node: DoublyLinkedNode) {
        val prevNode = node.prevNode
    }

    fun get(key: Int): Int {

        return -1
    }

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * var obj = LRUCache(capacity)
 * var param_1 = obj.get(key)
 * obj.put(key,value)
 */