package hello.servlet.web.frontcontroller.v5;
import hello.servlet.web.frontcontroller.ModelView;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
public interface MyHandlerAdapter {
    boolean supports(Object handler); // 핸들러를 지원할 수 있는지 확인

    ModelView handle(HttpServletRequest request, HttpServletResponse response,
                     Object handler) throws ServletException, IOException;
}