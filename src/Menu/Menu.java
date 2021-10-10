package Menu;

import java.util.Scanner;

public class Menu {

  // Variable
  private String id, name, type;
  private float price;
  public static Scanner sc = new Scanner(System.in);

  // Constructor
  public Menu() {
  }

  public Menu(String id, String name, String type, float price) {
    this.id = id;
    this.name = name;
    this.type = type;
    this.price = price;
  }

  // Getter
  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getType() {
    return type;
  }

  public float getPrice() {
    return price;
  }

  // Nhập dữ liệu
  public Menu enterInformation(String id) {
    this.id = id;
    System.out.print("Tên: ");
    name = sc.nextLine();
    System.out.print("Loại (đồ ăn/đồ uống): ");
    type = sc.nextLine();
    System.out.print("Giá sản phẩm: ");
    price = Float.parseFloat(sc.nextLine());
    return new Menu(this.id, name, type, price);
  }


  // Xuất đơn
  public void showInformation() {
    System.out.println("  ID: " + id);
    System.out.println("  Tên: " + name);
    System.out.println("  Loại: " + type);
    System.out.println("  Giá sản phẩm: " + price);
  }

  // Xuất danh sách
  public void showAllInformation(Menu[] a) {
    int i = 0;
    for (Menu menuItem : a) {
      System.out.println((++i));
      menuItem.showInformation();
    }
  }

}
