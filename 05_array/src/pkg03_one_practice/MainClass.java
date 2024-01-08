package pkg03_one_practice;

public class MainClass {

public static void method1() {
  // 월에 따른 계절 출력하기
  int month = 12;
  String[] seasons = new String[]{"겨울","겨울", "겨울", "봄", "봄", "봄",  "봄", "여름","여름","여름","여름", "가을", "가을", "가을", "가을", "겨울"};
  //치면서도 생각했다...이렇게...안하겠지.......ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ 배열 200개짜리면 어쩔꺼...
  // month % 12 /3!! 아깝다 한번만 더 들어가서 생각할걸 month/3 까지는 해봤는데 ㅠ 그렇군요 이렇게 수식에 수식을 거듭해서도 합니다! 코드가 짧아짐!
   
  int mod = month%12;
  
  System.out.println(seasons[mod]);
  
  //선생님 답안       month % 12     month % 12 /3
  /* 12 ~ 2             0 ~ 2             0
   * 3 ~ 5              3 ~ 5             1
   * 6 ~ 8              6 ~ 8             2
   * 9 ~ 11             9 ~ 11            3
   */
  
  System.out.println(seasons[month % 12 / 3]);
  

  
  
  
  //코드 한 줄만 추가할 것
  
  
  
}

 
public static void method2() {
  // 4일은 목요일, n일 후는 무슨 요일?
  int day = 4;
  int nDay = 10;
  String[] weekNames = new String[] {"일요일","월요일","화요일","수요일","목요일","금요일","토요일"};
  
  day += nDay;
  
  int d = day%7;
  
  System.out.println(weekNames[d]);
  
  //선생님은 그냥 sop(day % 7) 하셨음!
}

public static void method3() {
  
  //아스키코드 특문은 32번부터 시작한다. 대문자는 65부터 시작한다. 소문자는 97부터 시작한다. 아리비아숫자는 48부터 시작한다. 
  //외우라는거 아니지만 외우면 좋고 꼭 하라는건 아닌데 하면 좋다 이거져 알져 무슨말인지
  //'A' + 1 = 'B' 혹은 66
 
  char[] letters = new char[26];
  
  char ch = 'a';
  
  for(int i=0; i < letters.length; i++) {
    letters[i] = ch++; // ch -> 26개를 전부 A로 채우는 거임 ch++ -> 문자 다음으로 바꿔가면서 채움
    System.out.println(letters[i]);
  }
}
public static void method4() {
 
 //배열 a의 마지막 3개 요소를 배열 b의 값으로 수정하기
 int[] a = new int[] {10, 20, 30, 0, 0, 0};
 int[] b = new int[] {40, 50, 60};
 
 a[3] = b[0];
 a[4] = b[1];
 a[5] = b[2];
 
 //하면서도 이렇게 안하겠지......2222222 ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ for 문으로
 
 for (int i=0; i<b.length; i++) {
   a[3+i] = b[i];
 }
 
 for(int i=0; i < a.length; i++) {
   System.out.println(a[i]);
   }
 
 // 아까..왜 안된걸까...sop가 거기 들어가면 안됐나??

  /*
   * 배열 복사를 위한 자바 표준 API  <- API는 사용법을 익히는 거지 뭐 이해해서 구현하고 이런건 아니에요!
   * System.arraycopy(b ,0, a, 3, b.length)
   * 1) 복사시작요소   : b[0] 요소를 a[3] 요소로 복사
   * 2) 복사할요소개수 : b.length개 복사 
   */
  
  
}

public static void method5() {
  // 10진수를 2진수로 변환하기
  
  // 10진수
  int number = 35;
  
  // 2진수
  int[] binary = new int[10];
  int i = 0;
  
  while (number > 0) {
    binary[i++] = number%2;  //아랫줄에 i++ 적었던거 굳이 그럴 필요 없음. 그냥 바로 i++!   
    number /= 2;
  }
  
  for(int j=i-1 ; j >=0 ; j--) {               //j쓰는것도...관례상! 별찍을때 열심히  i j 한거 -> 관례상!
    System.out.print(binary[j]);
    }
         
  }
  
  

  public static void main(String[] args) {

    method5();
    
  }


  
}
