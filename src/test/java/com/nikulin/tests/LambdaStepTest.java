package com.nikulin.tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class LambdaStepTest {

    private static final String REPOSITORY = "SergeyNikulin/github-selenide-tests";
    private static final String ISSUE_NAME = "test_allure";

    @Test
    public void searchIssueLambdaStepTest() {
        step("Открываем главную страницу", () -> open("https://github.com/"));

        step("Ищем репозиторий " + REPOSITORY, () -> $(".header-search-input").setValue(REPOSITORY).submit());

        step("Переходим в репозиторий " + REPOSITORY, () -> $(linkText(REPOSITORY)).click());

        step("Открываем раздел Issues", () -> $("#issues-tab").click());

        step("Проверяем наличие Issue с названием " + ISSUE_NAME, () ->
                $(byText(ISSUE_NAME)).should(Condition.visible));
    }
}
