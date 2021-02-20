package controllers;

import activerecords.Goods;
import senders.SendByEmail;
import senders.SendBySms;
import senders.Sendable;
import storages.Basket;
import storages.Storage;
import view.BasketView;
import view.GoodsView;
import view.Menu;
import view.Messager;


public class MainMenuController {
    private final Menu menu = new Menu();
    private final GoodsView goodsView;
    private final Storage gStorage;
    private Basket basket = new Basket();
    private Messager messager = new Messager();
    private final BasketView basketView = new BasketView(basket);

    public MainMenuController(Storage gStorage) {
        this.gStorage = gStorage;
        this.goodsView = new GoodsView(gStorage);
    }

    public void showMainMenu() {
        goodsView.show();
        int operation;
        try {
            operation = menu.showMainMenu();
            switch (operation) {
                case 0:
                    break;
                case 1:
                    addToCart();
                    break;
                case 2:
                    showCart();
                    break;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private void addToCart() {
        String[] res = menu.showAddToCarMenu();
        if (!res[0].equals("0")) {
            int index = Integer.parseInt(res[0]);
            int reqAmount = Integer.parseInt(res[1]);
            Goods goods = (Goods) gStorage.getStorage().get((long) index);
            int amount = goods.getAmount();
            if (amount >= reqAmount) {
                goods.setAmount(amount - reqAmount);
                gStorage.getStorage().put((long) index, goods);
                Goods goodsToBasket = null;
                try {
                    goodsToBasket = goods.clone();
                    goodsToBasket.setAmount(reqAmount);
                } catch (CloneNotSupportedException e) {
                    e.printStackTrace();
                }
                basket.addRecord(goodsToBasket);
                showMainMenu();
            } else {
                messager.showMessage("Недостаточно товара!");
                showMainMenu();
            }

        } else {
            showMainMenu();
        }

    }

    private void showCart() {
        int chosenMenu = -1;
        while (true) {
            basketView.showContain();
            try {
                basketView.showMenu();
                chosenMenu = Integer.parseInt(basketView.readInput());
                if (chosenMenu > 3 || chosenMenu < 0) {
                    messager.showMessage("Число за пределом диапазона пунктов меню");
                } else {
                    break;
                }
            } catch (Exception ex) {
                messager.showMessage("Некорректный ввод.");
            }
        }
        switch (chosenMenu) {
            case 0: {
                showMainMenu();
                break;
            }
            case 1: {
                payAndSend();
                showMainMenu();
                break;
            }
            case 2: {
                deletePos();
                showMainMenu();
                break;
            }
            case 3: {
                clearBasket();
                showMainMenu();
                break;
            }
        }

    }

    private void clearBasket() {
        basket.getStorage().forEach(g -> {
            long index = g.getIndex();
            int amount = g.getAmount();
            gStorage.setAmountById(index, amount);
        });
        basket.getStorage().clear();
    }

    private void deletePos() {
        while (true) {
            basketView.showContain();
            basketView.showDeleteMenu();
            int id = -1;
            try {
                id = Integer.parseInt(basketView.readInput());
                if (id < 0 || id > basket.getStorage().size()) {
                    messager.showMessage("Число за пределом диапазона пунктов меню");
                } else {
                    long index = basket.getStorage().get(id - 1).getIndex();
                    int amount = basket.getStorage().get(id - 1).getAmount();
                    basket.getStorage().remove(id - 1);
                    gStorage.setAmountById(index, amount);
                    break;
                }
            } catch (Exception ex) {
                messager.showMessage("Некорректный ввод.");
            }
        }
    }

    private void payAndSend() {
        basketView.payMenu();
        while (true) {
            int id = -1;
            try {
                id = Integer.parseInt(basketView.readInput());
                if (id < 0 || id > 2) {
                    messager.showMessage("Число за пределом диапазона пунктов меню");
                } else {
                    Sendable sender;
                    if(id == 1) {
                        sender = new SendBySms();
                    } else {
                        sender = new SendByEmail();
                    }
                    messager.showMessage(sender.send());
                    basket.getStorage().clear();
                    break;
                }
            } catch (Exception ex) {
                messager.showMessage("Некорректный ввод.");
            }
        }
    }

}
