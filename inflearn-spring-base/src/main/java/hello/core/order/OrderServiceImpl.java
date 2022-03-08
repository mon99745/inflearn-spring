package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor //생성자를 자동으로 생성
public class OrderServiceImpl implements OrderService {
    //필드
    private final MemberRepository memberRepository;

    // OrderServiceImpl 은 DiscountPolicy 인터페이스에 의존한다.
    // 즉, DiscountPolicy에 상세한 내용은 기술되지 않는다.
    private final DiscountPolicy discountPolicy;

    //    private final DiscountPolicy discountPolicy = new FixDiscountPolicy(); // 정액 할인 정책
//    private final DiscountPolicy discountPolicy = new RateDiscountPolicy(); // 정률 할인 정책
//    private DiscountPolicy discountPolicy; // 인터페이스에만 의존하도록 설계

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {

        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}