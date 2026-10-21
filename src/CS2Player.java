

public class CS2Player {
    private final String name;
    private int money;
    private BuyStrategy buyStrategy;

    public CS2Player(String name, int money, BuyStrategy initialStrategy) {
        this.name = name;
        this.money = money;
        this.buyStrategy = initialStrategy;
    }

    public void setBuyStrategy(BuyStrategy strategy) {
        this.buyStrategy = strategy;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void buyEquipment() {
        int cost = buyStrategy.getRequiredMoney();
        IO.println("Username: " + name + " | Balance: " + money + "$");

        if (cost > money) {
            IO.println("Insufficient funds! Required Cost: " + cost + "$");
        } else {
            buyStrategy.executeBuy();
            money -= cost;
            IO.println("Successfully bought equipment! Remaining: " + money + "$\n");
        }
    }
}
