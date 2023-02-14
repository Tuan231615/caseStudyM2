package model;

public class MobilePhone extends ElectronicDevice {
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
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", cost=" + getCost() +
                ", color='" + getColor() + '\'' +
                ", quantity=" + getQuantity() +
                "screenType='" + screenType + '\'' +
                '}';
    }

    @Override
    public double getRealMoney() {
        if (getColor().equalsIgnoreCase("mau do")) {
            return (getAmount() - (getAmount() * 0.1));
        } else if (getColor().equalsIgnoreCase("mau den")) {
            return (getAmount() - (getAmount() * 0.2));
        } else
            return 0;
    }

    @Override
    public double getAmount() {
        return getCost() * getQuantity();
    }
}
