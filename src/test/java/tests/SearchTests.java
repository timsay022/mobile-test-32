package tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.*;
import static io.qameta.allure.Allure.step;

public class SearchTests extends TestBase {

    @Test
    void successfulSearchTest() {

        step("Поиск статьи об Appium", ()-> {
            $(accessibilityId("Search Wikipedia")).click();
            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Appium");
        });

        step("Записи об статьях найдены", ()-> {
            $$(id("org.wikipedia.alpha:id/page_list_item_title")).shouldHave(sizeGreaterThan(0));
        });
    }

    @Test
    void successfulOpenArticleTest() {

        step("Поиск статьи об Postman", ()-> {
            $(accessibilityId("Search Wikipedia")).click();
            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Postman (software)");
        });

        step("Записи об статьях найдены", ()-> {
            $$(id("org.wikipedia.alpha:id/page_list_item_title")).shouldHave(sizeGreaterThan(0));
        });

        step("Открыть статью с названием Postman (software)", ()-> {
            $$(id("org.wikipedia.alpha:id/page_list_item_title")).first().click();
        });

        step("Проверить название статьи", ()-> {
            $(className("android.widget.TextView")).shouldHave(text("An error occurred"));
        });
    }
}