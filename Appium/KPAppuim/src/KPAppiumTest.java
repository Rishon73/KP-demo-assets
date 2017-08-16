import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.TouchAction;

public class KPAppiumTest {
    private AndroidDriver driver = null;
    private final static String zipCode = "90210";

    @Before
    public void setup() {
        // Global vars for setup
        String MC_PROTOCOL = "http://";
        String MC_SERVER_IP = "dockerserver.aos.com";
        String MC_SERVER_USER = "admin@default.com";
        String MC_SERVER_PASSWORD = "Password1";
        String MC_PORT = ":8094";
        String APP_PACKAGE = "org.kp.m";
        String APP_ACTIVITY = "org.kp.m.activity.SplashActivity";

        try {
            // Set Capabilities instance
            DesiredCapabilities capabilities = new DesiredCapabilities();

            // Set device capabilities
            capabilities.setCapability("platformName", "Android");

            // Application capabilities
            capabilities.setCapability("appPackage", APP_PACKAGE);
            capabilities.setCapability("appActivity", APP_ACTIVITY);

            // Set MC Server credentials (could be skipped if "Anonymous access" is enabled for Appium scripts in the Administration settings).
            capabilities.setCapability("userName", MC_SERVER_USER);
            capabilities.setCapability("password", MC_SERVER_PASSWORD);
            System.out.println("================== " + MC_PROTOCOL + MC_SERVER_IP + MC_PORT + "/wd/hub ==================");

            // Create a session to the MC server
            driver = new AndroidDriver(new URL(MC_PROTOCOL + MC_SERVER_IP + MC_PORT + "/wd/hub"), capabilities);
            System.out.println("MC session was successfully created [Android Device]");

            // Create a wait object instance in order to verify expected conditions.
            WebDriverWait waitController = new WebDriverWait(driver, 60);

            // Create an implicitly wait instance to define the timeout for 'findElement' commands
            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

            System.out.println("=== Android WebDriver object created successfully ===");
        } catch (MalformedURLException e) {
            System.out.println("[ERROR]\n=== Malformed MC server URL ===\n" + e.getMessage() + "\nStack:\n" + e.getSuppressed());
        } catch (Exception e) {
            System.out.println("[ERROR]\n=== Test failed ===\n" + e.getMessage() + "\nStack:\n" + e.getSuppressed());
            e.printStackTrace();
        }
    }

    @Test
    public void TestFindFacility() {
        WebElement element;
        element = driver.findElementById("org.kp.m:id/sign_in_button");
        element.click();

        element = driver.findElementById("android:id/button1");
        element.click();

        System.out.println("Click Find facility button");
        element = driver.findElementById("org.kp.m:id/sign_in_facility_locator");
        element.click();

        System.out.println("Check if 'Allow location...' is there...");
        if (isElementPresent("com.android.packageinstaller:id/permission_allow_button")) {
            element = driver.findElementById("com.android.packageinstaller:id/permission_allow_button");
            element.click();
        }

        System.out.println("Click the 'Close' important message");
        element = driver.findElementById("android:id/button2");
        element.click();

        System.out.println("Click the search icon");
        element = driver.findElementByAccessibilityId("SearchIcon");
        element.click();

        System.out.println("Type the zipcode");
        element = driver.findElementById("org.kp.m:id/search_address_edit_text");
        element.click();
        element.sendKeys(zipCode);

        System.out.println("Tap on the Google Maps 'search' icon");
        TouchAction touchAction=new TouchAction(driver);
        touchAction.press(1121, 1492).waitAction(200).release().perform();
        //touchAction.tap(1150, 1280).perform();

        windowSync(1500);

        System.out.println("Open filters");
        element = driver.findElementByAccessibilityId("Filter");
        element.click();

        System.out.println("Additional Services");
        element = driver.findElementById("org.kp.m:id/checked_row_text_view");
        element.click();

        System.out.println("Click Ok");
        element = driver.findElementById("android:id/button1");
        element.click();

        System.out.println("Display List view");
        element = driver.findElementById("org.kp.m:id/locator_list_button");
        element.click();

        System.out.println("Select a facility");
        element = driver.findElementById("org.kp.m:id/locator_favorites_row_title");
        element.click();

        System.out.println("Check if 'Allow access to contact...' is there...");
        if (isElementPresent("com.android.packageinstaller:id/permission_allow_button")) {
            element = driver.findElementById("com.android.packageinstaller:id/permission_allow_button");
            element.click();
        }

        System.out.println("=== Test completed ===");
    }

    @After
    public void tearDown() {
        // Release lock in all cases
        if (driver != null) {
            System.out.println("MC session closed");
            driver.quit();
        }
    }

    private boolean isElementPresent(String id) {
        try {
            driver.findElementById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private void windowSync(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException err){
            System.out.println("[Error] error in windowSync(int duration): " + err.getMessage());
        }
    }
}
