package practice02_Cart;

public class MainClass {

  public static void main(String[] args) throws RuntimeException { //이렇게 메인에 박을 수도 있습니다. 개발자는 계속 회피하고, 마지막에 JVM이 받는다!

    try {
      //10000원 가진 고객
      Customer customer = new Customer(10000);
      
      //5개 물건 담을 수 있는 카트
      Cart cart = new Cart(10);
      
      //고객이 카트 가짐
      customer.setCart(cart);
      
      
      //고객 쇼핑
      customer.addToCart(new Product("맛동산", 3000));
      customer.addToCart(new Product("치토스", 10000));
      customer.addToCart(new Product("홈런볼", 5000));
      customer.changeCart(1, new Product("오땅", 1000));
      customer.removeCart(1);
      
      
      // 구매하면 영수증이 반환됨
      String receipt = customer.buy();
      
      // 영수증 확인
      System.out.println(receipt);
      
      // 고객정보 확인
      System.out.println("고객이 가진 돈 : " + customer.getMoney());
      
    } catch (Exception e) {
      
      System.out.println(e.getMessage());
      e.printStackTrace(); //개발시 예외추적용. 이러면 빨갛게 막 뭐라뭐라 같이 나와줍니다. 이런거 보고 추적하라고...
      
    }  
    
    
    
    
  }

}
