package activerecords;

public class GoodsProducer implements Fillable {
    private final long id;
    private final String producerName;
    private final String producerCountry;
    private final String producerDescription;

    public GoodsProducer(long id, String producerName, String producerCountry, String producerDescription) {
        this.id = id;
        this.producerName = producerName;
        this.producerCountry = producerCountry;
        this.producerDescription = producerDescription;
    }

    public long getId() {
        return id;
    }

    public String getProducerName() {
        return producerName;
    }

    public String getProducerCountry() {
        return producerCountry;
    }

    public String getProducerDescription() {
        return producerDescription;
    }

    @Override
    public String toString() {
        return "GoodsProducer{" +
                "ID=" + id +
                ", PRODUCER_NAME='" + producerName + '\'' +
                ", producerCountry='" + producerCountry + '\'' +
                ", producerDescription='" + producerDescription + '\'' +
                '}';
    }

    @Override
    public void setAmount(int amount) {

    }

    @Override
    public int getAmount() {
        return 0;
    }

    @Override
    public long getIndex() {
        return 0;
    }

    @Override
    public String toStringBasket() {
        return null;
    }
}
