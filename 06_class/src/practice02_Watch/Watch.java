package practice02_Watch;

public class Watch {

 private int hour;
 private int minute;
 private int second;
 
public Watch(int hour, int minute, int second) {
  super();
  this.hour = hour;
  this.minute = minute;
  this.second = second;
}

//주석은 선생님 답입니다. 보고 리뷰하면서 공부하기...이상한 값 넣는 사람들 나오니까 0 미만의 값 넣을 수 있게 처리 해주기! ㅋㅋㅋㅋ
  
public int addHour(int hour) {
  
 return this.hour += hour;
}

/*
 * if (hour <= 0) {
 * return;
 * this.hour += hour;
 * this.hour %= 24;  // 0~23 사이 값을 가지게 된다. 나머지연산(modular) 정말 많이 쓰여요! 익숙해지겠져...  
 *
 */


public void addMinute(int minute) {
  
  if(minute/60 >= 1) { 
    addHour(minute/60);
    this.minute += minute%60;
     
  } else {
    this.minute += minute;
  }
  
}

/*if (minute <= 0) {
return;
}
this.minute += minute;
 addHour(minute/60);
 this.minute %= 60;


*/


public void addSecond(int second) {
  
  if(second/60 >= 1) { 
    addMinute(second/60);
    this.second += second%60;
  } else {
    this.second += second;
  }
}

/*
 * if(second < 0) { 
 * return;
 * }
 * this.second += second;
 * addMinute(this.second/60);
 * this.second %= 60;
 */


public void see() {
  
  System.out.println(String.format("%02d:%02d:%02d", this.hour, this.minute, this.second));  //이런 포맷 알아두면 실무에서 유용해요!! 차차 외우게 될거라고 생각합니다...
}

//싹다 void로 해도 됨. 왜? 반환해서 어디 값 넘기는 거 아니니까! 아까는 money를 반환해서 sop하니까 반환값이 필요한거고 이건 see로 보니까 상관없음!
//void는 그렇게 이 메서드를 통째로 어디 반환하고 그 반환값이 필요한거 아니면 안써도 됨! 그런 상황입니다. 하다보면 아리까리 하던거 조금씩 더 아는 것 같고 그렇다...







}

