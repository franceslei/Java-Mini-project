package Mini_project;

public class Test {
private String s = null;
private static Object lock = null;

public Test() {
    lock = new Object();
}

private static String m(String s)  {
     synchronized(lock) {
    String s1 = "Dog";
    s = s1;
     }
     return s;
}

public static void main(String [] args) {
    String s  = "Cat";
    System.out.println(s);
    m(s);
    System.out.println(s);
}
}
