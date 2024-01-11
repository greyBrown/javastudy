package practice06_Cart;

public class Customer {

  //field
  private int money;
  private Cart cart;
  
  //constructor
  public Customer() {

  }

  public Customer(int money) {
    super();
    this.money = money;
  }

  public int getMoney() {
    return money;
  }

  public void setMoney(int money) {
    this.money = money;
  }

  public Cart getCart() {
    return cart;
  }

  public void setCart(Cart cart) {
    this.cart = cart;
  }
  
  // 물건넣기
  
  public void addToCart(Product product) { //null 체크 안하는 이유 : 카트 메소드가 한다.
    cart.addProduct(product); 
    }
  

  
  public void changeCart(int idx, Product product) { 
    cart.changeProduct(idx, product);
  }
    
  // 물건 빼기
  public void removeCart(int idx) {
    cart.removeProduct(idx);
  }
  
  // 구매
  // 반환 : 영수증
  
  public String buy() {
    
    int total = 0;
    String receipt = "영수증\n";
    
    for (int i = 0, count = cart.getCount(); i < count ; i++) {  
      //상수값임 count 값을 계속 메소드 호출하면서 사용할 필요 없으니 바꿔줄게요. 
      //이런 이유로 반복되는 조건에 메소드 호출하지 않아여! 필드값이 와야합니다. 메소드 노 필드 예스
      //이런거 성능에 중요한 요소라서 꼭 유의할것! 메소드가 들어간다면 최초값에 넣고 변수로 고정시켜주기! 반복조건에는 노!
      
      //cart에서 뺀 물건 1개
     Product product = cart.getProducts()[i]; 
     //이런 메소드 있었니...? 이따 보자....
     
     // 총 구매액 계산
     total += product.getPrice();
     
     
     // 구매 가능 여부 체크
     if(money < total) {
       System.out.println("구매금액이 부족합니다.");
       return null;
     }
     
    
     
     //영수증 만들기
     
     receipt += product.getName();
     receipt +="......";
     receipt += product.getPrice();
     receipt += "\n";
      }
     
     //구매
     money -= total;
     //영수증 만들기 추가
     receipt += "총 구매액......" + total + "\n";
     
    
     return receipt;
     
     
   
    

  
  
  
 
  
  
}
  
}
