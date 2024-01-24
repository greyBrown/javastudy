package practice02_text_copy;

import java.io.File;

public class MainClass {

  public static void main(String[] args) {

        
      //  MyFileUtils.fileCopy(new File("\\Program Files\\Java\\jdk-17\\LICENSE"),new File("\\storage\\LICENSE"));
    // 이런 야매...괜찮을까...그래도 성공
    
    
    File src = new File("\\Program Files\\Java\\jdk-17\\LICENSE");
    File dest = new File("\\storage\\LICENSE");
    
    MyFileUtils.fileCopy(src, dest);
    
    //선생님이 하신 버전 이렇게!
    //그렇구나...이렇게 해두면 경로 바뀌면 그것만 아래 src 에 쓱 넣어주면 되니까 더 보기 좋다!
    
    
  }

}
