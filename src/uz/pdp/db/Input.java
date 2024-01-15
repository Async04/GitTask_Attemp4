package src.uz.pdp.db;

import java.util.Scanner;

public interface Input {

    Scanner SCANNER_INT = new Scanner(System.in);
    Scanner SCANNER_STR = new Scanner(System.in);

    static int inputInt(String msg){
        System.out.print(msg+":");
        return SCANNER_INT.nextInt();
    }

    static String inputStr(String msg){
        System.out.print(msg+":");
        return SCANNER_STR.nextLine();
    }

}
