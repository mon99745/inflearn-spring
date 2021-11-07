package hello.core.member;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MemberServiceTest {
    MemberService memberService = new MemberServiceImpl();
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
