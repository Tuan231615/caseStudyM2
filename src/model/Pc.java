package model;

public class Pc extends ElectronicDevice{
    private String card;

    public Pc() {
    }

    public Pc(int id, String name, double cost, String color, int quantity, String card) {
        super(id, name, cost, color, quantity);
        this.card = card;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    @Override
    public String toString() {
        return "Pc{" +
                "card='" + card + '\'' +
                '}';
    }

    @Override
    public double getRealMoney() {
        return 0;
    }

    @Override
    public double getAmount() {
        return getCost() * getQuantity();
    }
}
