package view;

import java.util.Scanner;

public class Messager {
    public void showMessage(String text){
        Scanner scanner = new Scanner(System.in);
        System.out.println(text);
        System.out.println("Для продолжения нажмите Enter");
        scanner.nextLine();
    }
}
