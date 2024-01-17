package practice02_Cup;

public class Cup {
  
  private Coffee coffee;
  
  public void fill(Coffee coffee) {  //set메소드지만 fill라고 할게요~ 커피니까 ㅎㅎ
    this.coffee = coffee;
  }
  
  public void whoami() {
    coffee.whoami();
    
  }

  @Override
  public String toString() {
    return "Cup [coffee=" + coffee + "]";
  }

  
  /* Cup cup = new Cup();
   * cup.fill(new Americano());
   * cup.whoami();    <-이러면 아메리카노 new CafeLatte로 바꾸면 라떼가 나오겠죠! 인수가 바뀜에 따라 모습이 바뀌는 다형성!
   * 
   */
  
  
  
  
  
  
  }


