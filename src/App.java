import java.util.Objects;
import java.util.Scanner;

public class App {


  public static Scanner sc = new Scanner(System.in);

  public static void menulist() {
    System.out.println("---------------------------------");
    System.out.println("1. Quản lý nhân viên ");
    System.out.println("2. Quản lý menu ");
    System.out.println("3. Quản lý danh sách order hiện có");
    System.out.println("4. Quản lý danh sách thanh toán");
    System.out.println("5. Thoát chương trình");
  }

  public static void menuItem(int controller) {
    System.out.println("---------------------------------");
    switch (controller) {
      case 1 -> {
        System.out.println("1. Nhập danh sách nhân viên ");
        System.out.println("2. Thêm nhân viên ");
        System.out.println("3. Hiển thị thông tin danh sách ");
        System.out.println("4. Xoá nhân viên");
        System.out.println("5. Sửa thông tin nhân viên");
        System.out.println("6. Thoát chương trình");
      }
      case 2 -> {
        System.out.println("1. Nhập danh sách đồ ăn/uống ");
        System.out.println("2. Thêm đồ ăn/uống");
        System.out.println("2. Hiển thị danh sách đồ ăn/uống ");
        System.out.println("3. Xoá đồ ăn/uống");
        System.out.println("4. Sửa danh sách");
        System.out.println("5. Thoát chương trình");
      }
      case 3 -> {
        System.out.println("1. Thêm order ");
        System.out.println("2. Hiển thị danh sách order ");
        System.out.println("3. Xoá order");
        System.out.println("4. Sửa order");
        System.out.println("5. Thoát chương trình");
      }
      case 4 -> {
        System.out.println("2. Hiển thị thanh toán ");
        System.out.println("5. Thoát chương trình");
      }
    }

  }

  public static void cancelProgram() {
    String controller;
    while (true) {
      try {
        System.out.println("Tiếp tục (yes/no)? ");
        controller = sc.nextLine();
        if (!Objects.equals(controller, "yes") && !Objects.equals(controller, "no")) {
          throw new IllegalStateException("Vui lòng thử lại!");
        } else {
          if (controller.equals("no")) {
            System.exit(0);
          }
        }
      } catch (Exception e) {
        System.out.println("Vui lòng nhập lại!");
      }

    }
  }

  public static int checkInt() {
    int value = 0;
    while (true) {
      try {
        value = sc.nextInt();
      } catch (Exception e) {
        System.out.println(e.toString());
        System.out.println("Vui lòng nhập lại!");
      }
      break;
    }

    return value;
  }

  public static void main(String[] args) {

    int n, varController1, varController2;

    while (true) {
      menulist();
      System.out.print("❔ Chọn option: ");
      varController1 = checkInt();
      switch (varController1) {
        case 1: {
          while (true) {
            menuItem(varController1);
            System.out.print("❔ Chọn option: ");
            varController2 = checkInt();
            switch (varController2) {
              case 1: {

              }
              case 2: {

              }
              case 3: {

              }
              case 4: {

              }
              case 5: {
                System.exit(0);
              }
              default: {
                System.out.println("Vui lòng nhập lại");
              }
            }
          }
        }
        case 2: {
          while (true) {
            menuItem(varController1);
            System.out.print("❔ Chọn option");
            varController2 = checkInt();
            switch (varController2) {
              case 1: {
                System.out.println("1");
              }
              case 2: {

              }
              case 3: {

              }
              case 4: {

              }
              case 5: {
                System.exit(0);
              }
              default: {
                System.out.println("Vui lòng nhập lại");
              }
            }
          }
        }
        case 5: {
          System.exit(0);
        }
        default: {
          System.out.println("Vui lòng nhập lại");
        }
      }
    }
  }
}
