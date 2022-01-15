package qa.guru;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.clearBrowserCookies;
import static com.codeborne.selenide.Selenide.closeWebDriver;

public class BaseTest {

    @BeforeEach
    void beforeEach(){
        clearBrowserCookies();
        Configuration.baseUrl = "https://github.com/";
        Configuration.browserSize = "1590x850";
    }

    @AfterAll
    public static void afterAll(){

        closeWebDriver();
    }


}
