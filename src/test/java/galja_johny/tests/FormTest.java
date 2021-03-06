package galja_johny.tests;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class FormTest extends TestBase {

    @Disabled
    @Test
    void successfulFilling() {
        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue("John");
        $("#lastName").setValue("Doe");
        $("#userEmail").setValue("correct@email.com");
        $("#gender-radio-3").doubleClick();
        $("#userNumber").setValue("8983478737");

//        Накликать на пикере
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("September");
        $(".react-datepicker__year-select").selectOption("1990");
        $(".react-datepicker__day--019:not(.react-datepicker__day--outside-month)").click();

//        Автосаджест форма
        $("#subjectsInput").click();
        $("#subjectsInput").setValue("Hindi").pressEnter();

//        Чекбоксы
        $("#hobbies-checkbox-1").parent().click();
        $("#hobbies-checkbox-2").parent().click();
        $("#hobbies-checkbox-3").parent().click();

//        Прикрепить файл - не прикрепляется
        $("#uploadPicture").uploadFile(new File("src/test/resources/testimage.jpg"));

//        Адрес
        $("#currentAddress").setValue("Brighton main square");

//        Списки
        $("#state").scrollIntoView(true).click();
        $("#react-select-3-input").pressEnter();
        $("#city").click();
        $("#react-select-4-input").pressEnter();

//        Проверки, что всё заполнилось
        $("#firstName").shouldBe(value("John"));
        $("#lastName").shouldHave(value("Doe"));
        $("#userEmail").shouldHave(value("correct@email.com"));
        $("#gender-radio-3").isSelected();
        $("#userNumber").shouldHave(value("8983478737"));
        $("#dateOfBirthInput").shouldHave(value("19 Sep 1990"));
        $("#hobbies-checkbox-1").isSelected();
        $("#hobbies-checkbox-2").isSelected();
        $("#hobbies-checkbox-3").isSelected();
        $("#currentAddress").shouldHave(value("Brighton main square"));
        $("#react-select-3-input").isSelected();
        $("#react-select-4-input").isSelected();

//        Кнопка
        $("#submit").click();

//        Проверки результата
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("John Doe"),text("correct@email.com"),
        text("Other"), text("8983478737"), text("19 September,1990"), text("Hindi"),
                text("Sports, Reading, Music"), text("Sports, Reading, Music"),
                text("Brighton main square"), text("NCR Delhi"));
    }
}





