package pkg01_extends;

//class 자식 extends 부모 {}
//class 서브 extends 슈퍼 {}   //슈퍼 하면 부모 말하는 것! 서브가 자식!


public class Ev extends Car{
  
  public void charge() {
    System.out.println(model); 
    //슈퍼에서 선언한 private Sting model 못씀. 이유는? private 이라서. 자식이라고 해도 못봄! 접근제어자는 존중된다. 
    //private -> protected 로 변경후 실행 가능. 사실 쓸일이 그렇게 많진 않아요. 접근권한이 자식까지 확장된다! 정도.
    System.out.println("충전"); // 지금 ev가 사용할 수 있는 메서드는 4개! 부모 3 자기1
  }
  
  /*
   * sub is a super
   * 
   * sub has a super.
   * 
   * 이렇게 해석해서 둘 중 하나를 만족한다면 상속해도 괜찮다고 볼 수 있음. (Ev is a Car) 
   * (member has a address 어제한 이것도 상속은 가능했음. 하지만...이런건 좀 이상하잖아요? 좀 많이??? 일반적으로 선호되는 관계는 아니에요. 쓰긴하지만...쨌든 is 관계가 상속으로 아주 깔끔하죠)
   */

}
