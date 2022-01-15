package qa.guru.Tests;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Allure;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static qa.guru.Data.Data.*;

public class LambdaSteps extends BaseTest {

    @Test
    void lambdaSteps()  {
        step("Открываем главную страницу", () -> {
            open("");
        });
        step("Ищем репозиторий " + REPOSITORY, () -> {
            $("[name='q']").setValue(REPOSITORY).pressEnter();
        });
        step("Переходим в репозиторий " + REPOSITORY, () -> {
            $("[href='/" + REPOSITORY + "']").click();
        });
        step("Открываем таб Issues " + REPOSITORY, () -> {
            $("[data-content='Issues']").click();
        });
        step("Проверяем наличие валидного Issue с номером " + ISSUE_VALID, () -> {
            $(withText("#" + ISSUE_VALID + "")).should(appear);
        });
        step("Проверяем наличие НЕвалидного Issue с номером " + ISSUE_INVALID, () -> {
            Allure.addAttachment("Page Source", "text/html", WebDriverRunner.source(), "html");
            $(withText("#" + ISSUE_INVALID + "")).should(appear);
        });
    }
}
