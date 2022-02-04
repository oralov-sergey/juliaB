package pageObject;

import core.CommonActions;
import core.TestBase;
import io.qameta.allure.Step;

public class AccountPage extends TestBase {
    CommonActions commonActions = new CommonActions();

    public final String CURRENT_PASSWORD_FIELD = "//input[@id='old_password']";
    public final String NEW_PASSWORD_FIELD = "//input[@id='new_password']";
    public final String CONFIRM_NEW_PASSWORD_FIELD = "//input[@id='new_password_confirmation']";
    public final String CHANGE_PASSWORD_BUTTON = "//li[@id='change_password']";
    public final String APPLY_CHANGE_PASSWORD_BUTTON = "//div[contains(@class,'ButtonLegacy')]";
    public final String EXIT_BUTTON = "//a[@class='mh-subtle svelte-11h1c9']";
    public final String PROFILE_FOR_EXIT_BUTTON = "//div[@class='mh-profile-title svelte-kdyqkb']";

    public final String NEW_PASSWORD = "123456789";

    @Step("Change password for Spotify account")
    public AccountPage changePassword(String currentPassword, String newPassword) {
        commonActions.clickButton(CHANGE_PASSWORD_BUTTON)
                .enterData(CURRENT_PASSWORD_FIELD, currentPassword)
                .enterData(NEW_PASSWORD_FIELD, newPassword)
                .enterData(CONFIRM_NEW_PASSWORD_FIELD, newPassword)
                .clickButton(APPLY_CHANGE_PASSWORD_BUTTON);
        return this;
    }

    @Step("Exit Spotify account")
    public AccountPage exit() {
        commonActions.clickButton(PROFILE_FOR_EXIT_BUTTON)
                .clickButton(EXIT_BUTTON);
        return this;
    }


}
