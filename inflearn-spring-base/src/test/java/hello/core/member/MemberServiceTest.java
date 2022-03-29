package hello.core.member;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/*
 *  @Test : 본 어노테이션을 붙이면 Test 메서드로 인식하고 테스트
 *  JUnit5 기준으로 접근제한자가 Default 여도 된다. (JUnit4 까지는 public이어야 했었다.)
 *  @BeforeEach : 본 어노테이션을 붙인 메서드는 테스트 메서드 실행 이전에 수행
 *  @AfterEach : 본 어노테이션을 붙인 메서드는 테스트 메서드 실행 이후에 수행
 *  @Disabled : 본 어노테이션을 붙인 테스트 메서드는 무시
 *
 */
public class MemberServiceTest {

    MemberService memberService;

    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

    @Test
    void join() {

        //given
        Member member = new Member(1L, "memberA", Grade.VIP);

        //when
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        //then
        Assertions.assertThat(member).isEqualTo(findMember);
    }
}