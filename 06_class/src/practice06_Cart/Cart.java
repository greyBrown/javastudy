package practice06_Cart;

public class Cart {

  // field
  public final static int CART_SIZE= 10;
  private Product[] products; //배열선언. 아직 생성 안했어요! //카트에 담은 물건들
  private int count; //카트에 담은 물건의 수. index개념!! 이렇게 쓰입니다!! 이거 끄적이면서 좀 정리해보기
  
  //constructor
  public Cart(int cartSize) {
    products = new Product[Math.min(10, cartSize)];  //이렇게 활용할 수 있으니 기억해놔요~! 잘 쓰입니당.
  }

  public Product[] getProducts() {
    return products;
  }

  public void setProducts(Product[] products) {
    this.products = products;
  }

  public int getCount() {
    return count;
  }

  public void setCount(int count) {
    this.count = count;
  }
   
  // 물건 담기
  public void addProduct(Product product) {
    
    // 카트가 꽉 찬 경우
    if(count == products.length) {
      System.out.println("꽉 찼습니다.");
      return;
    }
    
   
    if(product == null) {
      System.out.println("카트에 담을 물건이 없습니다");
      return;
    }
    products[count++] = product;
    
  }
  
  // 물건 바꾸기
  public void changeProduct(int idx, Product product) {
    
    //카트가 비어 있는 경우
    if(count == 0) {
      System.out.println("카트가 비어있습니다.");
      return;
    }
    //바꿀 물건이 없는 경우
    if(product == null) {
      System.out.println("바꿀 물건이 없습니다");
      return;
    }
    //index(여기서는 물건번호, 장바구니목록번호 이런거에용)의 유효범위 검사 - 존재하지 않는 인덱스
    if(idx < 0 || idx >= products.length) {
      System.out.println("물건 번호가 잘못되었습니다.");  // -3번 칸이요? 그런칸 없어요. 13번째 칸이요? 그런칸 없어요!!!!!
      return;
    }
    
    products[idx] = product;   //원래 있던 물건을 바꾼거기 때문에 증감은 없음. 새로바꾼 물건(프로덕트)를 원래있던물건(인덱스)에...
  }
  
  
  
  
  
  // 물건 빼기 <-이게 이 문제의 핵심....^^ 배열의 복사를 써야함. 안그러면 빈공간이 슝슝날테니까... 그래도 배열복사 이런거 자바가 해줘여 친절하지...
  public void removeProduct(int idx) {
    //장바구니에 물건이 없다
    if( count == 0) {
      System.out.println("장바구니에 물건이 없습니다.");
      return;
    }
    
    //뺄 물건번호가 잘못되었음. 물건번호라 그러니까 헷갈리는데...장바구니 리스트가 쫙 있으면 그 리스트 목록! 제품번호가 아니라!
    if(idx < 0 || idx >= products.length) {
      System.out.println("물건 번호가 잘못되었습니다.");  
      return;
    }
    
    /* 물건이 5개인 경우로 가정
     * 
     * 삭제할 idx 복사할 요소의 개수 (count - idx - 1 : 복사할 요소의 개수)
     * 0           4  
     * 1           3
     * 2           2
     * 3           1
     * 4           0
     */
    System.arraycopy(products, idx +1, products, idx, count - idx -1); //뭐시여 이게..있다...알아봅시다...
    count--;
    
  }
  
      
  
  
  
  
  
}
