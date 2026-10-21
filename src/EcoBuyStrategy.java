public class EcoBuyStrategy implements BuyStrategy {
    private static final int REQUIRED_MONEY = 0;
    @Override
    public int getRequiredMoney() {
        return REQUIRED_MONEY;
    }

    @Override
    public void executeBuy() {
        IO.println("ECO BUY--- Buying: Nothing..");
    }
}