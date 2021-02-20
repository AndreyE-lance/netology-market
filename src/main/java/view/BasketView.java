package view;

import storages.Basket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BasketView {
    private final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private final Messager messager = new Messager();
    private Basket basket;


    public BasketView(Basket basket) {
        this.basket = basket;
        System.out.println("ВАША КОРЗИНА\n");
    }

    public void showContain(){
        GoodsView goodsView = new GoodsView(basket);
        goodsView.show();
    }

    public void showMenu() throws InterruptedException {
        StringBuilder sb = new StringBuilder("МЕНЮ\n");
        sb.append("1. Оформить и оплатить.\n")
                .append("2. Удалить.\n")
                .append("3. Очистить корзину.\n")
                .append("0. Вернуться в главное меню \n");
        System.out.println(sb.toString());
    }

    public void showDeleteMenu(){
        StringBuilder sb = new StringBuilder("\nВведите номер товара для удаления или ) для возврата в меню корзины.\n");
        System.out.println(sb.toString());
    }

    public String readInput(){
        try {
            return bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void payMenu(){
        StringBuilder sb = new StringBuilder("Оплачено! \n");
        sb.append("Получать уведомления через: \n")
                .append("1. SMS.\n")
                .append("2. E-mail.\n");
        System.out.println(sb.toString());
    }

}
