package org.fasttrackit.workshop.Preferences;

import com.sdl.selenium.web.WebLocator;
import com.sdl.selenium.web.WebLocatorAbstractBuilder;
import com.sdl.selenium.web.button.Button;
import com.sdl.selenium.web.form.TextField;
import com.sdl.selenium.web.utils.Utils;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class PreferencesWindow {

    private WebLocator window = new WebLocator().setId("preferences-win");
    private Button preferencesButton = new Button().setText("Preferences");
    private TextField currentPassword = new TextField().setLabel("Current Password");
    private TextField newPassword = new TextField().setLabel("New Password");
    private TextField confirmPass = new TextField().setLabel("Repeat Password");
    private Button saveButton = new Button(window).setText("Save");
    private Button closeButton = new Button(window).setText("Close");
    private WebLocator statusMessageEl = new WebLocator(window).setClasses("status-msg");

    public static void main(String[] args) {
        PreferencesWindow preferencesWindow = new PreferencesWindow();
        System.out.println(preferencesWindow.window.getPath());
        System.out.println(preferencesWindow.closeButton.getPath());
    }

    public void open() {
        preferencesButton.click();
        Utils.sleep(1000);
    }

    public void typeCurrentPassword(String password) {
        currentPassword.setValue(password);

    }

    public void typeNewPassword(String password) {
        newPassword.setValue(password);
    }

    public void typeConfirmNewPassword(String newPass) {
        confirmPass.setValue(newPass);
    }

    public void save() {
        saveButton.assertClick();
    }

    public void isMessageDisplayed(String expectedMessage) {
        assertThat(statusMessageEl.getHtmlText(), is(expectedMessage));
    }

    public void close() {
        closeButton.assertClick();
        Utils.sleep(1000); //because of fading window
    }
}