public class GoodsProducerBuilder{
    private GoodsProducer goodsProducer;

    public GoodsProducerBuilder(long ID, String PRODUCER_NAME) {
        this.goodsProducer = new GoodsProducer(ID, PRODUCER_NAME);
    }

    public GoodsProducerBuilder setCountry(String producerCountry){
        this.goodsProducer.producerCountry = producerCountry;
        return this;
    }

    public GoodsProducer build(){
        return goodsProducer;
    }

    public GoodsProducerBuilder setDescription(String producerDescription){
        this.goodsProducer.producerDescription = producerDescription;
        return this;
    }
}
