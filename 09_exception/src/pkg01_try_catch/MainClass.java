package pkg01_try_catch;

public class MainClass {
  
  public static void method1() {
    
    // 예외 처리가 발생하는 상황(실수가 들어가서 오류)
    
    String userInput = "12.3";
    
    int number = Integer.parseInt(userInput);
  
    System.out.println(number);
      
 }
      
  public static void method2() {      
    
    //예외 처리 : try - catch
      
    try {                                            
      
      String userInput = "12.3";
      
      int number = Integer.parseInt(userInput);
      System.out.println(number);
    
    } catch(NumberFormatException e) {  //예외 객체 이름은 e!!! 혹은 ex!!!!  numerFormat이렇게 안써요! 위에서 JVM이 예외를 던지면 catch가 받는다.
                                        //이렇게 하면 아무 메세지도 안보임. NumberFormatException이 발생했다는 빨간색 메세지가 뜨지 않음! 예외처리가 됐기 때문에 발생된 예외를 catch가 처리반으로 넘김... 이렇게 프로그램이 뻗는걸 막기위해 예외처리함.
      System.out.println("정수만 입력하세요.");    //개발할때 하면 안되는거 : catch 블록 비워두기 ㅋㅋㅋㅋ 뭐 경고문 적어줘야죠!!!!! 귀찮아도 적어줘요 꼭! 입력하란거 입력하세요 ㅡㅡ 이런거 들어가는 칸...
    }
       //try 쪽에 작성하는 코드를 두고 catch는 문제발생하면 뭐라고 말할지 적어두는 거.
  }

  public static void method3() {
    
    String[] userInputs = {"10", "20", "1.5", "2.5", "30"};    //이렇게 예외처리를 함으로써 문제가생기는 부분(1.5)에서 for 문이 죽지 않고 끝까지 돌아감. 예외로인해 프로그램이 죽지 않는다는게 포인트! 끝까지 돈다!
                                                               //최우선목표: 예외는 못막는다. 프로그램 안 나가는게 일단 최우선...!! 
    for(int i = 0; i < userInputs.length; i++) {
      
      try {
        
        int number = Integer.parseInt(userInputs[i]);
        System.out.println(number);
      
      } catch(NumberFormatException e) {
        
        System.out.println(userInputs[i] + "는 정수가 아닙니다.");
      }
    
    }
    
  }
  
  public static void method4() {
    
    //다중 catch 블록 (try 는 1개만 이에요!)
    
    String [] userInputs = {"10", "20", "15", "25", "30"};
    
    try {
      
      for(int i = 0; i < 6; i++) {
        
        int number = Integer.parseInt(userInputs[i]);
        System.out.println(number);
        
      }
        
    }  catch(NumberFormatException e) {
        System.out.println("정수만 처리할 수 있습니다.");
        
        
    }  catch(ArrayIndexOutOfBoundsException e) {
      System.out.println("사용할 수 없는 인덱스가 사용되었습니다.");
    
      } 
    
  }
  //흔한 실수 중 하나가 반복문 돌리다가 잘못된 인자 삭제하면서 데이터 개수값이 변하게되고 반복문 순서바뀌는거(삭제한거 때문에 당겨저서 건너뛰는게 생김)
  // 혹은 데이터 개수가 for 문 조건에 포함되어있어서 고정되어버려 존재하지 않는걸 참조하게되서 오류나는거...이런거 조심!
  // 이 경우 i < 6 이라는 잘못된 값을 주면 outofindex 예외가 뜨면서 프로그램이 죽는다. 이런걸 방지하기 위해 catch 를 다중으로 닮...문제가 하나가 아니니까 여러개 달겠다는 뜻...^^ ㅋㅋ ㅠ
  
  //catch 작성 시 주의사항 : 상속관계를 이해하고 만들 것! catch 블록에 순서가 있기 때문(상속관계를 따른다). Runtimeexception e를 넣으면 아래 outofindex에 컴파일 오류가 난다. 왜? Run이 넘버포맷과 아웃인덱스의 부모라서! 만약 굳이 해결하고 싶다면 순서를 바꾸면 된다. 자식이 먼저 오고 부모가 마지막에 오도록. 
  
  
  public static void main(String[] args) {
    method4();
    
  }

}

