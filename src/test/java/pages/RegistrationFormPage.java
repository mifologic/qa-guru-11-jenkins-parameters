package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormPage {

    @Step("Open page")
    public RegistrationFormPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        return this;
    }

    @Step("Fill first name")
    public RegistrationFormPage setFirstName(String studentName) {
        $("#firstName").setValue(studentName);
        return this;
    }

    @Step("Fill last name")
    public RegistrationFormPage setLastName(String studentLastName) {
        $("#lastName").setValue(studentLastName);
        return this;
    }

    @Step("Fill email")
    public RegistrationFormPage setEmail(String email) {
        $("#userEmail").setValue(email);
        return this;
    }

    @Step("Fill gender")
    public RegistrationFormPage setGender(String gender) {
        $("#genterWrapper").$(byText(gender)).click();
        return this;
    }

    @Step("Fill phone number")
    public RegistrationFormPage setPhoneNumber(String phoneNumber) {
        $("#userNumber").setValue(phoneNumber);
        return this;
    }

    @Step("Fill date of birth")
    public RegistrationFormPage setBirthDate(String date, String month, String year) {
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionContainingText(month);
        $(".react-datepicker__year-select").selectOptionContainingText(year);
        $(".react-datepicker__day--0" + date).click();
        return this;
    }

    @Step("Fill subject")
    public RegistrationFormPage setSubject(String subject) {
        $("#subjectsContainer").$("input").setValue(subject).pressEnter();
        return this;
    }

    @Step("Fill hobby")
    public RegistrationFormPage setHobby(String hobby) {
        $("#hobbiesWrapper").$(byText(hobby)).click();
        return this;
    }

    @Step("Upload photo")
    public RegistrationFormPage uploadPhoto(String file) {
        $("#uploadPicture").uploadFile(new File(file));
        return this;
    }

    @Step("Fill address")
    public RegistrationFormPage setAddress(String currentAddress) {
        $("#currentAddress").setValue(currentAddress);
        return this;
    }

    @Step("Fill city")
    public RegistrationFormPage setCity(String state, String city) {
        $("#stateCity-wrapper").$("input").setValue(state).pressTab();
        $("#city").$("input").setValue(city).pressTab();
        return this;
    }

    @Step("Push submit button ")
    public RegistrationFormPage submitForm() {
        $("#submit").click();
        return this;
    }

    @Step("Check for results")
    public RegistrationFormPage checkResult(String key, String value) {
        $(".modal-title").shouldHave(Condition.text("Thanks for submitting the form"));
        $(".table-responsive").$(byText(key))
                .parent().shouldHave(text(value));

        return this;
    }
}
