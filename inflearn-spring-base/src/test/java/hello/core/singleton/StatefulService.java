package hello.core.singleton;
 /*
 싱글톤 방식은 유지(stateful)하게 설계하면 안된다.
  */
public class StatefulService {
    private int price; //상태를 유지하는 필드
    public void order(String name, int price) {
        System.out.println("name = " + name + " price = " + price); this.price = price; //여기가 문제!
    }
    public int getPrice() {
        return price;
    }
}