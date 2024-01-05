package pkg02_loop;

public class loop_pratice {
  
  public static void method1() {
    
    // 100 ~ 1 출력하기 
    
    int n = 100;
    while (n >= 1) {
      System.out.println(n);
      n--;    
    }
      
    
    
  }
  
  public static void method2() {
    
    // 5 20 사이 모든 정수의 평균
    
    double sum = 0;
    int i = 5;
    int cs = 0;
    
    while (i<=20) {
      sum += i;  // 이 부분 total += n++; 이렇게 적어도 괜찮아요!
      i ++;
      cs ++;
    } 
    double avg = sum/cs;   //sum만 double로 바꿔줘도 promotion! 계산시에 cs도 알아서 double로 바뀐다!
    
    System.out.println("평균은 " + avg + " 입니다.");
    
    // 선생님의 두번째 방법
    // 5 ~ 20 ..16개인걸 알 수 있으니까 int = begin 5; int end =20; 를 추가해줘서 하는것도 좋아요. 이러면 cs 변수가 필요없어짐
    // 마지막에 end - begin +1 을 해주면 되니까! begin end가 확실히 보인다는 점에서 이런 코드가 권장돼요.
    
    
    
    
    // ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ += 이거 안헷갈리게 조심 ㅋㅋㅋㅋㅋㅋ = + 이거 걍 = 대입임...이러면 걍..sum은 i라고 하는거임...
    // 처음이라 이런 오타 많지만 차차 줄여서 0에 수렵하게 해봅시다~ 이런 오타 찾는거 넘 시간 아깝고...ㅠ 눈알 아프고...ㅠ
     
    //int 나누기 int는 몫이 int죠...답의 값이 double이어도 int 나누기 int는 int....둘 중 하나만 double로 바꿔줘도 됩니당. 
      
    }
        
    
    
  public static void method3() {
    
    //구구단 3단 출력하기
    int dan =3;
    
    for(int i=1; i<=9; i++) {
      System.out.println(dan + "곱하기" + i + "은" +dan*i);
    }
      
    
  }

  
  public static void method4() {
    
    //70원씩 모금하기
    //목표는 100,000원 이상
    
    //1회 모금액이 70원
    //2회 모금액 140원
    //3회 모금액 210원
    
    int a = 1;
    int g = 0;
    
    for(g = 70; g<=100000; g+=70 ) {
      System.out.println(a+"회 모금액" + g + "원");
      a++;
      
    }
    
    System.out.println("총 모금회수 "+ a +"번" +"총 모금액"+  g  + "원");
    
    
    //a++가 sop 전에 들어가면 총 모금횟수에서 1번 모자란 횟수가 되는데 sop 이후에 들어가면 딱 맞는다. 이런게 위치 구조 파악하는게 중요!!!
    // 실행순서가 (최초값, 조건값, 명령문 실행, 변화값) 이기 때문임!!! 변화는 한다..! 그리고 조건값에 맞나 안맞나 본다. g값은 이미 변했음!
    
    //선생님 버전
    
    int money =70 ; //1회 모금액
    int total = 0; // 전체 모금액
    int nth = 0; //회차
    final int GOAL = 100_000; //자바에서 지원하는 1000단위 구분기호!
    
    while(total < GOAL) {
      total += money;
      nth++;
      System.out.println(nth + "회 모금액" + total + "원");
      }
    
    //몇번하는지 모를 때 while이 유용한 면이 있어요~ for 로  값 가진채로 마지막에 한번 빠져나오는거 신경써줄 필요가 없죠!
    
  }
  
  public static void method5() {
    
    
    for(int i = 2 ; i <= 9; i++) {
       if(i == 6) break;
      for(int j = 1 ; j <= 9; j++) {
        if(j == 6) break;
        System.out.println(i + "x" + j + "=" + i*j);
      }
    }
    
    //위에가 내가 한거 아래 새로운 방법! for문을 break 하는 다른 방법! 라벨을 달아줄 수 있음.
    
    outer:
    for(int i = 2 ; i <= 9; i++) {
     for(int j = 1 ; j <= 9; j++) {
       System.out.println(i + "x" + j + "=" + i*j);
       if(j == 5 && i == 5) {
         break outer;
       }
     }
   }
    
    //2*1=2
    //2*2=4
    //9*9=81
    
    
  }
    
    
  
