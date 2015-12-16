package OOPSampleExam07Dec2015;

import java.util.Scanner;

public class TerminalIO {

    private static final Scanner sc = new Scanner(System.in);

    public static void println(String str) {
        System.out.println(str);
    }

    public static void print(String str) {
        System.out.print(str);
    }

    public static String readln() {
        String input = sc.nextLine();
        return input;
    }
}
