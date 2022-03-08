package hello.core;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
 /*
  * Junit 을 이용해서 test를 할 수 있지만
  * 아래와 같이 test 가능
  */
public class MemberApp {
    public static void main(String[] args) {
//         AppConfig appConfig = new AppConfig();
//         MemberService memberService = appConfig.memberService();
        // 스프링 컨테이너를 사용하기 위해 아래와 같이 변경
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        // 적상 작동하는지 확인
        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find Member = " + findMember.getName());
    }
}