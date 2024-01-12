package practice03_bus;

public class Seat {
  
  
  private Person person;
  
  public void sitDown(Person person) {
    this.person = person;
  }

  public void passenger() {
    person.passenger();
  }
  
}
