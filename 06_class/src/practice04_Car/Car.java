package practice04_Car;

public class Car {
  
  //field
  private Driver driver;
  private int currSpeed;
  private int fuel;
  public static final int MAX_SPEED = 100;
  
  
  //constructor
 Car() {
 }


  public Car(Driver driver, int currSpeed, int fuel) {
    super();
    this.driver = driver;
    this.currSpeed = currSpeed;
    this.fuel = fuel;
  }


  public Driver getDriver() {
    return driver;
  }


  public void setDriver(Driver driver) {
    this.driver = driver;
  }


  public int getCurrspped() {
    return currSpeed;
  }


  public void setCurrspped(int currspeed) {
    this.currSpeed = currspeed;
  }


  public int getFuel() {
    return fuel;
  }


  public void setFuel(int fuel) {
    this.fuel = fuel;
  }
 
 //static은 Car.MAXSPEED 이렇게 호출하니까 getter 필요없어요~ static은 static 답게~ 이상한짓 하지 말아요......알겠져.....
 //get 하면 누가봐도 static 아님 그 누가 봐도!! 쨌든 빼줘용
  
  public void enginStart() {
    if (driver == null || fuel == 0) {           //driver fuel if문 따로 나눠줄필요 없어요!! || 처리하면 됩니다!!!
      System.out.println("시동 실패");
    } else {
      System.out.println("시동 성공");
    }
  }
  
  //1초당 n씩 속도가 증가하는 accelerator(bestdriver는 10씩, 아니면 5씩 늘어난다)
  //1초당 1씩 연료가 줄어드는 accelerator
  public void accelerator(int pushTime) {
    
    if(currSpeed > MAX_SPEED) {
      System.out.println("이미 최고 속도입니다.");
      return;
    }
    if(fuel == 0 ) {
      System.out.println("연료가 없습니다.");
      return;
    }
    if(pushTime <= 0) {
      System.out.println("accelerator 를 잘 밟으세요");
      return;
    }
    
    int n = driver.isBestDriver()? 10 : 5;          //if else 안쓰고 이렇게 간단하게 표현할 수 있어요! 더 간단하게는 그냥 n에 이거 넣어주면 돼요.
    currSpeed += (pushTime * n);
    currSpeed = Math.min(currSpeed, MAX_SPEED);     //Math에 유용한 메서드가 많아요!!! 이러면 if 안쓰고 간단히 해결이 되죠
    
    fuel -= pushTime;
    fuel = Math.max(fuel, 0);
    
    System.out.println("현재 연료량 : " + fuel + ", 현재속도 : " + currSpeed);
    
  }
  
  // 1초당 속도가 10씩 줄어드는 brake
  public void brake(int pushTime) {
    if(currSpeed ==0) {
      System.out.println("이미 멈춰있습니다");
      return;
    }
    
    if(pushTime <= 0) {
      System.out.println("brake 를 잘 밟으세요");
      return;
    }
    
    currSpeed -= (pushTime * 10);
    currSpeed = Math.max(currSpeed, 0);
    
    System.out.println("현재 연료량 : " + fuel + ", 현재속도 : " + currSpeed);
    
  }

  
  
  
  
  
  
  

}
