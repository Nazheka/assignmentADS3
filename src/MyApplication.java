public class MyApplication {
    public static void main(String[] args) {
        MyHashTable<String, Integer> ht = new MyHashTable<>(10);
        ht.put("something", 0);
        System.out.println(ht.hash("something"));
        System.out.println(ht.get("something"));
        ht.remove("something");
        System.out.println(ht.get("something"));

    }
}
