public class MyApplication {
    public static void main(String[] args) {
        BST<Integer, String> bin = new BST<>();
        bin.put(4, "C");
        bin.put(2, "I");
        System.out.println(bin.get(2));
    }
}
