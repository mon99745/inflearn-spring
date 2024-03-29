package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/*
 * 객체의 생성과 연결은 AppConfig가 담당하게 된다.
 * 관심사 분리 (연결하는 역할과 실행하는 역할이 명확히 분리)
 * 사용영역과 구성영역의 분리 (할인정책을 변경 시 AppConfig 내에서 변경가능하다.
 * IoC 컨테이너 또는 DI 컨테이너 라고 말한다. (DI컨테이너가 일반적)
 */
@Configuration // AppConfig에 설정을 구성한다는 뜻
public class AppConfig {

    // 리팩터링 전
//    public MemberService memberService() {
//        return new MemberServiceImpl(memberRepository());
//    }
//    public OrderService orderService() {
//        return new OrderServiceImpl(memberRepository(), discountPolicy());
//    }
//    public MemberRepository memberRepository(){
//        return new MemoryMemberRepository();
//    }
//    public DiscountPolicy discountPolicy(){
//            //return new FixDiscountPolicy();
//        return new RateDiscountPolicy();
//    }
//}

    /*
    * 리펙터링 후
    * @Bean을 붙여줘서, 스프링 컨테이너에 스프링 빈으로 등록
    * appConfig.xml과 같다.
    */
    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }
    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
    @Bean
    public DiscountPolicy discountPolicy(){
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
