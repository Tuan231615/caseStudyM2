package controller;

import model.ElectronicDevice;
import model.Fridge;
import model.MobilePhone;
import model.Pc;
import storage.ReadWriteFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ElectronicManager {
    private static ElectronicManager instance;
    private final List<ElectronicDevice> electronicDevices;

    private ElectronicManager() {
        this.electronicDevices = ReadWriteFile.getInstance().readToFile();
    }

    public static ElectronicManager getInstance() {
        if (instance == null) {
            instance = new ElectronicManager();
        }
        return instance;
    }

    public List<ElectronicDevice> getElectronicDevices() {
        return electronicDevices;
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
                totalPriceMobilePhoneSale += (electronicDevice.getAmount() - priceMobilePhone);
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
                totalPricePcSale += (electronicDevice.getAmount() - pricePc);
            }
        }
        return totalPricePcSale;
    }

    //-----------------------------tinh tong tien cua tu lanh
    public double totalPriceFridge() {
        double totalPriceFridgeSale = 0;
        for (ElectronicDevice electronicDevice :
                electronicDevices) {
            if (electronicDevice instanceof Fridge) {
                totalPriceFridgeSale += (electronicDevice.getAmount() - electronicDevice.getRealMoney());
            }
        }
        return totalPriceFridgeSale;
    }

    //-------------------------------------------//
    //tong tien cua tat ca san pham
    public double priceElectronicDevice() {
        double priceElectronicDevice = 0;
        priceElectronicDevice += totalPriceFridge() + totalPricePc() + totalPriceMobilePhone();
        return priceElectronicDevice;
    }

    // them phan tu------------------

    public void addElement(ElectronicDevice electronicDevice) {
        electronicDevices.add(electronicDevice);
        ReadWriteFile.getInstance().writeToFile(electronicDevices);
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
        System.out.println("Mởi bạn nhập id sản phẩm: ");
        int id = Integer.parseInt(scanner.nextLine());
        for (ElectronicDevice e : electronicDevices) {
            System.out.println("Mời bạn nhập id : ");
            newId = Integer.parseInt(scanner.nextLine());
            System.out.println("Mời bạn nhập tên: ");
            newName = scanner.nextLine();
            System.out.println("Mời bạn nhập giá: ");
            newCost = Double.parseDouble(scanner.nextLine());
            System.out.println("Mời bạn nhập màu: ");
            newColor = scanner.nextLine();
            System.out.println("Mời bạn nhập số lượng: ");
            newQuantity = Integer.parseInt(scanner.nextLine());
            e.setId(newId);
            e.setName(newName);
            e.setCost(newCost);
            e.setColor(newColor);
            e.setQuantity(newQuantity);
            if (id == e.getId()) {
                if (e instanceof Fridge) {
                    System.out.println("Mời bạn nhập kiểu tủ lạnh: ");
                    newCooling = scanner.nextLine();
                    ((Fridge) e).setCooling(newCooling);
                } else if (e instanceof Pc) {
                    System.out.println("Mời bạn nhâp kiểu card của pc: ");
                    newCard = scanner.nextLine();
                    ((Pc) e).setCard(newCard);
                } else if (e instanceof MobilePhone) {
                    System.out.println("Mời bạn nhập kiểu màn hình của điện thoại: ");
                    newScreenType = scanner.nextLine();
                    ((MobilePhone) e).setScreenType(newScreenType);
                }
            }
        }
        ReadWriteFile.getInstance().writeToFile(electronicDevices);
    }

    //--------------------------------------------------//
    // ham xoa phan tu
    public void deleteElement() {
        if (electronicDevices.size() == 0) {
            System.out.println("khong co j de xoa ");
        } else {
            electronicDevices.remove(electronicDevices.size() - 1);
        }
        ReadWriteFile.getInstance().writeToFile(electronicDevices);
    }
    //---------------------------------------------------//
    //tim kiem theo id
    public void searchElement(Scanner scanner){
        System.out.println("Moi ban nhap ten san pham: ");
        String searhString =  scanner.nextLine();
        for (ElectronicDevice i:
             electronicDevices) {
            if (searhString.equalsIgnoreCase(i.getName())){
                System.out.println("Vi tri san pham can tim la: " + i.getId());
            } else{
                System.out.println("Khong tim thay phan tu");
            }
        }
    }
}
