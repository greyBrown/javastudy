package pkg01_wrapper_class;

//기본형을 클래스로 싸놓은거(wrap). 이러면 기본값이 0이 아니라 null 이 되니까 null 이 필요할때 쓰고...그런다. 제네릭에서 주로 쓰이는듯(제네릭에서 참조타입만 전달할 수 있기 때문임! 기본타입이 전달이 안됨. 그래서 클래스화한걸 쓰는거! ex> int가 아니라 integer를 전달해야함)
//클래스타입은 참조타입! primitive 데이터값이니까 메모리상의 차이는 있어요. 뭐 메모리상에서의 차이 정도..
//쓴적 많아요! int의 wrapping 타입 Integer....메소드 ParseInt 꺼낼 때 자주 쓴 그 친구~ 문자열을 int 로 만들때 꺼내 썼지만 원래는 단독 integer 로 써도 문제없죠.

//제네릭타입은 관례상 대문자 하나 많이씀. T V K 이렇게 종류별로 쓰는게 있음..V는 Value다 이렇게...
//클래스 작성시에는 어떤 타입을 쓸 지 모르다가, 인스턴스화하면서 타입을 정해 전달해줌.(객체생성시점에 결정)

public class MainClass {
  
  public static void main(String[] args) {
    
  

  //Auto Boxing (기본 타입 값 -> Wrapper 타입)
  Integer num = 10;      //예전에는 new Interger(10) 이랬는데 개선되었어요 ㅋㅋㅋ 일반 기본타입 쓰듯 써요!(객체 계속 늘어나면 메로리 소모되니까! 어제 쟈철에서 들은거...)
  
  //Auto Unboxing (Wrapper 타입 -> 기본 타입)
  int iNum = num;    //바로 바꿔줍니다. 문제없어요~
  
  System.out.println(num);

  
  }
  
}