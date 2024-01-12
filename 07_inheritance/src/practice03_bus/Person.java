package practice03_bus;

public class Person {
  
  private String name;
  
  
  public Person() {
    
  }

  public Person(String name) {
     this.name = name;
  }
  
  
  
  public void passenger() {
    System.out.println(this.name +"이 타고 있습니다.");
  }

  public String getPerson() {
    return name;
  }

  public void setPerson(String name) {
    this.name = name;
  }
  
  
  
  
  
  
  
}


