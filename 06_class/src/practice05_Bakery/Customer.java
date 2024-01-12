package practice05_Bakery;

public class Customer {
  
  //field
  private int money;
  private int count;
  
  public Customer() {
    // TODO Auto-generated constructor stub
  }

  public Customer(int money, int count) {
    super();
    this.money = money;
    this.count = count;
  }

  public int getMoney() {
    return money;
  }

  public void setMoney(int money) {
    this.money = money;
  }

  public int getCount() {
    return count;
  }

  public void setCount(int count) {
    this.count = count;
  }
  
  // 구매
  // 인자 : 구매할 가게, 구매할 빵 개수, 구매할 때 낼 돈
  // 반환 : 없음
  public void buy(Bakery bakery, int count, int money) { //이미 판매할때 예외처리 했죠? 그러니까 그건 sell이 해요. 여기서는 내가 못사는 경우만 생각하면 됨!
    
    //가진 돈이 부족하다.
    if(this.money < money) {
      System.out.println("가진 돈이 부족합니다.");
      return;
    }
    //구매 (곧 Bakery의 판매를 의미한다.)
    BreadChange breadChange = null; //베이커리 브레드체인지 이런데에 이상한 경로로 이상한 값 들어가는걸 사전에 방지
    if(bakery != null) {
        breadChange = bakery.sell(money, count);
        }
    
    //구매 결과 처리
    if(breadChange != null) {      //판매 실패시 null이 반환되는것을 사용해 예외처리한다.
    this.count += breadChange.getBread();
    this.money += breadChange.getChange();
    this.money -= money;
  }
    
    
    
    
    
  
  

  
  }
}
  
  


