package practice01;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.UUID;

public class MainClass {
  
  public static void method1() {
    
    // 파일명 만들기
    // 형식 : 하이픈이 제거된 UUID + 밑줄 + 타임스탬프.확장자
    
    String fileName = "apple.jpg"; //apple 은 날아가고 jpg 만 살림
    String extName = fileName.substring(fileName.lastIndexOf("."), fileName.length());
    StringBuilder builder = new StringBuilder();
    builder.append(UUID.randomUUID().toString().replace("-", "_"));
    builder.append("_");
    builder.append(System.currentTimeMillis());
    builder.append(extName);
    
    System.out.println(builder.toString());
    
  }
  
 public static Map<String, Object> method2 (String id) {
    
    // 나이 구하기 + 성별 구하기
    // 나이 : 현재년도 - 태어난 년도
    // 성별 : 하이픈 뒤의 숫자가 1, 3이면 남자 2, 4이면 여자
   
   
   //이프 라스트인덱스 - 다음 한글자가 1이나 2면 1900 3이나 4면 2000
   
   
//   //나이 추출
//   int extage = Integer.parseInt(id.substring(0, 2));
//   int geninfo = Integer.parseInt(id.substring(id.lastIndexOf("-"), id.lastIndexOf("-")+1));
//   if (geninfo == 1 || geninfo ==2) {
//     extage += 1900; 
//   } else {
//     extage += 2000;
//   }
//   LocalDateTime now = LocalDateTime.now();
//   int age = now.getYear() - extage;
//   
//   //성별추출
//   String gen = null;
//   if (geninfo == 1 || geninfo ==3) {
//     gen = "남자";
//   } else { 
//     gen = "여자";
//   }
//       
//   Map<String, Object> info = new HashMap<String, Object>();
//   info.put("나이", age);
//   info.put("성별", gen);
//   
//   System.out.println(info.get("나이"));
   
   //위에가 내가 한거 아래가 선생님
   
   //현재 년도
   int nowYear = LocalDate.now().getYear();
   
   //태어난 년도
   int birthYear  = 0;
   
   // 하이픈 뒤의 숫자
   int afterHyphen = Integer.parseInt(id.substring(7, 8));
   
   switch(afterHyphen) {
   case 1 :
   case 2 : 
     birthYear = 1900 + Integer.parseInt(id.substring(0, 2));
     break;
   case 3 :
   case 4 :
     birthYear = 2000 + Integer.parseInt(id.substring(0, 2));
     break;
   }
   
   String[] genders = {"여자", "남자"};  //2로 나눈 나머지가 0일때 여자가 오니까 여자가 idx1로 옵니다.
   
   return Map.of("age", nowYear - birthYear, "gender", genders[afterHyphen % 2]);
   
   

   /*
    * 이하는 메인메소드//Map<String, Object> map = method2("123456-7891012");
   // map을 for 문으로 돌려서 확인하기   Set<Entry<String, Object>>  entrySet = map.entrySet(); 이거 필요없네??????? 생략이...다 되네요.....
   
   for(Entry<String, Object> entry : map.entrySet()) {
     System.out.println(entry.getKey() + ":" + entry.getValue());}
    */
   
   }
   
    
  
 
 public static void method3() {
   
   // 각 나라별 수도 맞히기
   
   // 프랑스 수도는? >>> 
   // 파리
   // 스위스 수도는? >>> 
   // 베른
   // 영국 수도는? >>> 
   // 런던
   // 독일 수도는? >>> 
   // 베를린
   // 이탈리아 수도는? >>> 
   // 로마
   // 5개 정답 성공
   
   
   
   Map<String, String> map = Map.of("프랑스", "파리"
                                  , "독일", "베를린"
                                  , "이탈리아", "로마"
                                  , "스위스", "베른"
                                  , "영국", "런던");
   
   Scanner sc = new Scanner(System.in);
   int count = 0;
   for(Entry<String, String> entry : map.entrySet()) {
     System.out.println(entry.getKey() + "수도는? >>>"); 
     String capital = sc.next();
     if(capital.trim().equals(entry.getValue())) { 
       count++;
     }
   }
     System.out.println(count + "개 정답 성공");
     sc.close();
 }
 
