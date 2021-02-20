package filldata;

import activerecords.Goods;
import activerecords.ProductTypes;
import storages.Storage;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

public class FillGoodsStorage implements FillStorage {
    @Override
    public Storage fill(String path) {
        FileInputStream fis = null;
        Storage gStorage = null;
        try {
            fis = new FileInputStream(path);
            BufferedReader bReader = new BufferedReader(new InputStreamReader(fis));
            gStorage = new Storage();
            while (bReader.ready()) {
                String[] s = bReader.readLine().split("\\|");
                if (!gStorage.addRecord(Long.parseLong(s[0]), new Goods(Long.parseLong(s[0]),
                        s[1], ProductTypes.values()[Integer.parseInt(s[2])],
                        new BigDecimal(s[3]),Boolean.valueOf(s[4]),Long.parseLong(s[5]),s[6],Float.parseFloat(s[7]),Integer.parseInt(s[8])))) {
                    System.out.println("Дублирование индекса " + s[0] + ". Проверьте исходный файл Goods.txt");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return gStorage;
    }
}
