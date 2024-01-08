package pkg04_two_practice;

public class MainClass {
  
  public static void method1() {
    //구구단 결과를 2차원 배열에 저장하기
    int[][]dan = new int[9][9];
    
    for(int i=1; i < dan.length; i++) {
      for(int j=0; j < dan[i].length; j++) {
        dan[i][j] = (i+1)*(j+1);
        {System.out.print(String.format("%3d", dan[i][j]));}
      }
      System.out.println();
    }
    
    
  
    
    
    
    
    
    
  }
  
  public static void method2() {
    //apt 출력하기
    //1층 :11명
    //2층 :10명
    //3층 : 9명
    int[][] apt = new int[][] {
      {2, 3, 2, 4},
      {1, 1, 5, 3},
      {4, 2, 2, 1}
    };
    
    int sum = 0 ;
    
    for(int i=0; i<apt.length; i++) {
      for(int j=0; j<apt[i].length; j++) {  
        sum  += apt[i][j];
      }
      System.out.println((i+1)+"층은 " + sum + "명" );
      sum = 0;
    }
    
    // 둘 다 무사히 완성했다!!! 휴...두번째꺼 sum=0 줄 바꿔보면서 하나씩 다 넣어봤네.... 
    // sum=0이 없으면 누적합산이 되고, 안쪽 포문에 있으면 4, 3, 1 이렇게 나온다...4 3 1 이거 어서 온거지;;
    
  }
  
public static void method3() {
    
    // 배열 t 시계 방향으로 90도 회전하기
    
    /*
     * 1 1 1 1 1          0 0 0 0 1
     * 0 0 1 0 0          0 0 0 0 1
     * 0 0 1 0 0   --->   1 1 1 1 1
     * 0 0 1 0 0          0 0 0 0 1
     * 0 0 1 0 0          0 0 0 0 1
     */
    
    /*
     * 90도 회전하기
     * 1. t 배열의 90도 회전 상태를 rotate 배열에 저장한다.
     * 2. t 배열이 참조하는 값을 rotate 배열로 바꾼다.
     */
    
    int[][] t = {
        {1, 1, 1, 1, 1},
        {0, 0, 1, 0, 0},
        {0, 0, 1, 0, 0},
        {0, 0, 1, 0, 0},
        {0, 0, 1, 0, 0}
    };
    
    int[][] rotate = new int[5][5];
    
    //????????? 고민을 좀......배열을...새로로 만들 수는 없나...
    for(int i = 0; i<t.length; i++) {
         for(int j = 0; j<t[i].length; j++) {
           rotate[j][4-i]=t[i][j];
         }
      }
    
    
    

    for(int i=0; i < rotate.length; i++) {
      for(int j = 0; j < rotate[1].length; j++) {
        System.out.print(rotate[i][j]);
      }
      System.out.println();
    }
    
      
      ///11111 [0][j] 는 전부 [i][4]로 이동하게 된다
      ///00100 [1][j] 는 전부 [i][3]로 이동하게 된다.
      //       [2][j]         [i][2]     
      //       [3][j]         [i][1]
      //       [4][j]         [i][0]
      
    //         [i][j]         [j][4-i]
    // 아 식은 나름 잘 세웠어요~~~ 마지막  [i][j]  [j][4-i] 요거 추출을 못했다!! 숫자들이 연관성을 가지고 있으면 리터럴이 아니라 변수로 표현해줘야함!!!
    // 리터럴 이상하게 고정되면 for문 돌면서 덮어씌워져서 엉뚱한 결과가 나옴!!!!! 아쉽다 ㅠㅜ 간지러웠는데....
    }
      
    
    
    
    


  public static void main(String[] args) {

    method3();
  }

}
