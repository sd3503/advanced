package hello.advanced.trace.threadLocal;

import hello.advanced.trace.threadLocal.code.FieldService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class FieldServiceTest {
    private FieldService fieldService = new FieldService();

    @Test
    void Field(){
        log.info("main start");
        Runnable userA = () -> {
            fieldService.logic("userA");
        };
        Runnable userB = () -> {
            fieldService.logic("userB");
        };

        Thread threadA = new Thread(userA);
        threadA.setName("ThreadA");
        Thread threadB = new Thread(userB);
        threadB.setName("ThreadB");

        threadA.start();
        //sleep(2000);//동시성 문제 발생 X
        sleep(100);
        threadB.start();
        sleep(3000);//메인 쓰레드 종료 대기
    }

    private void sleep(int milis) {
        try {
            Thread.sleep(milis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
