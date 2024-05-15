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

    private MyHashTable(){}

    private MyHashTable(int M) {
        this.M = M;
        chainArray = new HashNode[M];
        size = 0;
    }

    private int hash(K key) {
        int hashCode = 0;
        int prime = 31; // common prime number for evaluating hashCode
        for (int i = 0; i < key.toString().length(); i++) { // loop through every character from the key
            hashCode = (hashCode * prime + key.toString().charAt(i)) % M; //formula
        }
        return hashCode;
    }
}
