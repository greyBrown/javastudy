package pkg03_constructor;

public class Person {
  
  private String name;
  

  public Person(String name) {
    super(); //person은 부모가 없는데 이 친구는 뭐죠? object죱
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
  
  
  
  
  

}
