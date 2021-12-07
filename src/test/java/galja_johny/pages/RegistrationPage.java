package galja_johny.pages;

import galja_johny.model.StudentRegistrationFormVM;

import java.io.File;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class RegistrationPage {
    // actions
    public RegistrationPage openPage() {
        open("https://demoqa.com/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        return this;
    }

    public void fillForm(StudentRegistrationFormVM student) {
        $("#firstName").setValue(student.firstName);
        $("#lastName").setValue(student.lastName);
        $("#userEmail").setValue(student.email);
        $("#genterWrapper").find(byText(student.someGender)).click();
        $("#userNumber").setValue(student.number);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption(student.year);
        $(".react-datepicker__month-select").selectOption(student.month);
        $(".react-datepicker__month").findElement(byText(student.day)).click();
        $("#subjectsInput").click();
        $("#subjectsInput").setValue(student.someSubject).pressEnter();
        $("#hobbiesWrapper").find(byText(student.someInterest)).click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/testimage.jpg"));
        $("#currentAddress").setValue(student.someAddress);
        $("#state").click();
        $("#react-select-3-input").setValue(student.state).pressEnter();
        $("#city").click();
        sleep(500);
        $("#react-select-4-input").setValue(student.city).pressEnter();
        $("#submit").click();
    }

    public void checkForm(StudentRegistrationFormVM student) {
        checkValue("Student Name", student.firstName + " " + student.lastName );
        checkValue("Gender", student.someGender );
        checkValue("Student Email", student.email);
        checkValue("Mobile", student.number);
        checkValue("Date of Birth", student.day + " " + student.month + "," + student.year );
        checkValue("Subjects", student.someSubject);
        checkValue("Hobbies", student.someInterest);
        checkValue("Address", student.someAddress);
        checkValue("State and City", student.state + " " + student.city );
    }

    private void checkValue(String key, String value) {
        $(".table-responsive").$(byText(key)).parent().shouldHave(text(value));
    }
}
