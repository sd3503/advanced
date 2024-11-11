package hello.advanced.trace.template;

import hello.advanced.trace.template.code.AbstractTemplate;
import hello.advanced.trace.template.code.SubclassLogic1;
import hello.advanced.trace.template.code.SubclassLogic2;
import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.implementation.bind.annotation.Super;
import org.junit.jupiter.api.Test;


@Slf4j
public class templateMethodTest {

    @Test
    void templateMethodV0() {
        logic1();
        logic2();
    }
    private void logic1() {
        long startTime = System.currentTimeMillis();
        //핵심 로직 실행
        log.info("비즈니스 로직1 start");
        //핵심 로직 종료
        long endTime = System.currentTimeMillis();
        long resultTIme = endTime - startTime;
        log.info("resultTIme = {}", resultTIme);
    }

    private void logic2() {
        long startTime = System.currentTimeMillis();
        //핵심 로직 실행
        log.info("비즈니스 로직2 start");
        //핵심 로직 종료
        long endTime = System.currentTimeMillis();
        long resultTIme = endTime - startTime;
        log.info("resultTIme = {}", resultTIme);
    }

    @Test
    void  templateMethodV1() {
        AbstractTemplate template1 = new SubclassLogic1();
        template1.execute();

        AbstractTemplate template2 = new SubclassLogic2();
        template2.execute();
    }
    @Test
    void templateMethodV2() {
        AbstractTemplate template1 = new AbstractTemplate() {
            @Override
            protected void call() {
                log.info("비즈니스 로직1 실행");
            }
        };
        log.info("클래스 이름1 = {}", template1.getClass());
        template1.execute();



        AbstractTemplate template2 = new AbstractTemplate() {
            @Override
            protected void call() {
                log.info("비즈니스 로직2 실행");
            }
        };
        log.info("클래스 이름2= {}", template2.getClass());
        template2.execute();
    }
}
