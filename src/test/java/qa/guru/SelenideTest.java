package qa.guru;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideTest extends BaseTest {

    @Test
    void selenideTest()  {
        open("");

        $("[name='q']").setValue("eroshenkoam/allure-example").pressEnter();
        $("[href='/eroshenkoam/allure-example']").click();
        $("[data-content='Issues']").click();

        $(withText("#58")).should(appear);
    }
}
