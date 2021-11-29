package galja_johny.tests;

import com.codeborne.selenide.Configuration;
import galja_johny.pages.RegistrationPage;
import org.junit.jupiter.api.BeforeEach;

public class TestBase {

    RegistrationPage regPage = new RegistrationPage();

    @BeforeEach
    public void setup() {
        Configuration.startMaximized = true;
    }
}
