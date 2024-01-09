
public class Anything {

  public static void main(String[] args) {

    for(int row=1; row <= 3; row++) {                    //상체
      for(int space=1; space<=row-1 ; space++) {
        System.out.printf(" ");}
      for(int star1 = row; star1<=row; star1++) {
        System.out.print(String.format("%3s","*"));}
      for(int space2 = row+1; space2<=4; space2++) {
        System.out.printf(" ");}
      for(int star2 = 5; star2 <=5; star2++) {
        System.out.print(String.format("%3s","*"));}
      for(int space3 =6; space3 <= 9-row; space3++) {
        System.out.printf(" ");}
      for(int star3= 10-row; star3 <= 10-row; star3++) {
        System.out.print(String.format("%3s","*"));}
      System.out.println();
    }
    
   
    for(int space=1; space<4; space++) {
      System.out.print(" ");
    }
   for(int star=1; star<4; star++) {
     System.out.print(String.format("%3s","*"));
    }
     System.out.println();
    for(int star=1; star <=9; star++) {
    System.out.print(String.format("%2s","*"));}  ///이거 8인게 좀 더 균형이 맞아보이긴 함...손가락 4개 처럼 ㅋㅋㅋㅋ                            //몸통
    System.out.println();
    for(int space=1; space<4; space++) {
      System.out.print(" ");
    }
   for(int star=1; star<4; star++) {
     System.out.print(String.format("%3s","*"));
    }
    
 
   
    
  }

}
