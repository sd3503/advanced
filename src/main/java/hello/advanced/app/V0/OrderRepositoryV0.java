package hello.advanced.app.V0;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryV0 {
    public void save(String  itemId) {

        if(itemId.equals("ex")){
            throw new IllegalArgumentException("예외 발생!");
        }

        sleep(1000);
    }
    private void sleep(int i) {
        try {
            Thread.sleep(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
