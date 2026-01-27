package ru.netology.delivery.test;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import ru.netology.delivery.data.DataGenerator;


import java.time.Duration;


import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
class DeliveryTest {

    @BeforeAll
    static void setUpAllure() {
        SelenideLogger.addListener("allure", new AllureSelenide()
                .screenshots(true)
                .savePageSource(true));
    }

    @AfterAll
    static void tearDownAllure() {
        SelenideLogger.removeListener("allure");
    }

    @BeforeEach
    void setup() {
        open("http://localhost:9999");
    }

    @Test
    @DisplayName("Should successful plan meeting")
    void shouldSuccessfulPlanMeeting() {
        var validUser = DataGenerator.Registration.generateUser("ru");

        var daysToAddForFirstMeeting = 4;
        var firstMeetingDate = DataGenerator.generateDate(daysToAddForFirstMeeting);
        var daysToAddForSecondMeeting = 7;
        var secondMeetingDate = DataGenerator.generateDate(daysToAddForSecondMeeting);

        $("[data-test-id=city] input").setValue(validUser.getCity());

        $("[data-test-id=date] input")
                .doubleClick()
                .sendKeys(Keys.BACK_SPACE);
        $("[data-test-id=date] input").setValue(firstMeetingDate);

        $("[data-test-id=name] input").setValue(validUser.getName());
        $("[data-test-id=phone] input").setValue(validUser.getPhone());

        $("[data-test-id=agreement]").click();

        $$("button")
                .find(Condition.text("Запланировать"))
                .click();


        $("[data-test-id=success-notification]")
                .shouldBe(visible, Duration.ofSeconds(3))
                .shouldHave(Condition.text("Успешно!"))
                .shouldHave(Condition.text("Встреча успешно запланирована на " + firstMeetingDate));

        // Перепланирование
        $("[data-test-id=date] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id=date] input").setValue(secondMeetingDate);


        $$("button").find(text("Запланировать")).click();


        $("[data-test-id=replan-notification]").shouldBe(visible)
                .shouldHave(text("У вас уже запланирована встреча"));


        $$("button").find(text("Перепланировать")).click();


        $("[data-test-id=success-notification]")
                .shouldBe(visible, Duration.ofSeconds(3))
                .shouldHave(Condition.text("Встреча успешно запланирована на " + secondMeetingDate))
                .shouldNotHave(text(firstMeetingDate));
    }
}
