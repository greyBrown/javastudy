package pkg01_branch;

public class branch_practice {
 public static void method1() {
    
    // 월에 따른 계절 출력하기
    int month = 4;
    String season;
    
    if(month >= 3 && month <=5 ) {
    season = "봄";
    } else if(month >= 6 && month <=8) {
      season = "여름";
    } else if(month >= 9 && month <= 11) {
      season = "가을";
    } else {
        season = "겨울";
      }
     System.out.println(season); 
    
    }
 
// int mod = month % 12;
// 
// if(mod <= 2) {
//   season = "겨울";
//   } else if(mod <= 5) {
//     season = "봄";
//   } else if(mod <= 8) {
//     season = "여름";
//   } else {
//       season = "가을";
//     }
//    System.out.println(season); 
//   
//   }
//  이런식으로도 짤 수 있겠죠! 오오오...
    
    
  
  
  public static void method2() {
    
    // 점수와 학년에 따른 합격 여부
    // 1~3학년 : 60점 이상이면 합격, 아니면 불합격
    // 4~6학년 : 70점 이상이면 합격, 아니면 불합격
    // if안에 if를 넣는 방법, 그냥 if를 2개 쓰는 방법도 있지요
    
    int score = 60;  // 점수
    int grade = 3;   // 학년
    
    //합격점수
   int pass = 0;
   if(grade >= 1 && grade <= 3) {
     pass = 60;
   } else if(grade >= 4 && grade <= 6) {
     pass = 70;
   }
   //합격/불합격
   String result = null;  //자바에서 null값은 아무것도 가르키지 않는다는 상태를 뜻하는 참조값의 초기화 형태임.
   if(score >= pass) {
     result = "합격";
   } else {
     result = "불합격";
   } System.out.println(result);
   
   
   
   //나중에 잘못된 값 못 입력하게 매서드 초반에 다른 코드를 넣을 거기 때문에...그게 일반적이라서 굳이 다른 숫자 넣는거 방지하는 코드 짤 필요 없음.
   
   
    
    
    
    
    
  }
  
  public static void method3() {
    
    // 4일은 목요일, n일 후는 무슨 요일?
    
    int day = 4;      // 4일은 목요일
    int nDay = 35;    // nDay일 후
    String weekName;  // 요일 (월~일)
    
    // day의 nDay일 후
    day += nDay;
    
    // day를 7로 나눈 나머지
    int mod = day % 7;
    
    if(mod == 0) 
      weekName = "일";
    else if (mod == 1)
      weekName = "월";
    else if (mod == 2)
      weekName = "화";
    else if (mod == 3)
      weekName = "수";
    else if (mod == 4)
      weekName = "목";
    else if (mod == 5)
      weekName = "금";
    else
      weekName = "토";
    
    System.out.println(weekName);
    
      
      
    
   
    
  }

  public static void method4() {
    
    //메뉴에 따른 가격
    //아메리카노 : 1000원
    //카페 라떼 : 2000원
    //밀크티 : 3000원
    //기타   : 5000원
    
    String order = "카페라떼";
    int price = 0;
    
    switch(order) {
    case "아메리카노" :
    price = 1000;
    break;
    case "카페라떼" :
    price = 2000;
    break;
    case "밀크티" :
    price = 3000;
    break;
    default:
    price= 5000;
     } System.out.println("가격은 " + price + "원 입니다.");
    
    
  }
  
  //Sring 문자열 동등비교 안된다고 했죠?! if (order == "아메리카노") 이런거 말하는 거예요! 그래서 이 문제를 string으로 푼 것! 문자열 비교시 switch가 유용할 수 있다.
  public static void main(String[] args) {
    // TODO Auto-generated method stub

    method4();
  }

}

