package tests;

import com.codeborne.selenide.Condition;
import data.TestData;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.className;
import static io.appium.java_client.AppiumBy.id;
import static io.qameta.allure.Allure.step;

@Epic("Онбординг")
@Story("Прохождение онбординга")
@Feature("Онбординг")
@DisplayName("Проверка онбординга")
public class OnboardingTests extends TestBase {
    @Owner("rybinaa")
    @Severity(SeverityLevel.NORMAL)
    @Test
    @DisplayName("Язык можно добавить на экране онбординга")
    void languageShouldBeAddedOnTheOnboardingScreen() {
        TestData testData = new TestData();

        step("Нажать на кнопку \"Add or edit languages\" на экране онбординга", () -> {
            $(id("org.wikipedia.alpha:id/addLanguageButton")).click();
        });
        step("Нажать на кнопку \"Add languages\"", () -> {
            $$(id("org.wikipedia.alpha:id/wiki_language_title")).findBy(text("Add language")).click();
        });
        step("Нажать на " + testData.language.getName() + " язык в списке", () -> {
            $$(id("org.wikipedia.alpha:id/localized_language_name"))
                    .findBy(text(testData.language.getName())).click();
        });
        step("Нажать на кнопку назад", () -> {
            $(className("android.widget.ImageButton")).click();
        });
        step("Проверить, что выбранный язык добавлен в список", () -> {
            $$(id("org.wikipedia.alpha:id/option_label"))
                    .get(1).shouldHave(text(testData.language.getName()));
        });
        step("Пропустить онбординг", () -> {
            $(id("org.wikipedia.alpha:id/fragment_onboarding_skip_button")).click();
        });
        step("Открыть настройки языка", () -> {
            $(id("org.wikipedia.alpha:id/nav_tab_more")).click();
            $(id("org.wikipedia.alpha:id/main_drawer_settings_container")).click();
            $$(id("android:id/title")).findBy(text("Wikipedia languages")).click();
        });
        step("Проверить, что выбранный язык добавлен в настройках", () -> {
            $$(id("org.wikipedia.alpha:id/langCodeText"))
                    .findBy(text(testData.language.getCode()))
                    .should(exist);
        });
    }

    @Owner("rybinaa")
    @Severity(SeverityLevel.MINOR)
    @Test
    @DisplayName("Онбординг можно пропустить по кнопке \"Skip\"")
    void onboardingShouldBeSkippedByButton() {
        step("Нажать на кнопку \"Skip\"", () -> {
            $(id("org.wikipedia.alpha:id/fragment_onboarding_skip_button")).shouldBe(Condition.visible);
            $(id("org.wikipedia.alpha:id/fragment_onboarding_skip_button")).click();
        });
        step("Проверить, что отображен заголовок на главной странице", () -> {
            $(id("org.wikipedia.alpha:id/main_toolbar_wordmark")).shouldBe(Condition.visible);
        });
    }
}
