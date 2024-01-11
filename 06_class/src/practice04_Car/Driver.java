package practice04_Car;

public class Driver {


  //field
  private String name;
  private int career;
  private boolean bestDriver; //carrer 가 10 이상이면 true
  
  
  //constructor
  public Driver() {
    // TODO Auto-generated constructor stub
  }

  public Driver(String name, int career) {
    super();
    this.name = name;
    this.career = career;
    this.bestDriver = career >= 10 ;        // 이 부분이 포인트! 생성자에서 막무가내로 정보를 넣으면 걸러지지않고 값이 들어가는 일을 방지한다! 
  }
  

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getCareer() {
    return career;
  }

  public void setCareer(int career) {
    this.career = career;
    this.setBestDriver(career >=10);  //!!! 이렇게!! setBd가 setCareer에 의존하므로 이렇게 종속되게 한다!
  }

  public boolean isBestDriver() {
    return bestDriver;
  }

  private void setBestDriver(boolean bestDriver) {
    this.bestDriver = bestDriver;
    
  }
  
  
  
  
  
  
}