  public static void method6() {
    // 2*1=2  3*1=3......9*1=9
    // 2*2=4.............9*2=9
    
    for(int i = 1; i <= 9; i++) {
      for(int j = 2 ; j <= 9; j++) {
        System.out.print(j + "x" + i + "=" + i*j + "\t");
      } {System.out.println("\n");}
    }
    
    //gh 출력 순서는 sop에서만 변수로 조절해주면 된다! 어렵게 생각하면 이상하게 생각하게 되는 경향도 있음 ㅋㅋㅋㅋ
    //gh 처음에 고정된게 첫번째 포문 따라서 변하는게 두번째 포문이다! 오 이거 덕분에 뭔가 더 이해가 갔음...형식은 내가 sop로 해주고...
    
    //전문적으로..... 처음에 고정된게 outer for 문 두번째에 고정된게 inner for 문
    //" " 이거...머 비슷하게 되긴하는데 "\t" 이게 훨씬 깔끔하죠!! 이런게...있었죠 그죠?? ^^
    
    
    
  }
  
  public static void method7() {

    /*
     * 삼각별 출력하기-1
     *        star=12345 
     * row=1       * 
     * row=2       ** 
     * row=3       *** 
     * row=4       **** 
     * row=5       *****
     * 
     * row=1, star=1~1 
     * row=2, star=1~2 
     * row=3, star=1~3 
     * row=4, star=1~4 
     * row=5, star=1~5
     */

    for(int i=1; i<=5; i++) {
      for(int j=1; j<=5; j++) {
        if(i >= j) System.out.print("*");
      } System.out.print("\n");
      }
      
    // 그냥 println() 이거나 \n 나 효과 비슷한듯...
    
  }
  
  public static void method8() {
    
    /*
     * 삼각별 출력하기-2
     *        star=12345
     * row=1       *****
     * row=2       ****
     * row=3       ***
     * row=4       **
     * row=5       *
     * 
     * row=1, star=1~5
     * row=2, star=1~4
     * row=3, star=1~3
     * row=4, star=1~2
     * row=5, star=1~1
     */
    
    for(int i=5; i>=1; i--) {
      for(int j=5; j>=1; j--) {
        if(i >= j) System.out.print("*");
      } System.out.print("\n");
      }
    
  }
  
  public static void method9() {
    
    /*
     * 삼각별 출력하기-3
     * space/star=123456789
     * row=1          *
     * row=2         ***
     * row=3        *****
     * row=4       *******
     * row=5      *********
     * 
     * row=1, space=1~4, star=5~5
     * row=2, space=1~3, star=4~6
     * row=3, space=1~2, star=3~7
     * row=4, space=1~1, star=2~8
     * row=5, space=1~0, star=1~9
     * 
     * row=1~5, sapce=1~5-row, star = 6-row~row+4
     */
      
      for(int row = 1; row <= 5; row++) {
        for(int space = 1; space <= 5 - row; space++) {
          System.out.print(" ");
          }
         for (int star = 6 - row; star <= row + 4; star++) {
           System.out.print("*");
         }
         System.out.println();
       
      }
      }
         
      
  
  
  public static void method10() {
    
    /*
     * 삼각별 출력하기-4
     * space/star=123456789
     * row=1      *********
     * row=2       *******
     * row=3        *****
     * row=4         ***
     * row=5          *
     * 
     * row=1, space=1~0, star=1~9
     * row=2, space=1~1, star=2~8
     * row=3, space=1~2, star=3~7
     * row=4, space=1~3, star=4~6
     * row=5, space=1~4, star=5~5
     */
    
    // row=1~5 space=1~row-1 star=row~10-row
    
    
    for(int row = 1; row <= 5; row++) {
      for(int space = 1; space <= row-1; space++) {
        System.out.print(" ");
     } 
     for(int star = row; star <= 10 - row; star++ ) {
      System.out.print("*");
   } System.out.println();
    }
 
     
    
  }  
  
  
  public static void main(String[] args) {

    
    method10();
  }

}
