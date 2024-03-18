// taken (with slight changes) from:
// https://github.com/trekhleb/javascript-algorithms/blob/master/src/data-structures/linked-list/LinkedList.js

class LinkedListNode {
    constructor(value, next = null) {
        this.value = value
        this.next = next
    }
}

class LinkedList {
    constructor() {
        this.head = null
        this.tail = null
    }
    prepend(value) {
        const newNode = new LinkedListNode(value, this.head)
        this.head = newNode
        if (!this.tail) {
            this.tail = newNode
        }
        return this
    }

    append(value) {
        const newNode = new LinkedListNode(value)
        if (!this.head) {
            this.head = newNode
            this.tail = newNode
        } else {
            this.tail.next = newNode
            this.tail = newNode
        }
        return this
    }

    insert(value, rawIndex) {
        const index = rawIndex < 0 ? 0 : rawIndex
        if (index < 0) {
            return this.prepend(value)
        }
        let count = 1
        let currentNode = this.head
        const newNode = new LinkedListNode(value)
        while (currentNode) {
            if (count === index) break
            currentNode = currentNode.next
            count++
        }
        if (currentNode) {
            newNode.next = currentNode.next
            currentNode.next = newNode
        } else {
            if (this.tail) {
                this.tail.next = newNode
                this.tail = newNode
            } else {
                this.head = newNode
                this.tail = newNode
            }
        }
        return this
    }

    delete(value) {
        if (!this.head) return null
        let deletedNode = null
        while (this.head && this.head.value === value) {
            deletedNode = this.head
            this.head = this.head.next
        }

        let currentNode = this.head

        if (currentNode !== null) {
            while (currentNode.next) {
                if (currentNode.next.value === value) {
                    deletedNode = currentNode.next
                    currentNode.next = currentNode.next.next
                } else {
                    currentNode = currentNode.next
                }
            }
        }
        if (this.tail.value === value) {
            this.tail = currentNode
        }
        return deletedNode
    }

    find(value) {
        if (!this.head || !value) return null
        let currentNode = this.head
        while (currentNode) {
            if (currentNode.value === value) {
                return currentNode
            }
            currentNode = currentNode.next
        }
        return null
    }

    deleteTail() {
        const deletedTail = this.tail
        if (this.head === this.tail) {
            this.head = null
            this.tail = null
            return deletedTail
        }

        let currentNode = this.head
        while (currentNode.next) {
            if (!currentNode.next.next) {
                currentNode.next = null
            } else {
                currentNode = currentNode.next
            }
        }
        this.tail = currentNode
        return deletedTail
    }

    deleteHead() {
        if (!this.head) return null
        const deletedHead = this.head
        if (this.head.next) {
            this.head = this.head.next
        } else {
            this.head = null
            this.tail = null
        }
        return deletedHead
    }

    toArray() {
        const nodes = []
        let currentNode = this.head
        while (currentNode) {
            nodes.push(currentNode)
            currentNode = currentNode.next
        }
        return nodes
    }
}

module.exports = LinkedList
