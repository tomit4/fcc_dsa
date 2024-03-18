// taken (with slight changes) from:
// https://github.com/trekhleb/javascript-algorithms/blob/master/src/data-structures/hash-table/HashTable.js
const LinkedList = require('./LinkedList.js')

const defaultHashTableSize = 32

class HashTable {
    constructor(hashTableSize = defaultHashTableSize) {
        this.buckets = Array(hashTableSize)
            .fill(null)
            .map(() => new LinkedList())
        this.keys = {}
    }

    // normally a more out of the box hashing function is used here (like SHA or MD5)
    hash(key) {
        const hash = Array.from(key).reduce(
            (hashAccumulator, keySymbol) =>
                hashAccumulator + keySymbol.charCodeAt(0),
            0,
        )
        return hash % this.buckets.length
    }

    set(key, value) {
        const keyHash = this.hash(key)
        this.keys[key] = keyHash
        const bucketLinkedList = this.buckets[keyHash]
        const node = bucketLinkedList.find(key)
        if (!node) bucketLinkedList.append(value)
        else node.value.value = value
    }

    delete(key, value) {
        const keyHash = this.hash(key)
        delete this.keys[key]
        const bucketLinkedList = this.buckets[keyHash]
        const node = bucketLinkedList.find(value)
        if (node) return bucketLinkedList.delete(node.value)
        return null
    }

    get(key, value) {
        const bucketLinkedList = this.buckets[this.hash(key)]
        if (!bucketLinkedList.head) return undefined
        const node = bucketLinkedList.find(value)
        return node ? node.value : undefined
    }

    has(key) {
        return Object.hasOwnProperty.call(this.keys, key)
    }

    getKeys() {
        return Object.keys(this.keys)
    }

    getValues() {
        return this.buckets.reduce((values, bucket) => {
            console.log('bucket :=>', bucket)
            const bucketValues = bucket
                .toArray()
                .map(linkedListNode => linkedListNode.value.value)
            return values.concat(bucketValues)
        }, [])
    }
}

const hashTable = new HashTable()

hashTable.set('jack', '123')
hashTable.set('jill', '456')
// Will insert at the same hash address as it is a simple modulus hash function
hashTable.set(10, 'whatever')
hashTable.set(20, 'whatever-again')

const jackValue = hashTable.get('jack', '123')
const jillValue = hashTable.get('jill', '456')
const nullValue = hashTable.get('null', 'notgonnafindme')
const tenValue = hashTable.get(10, 'whatever')
let twentyValue = hashTable.get(20, 'whatever-again')

console.log('jackValue :=>', jackValue)
console.log('jillValue :=>', jillValue)
console.log('nullValue :=>', nullValue)
console.log('tenValue :=>', tenValue)
console.log('twentyValue :=>', twentyValue)

/*
    returns:
    jackValue :=> 123
    jillValue :=> 456
    nullValue :=> undefined
    tenValue :=> whatever
    twentyValue :=> whatever-again 
*/

hashTable.delete(20, 'whatever-again')
twentyValue = hashTable.get(20, 'whatever-again')
console.log('twentyValue :=>', twentyValue) // twentyValue :=> undefined

hashTable.set(30, 'new-whatever')
const allValues = hashTable.getValues()
console.log('allValues :=>', allValues)
/*
    * NOTE: More to it, but here is our new linked list at the divisible by 10 hash address:
    bucket :=> LinkedList {
      head: LinkedListNode {
        value: 'whatever',
        next: LinkedListNode { value: 'new-whatever', next: null }
      },
      tail: LinkedListNode { value: 'new-whatever', next: null }
    }
*/
