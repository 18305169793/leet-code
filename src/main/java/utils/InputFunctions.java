package utils;
import java.util.Scanner;
public class InputFunctions {
    public enum getScanner{
        INSTANCE;
        private Scanner sc;
        private getScanner(){
            sc = new Scanner(System.in);
        }
        public Scanner getInstance(){
            return sc;
        }

    }

    public static String getString(){
        Scanner sc = getScanner.INSTANCE.getInstance();
        String receive = sc.nextLine();
        return receive;
    }

    public static String[] getStringArray(){
        Scanner sc = getScanner.INSTANCE.getInstance();
        String receive = sc.nextLine();
        return receive.split("\\s+");
    }

    public static int[] getIntArray(){
        String[] stringArray = getStringArray();
        int[] intArray;
        intArray = new int[stringArray.length];
        for (int i = 0; i <stringArray.length ; i++) {
            intArray[i] = Integer.parseInt(stringArray[i]);
        }
        return intArray;
    }

    public static void main(String[] args) {
        String s= getString();
        System.out.println(s.length());
        System.out.println(s.getBytes()[0]);
    }
}
