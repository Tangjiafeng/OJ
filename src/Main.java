public class Main {
    static class Tester {
        char c;// д╛хож╣'\u0000' null
    }
    public static void main(String[] args) {
        System.out.println("Hello World!");
        Tester t = new Tester();
        System.out.println("hello" + t.c + "world");
    }
}
