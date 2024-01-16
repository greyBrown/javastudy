package pkg05_throw;

public class MainClass {

  public static void main(String[] args) {
    
    /*
     * throw 
     * 1. 직접 예외 개체를 만들어서 던질 때 사용한다.
     * 2. 자바가 자동으로 던지지 않는 예외들은 throw 문으로 직접 던져야 한다.
     */
    
    try {
      
      int score = 100; // 0 ~100
      char grade;
      
      if(score < 0 || score > 100) {
        throw new RuntimeException();                    //런타임익셉션이 무난한 예외예요 ~.~ 컨트롤스페이스로 계속 해줘요. 이렇게 인자가 런타임익셉션이 옮으로써 캐치에서 이걸 매개변수로 받아 예외처리를 한다.
      }
      
      
      if(score >= 90)
        grade = 'A';
        else if(score >= 80)
        grade = 'B';
        else if(score >= 70)
        grade = 'C';
        else if(score >= 60)
        grade = 'D';
        else 
        grade = 'F';
        
        System.out.println("점수 :" + score + "점, 학점 : " + grade + "학점");
    
    } catch (Exception e) {
      
      System.out.println("잘못된 점수입니다.");
      
    }
    

  }

}
