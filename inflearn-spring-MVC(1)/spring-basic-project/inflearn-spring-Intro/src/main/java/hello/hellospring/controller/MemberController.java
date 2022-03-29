package hello.hellospring.controller;


import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {
    private final MemberService memberService;
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
    //회원 컨트롤러에서 조회 기능
    @GetMapping(value = "/members/new")
    public String createForm(){
        return "member/createMemberForm";
    }
//// 회원 컨트롤러에서 회원을 실제 등록하는 기능
//@PostMapping(value = "/members/new")
//public String create(MemberForm form) {
//    Member member = new Member();
//    member.setName(form.getName());
//    memberService.join(member);
//    return "redirect:/";
//}


}
