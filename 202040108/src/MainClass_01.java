
public class MainClass_01 {


  void method_info(String str) {
   String a = str.substring(0, 2);
   String b = str.substring(7, 8);
   
   //substring 0에서 -1까지의 글자를 추출한다.
   //oracle이랑 작동방법 똑같나? 아니었음..ex 1 3 -> 2번째 3번째 글자를 추출함.
   
   method_age(a);
   method_gender(b);
  }
  
  void method_age(String a) {
    System.out.println(a + "년 생입니다.");
    
  }
  
  void method_gender(String b) {
    switch(b) {
    case "1" :
    System.out.println("남성");
    break;
    case "2" :
    System.out.println("여성");
    break;
    case "3" :
    System.out.println("남성");
    break;
    case "4" :
    System.out.println("여성");
    break;
  }
    
  } 
}
