package controller;

import model.ElectronicDevice;
import model.Fridge;
import model.MobilePhone;
import model.Pc;
import storage.IReadWriteFile;
import storage.ReadWriteFile;
import views.Client;

import java.util.Comparator;
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
    public double totalElectronicDeviceBeforeSale(){
        double totalElectroniceDevice = 0;
        for (ElectronicDevice e:
             electronicDevices) {
            totalElectroniceDevice += e.getAmount();
        }
        return totalElectroniceDevice;
    }

    //-------------------------------------------//
    //Tổng tiền các sản phẩm sau khuyến mãi
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
        String id = String.valueOf(checkInt(scanner));
        for (ElectronicDevice e :
                electronicDevices) {
            if (electronicDevices.size() == 0) {
                System.out.println("không có gì để xóa ");
                break;
            } else if (id.equals(e.getId())) {
                electronicDevices.remove(e);
                break;

            }
        }
        readWriteFile.writeToFile(electronicDevices);
    }

    //---------------------------------------------------//
    //Tìm theo tên
    public void searchElement(Scanner scanner) {
        int flag = -1;
        System.out.println("Mời bạn nhập tên sản phẩm: ");
        String searhString = scanner.nextLine();

        for (int i = 0; i < electronicDevices.size(); i++) {
            if (searhString.equals(electronicDevices.get(i).getName())) {
                System.out.println("Sản phẩm là: " + electronicDevices.get(i));
                flag = i;
            }
        }
        if (electronicDevices.size() == 0 || flag < 0) {
            System.out.println("Không tìm thấy sản phẩm");
        }

    }
    //Sắp xếp sản phẩm
    private void sortSort(){
        electronicDevices.sort(new Comparator<ElectronicDevice>() {
            @Override
            public int compare(ElectronicDevice o1, ElectronicDevice o2) {
                return (Integer.parseInt(o1.getId())) - (Integer.parseInt(o2.getId()));
            }
        });
    }
    public void sortElement(){
        sortSort();
        readWriteFile.writeToFile(electronicDevices);
    }
    //Sửa theo tên sản phẩm
    public void editElement(Scanner scanner) {
        int flag = -1;
        String newId;
        String newName;
        double newCost;
        String newColor;
        int newQuantity;
        String newCooling;
        String newScreenType;
        String newCard;
        System.out.println("Mởi bạn nhập id sản phẩm: ");
        String id = scanner.nextLine();
        for (ElectronicDevice e : electronicDevices) {
            if (id.equals(e.getId())) {
                System.out.println("Mời bạn nhập id : ");
                newId = getID(scanner);
                System.out.println("Mời bạn nhập tên: ");
                newName = scanner.nextLine();
                System.out.println("Mời bạn nhập giá: ");
                newCost = checkDouble(scanner);
                System.out.println("Mời bạn nhập màu: ");
                newColor = scanner.nextLine();
                System.out.println("Mời bạn nhập số lượng: ");
                newQuantity = checkInt(scanner);
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
                break;
            }
            flag = 0;
        }
        if (flag < 0) {
            for (ElectronicDevice e :
                    electronicDevices) {
                if (!id.equals(e.getId())) {
                    System.out.println("""
                     -----------------------------------------------------------------------
                    |         Không tìm thấy sản phẩm cần sửa. Bạn có muốn nhập lại không?  |
                    |         10. Có, mời bạn nhập lại:                                     |
                    |         11. Thoát ra menu.                                            |
                     -----------------------------------------------------------------------
                    """);
                    int inPut = checkInt(scanner);
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
                    break;
                }
            }
        }
        readWriteFile.writeToFile(electronicDevices);
    }

    public int checkInt(Scanner scanner) {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            System.out.println("Nhập sai, mời bạn nhập lại: ");
        }
        return checkInt(scanner);
    }

    public double checkDouble(Scanner scanner) {
        try {
            return Double.parseDouble(scanner.nextLine());
        } catch (Exception e) {
            System.out.println("Nhập sai, mời bạn nhập lại: ");
        }
        return checkDouble(scanner);
    }

    public String getID(Scanner scanner) {
        while (true) {
            try {
                String id = scanner.nextLine();
                if (login.Regex.validateId(id)) {

                    for (ElectronicDevice e : electronicDevices) {
                        if (e.getId().equals(id)) {
                            throw new Exception();
                        }
                    }
                    return id;
                } else System.out.println("Mời bạn nhập id từ 0->9.");
            } catch (Exception e) {
                System.out.println("Mời bạn nhập id khác: ");
            }
        }
    }
}
