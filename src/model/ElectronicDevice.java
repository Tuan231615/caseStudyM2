package model;

import java.io.Serializable;

public abstract class ElectronicDevice implements Discount, Serializable {
    private int id;
    private String name;
    private double cost;
    private String color;
    private double quantity;

    public ElectronicDevice() {
    }

    public ElectronicDevice(int id, String name, double cost, String color, double quantity) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.color = color;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public abstract double getAmount();
}
