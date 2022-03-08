package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository { // Repository는 인터페이스에서 설정

    Member save(Member member);

    Optional<Member> findById(Long id); // 아이디를 찾는 함수
    Optional<Member> findByName(String name); //이름을 찾는 함수
    List<Member> findAll(); // 전체를 찾는 함수

}
