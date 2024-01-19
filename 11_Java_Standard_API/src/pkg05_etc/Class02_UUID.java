package pkg05_etc;

import java.util.UUID;

public class Class02_UUID {

  /*
   * java.util.UUID
   * 1. Universal Unique IDentifier
   * 2. 범용 고유 식별자
   * 3. 형식
   *    1) 16진수 32개와 하이픈(-) 4개로 구성
   *    2) 12345678-1234-1234-1234-1234567890ab
   * 
   * 크게 3가지 방법 정도가 있는데 version3 version4(가장 대중적) 해볼거예용
   */
  public static void main(String[] args) {
    
    // UUID Version 3(아이디를 활용해서 생성)
    String name = "홍길동";
    UUID uuid1 = UUID.nameUUIDFromBytes(name.getBytes());
    String result1 = uuid1.toString();
    System.out.println(result1);       //실행할때마다 동일한 값이 나오고, 이름을 바꾸면 값이 달라짐.
    
    // UUID Version 4(대중적인 방식)
    UUID uuid2 = UUID.randomUUID();
    String result2 = uuid2.toString();
    System.out.println(result2);  //실행 할때마다 같이 달라짐
    
    // uuid4로 불안하면 그 뒤에 timestamp를 추가적으로 붙이기도 합니다. 하지만 uuid4로도 중복가능성은 거의 없음
    // 저 뒤에서 12자리면 추출해서 쓰기도 하고...(lastIndexOf 이런거 써서 추출해냅니다. String 클래스는 이것저것 잘 쓰이니까 알아두기)
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
  }
  
  
  
  
  
}
