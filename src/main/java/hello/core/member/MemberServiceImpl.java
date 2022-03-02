package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
// Impl 관례상 하나의 인터페이스를 갖을때의 이름
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;

    @Autowired //ac.getBean(MemberRespository.class) 가 들어가는걸로 보면된다.
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}