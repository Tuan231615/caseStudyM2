package views;

import controller.ElectronicManager;
import model.ElectronicDevice;
import model.Fridge;
import model.MobilePhone;
import model.Pc;

import java.util.Scanner;

import static login.Login.login;

public class Client {
    public static ElectronicManager admin = ElectronicManager.getInstance();
    public static Scanner checkInput = new Scanner(System.in);
    public static int inPut = -1;

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
            System.out.println("10. Đăng xuất");
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

                    admin.deleteElement(checkInput);
                    break;
                case 6:
                    admin.searchElement(checkInput);
                    break;
                case 0:

                    System.exit(inPut);
                case 10:
                    login();
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
            System.out.println("3. Đăng xuất");
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
                case 3:
                    login();
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
                int id = Integer.parseInt(checkInput.nextLine());
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
                menuManage();
            default:
                System.out.println("Nhập sai dữ liệu");
        }
        return addElectronicDevice();
    }

    public static void loginReal() {
        System.out.println("Bạn có muốn nhập lại không?");
        System.out.println("0. Thoát");
        System.out.println("1. Nhập lại: ");
        switch (inPut) {
            case 0:
                System.exit(inPut);
            case 1:
                login();
                break;
            default:
                System.out.println("Nhập lỗi.");
        }
    }
}
