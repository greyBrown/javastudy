package practice04_Car;

public class MainClass {

  public static void main(String[] args) {

    //생성자 사용
    Driver driver1 = new Driver("elsa", 5);  //여기서 bestDriver를 넣으면 정보가 잘못될 수 있음. Driver class에서 bD를 career에                     의존적으로 바꿔줌(종속데이터처리)
    System.out.println(driver1.isBestDriver());
    
    
    //setter 사용
    Driver driver2 = new Driver();
    driver2.setName("elsa");
    driver2.setCareer(20);
    //driver2.setBestDriver(false);       //여전히 false값이 잘못 전달될 우려가 있음. 그래서 이걸 private로 바꿈!
    System.out.println(driver2.isBestDriver());
    
    Car car2 = new Car(driver2, 0, 100);
    car2.enginStart();
    car2.accelerator(5);
    car2.brake(5);
    
    Car car1 = new Car(driver1, 0, 100);
    car1.enginStart();
    car1.accelerator(5);
    car1.brake(5); 
    

    
    
    
  }

}
