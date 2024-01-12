package practice03_bus;

public class Man extends Person{

  private String name;

  
  @Override
   public void passenger() {
    System.out.println(this.name + "이 앉아있습니다.");
   }
   
}
