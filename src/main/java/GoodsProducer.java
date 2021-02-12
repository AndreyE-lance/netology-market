public class GoodsProducer {
    private final long ID;
    private final String PRODUCER_NAME;
    protected String producerCountry;
    protected String producerDescription;

    public GoodsProducer(long ID, String PRODUCER_NAME) {
        this.ID = ID;
        this.PRODUCER_NAME = PRODUCER_NAME;
    }

    public long getID() {
        return ID;
    }

    public String getPRODUCER_NAME() {
        return PRODUCER_NAME;
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
                "ID=" + ID +
                ", PRODUCER_NAME='" + PRODUCER_NAME + '\'' +
                ", producerCountry='" + producerCountry + '\'' +
                ", producerDescription='" + producerDescription + '\'' +
                '}';
    }
}
