package practice03_Club;

public class MainClass {

  public static void main(String[] args) {

    Club club = new Club();
    
    Person p1 = new Person("1");
    Person p2 = new Person("2");
    Person p3 = new Person("3");
    Person p4 = new Person("4");
    Person p5 = new Person("5");
    
    System.out.println(System.identityHashCode(p3));
    
    club.enterClub(p1);
    club.enterClub(p2);
    club.enterClub(p3);
    club.enterClub(p3);
    club.enterClub(p3);
    club.enterClub(p4);
    club.enterClub(p5);
    club.enterClub(new Person("6"));
    club.enterClub(new Person("6"));
    
    //p3는 동일한 참조값을 가져서 중복체크에서 걸러지지만 new Person("6")은 참조값이 다르니까 중복체크에 걸리지 않음. 그래서 둘다 입장이 됨.
    //set 는 비교할 때 참조값을 비교함(참조값밖에 못가지니까...) 중복검사할떄 주소같으면 안받고 주소 다르면 받는거.
    //근데 참조값이 아니라 아이디를 꺼내서 비교하고 싶으면 어떻게 해야할까? source 에서 hashcode - equals 오버라이딩함.
    //오버라이딩 후 다시 실행하면 6이 한명만 있는것을 확인할 수 있음. hashset에 저장되는 친구들은 equals 을 보통 가지고 있고...뭐 그런 과정을 통해 필드값 같아도 거르는 작업을 할 수 있는거죠...
     
    
    club.leaveClub(p1);
    
    club.poolList();
    
    
    
    
  }

}
