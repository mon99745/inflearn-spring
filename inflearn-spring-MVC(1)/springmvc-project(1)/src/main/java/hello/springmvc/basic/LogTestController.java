package hello.springmvc.basic;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@Slf4j
@RestController // @RestController 는 반환 값으로 뷰를 찾는 것이 아니라, HTTP 메시지 바디에 바로 입력
public class LogTestController {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping("/log-test")
    public String logTest() {
        String name = "Spring";

        //System.out.println("name = " + name); // 불필요한 정보까지 출력되서 트래픽에서 문제가 되기도한다.

//       Lombok - @Slf4j 를 사용하게 되면 log.info(); 와 같이 사용할 수 있다.

        log.trace("trace log={}", name);
        log.trace("trace log=" + name);

        log.debug("debug log={}", name);
        // 여기부터는 실무에서 사용된다.
        log.info(" info log={}", name);
        log.warn(" warn log={}", name);
        log.error("error log={}", name);
        //로그를 사용하지 않아도 a+b 계산 로직이 먼저 실행됨, 이런 방식으로 사용하면 X log.debug("String concat log=" + name);
        return "ok";
    } }