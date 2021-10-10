import Menu.Menu;
import OrderList.OrderList;
import Staff.Staff;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.util.UUID;

public class App {

  public static Scanner sc = new Scanner(System.in);

  /**
   * Generate short UUID (13 characters)
   *
   * @return short UUID
   */
  public static String shortUUID() {
    UUID uuid = UUID.randomUUID();
    long l = ByteBuffer.wrap(uuid.toString().getBytes()).getLong();
    return Long.toString(l, Character.MAX_RADIX);
  }

  public static void menulist() {
    System.out.println("---------------------------------");
    System.out.println("1. Quản lý nhân viên ");
    System.out.println("2. Quản lý menu ");
    System.out.println("3. Quản lý danh sách order");
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
    ArrayList<Staff> staffArray = new ArrayList<>();
    ArrayList<Menu> menuArray = new ArrayList<>();
    ArrayList<OrderList> orderArray = new ArrayList<>();

    while (true) {
      menulist();
      System.out.print("❔ Chọn option: ");
      varController1 = checkInt();
      switch (varController1) {
        case 1: {
          Staff varHandleStaff = new Staff();
          while (true) {
            menuItem(varController1);
            System.out.print("❔ Chọn option: ");
            varController2 = checkInt();
            if (varController2 == 1) {
              System.out.print("---- Nhập số lượng nhân viên: ");
              n = checkInt();
              sc.nextLine();
              staffArray = new ArrayList<>(n);
              for (int i = 0; i < n; i++) {
                System.out.println("---- Nhập thông tin nhân viên " + (i + 1));
                staffArray.add(varHandleStaff.enterInformation(shortUUID()));
              }
            } else if (varController2 == 2) {
              System.out.println("---- Nhập thông tin nhân viên cần thêm: ");
              staffArray.add(varHandleStaff.enterInformation(shortUUID()));
            } else if (varController2 == 3) {
              int i = 0;
              for (Staff staffItem : staffArray) {
                System.out.println("---- Thông tin nhân viên " + (++i) + " ----");
                staffItem.showInformation();
              }
            } else if (varController2 == 4) {
              System.out.print("---- Nhập id nhân viên cần xoá: ");
              sc.nextLine();
              String idFind = sc.nextLine();
              for (int i = 0; i < staffArray.size(); i++) {
                if (Objects.equals(idFind, staffArray.get(i).getId())) {
                  staffArray.remove(i);
                  break;
                }
                if (!Objects.equals(idFind, staffArray.get(i).getId())
                    && i == staffArray.size() - 1) {
                  System.out.println("❌ Không tìm thấy");
                }
              }
            } else if (varController2 == 5) {
              System.out.print("---- Nhập id nhân viên cần sửa: ");
              sc.nextLine();
              String idFind = sc.nextLine();
              for (int i = 0; i < staffArray.size(); i++) {
                if (Objects.equals(idFind, staffArray.get(i).getId())) {
                  System.out.print(
                      "---- Nhập loại thông tin bạn muốn sửa (name/age/address/position): ");
                  String option = sc.nextLine();
                  System.out.print("---- Nhập dữ liệu mới: ");
                  String newValue = "";
                  int newValueInt = 0;
                  if (option.equals("age")) {
                    newValueInt = sc.nextInt();
                  } else {
                    newValue = sc.nextLine();
                  }
                  if (option.equals("name")) {
                    staffArray.set(i,
                        new Staff(staffArray.get(i).getId(), newValue, staffArray.get(i).getAge(),
                            staffArray.get(i).getAddress(), staffArray.get(i).getPosition()));
                  } else if (option.equals("age")) {
                    staffArray.set(i,
                        new Staff(staffArray.get(i).getId(), staffArray.get(i).getName(),
                            newValueInt,
                            staffArray.get(i).getAddress(), staffArray.get(i).getPosition()));
                  } else if (option.equals("address")) {
                    staffArray.set(i,
                        new Staff(staffArray.get(i).getId(), staffArray.get(i).getName(),
                            staffArray.get(i).getAge(),
                            newValue, staffArray.get(i).getPosition()));
                  } else if (option.equals("position")) {
                    staffArray.set(i,
                        new Staff(staffArray.get(i).getId(), staffArray.get(i).getName(),
                            staffArray.get(i).getAge(),
                            staffArray.get(i).getAddress(), newValue));
                  } else {
                    System.out.println("❌ Không tìm thấy thông tin bạn muốn sửa");
                  }
                }
              }
            } else if (varController2 == 6) {
              break;
            } else {
              System.out.println("Vui lòng nhập lại");
            }
          }
          break;
        }
        case 2: {
          Menu varHandleMenu = new Menu();
          while (true) {
            menuItem(varController1);
            System.out.print("❔ Chọn option: ");
            varController2 = checkInt();
            if (varController2 == 1) {
              System.out.print("---- Nhập số lượng đồ ăn/uống: ");
              n = checkInt();
              sc.nextLine();
              menuArray = new ArrayList<>(n);
              for (int i = 0; i < n; i++) {
                System.out.println("---- Nhập đồ ăn/uống " + (i + 1));
                menuArray.add(varHandleMenu.enterInformation(shortUUID()));
              }
            } else if (varController2 == 2) {
              System.out.println("---- Nhập dữ liệu đồ ăn/uống");
              menuArray.add(varHandleMenu.enterInformation(shortUUID()));
            } else if (varController2 == 3) {
              int i = 0;
              for (Menu menuItem : menuArray) {
                System.out.println("---- Thông tin đồ ăn " + (++i) + " ----");
                menuItem.showInformation();
              }
            } else if (varController2 == 4) {
              System.out.print("---- Nhập id đồ ăn/uống cần xoá: ");
              sc.nextLine();
              String idFind = sc.nextLine();
              for (int i = 0; i < menuArray.size(); i++) {
                if (Objects.equals(idFind, menuArray.get(i).getId())) {
                  menuArray.remove(i);
                }
              }
            } else if (varController2 == 5) {
              System.out.print("---- Nhập id đồ ăn/uống cần sửa: ");
              sc.nextLine();
              String idFind = sc.nextLine();
              for (int i = 0; i < menuArray.size(); i++) {
                if (Objects.equals(idFind, menuArray.get(i).getId())) {
                  System.out.print("---- Nhập loại thông tin bạn muốn sửa (name/type/price): ");
                  String option = sc.nextLine();
                  System.out.print("---- Nhập dữ liệu mới: ");
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
                    System.out.println("❌ Không tồn tại loại thông tin bạn muốn sửa");
                  }
                }
              }
            } else if (varController2 == 6) {
              break;
            } else {
              System.out.println("Vui lòng nhập lại");
            }
          }
          break;
        }
        case 3: {
          OrderList varHandleOrder = new OrderList();
          while (true) {
            menuItem(varController1);
            System.out.print("❔ Chọn option: ");
            varController2 = checkInt();
            if (varController2 == 1) {
              System.out.println("---- Nhập dữ liệu order");
              orderArray.add(varHandleOrder.enterInformation(shortUUID()));
            } else if (varController2 == 2) {
              System.out.println("---- Hiển thị danh sách order");
              int i = 0;
              for (OrderList orderItem : orderArray) {
                System.out.println("---- Order " + (++i));
                orderItem.showInformation(menuArray);
              }
            } else if (varController2 == 3) {
              
            } else if (varController2 == 4) {

            } else if (varController2 == 5) {
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
