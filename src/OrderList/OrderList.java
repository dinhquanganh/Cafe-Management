package OrderList;

import Menu.Menu;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class OrderList {

  // Variable
  public static Scanner sc = new Scanner(System.in);
  public DateTimeFormatter datetimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss dd/MM/yyyy");
  public String id;
  private String tablePosition;
  private LocalDateTime orderAt;
  private ArrayList<OrderItem> orderItems;
  private boolean isPay;

  // Constructor
  public OrderList() {
    this.isPay = false;
  }

  public OrderList(String id, String tablePosition, LocalDateTime orderAt,
      ArrayList<OrderItem> orderItems, boolean isPay) {
    this.id = id;
    this.tablePosition = tablePosition;
    this.orderAt = orderAt;
    this.orderItems = orderItems;
    this.isPay = isPay;
  }

  // Getter
  public String getId() {
    return id;
  }

  public String getTablePosition() {
    return tablePosition;
  }

  public LocalDateTime getOrderAt() {
    return orderAt;
  }

  public ArrayList<OrderItem> getOrderItems() {
    return orderItems;
  }

  public boolean getIsPay() {
    return isPay;
  }

  // Nhập mảng order
  public ArrayList<OrderItem> enterArrayOrderItem(ArrayList<Menu> menu) {
    ArrayList<OrderItem> orderItems = new ArrayList<>();
    while (true) {
      String option;
      OrderItem varHandleOrderItem = new OrderItem(), newData;
      while (true) {
        try {
          newData = varHandleOrderItem.enterInformation();
          // Kiểm tra sự xuất hiện id trong danh sách menu
          boolean checkAppear = false;
          for (Menu menuItem : menu) {
            if (Objects.equals(menuItem.getId(), newData.id)) {
              checkAppear = true;
              break;
            }
          }
          if (checkAppear) {
            // Kiểm tra trùng lặp id trong danh sách hiện tại
            for (OrderItem item : orderItems) {
              if (Objects.equals(item.id, newData.id)) {
                throw new ArithmeticException("Trùng lặp id trước đó!");
              }
            }
          } else {
            throw new ArithmeticException("Không tìm thấy id món ăn này!");
          }
        } catch (Exception e) {
          System.out.println(e);
          System.out.println("Vui lòng nhập lại");
          continue;
        }
        break;
      }
      orderItems.add(newData);
      System.out.print("Tiếp tục nhập(y/n)? ");
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
    return orderItems;
  }

  // Nhập dữ liệu
  public OrderList enterInformation(String id, ArrayList<Menu> menu) {
    this.id = id;
    this.orderAt = LocalDateTime.now();
    isPay = false;
    System.out.print("Tên hoặc vị trí bàn order: ");
    tablePosition = sc.nextLine();
    System.out.println("Danh sách các đồ order: ");
    orderItems = enterArrayOrderItem(menu);

    return new OrderList(this.id, tablePosition, this.orderAt, orderItems, isPay);
  }

  // Xuất đơn dữ liệu
  public void showInformation(ArrayList<Menu> menu) {
    System.out.println("Id order: " + id);
    System.out.println("Bàn order: " + tablePosition);
    System.out.println("Đặt lúc: " + orderAt.format(datetimeFormatter));
    System.out.println("Danh sách order: ");
    for (OrderItem i : orderItems) {
      for (Menu j : menu) {
        if (Objects.equals(i.id, j.getId())) {
          System.out.println(
              "    - Tên đồ ăn/uống: " + j.getName() + " | Số lượng order: " + i.getQuantity());
        }
      }
    }
    System.out.println("Trạng thái: " + (!isPay ? "Chưa thanh toán" : "Đã thanh toán"));
  }
}
