package model;

public class MobilePhone extends ElectronicDevice{
    private String screenType;

    public MobilePhone() {
    }

    public MobilePhone(int id, String name, double cost, String color, int quantity, String screenType) {
        super(id, name, cost, color, quantity);
        this.screenType = screenType;
    }

    public String getScreenType() {
        return screenType;
    }

    public void setScreenType(String screenType) {
        this.screenType = screenType;
    }

    @Override
    public String toString() {
        return "MobilePhone{" +
                "screenType='" + screenType + '\'' +
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
