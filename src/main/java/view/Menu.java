package view;

import java.util.Scanner;

public class Menu {
    private Scanner scanner = new Scanner(System.in);
    private Messager messager = new Messager();

    public Menu() {
        System.out.println("Приветствуем вас в нашем магазине!");
    }

    public int showMainMenu() throws InterruptedException {
        StringBuilder sb = new StringBuilder("МЕНЮ\n");
        sb.append("1. Добавить товар в корзину.\n")
                .append("2. Перейти в корзину.\n")
                //.append("3. Фильтр.\n")
                //.append("4. Отслеживание заказа.\n")
                .append("0. Выход. \n");
        System.out.println(sb.toString());
        int result = -1;
        try {
            result = scanner.nextInt();
        } catch (Exception ex) {
            messager.showMessage("Неправильный ввод. Введите корректный индекс операции.");
            showMainMenu();
        }
        if (result > 4 || result < 0) {
            messager.showMessage("Неправильный ввод. Введите корректный индекс операции.");
            showMainMenu();
        }
        return result;
    }

    public String[] showAddToCarMenu() {
        System.out.println("Введите номер товара и количество через пробел или 0 для возврата в меню:");
        scanner.nextLine();
        String[] result = scanner.nextLine().split(" ");
        if (result.length == 1 && result[0].equals("0")) {
            return result;
        } else {
            if(inputCheck(result)){
                return result;
            } else {
                messager.showMessage("Некоректный ввод");
                showAddToCarMenu();
            }
        }
        return result;
    }

    private boolean inputCheck(String[] str) {
        for (String s : str) {
            try {
                int i = Integer.parseInt(s);
                if (i<=0) return false;
            } catch (IllegalArgumentException ex) {
                return false;
            }
        }
        return true;
    }
}
