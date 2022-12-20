package com.nikulin.tests;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class WebSteps {

    @Step("Открываем главную страницу")
    public WebSteps openMainPage(){
        open("https://github.com/");
        return this;
    }

    @Step("Ищем репозиторий {repository}")
    public WebSteps searchForRepository(String repository){
        $(".header-search-input").setValue(repository).submit();
        return this;
    }

    @Step("Переходим в репозиторий {repository}")
    public WebSteps goToRepository(String repository){
        $(linkText(repository)).click();
        return this;
    }

    @Step("Открываем раздел Issues")
    public WebSteps openIssuesTab(){
        $("#issues-tab").click();
        return this;
    }

    @Step("Проверяем наличие Issue с названием {name}")
    public void shouldSeeIssueWithName(String name){
        $(byText(name)).should(Condition.visible);
    }
}
