package OrderList;

import java.util.Scanner;

public class OrderItem extends OrderList {

  // Variable
  public static Scanner sc = new Scanner(System.in);
  private int quantity;

  // Constructor
  public OrderItem() {
  }

  public OrderItem(String id, int quantity) {
    super.id = id;
    this.quantity = quantity;
  }

  // Getter
  public int getQuantity() {
    return quantity;
  }

  // Nhập dữ liệu
  public OrderItem enterInformation() {
    System.out.print("-- Nhập id đồ ăn/uống: ");
    id = sc.nextLine();
    System.out.print("-- Nhập số lượng: ");
    quantity = Integer.parseInt(sc.nextLine());
    return new OrderItem(id, quantity);
  }
}
