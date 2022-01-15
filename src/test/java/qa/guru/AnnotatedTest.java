package qa.guru;

import org.junit.jupiter.api.Test;
import qa.guru.Pages.WebSteps;

import static qa.guru.Data.Data.ISSUE;
import static qa.guru.Data.Data.REPOSITORY;

public class AnnotatedTest extends BaseTest{


    @Test
    void annotatedSteps(){
        WebSteps steps = new WebSteps();

        steps.openMainPage();
        steps.searchRepository(REPOSITORY);
        steps.openRepository(REPOSITORY);
        steps.openIssueTab();
        steps.checkIssueNumber(ISSUE);

    }
}
