public class StackOverflow {
    public static void recursiveCall() {
        recursiveCall(); // 无限递归
    }
    public static void main(String[] args) {
        recursiveCall();
    }
}