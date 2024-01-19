package pkg05_etc;

import java.text.DecimalFormat;

public class Class03_DecimalFormat {

  public static void main(String[] args) {

    double number = 12345.6789;
    DecimalFormat df = new DecimalFormat("#,##0.00");   //0: 자리가 비었으면 강제로 0을 표시. #: 없다면 생략. 일의자리는 0으로 표시해줘야함.
    System.out.println(df.format(number));
   
    //보통 이런작업은 화면단에서 많이 합니다. 자바에서도 하긴 해요.
    
    
    
    
  }

}
