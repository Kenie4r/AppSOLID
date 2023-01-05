package Utils;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.kodigo.Utils.PauseScreen;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTimeout;

public class PauseScreenTest {
    @Test
    void pauseScreenTest(){
        int segundos = 2;
        assertTimeout(Duration.ofMillis((1000*2)+30),()->{
            PauseScreen.pause(segundos);
        });
    }
}
