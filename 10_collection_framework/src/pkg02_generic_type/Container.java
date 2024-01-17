package pkg02_generic_type;

class Container<T> {
  
  private T item;
  //오브젝트는 모든 것을 저장할 수 있는 만능타입. 하지만 꺼낼 쓸 때마다 캐스팅을 해야한다는 문제...^^(오브젝트 메소드만 꺼낼 수 있음) 이렇게도 할 수 있지만 제네릭이니까~ 


  public T getItem() {
    return item;
  }

  public void setItem(T item) {
    this.item = item;
  }   
  
  

}
