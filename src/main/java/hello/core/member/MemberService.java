package hello.core.member;

public interface MemberService {
    // 회원가입
    void join(Member member);

    // 회원조회
    Member findMember(Long memberId);
}
