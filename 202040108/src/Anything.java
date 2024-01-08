
public class Anything {

  public static void main(String[] args) {

    for(int row=1; row <= 3; row++) {
      for(int space=1; space<=row-1 ; space++) {
        System.out.printf(" ");}
      for(int star1 = row; star1<=row; star1++) {
        System.out.printf("*");}
      for(int space2 = row+1; space2<=4; space2++) {
        System.out.printf(" ");}
      for(int star2 = 5; star2 <=5; star2++) {
        System.out.printf("*");}
      for(int space3 =6; space3 <= 9-row; space3++) {
        System.out.printf(" ");}
      for(int star3= 10-row; star3 <= 10-row; star3++) {
        System.out.printf("*");}
      System.out.println();
    }
    for(int star=1; star <=9; star++) {
    System.out.printf("*");}
   //성공!!!!!!!!!!!!!!!!! ㅠㅜㅠㅜㅠㅜ
  }

}
