package pkg09_access_modifier;

/*
 * Getter
 * 1. 클래스의 필드값을 외부로 반환하는 메소드이다.
 * 2. get + 필드명으로 메소드이름을 결정해야 한다.(boolean 타입은 is + 필드명)
 */

/*
 * Setter
 * 1. 외부로부터 전달된 값을 필드에 저장하는 메소드이다.
 * 2. set + 필드명으로 메소드이름을 결정해야 한다.
 */

public class Computer {

  // field //필드값은 private로.

  private String model;
  private int price;
  private Calculator calculator;

  // 필드 초기화를 위해 생성자를 사용할 수 있다. 생성자를 만드는 이유는 보통 필드 초기화 때문임! 아니라면 굳이 만들 필요가 없으니까...!
  // 생성자가 n개다 -> 객체를 생성하는 방법도 n개다.

  // constructor //메서드인 여기서부터는 public
  public Computer(String model, int price, Calculator calculator) {
    this.model = model;
    this.price = price;
    this.calculator = calculator;
  }

  // method
  public void setModel(String model) {
    this.model = model;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public void setCalculator(Calculator calculator) {
    this.calculator = calculator;
  }

  public String getModel() {
    return model;
  }

  public int getPrice() {
    return price;
  }

  public Calculator getCalculator(int... params) {
    return calculator;
  }

  // 이거 다 원래는 source탭에 들어가서 generate constructor 와 generate setter/getter 생성으로 자동으로 만들어줍니당.
  // 나중에 라이브러리 가면 저것도 다 세팅이 알아서 됩니다...
  

}
