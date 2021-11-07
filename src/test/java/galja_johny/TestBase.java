package galja_johny;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;

public class TestBase {

    @BeforeEach
    public void setup() {
        Configuration.startMaximized = true;
    }
}
