package qa.guru.Pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebSteps {

    @Step("Открываем главную страницу")
    public void openMainPage(){
        open("");
    }

    @Step("Ищем репозиторий {rep}")
    public void searchRepository(String rep){
        $("[name='q']").setValue(rep).pressEnter();
    }

    @Step("Переходим в репозиторий {rep}")
    public void openRepository(String rep){
        $("[href='/" + rep + "']").click();
    }

    @Step("Открываем таб Issues")
    public void openIssueTab(){
        $("[data-content='Issues']").click();
    }

    @Step("Проверяем наличие Issue с номером {issue}")
    public void checkIssueNumber(String issue){
        $(withText("#" + issue + "")).should(appear);
    }
}
