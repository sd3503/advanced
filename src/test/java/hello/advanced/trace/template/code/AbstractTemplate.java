package hello.advanced.trace.template.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class AbstractTemplate {

    public void execute(){
        long startTime = System.currentTimeMillis();
        //핵심 로직 실행
        call();
        //핵심 로직 종료
        long endTime = System.currentTimeMillis();
        long resultTIme = endTime - startTime;
        log.info("resultTIme = {}", resultTIme);
    }
    protected abstract void call();

}
