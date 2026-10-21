public class Main {
    public static void main(String[] args) {
        // Client instantiates strategies and injects them into the context
        BuyStrategy fullBuy = new FullBuyStrategy();
        BuyStrategy forceBuy = new ForceBuyStrategy();
        BuyStrategy ecoBuy = new EcoBuyStrategy();

        CS2Player player = new CS2Player("donk", 5000, fullBuy);

        // Round 1: Full Buy
        IO.println("--- Round 1: Good Economy ---");
        player.buyEquipment();

        // Round 2: Low Money -> Switch to Eco
        IO.println("--- Round 2: Low Economy ---");
        player.setBuyStrategy(ecoBuy);
        player.buyEquipment();

        // Round 3: Force Buy
        IO.println("--- Round 3: Decisive Round ---");
        player.setMoney(2100);
        player.setBuyStrategy(forceBuy);
        player.buyEquipment();
    }
}