package views;

import login.Email;
import controller.ElectronicManager;
import login.Password;
import model.ElectronicDevice;
import model.Fridge;
import model.MobilePhone;
import model.Pc;
import storage.InReadWriteFile;
import storage.ReadWriteFile;

import java.util.List;
import java.util.Scanner;

public class Client {
    public static ElectronicManager admin = ElectronicManager.getInstance();
    public static Scanner checkInput = new Scanner(System.in);
    public static int inPut = -1;
    private static Email email1 = new Email();
    private static Password password = new Password();
    public static final String[] validEmail = new String[]{"trieu@gmail.com", "tuan@gmail.com"};
    public static final String[] validPassword = new String[]{"Trieu.2004"};
    public static void main(String[] args) {
        login();
    }

    public static void menuManage() {
        while (inPut != 0) {
            System.out.println("------------------Menu của quản lý---------------------");
            System.out.println("Your choise: ");
            System.out.println("1. Danh sách sản phẩm: ");
            System.out.println("2. Tổng tiền thanh toán: ");
            System.out.println("3. Thêm sản phẩm: ");
            System.out.println("4. Sửa sản phẩm: ");
            System.out.println("5. Xoá sản phẩm: ");
            System.out.println("6. tim kiem san pham: ");
            System.out.println("0. Thoát chương trình: ");
            inPut = Integer.parseInt(checkInput.nextLine());
            switch (inPut) {
                case 1:

                    admin.display();
                    break;
                case 2:

                    System.out.println(admin.priceElectronicDevice());
                    break;
                case 3:

                    admin.addElement(addElectronicDevice());
                    break;
                case 4:

                    admin.editElement(checkInput);
                    break;
                case 5:

                    admin.deleteElement();
                    break;
                case 6:
                    admin.searchElement(checkInput);
                    break;
                case 0:

                    System.exit(inPut);
                default:
                    System.out.println("Nhập sai dữ liệu");
            }
        }
    }

    public static void menuStaff() {
        while (inPut != 0) {
            System.out.println("------------------Menu nhan vien-----------------------");
            System.out.println("Your choise: ");
            System.out.println("1. Danh sách sản phẩm: ");
            System.out.println("2. Tổng tiền sản phẩm: ");
            System.out.println("0. Thoát chương trình.");
            System.out.println("Mời bạn nhập: ");
            inPut = Integer.parseInt(checkInput.nextLine());
            switch (inPut) {
                case 1:

                    admin.display();
                    break;
                case 2:

                    System.out.println(admin.totalPricePc());
                    break;
                case 0:
                    System.exit(inPut);
                default:
                    System.out.println("Lỗi nhập.");
            }
        }
    }

    public static ElectronicDevice addElectronicDevice() {
        System.out.println("Bạn muốn thêm sản phẩm nào? ");
        System.out.println("1. Thêm điện thoại: ");
        System.out.println("2. Thêm máy tính: ");
        System.out.println("3. Thêm tủ lạnh: ");
        System.out.println("0. Thoát ra");
        System.out.println("Mời bạn nhập: ");
        inPut = Integer.parseInt(checkInput.nextLine());
        switch (inPut) {
            case 1: {
                System.out.println("Nhập id điện thoại: ");
                int id = checkInput.nextInt();
                String b = checkInput.nextLine();
                System.out.println("Nhập tên điện thoại: ");
                String name = checkInput.nextLine();
                System.out.println("Nhập giá tiền điện thoại: ");
                double cost = Double.parseDouble(checkInput.nextLine());
                System.out.println("Nhập màu sắc điện thoại: ");
                String color = checkInput.nextLine();
                System.out.println("Nhập số lượng điện thoại: ");
                int quantity = Integer.parseInt(checkInput.nextLine());
                System.out.println("Nhập kiểu màn hình: ");
                String typeOfScreen = checkInput.nextLine();
                return new MobilePhone(id, name, cost, color, quantity, typeOfScreen);
            }
            case 2: {
                System.out.println("Nhập id máy tính: ");
                int id = Integer.parseInt(checkInput.nextLine());
                System.out.println("Nhập tên máy tính: ");
                String name = checkInput.nextLine();
                System.out.println("Nhập giá tiền máy tính: ");
                double cost = Double.parseDouble(checkInput.nextLine());
                System.out.println("nhập màu sắc máy tính: ");
                String color = checkInput.nextLine();
                System.out.println("Nhập số lượng máy tính: ");
                int quantity = Integer.parseInt(checkInput.nextLine());
                System.out.println("Nhập loại card: ");
                String card = checkInput.nextLine();
                return new Pc(id, name, cost, color, quantity, card);
            }
            case 3: {
                System.out.println("Nhập id tủ lạnh:");
                int id = Integer.parseInt(checkInput.nextLine());
                System.out.println("Nhập tên tủ lạnh: ");
                String name = checkInput.nextLine();
                System.out.println("Nhập giá tiền: ");
                double cost = Double.parseDouble(checkInput.nextLine());
                System.out.println("Nhập màu sắc: ");
                String color = checkInput.nextLine();
                System.out.println("Nhập số lựợng tủ lạnh: ");
                int quantity = Integer.parseInt(checkInput.nextLine());
                System.out.println("Nhập loại tủ lạnh: ");
                String cooling = checkInput.nextLine();
                return new Fridge(id, name, cost, color, quantity, cooling);
            }
            case 0:
                System.exit(inPut);
            default:
                System.out.println("Nhập sai dữ liệu");
        }
        return addElectronicDevice();
    }

    public static void login() {
        while (inPut != 0) {
            System.out.println("-----Login-----");
            System.out.println("1. Nhập tên tài khoản: ");
            String tk = checkInput.nextLine();
            System.out.println("2. Nhap mat khau: ");
            String password = checkInput.nextLine();
            for (String s : validEmail) {
                boolean isValid = email1.validate(s);
                for (String i:
                     validPassword) {
                    boolean isValid1 = password.validate(i);

                if (isValid && validEmail[0].equals(tk) && validPassword[1].equals(password)) {
                    menuManage();
                } else {
                    menuStaff();
                }
            }
                Ơ
        }

    }
}
