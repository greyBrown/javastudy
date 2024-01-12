package practice03_bus;

public class Bus {
  
  private Seat[] seats;
  private int seatCount; //승객수 들어오는 순서대로 탑니다.
  public static final int SEATMAX =10;
  
  
  
  public Bus(int seatCount) {
    seats = new Seat[seatCount];
    for(int i =1; i < seats.length; i++) {
      seats[i] = new Seat();
    }
  }
  
  //좌석에 승객이 앉음
  public void takeSeat(Seat seat) {
    if(seatCount>seats.length) {
      System.out.println("더 이상 승차할 수 없습니다.");
      return;}

    seats[seatCount++] = seat;
    System.out.println( seats.length);
    System.out.println(seatCount + "번 째 승객이 탑승하였습니다. 남은 좌석" + (seats.length - seatCount)+ "개 입니다.");
  }

  
  public void checkbus() {
    for(int i = 0; i < seatCount; i++) {
      seats[i].passenger();
    }
    
  }
  
  
}
