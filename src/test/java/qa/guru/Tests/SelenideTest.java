package qa.guru.Tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import qa.guru.Pages.WebSteps;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.SeverityLevel.NORMAL;
import static qa.guru.Data.Data.ISSUE_VALID;

public class SelenideTest extends BaseTest {

    @Feature("Тесты для неавторизованного пользователя")
    @Story("Поиск ISSUE")
    @Severity(NORMAL)
    @DisplayName("Проверка наличия Issue")
    @Owner("Mikhail Loginov")
    @Link(value = "Github", url = "https://github.com/")
    @Test
    void selenideTest()  {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("");

        $("[name='q']").setValue("eroshenkoam/allure-example").pressEnter();
        $("[href='/eroshenkoam/allure-example']").click();
        $("[data-content='Issues']").click();

        $(withText("#" + ISSUE_VALID + "")).should(appear);
    }

    @AfterEach
    public void saveSources(){
        new WebSteps().addScreen();
    }
}
