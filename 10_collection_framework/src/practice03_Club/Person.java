package practice03_Club;

public class Person {

  private String id;
  
  public Person() {
    // TODO Auto-generated constructor stub
  }

  public Person(String id) {
    super();
    this.id = id;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  @Override
  public String toString() {
    return "Person [id=" + id + "]";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    return result;  //만약 이게 1이면 해쉬코드가 없는구나 다름없어서 풀스캔을 하겠죠...이렇게 해쉬코드를 만들어서 부분부분 나눠줌. 이클립스가 아주 잘 만들어주니까 건들지 말고 쓰면 됩니다.
  }
  //빠른 검색을 위해 만들어짐. hashcode 를 참조해 파트를 쪼개서 찾겠다. -> 그렇게 나눈 후 equals로 찾음. : 이게 해쉬알고리즘
  //있는거 갖다 쓰니까 막 너무 깊게 이해할 필요 없어요....^-^ 쨌든 hashcode -> equals 이 두 과정을 거치니까 이클립스도 이 두개를 항상 같이 만듭니다.
  //오버라이딩 전 원래 hash값은 참조값...근데 뭐 그냥 그렇다고요 구분용...

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Person other = (Person) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    return true;
  }
  
  
  
  
  
  
}
