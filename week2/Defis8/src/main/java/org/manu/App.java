package org.manu;

public class App {
    public static void main(String[] args) {
        Stack<String> stackString = new Stack<>();

        stackString.push("Hello");
        stackString.push("world");
        stackString.push(" !");

        System.out.println(stackString.get());
    }
}
