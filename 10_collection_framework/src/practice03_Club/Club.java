package practice03_Club;

import java.util.HashSet;
import java.util.Set;

public class Club {
  
  public Club() {
    pool = new HashSet<Person>();
  }
  
  private Set<Person> pool;
  
  public void enterClub(Person person) {
    pool.add(person);
  }
  
  public void leaveClub(Person person) {
    pool.remove(person);
  }
  
  
  public void poolList() {
    for(Person person : pool) {
      System.out.println(person);   //toString 추가해주고 오면 이렇게 간단하게 할 수 있음.
    }
  }
  
  
  

}
