package storages;

import activerecords.Fillable;

import java.util.ArrayList;
import java.util.List;

public class Basket implements BasketStorage {
    private final List<Fillable> basket = new ArrayList<>();

    @Override
    public List<Fillable> getStorage() {
        return basket;
    }

    @Override
    public boolean addRecord(Fillable fillable) {
        return basket.add(fillable);
    }

    @Override
    public boolean deleteRecord(Fillable fillable) {
        return basket.remove(fillable);
    }

    @Override
    public boolean editAmount(int index, int newAmount) {
        basket.get(index).setAmount(newAmount);
        return true;
    }
}
