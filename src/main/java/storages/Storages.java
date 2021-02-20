package storages;

import activerecords.Fillable;

import java.util.Map;

public interface Storages extends Storageable{
    Map<Long, Fillable> getStorage();

    boolean addRecord(long l, Fillable fillable);
    void setAmountById(long id,int amount);
}
