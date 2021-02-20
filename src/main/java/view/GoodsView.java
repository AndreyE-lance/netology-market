package view;

import storages.Basket;
import storages.Storage;
import storages.Storageable;

import java.util.concurrent.atomic.AtomicInteger;

public class GoodsView {
    private final Storageable storage;

    public GoodsView(Storageable storage) {
        this.storage = storage;
    }

    public void show() {
        if (storage instanceof Storage) {
            Storage newStorage = (Storage) storage;
            newStorage.getStorage().forEach((k,v)-> System.out.println(v));
        } else if(storage instanceof Basket){
            Basket basket = (Basket) storage;
            AtomicInteger i = new AtomicInteger(1);
            basket.getStorage().forEach(v->  {
                System.out.println(i.get()+" "+v.toStringBasket());
            i.getAndIncrement();});
        }
    }
}
