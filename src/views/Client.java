package views;

import controller.ElectronicManager;
import model.ElectronicDevice;
import model.Fridge;
import model.MobilePhone;
import model.Pc;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Client {
    public static List<ElectronicDevice> electronicDevices= new ArrayList<>();
    public static ElectronicManager admin = new ElectronicManager(electronicDevices);
    public static Scanner checkInput = new Scanner(System.in);
    public static int inPut;

    public static void main(String[] args) {
        do {
            System.out.println("------------------Mune---------------------");
            System.out.println("1. Danh sach san pham");
            System.out.println("2. Tong tien thanh toan");

            System.out.println("3. Them san pham");
            System.out.println("4. Sua san pham");
            System.out.println("5. Xoa san pham");
            System.out.println("0. Thoat chuong trinh");
            System.out.println("Moi ban chon: ");
            inPut = checkInput.nextInt();
            switch (inPut){
                case 1: admin.display();
                case 2: admin.priceElectronicDevice();
                case 3: admin.addElement(addElectronicDevice());
                case 4: admin.editElement(checkInput);
                case 5: admin.deleteElement();
                case 0: System.exit(inPut);
                default:
                    System.out.println("Nhap sai du lieu roi");
            }
        }while (true);
    }
    public static ElectronicDevice addElectronicDevice() {
        System.out.println("Ban muon them san pham nao? ");
        System.out.println("1. Them dien thoai: ");
        System.out.println("2. Them may tinh: ");
        System.out.println("3. Them tu lanh");
        System.out.println("0. Thoat ra");
        inPut = checkInput.nextInt();
        switch (inPut) {
            case 1: {
                System.out.println("Nhap id dien thoai: ");
                int id = checkInput.nextInt();
                System.out.println("Nhap ten dien thoai: ");
                String name = checkInput.nextLine();
                System.out.println("Nhap gia tien dien thoai: ");
                double cost = checkInput.nextDouble();
                System.out.println("Nhap mau sac dien thoai: ");
                String color = checkInput.nextLine();
                System.out.println("nhap so luong dien thoai: ");
                int quantity = checkInput.nextInt();
                System.out.println("Nhap kieu man hinh: ");
                String typeOfScreen = checkInput.nextLine();
                return new MobilePhone(id, name, cost, color, quantity, typeOfScreen);
            }
            case 2: {
                System.out.println("Nhap id may tinh: ");
                int id = checkInput.nextInt();
                System.out.println("Nhap ten may tinh: ");
                String name = checkInput.nextLine();
                System.out.println("Nhap gia tien: ");
                double cost = checkInput.nextDouble();
                System.out.println("nhap mau sac: ");
                String color = checkInput.nextLine();
                System.out.println("nhap so luong may tinh: ");
                int quantity = checkInput.nextInt();
                System.out.println("nhap loai card cua may: ");
                String card = checkInput.nextLine();
                return new Pc(id, name, cost, color, quantity, card);
            }
            case 3: {
                System.out.println("Nhap id tu lanh:");
                int id = checkInput.nextInt();
                String b = checkInput.nextLine();
                System.out.println("nhap ten tu lanh: ");
                String name = checkInput.nextLine();
                System.out.println("nhap gia tien: ");
                double cost = checkInput.nextDouble();
                String c = checkInput.nextLine();
                System.out.println("nhap mau sac san pham: ");
                String color = checkInput.nextLine();
                System.out.println("Nhap so luong tu lanh: ");
                int quantity = checkInput.nextInt();
                String d =checkInput.nextLine();
                System.out.println("nhap loai tu lanh: ");
                String cooling = checkInput.nextLine();
                return new Fridge(id, name, cost, color, quantity, cooling);
            }
            case 0: System.exit(inPut);
            default:
                System.out.println("Nhap sai du lieu roi");
        }
        return null;
    }
}
