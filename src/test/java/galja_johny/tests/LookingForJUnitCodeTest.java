package galja_johny.tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class LookingForJUnitCodeTest extends TestBase {

    @Test
    void successfulFilling() {
        open("https://github.com/selenide/selenide");
        $("#wiki-tab").click();
        $(byText("Soft assertions")).shouldBe(visible);
        $(".markdown-body").$(byText("Soft assertions")).click();
        $$(".markdown-body ol").get(3).$("li").shouldHave(text("Using JUnit5 extend test class:"));
        $$(".markdown-body ol").get(3).sibling(0).$("div pre").$(".pl-smi").shouldHave(text("SoftAssertsExtension"));
    }
}
