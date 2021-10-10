import Menu.Menu;
import Staff.Staff;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class App {

  public static Scanner sc = new Scanner(System.in);

  public static void menulist() {
    System.out.println("---------------------------------");
    System.out.println("1. Qu?n lý nhân viên ");
    System.out.println("2. Qu?n lý menu ");
    System.out.println("3. Qu?n lý danh sách order hi?n có");
    System.out.println("4. Qu?n lý danh sách thanh toán");
    System.out.println("5. Thoát ch??ng trình");
  }

  public static void menuItem(int controller) {
    System.out.println("---------------------------------");
    switch (controller) {
      case 1 -> {
        System.out.println("1. Nh?p danh sách nhân viên ");
        System.out.println("2. Thêm nhân viên ");
        System.out.println("3. Hi?n th? thông tin danh sách ");
        System.out.println("4. Xoá nhân viên");
        System.out.println("5. S?a thông tin nhân viên");
        System.out.println("6. Thoát ch??ng trình");
      }
      case 2 -> {
        System.out.println("1. Nh?p danh sách ?? ?n/u?ng ");
        System.out.println("2. Thêm ?? ?n/u?ng");
        System.out.println("3. Hi?n th? danh sách ?? ?n/u?ng ");
        System.out.println("4. Xoá ?? ?n/u?ng");
        System.out.println("5. S?a danh sách");
        System.out.println("6. Thoát ch??ng trình");
      }
      case 3 -> {
        System.out.println("1. Thêm order ");
        System.out.println("2. Hi?n th? danh sách order ");
        System.out.println("3. Xoá order");
        System.out.println("4. S?a order");
        System.out.println("5. Thoát ch??ng trình");
      }
      case 4 -> {
        System.out.println("2. Hi?n th? thanh toán ");
        System.out.println("5. Thoát ch??ng trình");
      }
    }
  }

  public static void cancelProgram() {
    String controller;
    while (true) {
      try {
        System.out.println("Ti?p t?c (yes/no)? ");
        controller = sc.nextLine();
        if (!Objects.equals(controller, "yes") && !Objects.equals(controller, "no")) {
          throw new IllegalStateException("Vui lòng th? l?i!");
        } else {
          if (controller.equals("no")) {
            System.exit(0);
          }
        }
      } catch (Exception e) {
        System.out.println("Vui lòng nh?p l?i!");
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
        System.out.println("Vui lòng nh?p l?i!");
      }
      break;
    }
    return value;
  }

  public static void main(String[] args) {

    int n, varController1, varController2;
    ArrayList<Menu> menuArray = new ArrayList<>();
    var staffArray = new ArrayList<Staff>();
    while (true) {
      menulist();
      System.out.print("? Ch?n option: ");
      varController1 = checkInt();
      switch (varController1) {
        case 0: {
          while (true) {
            menuItem(varController1);
            System.out.print("? Ch?n option: ");
            varController2 = checkInt();
            if (varController2 == 1) {
                System.out.println("1");
            } else if (varController2 == 2) {
                System.out.println("2");
            } else if (varController2 == 3) {
                System.out.println("3");
            } else {
                System.out.println("Vui lòng nh?p l?i");
            }
          }
        }
        case 1: {
            Staff varHandleStaff = new Staff();
            while (true) {
                menuItem(varController1);
                System.out.print("? Ch?n option: ");
                varController2 = checkInt();
                if (varController2 == 1) {
                    System.out.print("Nh?p s? l??ng nhân viên: ");
                    n = checkInt();
                    sc.nextLine();
                    staffArray = new ArrayList<>(n);
                    for (int i = 0; i < n; i++) {
                        System.out.println("Nh?p thông tin nhân viên: " + (i + 1));
                        staffArray.add(varHandleStaff.enterStaff());
                    }          
                } else if (varController2 == 2) {
                    System.out.println("Nh?p thông tin nhân viên can thêm: ");
                    staffArray.add(varHandleStaff.enterStaff());
                } else if (varController2 == 3) {
                    int i = 0;
                    for (Staff staffItem : staffArray) {
                      System.out.println("Thông tin nhân viên " + (++i));
                      staffItem.showStaff();
                    }
                } else if (varController2 == 4) {
                    System.out.print("Nh?p id nhân viên c?n xoá: ");
                    sc.nextLine();
                    String idFind = sc.nextLine();
                    for (int i = 0; i < staffArray.size(); i++) {
                      if (Objects.equals(idFind, staffArray.get(i).getId())) {
                        staffArray.remove(i);
                      }
                    }
                } else if (varController2 == 5) {
                    System.out.print("Nh?p id nhân viên cân sua: ");

                    sc.nextLine();
                    String idFind = sc.nextLine();
                    for (int i = 0; i < staffArray.size(); i++) {
                      if (Objects.equals(idFind, staffArray.get(i).getId())) {
                        System.out.print("Nh?p lo?i thông tin b?n mu?n s?a (name/age/address/position): ");
                        String option = sc.nextLine();
                        System.out.print("Nh?p d? li?u m?i: ");
                        String newValue = "";
                        int newValueInt = (int) 0f;
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
                              new Staff(staffArray.get(i).getId(),staffArray.get(i).getName(), newValueInt, 
                                  staffArray.get(i).getAddress(), staffArray.get(i).getPosition()));
                        } else if (option.equals("address")) {
                         staffArray.set(i,
                              new Staff(staffArray.get(i).getId(),staffArray.get(i).getName(),staffArray.get(i).getAge(),
                                      newValue,staffArray.get(i).getPosition()));
                        }else if (option.equals("position")) {
                         staffArray.set(i,
                              new Staff(staffArray.get(i).getId(),staffArray.get(i).getName(),staffArray.get(i).getAge(),
                                      staffArray.get(i).getAddress(),newValue));
                        }  else {
                          System.out.println("Không t?n t?i lo?i thông tin b?n mu?n s?a");
                        } 
                      } else if (varController2 == 6) {
                            break;
                       }
                    }
                  }
            }
        }
        case 2: {
          Menu varHandleMenu = new Menu();
          while (true) {
            menuItem(varController1);
            System.out.print("? Ch?n option: ");
            varController2 = checkInt();
            if (varController2 == 1) {
              System.out.print("Nh?p s? l??ng ?? ?n/u?ng: ");
              n = checkInt();
              sc.nextLine();
              menuArray = new ArrayList<>(n);
              for (int i = 0; i < n; i++) {
                System.out.println("Nh?p ?? ?n/u?ng " + (i + 1));
                menuArray.add(varHandleMenu.enterInformation());
              }
            } else if (varController2 == 2) {
              System.out.println("--------Nh?p d? li?u ?? ?n/u?ng");
              menuArray.add(varHandleMenu.enterInformation());
            } else if (varController2 == 3) {
              int i = 0;
              for (Menu menuItem : menuArray) {
                System.out.println("Thông tin ?? ?n " + (++i));
                menuItem.showInformation();
              }
            } else if (varController2 == 4) {
              System.out.print("Nh?p id ?? ?n/u?ng c?n xoá: ");
              sc.nextLine();
              String idFind = sc.nextLine();
              for (int i = 0; i < menuArray.size(); i++) {
                if (Objects.equals(idFind, menuArray.get(i).getId())) {
                  menuArray.remove(i);
                }
              }
            } else if (varController2 == 5) {
              System.out.print("Nh?p id ?? ?n/u?ng c?n s?a: ");

              sc.nextLine();
              String idFind = sc.nextLine();
              for (int i = 0; i < menuArray.size(); i++) {
                if (Objects.equals(idFind, menuArray.get(i).getId())) {
                  System.out.print("Nh?p lo?i thông tin b?n mu?n s?a (name/type/price): ");
                  String option = sc.nextLine();
                  System.out.print("Nh?p d? li?u m?i: ");
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
                    System.out.println("Không t?n t?i lo?i thông tin b?n mu?n s?a");
                  }
                }
              }
            } else if (varController2 == 6) {
              break;
            } else {
              System.out.println("Vui lòng nh?p l?i");
            }
          }
        }
        case 5: {
          System.exit(0);
        }
        default: {
          System.out.println("Vui lòng nh?p l?i");
        }
      }
    }
  }
}

