public class FullBuyStrategy implements BuyStrategy {
    private static final int REQUIRED_MONEY = 4200;
    @Override
    public int getRequiredMoney() {
        return REQUIRED_MONEY;
    }

    @Override
    public void executeBuy() {
        IO.println("FULL BUY--- Buying: AK-47, Kevlar and Helmet, Smoke and Flash");
    }
}
