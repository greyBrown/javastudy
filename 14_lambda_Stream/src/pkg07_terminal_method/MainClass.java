package pkg07_terminal_method;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Stream;

public class MainClass {

  
  public static void method1() {
    
    // java.util.stream.Stream 생성
    Stream<String> seasons = Stream.of("spring", "summer", "autumn", "winter");
    
    // forEach() 메소드 호출 
    // Stream 에 저장된 요소를 Consumer 의 파라미터에 전달하는 메소드     (+스트림에 있는 모든 요소들을 하나씩 빼서 consumer에 전달해줌)
    seasons.forEach((season) -> System.out.println(season));
    //seasons 의 요소들을 하나씩 꺼내서(season) 그걸 받아서 출력하게 된다. 이런 구조로 돌아감.
    //SOP에 seasons 넣으니까 어디 이상한 주소같은게 나오는데... 자기가 속한 스트림 주소...?
    //consumer가 매개변수가 있고 반환값은 없는 함수형이니까....void method(seasons) 인데 그 안에서 알아서 for문 돌려서 보여주는...그런느낌
    //foreach는 마지막에~ 개별씩 최종연산이라고했나? 그건 하면 끝이2ㅛ!
    
    
    
  }
  
  public static void method2() {
    
    // 배열을 Stream 으로 만들기
    String [] seasons = {"spring", "summer", "autumn", "winter"};
    Stream<String> stream = Arrays.stream(seasons);
    
    // forEach() 메소드
    stream.forEach((season) -> {System.out.println(season);} );
    
    
    
  }
  
  public static void method3() {
    
    //Collection(List, set) 을 stream 으로 만들기
    List<String> seasons = Arrays.asList("spring", "summer", "autumn", "winter");
    Stream<String> stream = seasons.stream();  // 보통 이 문장은 많이들 생략해요. seasons.stream().forEach() 이렇게...entryset 일일이 선언 안한것처럼!
    stream.forEach((season) -> System.out.println(season));
    
    
    ///최종적으로는 Arrays.asList(....).stream().forEach(); 이런형태로 입력하는 게 좋아요. 점점 이렇게 입력해야해요
    Arrays.asList("spring", "summer", "autumn", "winter").stream().forEach((season) -> System.out.println(season)); 
    //변수선언도 필요 없이 아주 잘 나오는군... 이런거 최근에 진짜 신경쓰였는데...선언문들 다 생략되고 다 어디 메소드에 들어가있는거...익숙해지겠져..ㅠ...
    
    new HashSet<String>(seasons).stream().forEach((season) -> System.out.println(season));
    // set 으로는 이렇게 합니다. 이것도 위같은 형식으로~ 이런 형식이..나름 스트림의 철학이에요^^ 이렇게 한방에 쭉 나와서 처리하는게....
    // set 는 순서가 없음! 출력도 사계절이 섞여서 출력된다 ㅋㅋㅋ
    
  }
  
  public static void method4() {
    
    //IO의 Reader의 while 문을 대신 forEach로 처리할 수 있음!!! 해봅시당
    
    File dir = new File("\\storage");
    File file = new File(dir, "sample2.txt");
    
    BufferedReader in = null;
    
    try {
      
      in = new BufferedReader(new FileReader(file));
      
      StringBuilder builder = new StringBuilder();
      
      
      in.lines().forEach((line) -> builder.append(line).append("\n"));            
      // 이 메소드! 한 줄씩 다 빼서 Stream으로 만들어 준다. 개발자가 끝났는지 체크하면서 반복돌릴필요가 없음. 
      //도달하는 길이 길었던 제일 쉬운 방법 ㅋㅋㅋㅋㅋ
      // 글쿤 향상된 for 문 이랑 같다. line 아니라 무슨 변수명을 갔다 써도 됨. 이 변수가 나중에 빼다 쓴거 처리하라는..rgrg?
      
      in.close();
      
      System.out.println(builder.toString());
      
      
    } catch (Exception e) {
      e.printStackTrace();
    }
   
    
  }
  
  public static void method5() {
    
    // JAVA_HOME 파일명 출력하기 연습문제. 12장의 1번 파일 참고. 팁 : 배열을 stream으로 바궈서 해결

//    File javaHome = new File("\\Program Files\\Java\\jdk-17");
//    File[] files = javaHome.listFiles();
//    
//    StringBuilder builder = new StringBuilder();
//    
//   List<File> javafile = Arrays.asList(files);
//   javafile.stream().forEach((java) -> builder.append(java).append("\n"));
//   System.out.println(builder.toString());
    // 내가 쓴 구구절절 코드...
   
    
    
   File javaHome = new File("\\Program Files\\Java\\jdk-17");
   File[] files = javaHome.listFiles();
   Stream<File> stream = Arrays.stream(files);
   stream.forEach((file) -> System.out.println(file.getName()));
   //깔끔...^^
    
   try {
     //좀 다른 방법으로도 풀어볼게요.
     Path path = Paths.get("\\Program Files\\Java\\jdk-17");         //File 친구...비슷한 클래스임 //Files Paths 이건 File Path 도와주는 보조 클래스
     Stream<Path> stream2 = Files.list(path);
     stream2.forEach((p) -> System.out.println(p.getFileName()));
     stream2.close();
     
  } catch (IOException e) {
            e.printStackTrace();
  }
  }
  
  public static void main(String[] args) {

    method5();
  }

}
