package galja_johny;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.io.File;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class FormTest {

    @BeforeEach
    public void setup() {
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
    }

    @Test
    void successfulFilling() {
        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue("John");
        $("#lastName").setValue("Doe");
        $("#userEmail").setValue("correct@email.com");
        $("#gender-radio-3").doubleClick();
        $("#userNumber").setValue("8983478737");

//        Просто напечатать дату
        $("#dateOfBirthInput").doubleClick();
        $("#dateOfBirthInput").sendKeys(Keys.CONTROL+"a");
        $("#dateOfBirthInput").sendKeys(Keys.SPACE);
        $("#dateOfBirthInput").setValue("19 Sep 1990");
        $("#dateOfBirthInput").sendKeys(Keys.ESCAPE);

//        Накликать на пикере - не накликивается
//        $("[class=react-datepicker__navigation react-datepicker__navigation--previous]").click();
//        $("[class=react-datepicker__year-select]").selectOption("1990");
//        $("[class=react-datepicker__month]").execute(pickDate);
//        $("[id=dateOfBirthInput]").shouldHave(text("19 Sep 1990"));


//        Автосаджест форма
        $("#subjectsInput").click();
        $("#subjectsInput").setValue("Hindi").pressEnter();


//        Чекбоксы
        $("#hobbies-checkbox-1").parent().click();
        $("#hobbies-checkbox-2").parent().click();
        $("#hobbies-checkbox-3").parent().click();


//        Прикрепить файл - не прикрепляется
//        $("[id=uploadPicture]").click();
//        File file = new File("testimgk.png");
//        $("#file").uploadFile(file);
//        $("[id=uploadPicture]").uploadFile("C:\Users\galja\Downloads\Image from iOS (6).png");


//        Адрес
        $("#currentAddress").setValue("Brighton main square");

//        Списки
        $("#state").scrollIntoView(true).click();
        $("#react-select-3-input").pressEnter();
        $("#city").click();
        $("#react-select-4-input").pressEnter();

//        Кнопка
        $("#submit").doubleClick();

//        Проверки
        $("#firstName").shouldBe(value("John"));
        $("#lastName").shouldHave(value("Doe"));
        $("#userEmail").shouldHave(value("correct@email.com"));
        $("#gender-radio-3").isSelected();
        $("#userNumber").shouldHave(value("8983478737"));
        $("#dateOfBirthInput").shouldHave(value("19 Sep 1990"));
        $("#subjectsInput").shouldHave(value("Hindi"));
        $("#hobbies-checkbox-1").isSelected();
        $("#hobbies-checkbox-2").isSelected();
        $("#hobbies-checkbox-3").isSelected();
        $("#currentAddress").shouldHave(value("Brighton main square"));
        $("#react-select-3-input").isSelected();
        $("#react-select-4-input").isSelected();




    }

}

