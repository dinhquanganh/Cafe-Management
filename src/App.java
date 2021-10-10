import Menu.Menu;
import java.util.ArrayList;
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
        System.out.println("3. Hiển thị danh sách đồ ăn/uống ");
        System.out.println("4. Xoá đồ ăn/uống");
        System.out.println("5. Sửa danh sách");
        System.out.println("6. Thoát chương trình");
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
    ArrayList<Menu> menuArray = new ArrayList<>();

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
            if (varController2 == 1) {

            } else if (varController2 == 2) {
              System.out.println("2");
            } else if (varController2 == 3) {
              System.out.println("2");
            } else {
              System.out.println("Vui lòng nhập lại");
            }
          }
        }
        case 2: {
          Menu varHandleMenu = new Menu();
          while (true) {
            menuItem(varController1);
            System.out.print("❔ Chọn option: ");
            varController2 = checkInt();
            if (varController2 == 1) {
              System.out.print("Nhập số lượng đồ ăn/uống: ");
              n = checkInt();
              sc.nextLine();
              menuArray = new ArrayList<>(n);
              for (int i = 0; i < n; i++) {
                System.out.println("Nhập đồ ăn/uống " + (i + 1));
                menuArray.add(varHandleMenu.enterInformation());
              }
            } else if (varController2 == 2) {
              System.out.println("--------Nhập dữ liệu đồ ăn/uống");
              menuArray.add(varHandleMenu.enterInformation());
            } else if (varController2 == 3) {
              int i = 0;
              for (Menu menuItem : menuArray) {
                System.out.println("Thông tin đồ ăn " + (++i));
                menuItem.showInformation();
              }
            } else if (varController2 == 4) {
              System.out.print("Nhập id đồ ăn/uống cần xoá: ");
              sc.nextLine();
              String idFind = sc.nextLine();
              for (int i = 0; i < menuArray.size(); i++) {
                if (Objects.equals(idFind, menuArray.get(i).getId())) {
                  menuArray.remove(i);
                }
              }
            } else if (varController2 == 5) {
              System.out.print("Nhập id đồ ăn/uống cần sửa: ");

              sc.nextLine();
              String idFind = sc.nextLine();
              for (int i = 0; i < menuArray.size(); i++) {
                if (Objects.equals(idFind, menuArray.get(i).getId())) {
                  System.out.print("Nhập loại thông tin bạn muốn sửa (name/type/price): ");
                  String option = sc.nextLine();
                  System.out.print("Nhập dữ liệu mới: ");
                  String newValue = "";
                  float newValueFloat = 0f;
                  if (option.equals("price")) {
                    newValueFloat = sc.nextFloat();
                  } else {
                    newValue = sc.nextLine();
                  }
                  if (option.equals("name")) {
                    menuArray.set(i,
                        new Menu(menuArray.get(i).getId(), newValue, menuArray.get(i).getType(),
                            menuArray.get(i).getPrice()));
                  } else if (option.equals("type")) {
                    menuArray.set(i,
                        new Menu(menuArray.get(i).getId(), menuArray.get(i).getName(), newValue,
                            menuArray.get(i).getPrice()));
                  } else if (option.equals("price")) {
                    menuArray.set(i,
                        new Menu(menuArray.get(i).getId(), menuArray.get(i).getName(),
                            menuArray.get(i).getType(), newValueFloat));
                  } else {
                    System.out.println("Không tồn tại loại thông tin bạn muốn sửa");
                  }
                }
              }
            } else if (varController2 == 6) {
              break;
            } else {
              System.out.println("Vui lòng nhập lại");
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
