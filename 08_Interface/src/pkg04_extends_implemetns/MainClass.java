package pkg04_extends_implemetns;

public class MainClass {

  public static void main(String[] args) {  

    Domestic domestic = new SeoulTrip();
    domestic.vehicle();
    ((SeoulTrip)domestic).sightseeing();
    
    Travel travel = new SeoulTrip();
    travel.sightseeing();
    ((SeoulTrip)travel).vehicle();
    
    SeoulTrip seoulTravel = new SeoulTrip();
    seoulTravel.vehicle();
    seoulTravel.sightseeing();
    
  }

}
