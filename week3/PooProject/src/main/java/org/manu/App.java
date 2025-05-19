package org.manu;

public class App {
    public static void main(String[] args) {
        Command command = Command.HELP;

        System.out.println(command.execute("MONTHLY_AVERAGE"));
    }
}
