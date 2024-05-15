public class MyHashTable <K, V> {
    private class HashNode <K, V> {
        private K key;
        private V value;
        private HashNode <K, V> next;

        public HashNode (K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "{" + key + " " + value + "}";
        }
    }

    private HashNode<K, V>[] chainArray;
    private int M = 11;
    private int size;

    public MyHashTable(){}

    public MyHashTable(int M) {
        this.M = M;
        chainArray = new HashNode[M];
        size = 0;
    }

    public int hash(K key) {
        checkKey(key);
        int index = 0;
        int prime = 31; // common prime number for evaluating hashCode
        for (int i = 0; i < key.toString().length(); i++) { // loop through every character from the key
            index = (index * prime + key.toString().charAt(i)) % M; //formula
        }
        return index;
    }

    public void put (K key, V value) {
        checkKey(key);
        int index = hash(key);
        HashNode<K, V> currentNode = chainArray[index];
        HashNode<K, V> previousNode = null;
        while (currentNode != null) { //finding if key already exists
            if (currentNode.key.equals(key)) {
                currentNode.value = value; //if key exists update value
                return;
            }
            previousNode = currentNode;
            currentNode = currentNode.next;
        }
        //if key doesn't exist, create a newNode
        HashNode<K, V> newNode = new HashNode<>(key, value);
        if (previousNode != null) {
            previousNode.next = newNode;
        } else {
            chainArray[index] = newNode;
        }
        size++;
    }

    public V get(K key) {
        int index = hash(key);
        HashNode<K, V> currentNode = chainArray[index];
        while (currentNode != null) { //finding node with key
            if (currentNode.key.equals(key)) {
                return currentNode.value;
            }
            currentNode = currentNode.next;
        }
        return null; // no such key was found
    }

    public void delete(K key) {
        int index = hash(key);
        HashNode<K, V> currentNode = chainArray[index];
        HashNode<K, V> previousNode = null;
        while (currentNode != null) {
            if (currentNode.key.equals(key)) {
                if (previousNode == null) {
                    chainArray[index] = currentNode.next;
                } else {
                    previousNode.next = currentNode.next;
                }
                size--;
            }
            previousNode = currentNode;
            currentNode = currentNode.next;
        }
    }


    private void checkKey(K key) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null.");
        }
    }
}
