package controller;

import model.ElectronicDevice;
import model.Fridge;
import model.MobilePhone;
import model.Pc;
import storage.IReadWriteFile;
import storage.ReadWriteFile;
import views.Client;
import java.util.List;
import java.util.Scanner;

public class ElectronicManager {
    private static ElectronicManager instance;
    private final List<ElectronicDevice> electronicDevices;
    private final IReadWriteFile readWriteFile = ReadWriteFile.getInstance();

    private ElectronicManager() {
        this.electronicDevices = readWriteFile.readToFile();
    }

    public static ElectronicManager getInstance() {
        if (instance == null) {
            instance = new ElectronicManager();
        }
        return instance;
    }

    //----------------In ra màn hình
    public void display() {
        System.out.println(electronicDevices);
    }

    //Tổng tiền điện thoại------------------
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

    //Tổng tiền máy tính------------------
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

    //Tổng tiền tủ lạnh-----------------------------
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
    //Tổng tiền các sản phẩm
    public double priceElectronicDevice() {
        double priceElectronicDevice = 0;
        priceElectronicDevice += totalPriceFridge() + totalPricePc() + totalPriceMobilePhone();
        return priceElectronicDevice;
    }

    // Thêm phần tử------------------

    public void addElement(ElectronicDevice electronicDevice) {
        electronicDevices.add(electronicDevice);
        readWriteFile.writeToFile(electronicDevices);
    }

    //--------------------------------------------------//
    // Xóa theo id
    public void deleteElement(Scanner scanner) {
        System.out.println("Nhập sản phẩm cần xóa: ");
        int id = Integer.parseInt(scanner.nextLine());
        for (ElectronicDevice e :
                electronicDevices) {
            if (electronicDevices.size() == 0) {
                System.out.println("không có j để xóa ");
                break;
            } else if (id == (e.getId())) {
                electronicDevices.remove(e);
                break;

            }
            else if (id < 1 || id != e.getId()) {
                System.out.println("----Lỗi nhập. Mời bạn nhập lại----");
                deleteElement(scanner);
            }
        }
        readWriteFile.writeToFile(electronicDevices);
    }

    //---------------------------------------------------//
    //Tìm theo tên
    public void searchElement(Scanner scanner) {
        int flag = 0;
        System.out.println("Mời bạn nhập tên sản phẩm: ");
        String searhString = scanner.nextLine();
        for (ElectronicDevice i : electronicDevices) {
            if (searhString.contains(i.getName())) {
                System.out.println("Sản phẩm là: " + i);
                flag = 1;
            }
            if (flag == 0) {
                System.out.println("Không tìm thấy sản phẩm. Mời bạn nhập lại");
                searchElement(scanner);
                break;
            }
            flag++;
        }

    }

    //Sửa theo tên sản phẩm
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
            if (id == e.getId()) {
                System.out.println("Mời bạn nhập id : ");
                newId = Integer.parseInt(scanner.nextLine());
                if (newId == e.getId()) {
                    System.out.println("Bị trùng id, mời bạn nhập lại: ");
                    newId = Integer.parseInt(scanner.nextLine());
                }
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
                if (e instanceof Fridge) {
                    System.out.println("Mời bạn nhập kiểu tủ lạnh: ");
                    newCooling = scanner.nextLine();
                    ((Fridge) e).setCooling(newCooling);
                    break;
                } else if (e instanceof Pc) {
                    System.out.println("Mời bạn nhâp kiểu card của pc: ");
                    newCard = scanner.nextLine();
                    ((Pc) e).setCard(newCard);
                    break;
                } else if (e instanceof MobilePhone) {
                    System.out.println("Mời bạn nhập kiểu màn hình của điện thoại: ");
                    newScreenType = scanner.nextLine();
                    ((MobilePhone) e).setScreenType(newScreenType);
                    break;
                }
            }
            break;
        }

        for (ElectronicDevice e :
                electronicDevices) {
            if (id != e.getId()) {
                System.out.println("Không tìm thấy sản phẩm cần sửa. Bạn có muốn nhập lại không?");
                System.out.println("10. Có, mời bạn nhập lại: ");
                System.out.println("11. Thoát ra menu.");
                int inPut = Integer.parseInt(scanner.nextLine());
                switch (inPut) {
                    case 10:
                        editElement(scanner);
                        break;
                    case 11:
                        Client.menuManage();
                        break;
                    default:
                        System.out.println("Nhập lỗi.");
                }
            }
            break;
        }
        readWriteFile.writeToFile(electronicDevices);
    }

}
