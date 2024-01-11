package practice06_Cart;

public class Product {
  
  // field 
  private String name;
  private int price;
  
  
  //constructor
  public Product() {
  
  }

  //method
  public Product(String name, int price) {
    super();
    this.name = name;
    this.price = price;
  }


  public String getName() {
    return name;
  }


  public void setName(String name) {
    this.name = name;
  }


  public int getPrice() {
    return price;
  }


  public void setPrice(int price) {
    this.price = price;
  }
  
  
 
  
  

}
