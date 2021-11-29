package galja_johny.tests;

import com.github.javafaker.Faker;
import galja_johny.model.StudentRegistrationFormVM;
import org.junit.jupiter.api.Test;

public class FormTestWithPageObjects extends TestBase {

    Faker faker = new Faker();

    @Test
    void successfulFilling() {
        StudentRegistrationFormVM vasya = new StudentRegistrationFormVM();
        vasya.firstName = faker.name().firstName();
        vasya.lastName = faker.name().lastName();
        vasya.email = "asd@mjhg.ru";
        vasya.someGender = "Other";
        vasya.number = faker.number().digits(10);
        vasya.year = "2020";
        vasya.month = "September";
        vasya.day = "19";
        vasya.someSubject = "Hindi";
        vasya.someInterest = "Music";
        vasya.someAddress = faker.address().streetAddress();
        vasya.city = "Karnal";
        vasya.state = "Haryana";


        regPage
                .openPage()
                .fillForm(vasya);

        regPage.checkForm(vasya);


    }

}







