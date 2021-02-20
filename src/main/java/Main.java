import controllers.MainMenuController;
import filldata.FillGoodsStorage;
import storages.Storage;


public class Main {
    public static final String PATH_TO_PRODUCERS = "src/main/resources/Producers.txt";
    public static final String PATH_TO_GOODS = "src/main/resources/Goods.txt";
    public static Storage gStorage;
    public static Storage gpStorage;

    public static void main(String[] args) throws CloneNotSupportedException {
        initStorages();
        MainMenuController mmController = new MainMenuController(gStorage);
        mmController.showMainMenu();
    }

    public static void initStorages() {
        FillGoodsStorage fillStorage = new FillGoodsStorage();
        gStorage = fillStorage.fill(PATH_TO_GOODS);
    }
}
