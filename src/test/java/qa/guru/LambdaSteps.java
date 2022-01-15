package qa.guru;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static qa.guru.Data.Data.ISSUE;
import static qa.guru.Data.Data.REPOSITORY;

public class LambdaSteps extends BaseTest{



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
        step("Проверяем наличие Issue с номером " + ISSUE, () -> {
            $(withText("#" + ISSUE + "")).should(appear);
        });
    }
}
