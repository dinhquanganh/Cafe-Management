package OrderList;

import Menu.Menu;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class OrderList {

  public static Scanner sc = new Scanner(System.in);
  public DateTimeFormatter datetimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss dd/MM/yyyy");

  // Variable
  protected String id;
  private String tablePosition;
  private float totalBill;
  private LocalDateTime orderAt;
  private ArrayList<OrderItem> orderItems;
  private boolean isPay;

  // Constructor
  public OrderList() {
    this.isPay = false;
  }

  public OrderList(String id, String tablePosition, float totalBill, LocalDateTime orderAt,
      ArrayList<OrderItem> orderItems, boolean isPay) {
    this.id = id;
    this.tablePosition = tablePosition;
    this.totalBill = totalBill;
    this.orderAt = orderAt;
    this.orderItems = orderItems;
    this.isPay = isPay;
  }

  // Nhập dữ liệu
  public OrderList enterInformation(String id) {
    this.id = id;
    this.orderAt = LocalDateTime.now();
    System.out.print("Vị trí bàn: ");
    tablePosition = sc.nextLine();
    System.out.println("Danh sách các đồ order");
    orderItems = new ArrayList<>();
    while (true) {
      String option;
      OrderItem varHandleOrderItem = new OrderItem(), newData;
      while (true) {
        try {
          newData = varHandleOrderItem.enterInformation();
          for (OrderItem item : orderItems) {
            if (Objects.equals(item.id, newData.id)) {
              throw new Exception("Trùng lặp id trước đó");
            }
          }
        } catch (Exception e) {
          System.out.println(e);
          System.out.println("Vui lòng nhập lại");
          continue;
        }
        break;
      }
      orderItems.add(newData);
      System.out.print("Tiếp tục nhập(y/n)?");
      while (true) {
        try {
          option = sc.nextLine();
          if (!option.equals("y") && !option.equals("n")) {
            throw new ArithmeticException("Dữ liệu không đúng");
          }
        } catch (Exception e) {
          System.out.println(e);
          System.out.println("Vui lòng nhập lại (y/n)");
          continue;
        }
        break;
      }
      if (option.equals("n")) {
        break;
      }
    }
    return new OrderList(this.id, tablePosition, totalBill, orderAt, orderItems, isPay);
  }

  // Xuất đơn dữ liệu
  public void showInformation(ArrayList<Menu> menu) {
    System.out.println("Id: " + id);
    System.out.println("Bàn order: " + tablePosition);
    System.out.println("Đặt lúc: " + orderAt.format(datetimeFormatter));
    System.out.println("Danh sách order: ");
    for (OrderItem i : orderItems) {
      for (Menu j : menu) {
        if (Objects.equals(i.id, j.getId())) {
          System.out.println(
              "    - Tên đồ ăn/uống: " + j.getName() + " / Số lượng order: " + i.getQuantity());
        }
      }
    }
    System.out.println("Thanh toán: " + (!isPay ? "Chưa thanh toán" : "Đã thanh toán"));
  }
}
