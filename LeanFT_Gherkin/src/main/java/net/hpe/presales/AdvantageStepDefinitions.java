package net.hpe.presales;

import java.io.IOException;

import com.hp.lft.report.ReportException;
import com.hp.lft.report.Reporter;
import com.hp.lft.report.Status;
import com.hp.lft.sdk.GeneralLeanFtException;
import com.hp.lft.sdk.GeneralReplayException;
import com.hp.lft.sdk.mobile.*;
import com.hp.lft.sdk.web.*;
import com.hp.lft.verifications.Verify;

import cucumber.api.PendingException;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.en.And;
import net.hpe.AOSModel;
import org.junit.Assert;


/**
 * Created by Administrator on 8/14/2016.
 */
public class AdvantageStepDefinitions
{
    private static String APP_VERSION;
    private static String APP_IDENTIFIER;
    private static String currentDevice;
    private static boolean INSTALL_APP;
    private static boolean HIGHLIGHT;
    private static Device device;
    private static boolean noProblem = true;
    private static Application app;
    private static AOSModel appModel;
    private static ApplicationDescription[] appDescription = new ApplicationDescription[1];

    private enum LOG_LEVEL {INFO, ERROR};

    @Before
    public void beforeScenario(Scenario scenario) throws IOException, GeneralLeanFtException, ReportException, InterruptedException {
        //the following will start a new test node in the report
        String appVersion = System.getProperty("appVersion");
        if (appVersion != null)
            APP_VERSION = System.getProperty("appVersion");

        APP_IDENTIFIER = "com.advantageonlineshopping.advantage";
        INSTALL_APP = true;
        HIGHLIGHT = true;

        appDescription[0] = new ApplicationDescription();
        appDescription[0].setIdentifier(APP_IDENTIFIER);
        appDescription[0].setPackaged(true);
        appDescription[0].setVersion(APP_VERSION);

        try {
            device = initDevice();
            if (device != null) {
                appModel = new AOSModel(device);
                app = device.describe(Application.class, appDescription[0]);
                currentDevice = "\"" + device.getName() + "\" (" + device.getId() + "), Model :" + device.getModel() + ", OS: " + device.getOSType() + " version: " + device.getOSVersion();

                if (INSTALL_APP) {
                    logMessages("Installing app: " + app.getIdentifier() + ", Version: " + APP_VERSION, LOG_LEVEL.INFO);
                    //app.install();
                    app.launch();
                } else {
                    app.restart();
                }

            } else {
                logMessages("======= Device couldn't be allocated, exiting script =======", LOG_LEVEL.ERROR);
                noProblem = false;
                Assert.fail();
            }
        } catch (GeneralReplayException grex) {
            if (grex.getErrorCode() == 2036) {
                logMessages(grex.getMessage(), LOG_LEVEL.ERROR);
                noProblem = false;
            }
        }

        if (!noProblem) return;
        Thread.sleep(3000);
    }

    @After
    public void afterScenario() throws InterruptedException, ReportException, GeneralLeanFtException {

    }

    @Given("^User is viewing the product$")
    public void userIsViewingTheProduct() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
        logMessages("Tap Speakers", LOG_LEVEL.INFO);
        if (HIGHLIGHT) {
            appModel.AOS().SPEAKERS().highlight();
        }
        appModel.AOS().SPEAKERS().tap();

        logMessages("Tap Bose", LOG_LEVEL.INFO);
        if (HIGHLIGHT)
            appModel.AOS().BOSESOUNDLINKBLUETOOTHSPEAKER().highlight();
        appModel.AOS().BOSESOUNDLINKBLUETOOTHSPEAKER().tap();
    }

    @When("^\"([^\"]*)\" is selected$")
    public void isSelected(String arg0) throws Throwable {
        logMessages("Tap to put/add to cart", LOG_LEVEL.INFO);
        if (HIGHLIGHT) {
            appModel.AOS().PUT_IN_CART().highlight();
        }
        appModel.AOS().PUT_IN_CART().tap();
    }

    @Then("^Product should then be seen in the shopping cart.$")
    public void productSeenInCart(){
        int qtyExpected =1;
        int qtyFound = 1;
        Verify.areEqual(qtyExpected,qtyFound);
    }


    private Device initDevice() throws GeneralLeanFtException {
        try {
            logMessages("Init device capabilities for test...", LOG_LEVEL.INFO);
            DeviceDescription description = new DeviceDescription();
            description.setOsType("Android");
            //description.setOsVersion("> 6.0");
            //description.setId("CB5A23UKKM");
            //description.setName("Nexus 7");
            //description.setModel("Sony");
            //return MobileLab.lockDevice(description);
            return MobileLab.lockDevice(description, appDescription, DeviceSource.MOBILE_CENTER);
        } catch (GeneralLeanFtException err) {
            logMessages("failed allocating device: " + err.getMessage(), LOG_LEVEL.ERROR);
            return null;
        } catch (Exception ex) {
            logMessages("General error: " + ex.getMessage(), LOG_LEVEL.ERROR);
            return null;
        }
    }

    private String getTimeStamp(String pattern) {
        return new java.text.SimpleDateFormat(pattern).format(new java.util.Date());
    }

    private void logMessages(String message, LOG_LEVEL level) {
        String prefix = (level == LOG_LEVEL.INFO) ? "[INFO] " : "[ERROR] ";
        Status status = (level == LOG_LEVEL.INFO) ? Status.Passed : Status.Failed;
        System.out.println(prefix + " [" + getTimeStamp("dd/MM/yyyy HH:mm:ss") + "] " + message);
        try {
            Reporter.reportEvent(prefix, message, status);
        } catch (ReportException rex) {
            System.out.println("[ERROR] " + rex.getMessage());
        }
    }
}
