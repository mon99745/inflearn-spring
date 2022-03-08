package hello.core.autowired;

import com.beust.jcommander.internal.Nullable;
import hello.core.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Optional;

public class AutoWiredTest {

    @Test
    void AutoWiredOption(){
        new AnnotationConfigApplicationContext(TestBean.class);
//        ac.getBean
    }
    static class TestBean{
        //호출 안됨
        // 자동 주입할 대상이 없으면 수정자 메서드 자체가 호출안됨
        @Autowired(required = false)
        public void setNoBean1(Member noBean1) {
            System.out.println("setNoBean1 = " + noBean1);
        }
        //null 호출
        @Autowired
        public void setNoBean2(@Nullable Member noBean2) {
            System.out.println("setNoBean2 = " + noBean2);
        }
        //Optional.empty 호출
        @Autowired(required = false)
        public void setNoBean3(Optional<Member> noBean3) {
            System.out.println("setNoBean3 = " + noBean3);
        }
    }
}
