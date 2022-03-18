package hello.servlet.web.servletmvc;
import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
// 회원 저장 페이지 호출
@WebServlet(name = "mvcMemberSaveServlet", urlPatterns = "/servlet-mvc/members/save")
        public class MvcMemberSaveServlet extends HttpServlet {
        private MemberRepository memberRepository = MemberRepository.getInstance();

        @Override
        protected void service(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
                        //파라미터 받고,
                        String username = request.getParameter("username");
                        int age = Integer.parseInt(request.getParameter("age"));
                        // 서비스로직 호출하고,
                        Member member = new Member(username, age);
                        System.out.println("member = " + member);
                        memberRepository.save(member);
                        //Model에 데이터를 보관한다.
                        request.setAttribute("member", member);

                        // view로 보내주고,
                        String viewPath = "/WEB-INF/views/save-result.jsp";
                        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
                        dispatcher.forward(request, response);
                        }
}