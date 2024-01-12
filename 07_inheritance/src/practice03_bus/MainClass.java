package practice03_bus;

public class MainClass {

  public static void main(String[] args) {

    Seat seats;
    
    Bus bus = new Bus(10);
    
    Seat seats1 = new Seat();
    Seat seats2 = new Seat();
    Seat seats3 = new Seat();
    Seat seats4 = new Seat();
    Seat seats5 = new Seat();
    Seat seats6 = new Seat();
    Seat seats7 = new Seat();
    Seat seats8 = new Seat();
    Seat seats9 = new Seat();
    Seat seats10 = new Seat();
    
    seats1.sitDown(new Person("Elsa"));
    seats2.sitDown(new Person("Ollaf"));
    seats3.sitDown(new Person("John"));
    seats4.sitDown(new Person("Christoff"));
    seats5.sitDown(new Person("Anna"));
    seats6.sitDown(new Person("Troll"));
    seats7.sitDown(new Person("Fairy"));
    seats8.sitDown(new Person("Horse"));
    seats9.sitDown(new Person("Smith"));
    seats10.sitDown(new Person("Alice"));
    
    
    
    bus.takeSeat(seats1);
    bus.takeSeat(seats2);
    bus.takeSeat(seats3);
    bus.takeSeat(seats4);
    bus.takeSeat(seats5);
    bus.takeSeat(seats6);
    bus.takeSeat(seats7);
    bus.takeSeat(seats8);
    bus.takeSeat(seats9);
    bus.takeSeat(seats10);
    
    bus.checkbus();
    
    
    
    
    
   
    
    
    
    
  }

}
