package practice02_Cart;

import java.util.ArrayList;
import java.util.List;

public class Cart {

  // field
  private List<Product> products;  // 카트에 담은 물건들
  
  // constructor
  public Cart(int cartSize) {
    products = new ArrayList<Product>(cartSize);
  }

  // method
  public List<Product> getProducts() {
    return products;
  }
  public void setProducts(List<Product> products) {
    this.products = products;
  }
  
  // 물건 담기
  public void addProduct(Product product) throws RuntimeException {  //예외를 회피~~
    
    // 담을 물건이 없는 경우
    if(product == null) {
      throw new RuntimeException("카트에 담을 물건이 없습니다.");
    }
    
    products.add(product);
    
  }
  
  // 물건 바꾸기
  public void changeProduct(int idx, Product product)throws RuntimeException {
    
    // 카트가 비어 있는 경우
    if(products.size() == 0) {
      throw new RuntimeException("카트가 비어 있습니다.");
     
    }
    
    // 바꿀 물건이 없는 경우
    if(product == null) {
      throw new RuntimeException("바꿀 물건이 없습니다.");
    
    }
    
    // 존재하지 않는 물건 번호(인덱스)인 경우
    if(idx < 0 || idx >= products.size()) {
      throw new RuntimeException("물건 번호가 잘못되었습니다.");
      
    }
    
    products.set(idx, product);
    
  }
  
  // 물건 빼기
  public void removeProduct(int idx) throws RuntimeException {
    
    // 카트에 담긴 물건 개수
    int size = products.size();
    
    // 카트가 비어 있는 경우
    if(size == 0) {
      throw new RuntimeException("카트가 비어 있습니다.");}
    
    // 존재하지 않는 물건 번호(인덱스)인 경우
    if(idx < 0 || idx >= size) {
      throw new RuntimeException("물건 번호가 잘못되었습니다.");
    }
    
    products.remove(idx);
    
  }
  
  /* 여기서는 throws RuntimeException를 생략할 수 있다.. 왜? unchecked(ex Runtime) 는 예외처리 구문이 없어도 동작하는 예외이기 때문에 생략할 수 있다.
   * 이러한 이유로 예외 회피구문 throws 를 생략해도 동작이 가능하다. Runtime같은 경우 생략될 수 있는 대표적인 예이다...^^ 뭐 그런거예요
   * checked Exception 은 반드시! 반드시 적어줘야 해요! 꼭 생략하라는 건 아니고 다른 사람 코드 봤을 때 파악하기 쉬우니까 참고하세요!
   * 
   */
}
