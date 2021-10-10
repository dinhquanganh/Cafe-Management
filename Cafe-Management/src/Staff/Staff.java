package Staff;

import java.util.Scanner;

public class Staff {
  private String id, name, address, position ;
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

  // Nh?p
  public Staff enterStaff() {

    System.out.print("id");
    id = sc.nextLine();
    System.out.print("name");
    name = sc.nextLine();
    System.out.print("Age");
    age = Integer.parseInt(sc.nextLine());
    System.out.print("address");
    address = sc.nextLine();
    System.out.print("position");
    position = sc.nextLine();
    return new Staff (id, name, age, address, position);
  }


  // Xu?t ??n
  public void showStaff() {
    System.out.println("Id: " + id);
    System.out.println("Name: " + name);
    System.out.println("Age: " + age);
    System.out.println("Address: " + address);
    System.out.println("Position: " + position);
  }

  // Xu?t danh sách
  public void showAllStaff(Staff[] a) {
    int i = 0;
    for (Staff staffItem : a) {
      System.out.println((++i));
      staffItem.showStaff();
    }
  }

}
