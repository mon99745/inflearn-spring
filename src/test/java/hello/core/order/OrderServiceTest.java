package hello.core.order;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import hello.core.order.OrderService;
import org.junit.jupiter.api.BeforeEach;

class OrderServiceTest {
    MemberService memberService;
    OrderService orderService;
    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }
}