package hello.core.singleton;
import hello.core.AppConfig;
import hello.core.member.MemberRepository;
import hello.core.member.MemberServiceImpl;
import hello.core.order.OrderServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import
        org.springframework.context.annotation.AnnotationConfigApplicationContext;
import static org.assertj.core.api.Assertions.*;
 /*
 * AppConfig에서 MemberRepository가 여러번 호출되기 때문에 여러개의 인스턴스가 생성되어야 한다고 생각되는데,
 * 왜 하나의 인스턴스만 생성되는지 확인하기 위함
 * 이유 : 스프링 자체적으로 해결 (@Configuration)
 */
public class ConfigurationSingletonTest {
    @Test
    void configurationTest() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);

        MemberRepository memberRepository = ac.getBean("memberRepository", MemberRepository.class);
//        MemberRepository memberRepository1 = memberService.getMemberRepository();
//        MemberRepository memberRepository2 = orderService.getMemberRepository();

//모두 같은 인스턴스를 참고하고 있다.
//        System.out.println("memberService -> memberRepository = " + memberService.getMemberRepository());
//        System.out.println("orderService -> memberRepository  = " + orderService.getMemberRepository());
//        System.out.println("memberRepository = " + memberRepository); //모두 같은 인스턴스를 참고하고 있다.
//        assertThat(memberService.getMemberRepository()).isSameAs(memberRepository);
//        assertThat(orderService.getMemberRepository()).isSameAs(memberRepository);ㅍ
    }
}
