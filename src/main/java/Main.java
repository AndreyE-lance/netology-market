public class Main {
    public static void main(String[] args) {
        Goods goods = new Goods(1234,"",ProductTypes.PRODUCT);
        GoodsProducer goodsProducer = new GoodsProducerBuilder(1,"ProctorAndGamble")
                .setCountry("DE")
                .setDescription("Super company since 1995")
                .build();
        System.out.println(goodsProducer);
    }
}
