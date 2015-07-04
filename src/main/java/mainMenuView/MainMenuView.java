package mainMenuView;


import com.sdl.selenium.web.button.*;
import com.sdl.selenium.web.link.WebLink;


public class MainMenuView {
    private static Button preferencesButton = new Button().setText("Preferences");
    public static WebLink logout = new WebLink().setText("Logout");

    public static void logout(){
        logout.assertClick();
    }
}
