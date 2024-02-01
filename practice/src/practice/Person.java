package practice;

public class Person {
  
  String name;
  String phone;
  String gender;
  
  public Person() {
    // TODO Auto-generated constructor stub
  }
  public Person(String name, String phone, String gender) {
    super();
    this.name = name;
    this.phone = phone;
    this.gender = gender;
  }
  @Override
  public String toString() {
    return "Person [name=" + name + ", phone=" + phone + ", gender=" + gender + "]";
  }
 

}
