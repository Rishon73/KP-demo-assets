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
    private enum LOG_LEVEL {INFO, ERROR};
    private static boolean noProblem = true;

    @Before
    public void setup() {
        // Global vars for setup
        //String MC_SERVER = "http://demo.mobilecenter.io:8080";    // RnD MC lab
        String MC_SERVER = "http://hpmc2.globalepps.com:8080";      // PS MC lab
        String MC_SERVER_USER = "sshiff@hpe.com";
        String MC_SERVER_PASSWORD = "";
        String APP_PACKAGE = "org.kp.m";
        String APP_ACTIVITY = "org.kp.m.activity.SplashActivity";

        try {
            // Set Capabilities instance
            DesiredCapabilities capabilities = new DesiredCapabilities();

            // Set device capabilities
            capabilities.setCapability("platformName", "Android");
            capabilities.setCapability("deviceName", "Nexus 7");
            //capabilities.setCapability("platformVersion", "7.1.2");

            // Application capabilities
            capabilities.setCapability("appPackage", APP_PACKAGE);
            capabilities.setCapability("appActivity", APP_ACTIVITY);

            // Set MC Server credentials (could be skipped if "Anonymous access" is enabled for Appium scripts in the Administration settings).
            capabilities.setCapability("userName", MC_SERVER_USER);
            capabilities.setCapability("password", MC_SERVER_PASSWORD);
            logMessages("================== " + MC_SERVER + "/wd/hub ==================", LOG_LEVEL.INFO);

            // Create a session to the MC server
            driver = new AndroidDriver(new URL(MC_SERVER + "/wd/hub"), capabilities);
            logMessages("MC session was successfully created [Android Device]", LOG_LEVEL.INFO);

            // Create a wait object instance in order to verify expected conditions.
            WebDriverWait waitController = new WebDriverWait(driver, 60);

            // Create an implicitly wait instance to define the timeout for 'findElement' commands
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

            logMessages("=== Android WebDriver object created successfully ===", LOG_LEVEL.INFO);
        } catch (MalformedURLException e) {
            logMessages("=== Malformed MC server URL ===\n" + e.getMessage(), LOG_LEVEL.ERROR);
            noProblem = false;
        } catch (org.openqa.selenium.WebDriverException wde) {
            logMessages("=== Test failed: WebDriverException ===\n" + wde.getMessage(), LOG_LEVEL.ERROR);
            wde.printStackTrace();
            noProblem = false;
        }
    }

    @Test
    public void TestFindFacility() {
        if (!noProblem) return;
        try {
            logMessages("Device in use: " + driver.getCapabilities().getCapability("deviceName").toString() +
                    ", version: " + driver.getCapabilities().getCapability("platformVersion").toString(), LOG_LEVEL.INFO);
            WebElement element;
            element = driver.findElementById("org.kp.m:id/sign_in_button");
            element.click();

            element = driver.findElementById("android:id/button1");
            element.click();

            logMessages("Click Find facility button", LOG_LEVEL.INFO);
            element = driver.findElementById("org.kp.m:id/sign_in_facility_locator");
            element.click();

            logMessages("Check if 'Allow location...' is there...", LOG_LEVEL.INFO);
            if (isElementPresent("com.android.packageinstaller:id/permission_allow_button")) {
                element = driver.findElementById("com.android.packageinstaller:id/permission_allow_button");
                element.click();
            }

            logMessages("Click the 'Close' important message", LOG_LEVEL.INFO);
            element = driver.findElementById("android:id/button2");
            element.click();

            logMessages("Click the search icon", LOG_LEVEL.INFO);
            element = driver.findElementByAccessibilityId("SearchIcon");
            element.click();

            logMessages("Type the zipcode", LOG_LEVEL.INFO);
            element = driver.findElementById("org.kp.m:id/search_address_edit_text");
            element.click();
            element.sendKeys(zipCode);

            if (driver.getCapabilities().getCapability("deviceName").toString().equals("0a9e0bfe")) {
                logMessages("Tap on the Google Maps 'search' icon", LOG_LEVEL.INFO);
                TouchAction touchAction=new TouchAction(driver);
                touchAction.press(1121, 1492).waitAction(200).release().perform();
                //touchAction.tap(1150, 1280).perform();
            }
            else {
                logMessages("Find the 'search' button", LOG_LEVEL.INFO);
                element = driver.findElementById("org.kp.m:id/customedMyLocationButton");
                logMessages("Click the 'search' button", LOG_LEVEL.INFO);
                element.click();
            }

            windowSync(1500);

            logMessages("Open filters", LOG_LEVEL.INFO);
            element = driver.findElementByAccessibilityId("Filter");
            element.click();

            logMessages("Additional Services", LOG_LEVEL.INFO);
            element = driver.findElementById("org.kp.m:id/checked_row_text_view");
            element.click();

            logMessages("Click Ok", LOG_LEVEL.INFO);
            element = driver.findElementById("android:id/button1");
            element.click();

            logMessages("Display List view", LOG_LEVEL.INFO);
            element = driver.findElementById("org.kp.m:id/locator_list_button");
            element.click();

            logMessages("Select a facility", LOG_LEVEL.INFO);
            element = driver.findElementById("org.kp.m:id/locator_favorites_row_title");
            element.click();

            logMessages("Check if 'Allow access to contact...' is there...", LOG_LEVEL.INFO);
            if (isElementPresent("com.android.packageinstaller:id/permission_allow_button")) {
                element = driver.findElementById("com.android.packageinstaller:id/permission_allow_button");
                element.click();
            }
            logMessages("================== Test completed ==================", LOG_LEVEL.INFO);
        } catch (Exception ex) {
            logMessages("error in script. " + ex.getMessage(), LOG_LEVEL.ERROR);
        }
    }

    @After
    public void tearDown() {
        // Release lock in all cases
        if (driver != null) {
            logMessages("MC session closed", LOG_LEVEL.INFO);
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
            logMessages("Error in windowSync(int duration): " + err.getMessage(), LOG_LEVEL.ERROR);
        }
    }

    private String getTimeStamp(String pattern) {
        return new java.text.SimpleDateFormat(pattern).format(new java.util.Date());
    }

    private void logMessages(String message, LOG_LEVEL level) {
        String prefix = (level==LOG_LEVEL.INFO) ? "[INFO] " : "[ERROR] ";
        System.out.println(prefix + " [" + getTimeStamp("dd/MM/yyyy HH:mm:ss") + "] " + message);
    }
}
