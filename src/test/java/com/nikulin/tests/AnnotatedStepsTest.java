package com.nikulin.tests;

import org.junit.jupiter.api.Test;

public class AnnotatedStepsTest {

    private static final String REPOSITORY = "SergeyNikulin/github-selenide-tests";
    private static final String ISSUE_NAME = "test_allure";

    @Test
    public void searchIssueAnnotatedStepTest() {
        WebSteps steps = new WebSteps();

        steps.openMainPage()
                .searchForRepository(REPOSITORY)
                .goToRepository(REPOSITORY)
                .openIssuesTab()
                .shouldSeeIssueWithName(ISSUE_NAME);
    }
}
