package tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.className;
import static io.appium.java_client.AppiumBy.id;
import static io.qameta.allure.Allure.step;

@DisplayName("Проверка онбординга")
public class OnboardingTests extends TestBase {

    @Test
    @DisplayName("Язык можно добавить на экране онбординга")
    void languageShouldBeAddedOnTheOnboardingScreen() {
        step("Нажать на кнопку \"Add or edit languages\" на экране онбординга", () -> {
            $(id("org.wikipedia.alpha:id/addLanguageButton")).click();
        });
        step("Нажать на кнопку \"Add languages\"", () -> {
            $(id("org.wikipedia.alpha:id/wiki_language_title")).click();
        });
        step("Нажать на Русский язык в списке", () -> {
           $(id("org.wikipedia.alpha:id/languages_list_recycler")).find(byText("Русский"))
                   .click();
        });
        step("Нажать на кнопку назад", () -> {
            $(className("android.widget.ImageButton")).click();
        });
        step("Проверить, что выбранный язык добавлен в список", () -> {
            $(id("org.wikipedia.alpha:id/languagesList")).shouldHave(Condition.text("Русский"));
        });
    }

    @Test
    @DisplayName("Онбординг можно пропустить по кнопке \"Skip\"")
    void onboardingShouldBeSkippedByButton() {
        $(id("org.wikipedia.alpha:id/fragment_onboarding_skip_button")).shouldBe(Condition.visible);
        $(id("org.wikipedia.alpha:id/fragment_onboarding_skip_button")).click();
        $(id("org.wikipedia.alpha:id/main_toolbar_wordmark")).shouldBe(Condition.visible);
    }
}