 public static void method4() {
   
   //5000원이 있는 통장(balance)에서 랜덤하게 출금하기
   
   int Account = 5000;
   int count = 0;
   
   // 출금액 : 1 <= 난수 <= balance
 
 
//   while( Account >= 0) {
//     Account -= Math.random() * 900 + 1;
//     if (Account < 0) {
//       Account = 0;
//       System.out.println(Account);
//       return;
//     }
//     System.out.println(Account);
//   } 내가 한 부분
   
   //이런 야매...과연 정답이 맞을것인가?
   
 }
 
 public static void method5() {
   
   //윷놀이(랜덤)
   
   String[] yuts = {"", "도", "개", "걸", "윷", "모"};
  //idx 만큼 움직인다.
   //배열의 랜덤은 mr *60 +1 만큼의 랜덤으로 움직이고
   //해당 idx의 숫자만큼 움직인다.
   
   
//  List<String> yut  = Arrays.asList(yuts);
   
//   int random =(int)(Math.random() * 5 + 1); 내가 한 부분
//   
//   if(random >= 4) {
//     int random2=(int)(Math.random() * 5 + 1);
//     System.out.println("\"" +yut.get(random) + "\" " + "\"" +yut.get(random2) + "\" " + (random+random2)  +"칸 이동합니다." );
//   } else {
//   System.out.println("\"" +yut.get(random) + "\" " + random  +"칸 이동합니다." );
//   }
       
   StringBuilder builder = new StringBuilder();

   int move = 0;
   int totalmove = 0;
   do {
    move = (int)(Math.random() * 5 + 1);
    totalmove += move;
    builder.append(yuts[move]);
    builder.append(",");
    System.out.println(yuts[move]);
  } while (move >= 4);
   builder.append(totalmove).append("칸 이동한다.");
   
   System.out.println(builder.toString());
   
   
  //StringBuilder append.append.append. 이거 가능함!!! 메소드 체이닝이 가능
   
//do - while 조건문! do 먼저 하고!! 먼저 하고!!! 그 다음에 while 의 조건식을 따른다! 조건이 1턴 늦춰짐. 
   
   
   
   
   
 }
 
 public static void method6() {
   
   /*SecureRandom을 이용해 "대문자+소문자+숫자"로 구성된 임의의 인증번호 만들기
   *   몇 자리의 인증번호를 생성할까요? 4
   *   
   *   인증번호 ~~~가 생성되었습니다.
   *   
   *   62진법에서 무작위로 4개 뽑는다?
   *   
   *
   */
   
   
   
   
   
 }
 
 public static void method7() {
   

   //Updown 게임
   //컴퓨터가 1~ 10000 사이의 난수를 발생시킨다.
   //사용자는 해당 난수를 맞힌다.
   //아아아 더 큰데/
   //아아아 좀 작은데
   //정답!
  
  /*
   * 어케하나...random 이 결정되고 sc.next()를 받는다. sc.next() > random 이면  SOP("더 작은 숫자가 필요합니다") 반대면 반대
   * sc.next() == random SOP("정답을 맞추셨습니다!") 이렇게? 
   */
   
   
   
 }
 
 public static void method8() {
   
   // 0~9 사이 난수를 100개 발생시키고 발생한 난수들이 생성된 횟수(빈도수)를 그래프화하시오
   
 
 }
 
 public static void method9() {
   
   // 5*5 숫자 빙고판 자동 생성
   
   
   
 }
 
  public static void main(String[] args) {

    
    
    
    method5();
    
    
    
    
    
    
    
    
    
    
    
    
  }

}
