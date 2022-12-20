package com.nikulin.tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class SelenideTest {

    private static final String REPOSITORY = "SergeyNikulin/github-selenide-tests";
    private static final String ISSUE_NAME = "test_allure";

    @Test
    public void searchIssueSelenideTest(){
        open("https://github.com/");
        $(".header-search-input").click();
        $(".header-search-input").setValue(REPOSITORY).submit();
        $(linkText(REPOSITORY)).click();
        $("#issues-tab").click();
        $(byText(ISSUE_NAME)).should(Condition.visible);
    }
}
