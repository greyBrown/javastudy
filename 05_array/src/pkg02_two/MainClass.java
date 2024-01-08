package pkg02_two;

public class MainClass {

  public static void method1() {
    
    /*
     * 2차원 배열
     * 1. 1차원 배열이 여러 개 모인 자료 구조이다.
     * 2. 1차원 배열 여러 개를 같은 이름으로 관리한다.
     * 3. 행과 열의 집합체인 테이블 구조로 이해를 하면 된다.
     * 4. 사용하는 인덱스가 2개(행, 열)이다.
     */
    
    /*
     * 2차원 배열의 선언과 생성
     * 1. 선언
     *    int[][] 배열이름  //int 배열이름 [][] 도 있긴하지만...이건 그냥 있다 정도로만~~
     * 2. 생성 
     *   1) new int[m][n] - 길이가 n인 1차원 배열이 m개 있는 배열 
     *   2) new int[m][]  - 길이가 ?인 1차원 배열이 m개 있는 배열 (?은 나중에 결정함) 
     */

    // 배열 선언
    int[][] arr;
    
    // 배열 생성
    arr = new int[2][3]; //길이가 3인 1차원 배열이 2개 생긴다.
    
    // 배열 요소(배열이름 + 대괄호 2개 + 인덱스 2개)
    
    // 1번째 1차원 배열의 요소 3개
    System.out.println(arr[0][0]); 
    System.out.println(arr[1][1]);
    System.out.println(arr[1][2]);
    
    // 2번째 1차원 배열의 요소 3개
    System.out.println(arr[1][0]);
    System.out.println(arr[1][1]);
    System.out.println(arr[1][2]);
    
  }
  
  public static void method2() {
    
    //2차원 배열의 선언 및 생성
    int[][] arr = new int [2][3];
    
    //1번째 1차원 배열
    System.out.println(arr[0]);           //참조값 arr[0] 이게 첫번째 1차원 배열 이름(주소값을 가짐)
    System.out.println(arr[0].length);    //3
    
    //2번째 1차원 배열
    System.out.println(arr[1]);           //참조값 arr[1] 이게 두번째 1차원 배열 이름(주소값을 가짐)
    System.out.println(arr[1].length);    //3
  }
  
  public static void method3() {
    //2배열은...같은 길!!이!!의!! 1차원 배열이 여러개
    
    
    //선언 및 생성
    int[][]arr = new int[2][3];
    
    //1번째 1차원 배열 출력
    for(int j = 0; j < arr[0].length; j++) {
      System.out.println(arr[0][j]);
    }
    
    //2번째 1차원 배열 출력
    for(int j = 0; j < arr[1].length; j++) {
      System.out.println(arr[1][j]);
    }
    
    for(int i=0; i < arr.length; i++) {
      for(int j = 0; j < arr[1].length; j++) {
        System.out.println(arr[i][j]);
      }
    }
      // 저 2부분(arr.length)이 나중에 바뀌긴 합니다!  처음에 arr[0].length 넣으니까 오류는 나지만 실행은 되는게 이거 아님!! 저러면 첫번째 1차원 배열의 길이가 되는거다.
    // 1차원 배열이 몇개인지 넣어주는 부분인데 저러면 당연히 1차원 배열 숫자랑은 다른 숫자가 나옴!
    //저 2에는 arr.length이 들어갑니다? 왜? 1차원 배열을 하나의 형태라고 생각한다면. 2차원 배열은 1차원 배열을 내용(가로)으로 가지는 1차원 배열(세로)이기 때문이다.
    
    //2차원으로 출력
    for(int i =0; i < arr.length; i++) {
      for(int j = 0; j < arr[i].length; j++) {
        //System.out.printf("%3d", "arr[i][j]" );
        System.out.print(String.format("%3d", arr[i][j]));  //나중에 웹개발에 쓸 문자열 반환타입입니다!printf는 사실상 웹개발에서는 쓸모가 없고 나중가서 이걸 씁니당.
      }
      System.out.println();
    }
  }
    
    public static void method4() {
    
    
      //2차원 배열 초기화
      int[][] arr = new int[][] {
      {10, 20, 30},
      {40, 50, 60}
    };
    


    
      for(int i=0; i < arr.length; i++) {
        for(int j=0; j < arr[i].length; j++) {
          System.out.print(String.format("%3d", arr[i][j]));
        }
        System.out.println();
      }
      
   
      
      
      
    
    
    
       //arr[i] 저래도 되나?? 왜 되는가...첫번째 for문에서 i 0으로 시작 한바퀴돌고 i=1됨...아하아하 이해 됨. 포문안에서 i=2가 된 적이 없음... i=2 동시에 포문 끝남.
       // 헷갈리지 말기 i가 포문 바깥에서 선언되면 포문 끝나고 i 체크해보면 포문 안쪽에 있는 i + 1임!! 이왕 헷갈린거 여기서 확실히 기억해두자!
      
      
    
  }
  
    
    public static void method5() {
    }
    
    
  
  public static void main(String[] args) {
    method4();
    
    
  }

}
