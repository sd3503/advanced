package hello.advanced.trace.strategy.code.strategy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ContextV2 {

    public  void execute(Strategy strategy) {
        long startTime = System.currentTimeMillis();
        //핵심 로직 실행
        strategy.call();
        //핵심 로직 종료
        long endTime = System.currentTimeMillis();
        long resultTIme = endTime - startTime;
        log.info("resultTIme = {}", resultTIme);
    }
}
