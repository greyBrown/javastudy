package pkg07_polymorphism;

public class Person {

  public void powerOn(Elec elec) {   // Elec elc = new Tv() 또는 Elec elec = new Radio()
    ///여기에 라디오 티비(둘다 업캐) 둘따 껏켰하고 싶으면 Elec 타입을 넣어야죠! 왜냐하면 업캐스팅돼서 둘다 지금 Elec 이니까!  
   
    
  /*  
   * 1. 다운캐스팅으로 powerOn() 호출하기 -> 전자제품이 추가될때마다 코드의 추가가 필요하므로 추천하지 않음. 해결책이라 볼 수 없음.
    if (elec instanceof Tv) {
       ((Tv) elec).powerOn();
    }
    else if (elec instanceof Radio) {
      ((Radio) elec).powerOn();
    }
    //이렇게 다운캐스팅으로도 해결할 수 있지만 개수만 많아지면? 좋은선택이 아니죠! 
  */  
    /*
     * 2. Elec 에 powerOn() 메소드를 추가하고 Tv 나 Radio 가 오버라이드 하기
     */
    
    elec.powerOn();
    
  }
}
