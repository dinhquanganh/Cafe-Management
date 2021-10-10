package Staff;

import java.util.Scanner;

public class Staff {

  private String id, name, address, position;
  private int age;
  public static Scanner sc = new Scanner(System.in);

  public Staff() {
  }

  public Staff(String id, String name, int age, String address, String position) {
    this.id = id;
    this.name = name;
    this.address = address;
    this.position = position;
    this.age = age;
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getAddress() {
    return address;
  }

  public String getPosition() {
    return position;
  }

  public Integer getAge() {
    return age;
  }

  // Nhập
  public Staff enterInformation(String id) {
    this.id = id;
    System.out.print("Họ và tên: ");
    name = sc.nextLine();
    System.out.print("Tuổi: ");
    age = Integer.parseInt(sc.nextLine());
    System.out.print("Địa chỉ: ");
    address = sc.nextLine();
    System.out.print("Chức vụ hiện tại: ");
    position = sc.nextLine();
    return new Staff(this.id, name, age, address, position);
  }


  // Xuất đơn
  public void showInformation() {
    System.out.println("ID: " + id);
    System.out.println("Họ và tên: " + name);
    System.out.println("Tuổi: " + age);
    System.out.println("Địa chỉ: " + address);
    System.out.println("Chức vụ hiện tại: " + position);
  }

  // Xuất danh sách
  public void showAllStaff(Staff[] a) {
    int i = 0;
    for (Staff staffItem : a) {
      System.out.println((++i));
      staffItem.showInformation();
    }
  }

}
