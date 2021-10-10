package Menu;

import java.util.Scanner;

public class Menu {

  private String id, name, type;
  private float price;
  public static Scanner sc = new Scanner(System.in);

  public Menu() {
  }

  public Menu(String id, String name, String type, float price) {
    this.id = id;
    this.name = name;
    this.type = type;
    this.price = price;
  }

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

  // Nhập
  public Menu enterInformation() {

    System.out.print("id");
    id = sc.nextLine();
    System.out.print("name");
    name = sc.nextLine();
    System.out.print("type");
    type = sc.nextLine();
    System.out.print("price");
    price = Float.parseFloat(sc.nextLine());
    return new Menu(id, name, type, price);
  }


  // Xuất đơn
  public void showInformation() {
    System.out.println("Id: " + id);
    System.out.println("Name: " + name);
    System.out.println("Type: " + type);
    System.out.println("Price: " + price);
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
