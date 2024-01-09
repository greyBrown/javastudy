package pkg02_parameter;

public class MainClass {

  public static void main(String[] args) {
    
    //객체 선언 및 생성
    Calculator calculator = new Calculator();
    
    //메소드 호출
    calculator.method1();  //이쪽(주는쪽)에서는 파라미터(받는쪽)를 인수, 인자(argument)라고 합니다. 근데 뭐 그렇게 구분은 잘...
    
    int a = 10;
    calculator.method2(a);
    
    calculator.method3("hello world");
    
    calculator.method4(1.5, 1.2);
    
    calculator.method5(a); //메서드 호출과 생성 모두 중요함! 메서드가 겹치고 겹치면 헷갈릴 수 있는데 구조 잘 알아놓으면 나중에 보기 쉬워요
    
    //가변 인자
    calculator.method6(1, 2, 3);
    
    //배열 인자
    int[] arr = {10, 20, 30};
    calculator.method7(arr); //중괄호 초기화는 배열을 선언할 때만 가능하다. {초기화}가 안됨. 때문에 arr을 따로 만들어줘야 한다. 아니면 다음 방법 요거!
    calculator.method7(new int[] {10, 20, 30});
    
    
    //객체 인자
    //1.Adder 타입의 adder 객체를 전달
    //Adder adder = new Adder();
    //calculator.method8(adder);
    //2.Adder 타입의 객체를 전달
    calculator.method8(new Adder());  //주는 쪽과 받는 쪽을 한 문장으로 만들면 좀 더 이해하기 쉬워요. Adder adder = new Adder()
 
    //gh 걍 해봄..Q.메서드 없어도 이거 될 거 같은데? A.된다.
    //하지만 메서드 안에 객체를 넣어야하는 일이 있겠죠??? 잘 알아둡시다...
    Adder add = new Adder();
    add.add(4, 5, 6);
    //그림으로 그려보면 이해가 더 잘될듯...? 한장 손코딩해보자...^^
    
  }

}
