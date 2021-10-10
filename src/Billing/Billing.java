package Billing;

import Menu.Menu;
import OrderList.OrderItem;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Objects;

public class Billing {

  // Variable
  public DateTimeFormatter datetimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss dd/MM/yyyy");
  private String id, orderId, tablePosition;
  private final LocalDateTime payAt;
  private ArrayList<OrderItem> orderItems;

  // Constructor
  public Billing() {
    this.payAt = LocalDateTime.now();
  }

  public Billing(String id, String orderId, String tablePosition, ArrayList<OrderItem> orderItems) {
    this.id = id;
    this.orderId = orderId;
    this.tablePosition = tablePosition;
    this.payAt = LocalDateTime.now();
    this.orderItems = orderItems;
  }

  // Getter
  public String getOrderId() {
    return orderId;
  }

  // Show thông tin đồ ăn/uống
  public void showOrderItemInformation(ArrayList<Menu> menu) {
    float totalMoney = 0f;
    for (OrderItem i : orderItems) {
      for (Menu j : menu) {
        if (Objects.equals(i.id, j.getId())) {
          totalMoney += i.getQuantity() * j.getPrice();
          System.out.println(
              "    - Tên: " + j.getName() + " | Số lượng: " + i.getQuantity()
                  + " | Đơn giá: " + j.getPrice() + " | Thành tiền: "
                  + i.getQuantity() * j.getPrice());
        }
      }
    }
    System.out.println("  **TỔNG TIỀN: " + totalMoney);
  }

  // Xuất thông tin
  public void showInformation(
      ArrayList<Menu> menu) {
    System.out.println("  ID thanh toán: " + id);
    System.out.println("  Thanh toán lúc: " + payAt.format(datetimeFormatter));
    System.out.println("  Bàn: " + tablePosition);
    System.out.println("  Tên các đồ ăn/uống đã order:");
    showOrderItemInformation(menu);
  }
}
