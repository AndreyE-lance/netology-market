package storages;

import activerecords.Fillable;

import java.util.List;

public interface BasketStorage extends Storageable{
    List<Fillable> getStorage();

    boolean addRecord(Fillable fillable);

    boolean deleteRecord(Fillable fillable);

    boolean editAmount(int index, int newAmount);

}
