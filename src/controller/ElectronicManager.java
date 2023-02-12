package controller;

import model.ElectronicDevice;
import model.Fridge;
import model.MobilePhone;
import model.Pc;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ElectronicManager {
    List<ElectronicDevice> electronicDevices;

    public ElectronicManager() {
        electronicDevices = new ArrayList<>();
    }

    public ElectronicManager(List<ElectronicDevice> electronicDevices) {
        this.electronicDevices = electronicDevices;
    }

    //CRUD
    //----------------in ra man hinh
    public void display() {
        for (int i = 0; i < electronicDevices.size(); i++) {
            System.out.println(electronicDevices);
        }
    }

    //------------------tinh tong tien cua dien thoai
    public double totalPriceMobilePhone() {
        double priceMobilePhone = 0;
        double totalPriceMobilePhoneSale = 0;
        for (ElectronicDevice electronicDevice :
                electronicDevices) {
            if (electronicDevice instanceof MobilePhone) {
                priceMobilePhone += electronicDevice.getRealMoney();
                totalPriceMobilePhoneSale += (electronicDevice.getAmount() - electronicDevice.getRealMoney());
            }
        }
        return totalPriceMobilePhoneSale;
    }

    //------------------tinh tong tien cua may tinh
    public double totalPricePc() {
        double pricePc = 0;
        double totalPricePcSale = 0;
        for (ElectronicDevice electronicDevice :
                electronicDevices) {
            if (electronicDevice instanceof Pc) {
                pricePc += electronicDevice.getRealMoney();
                totalPricePcSale += (electronicDevice.getAmount() - electronicDevice.getRealMoney());
            }
        }
        return totalPricePcSale;
    }

    //-----------------------------tinh tong tien cua tu lanh
    public double totalPriceFridge() {
        double priceFridge = 0;
        double totalPriceFridgeSale = 0;
        for (ElectronicDevice electronicDevice :
                electronicDevices) {
            if (electronicDevice instanceof Fridge) {
                priceFridge += electronicDevice.getRealMoney();
                totalPriceFridgeSale += (electronicDevice.getAmount() - electronicDevice.getRealMoney());
            }
        }
        return totalPriceFridgeSale;
    }
    //-------------------------------------------//
    //tong tien cua tat ca san pham
    public double priceElectronicDevice() {
        double priceElectronicDevice = 0;
        for (ElectronicDevice e :
                electronicDevices) {
            priceElectronicDevice += totalPriceFridge() + totalPricePc() + totalPriceMobilePhone();
        }
        return priceElectronicDevice;
    }
    Scanner scanner = new Scanner(System.in);// them phan tu------------------

    public void addElement(ElectronicDevice electronicDevice) {
        electronicDevices.add(electronicDevice);
    }

    //----------------------------------------------------//
    //sua phan tu
    public void editElement(Scanner scanner) {
        int newId;
        String newName;
        double newCost;
        String newColor;
        int newQuantity;
        String newCooling;
        String newScreenType;
        String newCard;
        System.out.println("Moi ban nhap id san pham: ");
        int id = scanner.nextInt();
        for (ElectronicDevice e : electronicDevices) {
            if (id == e.getId()) {
                if (e instanceof Fridge) {
                    System.out.println("Moi ban nhap id tu lanh: ");
                    newId = scanner.nextInt();
                    System.out.println("Moi ban nhap ten san pham: ");
                    newName = scanner.nextLine();
                    System.out.println("Moi ban nhap gia san pham: ");
                    newCost = scanner.nextDouble();
                    System.out.println("Moi ban nhap mau san pham: ");
                    newColor = scanner.nextLine();
                    System.out.println("Moi ban nhap so luong san pham: ");
                    newQuantity = scanner.nextInt();
                    System.out.println("Moi ban nhap kieu tu lanh: ");
                    newCooling = scanner.nextLine();
                    e.setId(newId);
                    e.setName(newName);
                    e.setCost(newCost);
                    e.setColor(newColor);
                    e.setQuantity(newQuantity);
                    ((Fridge) e).setCooling(newCooling);
                } else if (e instanceof Pc) {
                    System.out.println("Moi ban nhap id san pham: ");
                    newId = scanner.nextInt();
                    System.out.println("Moi ban nhap ten san pham: ");
                    newName = scanner.nextLine();
                    System.out.println("Moi ban nhap gia san pham: ");
                    newCost = scanner.nextDouble();
                    System.out.println("Moi ban nhap mau san pham: ");
                    newColor = scanner.nextLine();
                    System.out.println("Moi ban nhap so luong san pham: ");
                    newQuantity = scanner.nextInt();
                    System.out.println("Moi ban nhap kieu card: ");
                    newCard = scanner.nextLine();
                    e.setId(newId);
                    e.setName(newName);
                    e.setCost(newCost);
                    e.setColor(newColor);
                    e.setQuantity(newQuantity);
                    ((Pc) e).setCard(newCard);
                } else if (e instanceof MobilePhone){
                    System.out.println("Moi ban nhap id san pham: ");
                    newId = scanner.nextInt();
                    System.out.println("Moi ban nhap ten san pham: ");
                    newName = scanner.nextLine();
                    System.out.println("Moi ban nhap gia san pham: ");
                    newCost = scanner.nextDouble();
                    System.out.println("Moi ban nhap mau san pham: ");
                    newColor = scanner.nextLine();
                    System.out.println("Moi ban nhap so luong san pham: ");
                    newQuantity = scanner.nextInt();
                    System.out.println("Moi ban nhap kieu man hinh: ");
                    newScreenType = scanner.nextLine();
                    e.setId(newId);
                    e.setName(newName);
                    e.setCost(newCost);
                    e.setColor(newColor);
                    e.setQuantity(newQuantity);
                    ((MobilePhone)e).setScreenType(newScreenType);
                }
            }
        }
    }

    //--------------------------------------------------//
    // ham xoa phan tu
    public void deleteElement() {
        if (electronicDevices.size() == 0) {
            System.out.println("khong co j de xoa ");
        } else {
            electronicDevices.remove(electronicDevices.size() - 1);
        }
    }
    //---------------------------------------------------//
}
