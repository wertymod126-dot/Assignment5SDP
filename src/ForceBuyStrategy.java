public class ForceBuyStrategy implements BuyStrategy {
    private static final int REQUIRED_MONEY = 2000;
    @Override
    public int getRequiredMoney() {
        return REQUIRED_MONEY;
    }
    @Override
    public void executeBuy()
    {
        IO.println("FORCE BUY--- Buying: MAC-10, Kevlar, Smoke");
    }
}
