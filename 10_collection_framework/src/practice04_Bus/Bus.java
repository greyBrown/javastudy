package practice04_Bus;

import java.util.ArrayList;
import java.util.List;

// 1.Seat[] -> List<Seat>
// 2. 25 -> public static final
// 3. exception


public class Bus {

  // field
  private List<Seat> seats;
  private int numOfPerson;
  public static final int MAX = 25;
  
  // constructor
  public Bus() {
    seats = new ArrayList<Seat>(MAX);
    for(int i = 0; i < MAX ; i++) {
      seats.add(new Seat());
    }
  }
  
  // method
  
  // 버스 타기(앞 자리부터 채우는 방식으로 앉기)
  public void on(Person person) throws RuntimeException{
    if(numOfPerson >= MAX) {
      throw new RuntimeException("만석입니다. 버스에 탈 수 없습니다.");
    }
    for(int i = 0; i < MAX; i++) {
      //Seat seat 는 각 좌석을 의미
      Seat seat = seats.get(i);
      if(seat.getPerson() == null) {        
        seat.setPerson(person);
        numOfPerson++;
        break;
        
      }
    }
  }
  
  // 버스 내리기
  public void off(int seatNo) throws RuntimeException{
    if(seatNo <= 0 || seatNo > MAX) {
    throw new RuntimeException("좌석 번호가 잘못 전달되었습니다."); 
    }
    seats.get(seatNo - 1).setPerson(null);
    numOfPerson--;
  }
  
  // 버스 탑승 명단
  public void info() {
    System.out.println("===== 탑승자 목록 확인 =====");
    for(int i = 0; i < MAX; i++) {
      // 각 좌석에 앉아 있는 사람
      Person person = seats.get(i).getPerson();
      if(person == null) {
        System.out.println(String.format("%02d", i + 1) + "번 좌석 : 비어 있음");
      } else {
        System.out.println(String.format("%02d", i + 1) + "번 좌석 : " + person.getName());
      }
    }
  }
  
}
