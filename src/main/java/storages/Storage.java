package storages;

import activerecords.Fillable;

import java.util.HashMap;
import java.util.Map;

public class Storage implements Storages {
    private Map<Long, Fillable> storage = new HashMap<>();

    @Override
    public Map<Long, Fillable> getStorage() {
        return storage;
    }

    @Override
    public boolean addRecord(long l, Fillable fillable) {
        if(storage.put(l,fillable)==null){
            return true;
        }
        return false;
    }

    @Override
    public void setAmountById(long id, int amount) {
        int currentAm = storage.get(id).getAmount();
        storage.get(id).setAmount(amount+currentAm);
    }
}
