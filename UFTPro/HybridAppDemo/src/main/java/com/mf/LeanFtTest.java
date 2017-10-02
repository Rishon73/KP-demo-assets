package com.mf;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.hp.lft.sdk.*;
import com.hp.lft.sdk.web.*;
import com.hp.lft.verifications.*;

import com.hp.lft.report.ReportException;
import com.hp.lft.report.Reporter;
import com.hp.lft.report.Status;

import unittesting.*;
import com.hp.lft.sdk.mobile.*;


import unittesting.*;

public class LeanFtTest extends UnitTestClassBase {
    private static String APP_VERSION;
    private static String APP_IDENTIFIER;
    private static String currentDevice;
    private static boolean INSTALL_APP;
    private static boolean UNINSTALL_APP;
    private static boolean HIGHLIGHT;
    private static Device device;
    private static boolean noProblem = true;
    private static Application app;
    private static String DEVICE_LOGS_FOLDER;
    private static ApplicationDescription[] appDescription = new ApplicationDescription[1];
    private enum LOG_LEVEL {INFO, ERROR};
    private HybridAppModel appModel;

    @BeforeClass
    public void setUp() throws Exception {
        logMessages("Enter setUp() method ", LOG_LEVEL.INFO);
        APP_VERSION = "18";
        APP_IDENTIFIER = "com.hpeit.mobile.cpxorderstatus";
        DEVICE_LOGS_FOLDER = "";
        INSTALL_APP = true;
        UNINSTALL_APP = false;
        HIGHLIGHT = true;

        try {
            device = initDevice();
            if (device != null) {
                appModel = new HybridAppModel(device);

                appDescription[0] = new ApplicationDescription.Builder().identifier(APP_IDENTIFIER).packaged(true).version(APP_VERSION).build();
                app = device.describe(Application.class, appDescription[0]);
                currentDevice = "\"" + device.getName() + "\" (" + device.getId() + "), Model :" + device.getModel() + ", OS: " + device.getOSType() + " version: " + device.getOSVersion() + ", manufacturer: " + device.getManufacturer();

                logMessages("Allocated device: " + currentDevice + ". App in use: \"" + app.getName() + "\" v" + app.getVersion(), LOG_LEVEL.INFO);

                if (INSTALL_APP) {
                    logMessages("Installing app: " + app.getName(), LOG_LEVEL.INFO);
                    app.install();
                } else {
                    logMessages("Restarting app: " + app.getName(), LOG_LEVEL.INFO);
                    app.restart();
                }
            } else {
                logMessages("Device couldn't be allocated, exiting script", LOG_LEVEL.ERROR);
                noProblem = false;
            }
        } catch (NullPointerException npex) {
            logMessages("NullPointerException in setup(): " + npex.getMessage(), LOG_LEVEL.ERROR);
        } catch (GeneralReplayException grex) {
            if (grex.getErrorCode() == 2036) {
                logMessages("GeneralReplayException in setup(): " + grex.getMessage(), LOG_LEVEL.ERROR);
                noProblem = false;
            }
        } catch (Exception ex) {
            logMessages("Exception in setup(): " + ex.getMessage(), LOG_LEVEL.ERROR);
            noProblem = false;
        }
        logMessages("Exit setUp()", LOG_LEVEL.INFO);
    }

    @AfterClass
    public void afterClass() throws Exception {
    }

    @BeforeMethod
    public void beforeMethod() throws Exception {
    }

    @AfterMethod
    public void afterMethod() throws Exception {
    }

    @Test
    public void test() throws GeneralLeanFtException {
        if (!noProblem) return; // check if we had issues in initializing app and device
        device.describe(Application.class, new ApplicationDescription.Builder()
                .identifier("com.hpeit.mobile.cpxorderstatus")
                .packaged(true).build())
                .describe(WebView.class, new WebViewDescription.Builder()
                        .className("WebView")
                        .mobileCenterIndex(0).build())
                .describe(Page.class, new PageDescription())
                .describe(WebElement.class, new WebElementDescription.Builder()
                        .tagName("svg")
                        .innerText("menu").build()).highlight();

        appModel.CPXOrderStatusApplication().MobileWebView().CPXOrderStatusPage().MenuWebElement().click();

        appModel.CPXOrderStatusApplication().MobileWebView().CPXOrderStatusPage().HomeWebElement().highlight();
        appModel.CPXOrderStatusApplication().MobileWebView().CPXOrderStatusPage().WatchedOrdersWebElement().highlight();
        appModel.CPXOrderStatusApplication().MobileWebView().CPXOrderStatusPage().PreferencesWebElement().highlight();
        appModel.CPXOrderStatusApplication().MobileWebView().CPXOrderStatusPage().ActionsWebElement().highlight();
        appModel.CPXOrderStatusApplication().MobileWebView().CPXOrderStatusPage().NextWebElement().highlight();
        appModel.CPXOrderStatusApplication().MobileWebView().CPXOrderStatusPage().WebElement().highlight();

        appModel.CPXOrderStatusApplication().MobileWebView().CPXOrderStatusPage().MenuWebElement().click();

        windowSync(10000);

    }

    private Device initDevice() throws GeneralLeanFtException {
        try {
            logMessages("Init device capabilities for test...", LOG_LEVEL.INFO);
            DeviceDescription description = new DeviceDescription();
            description.setOsType("Android");
            description.setOsVersion("> 6.0");
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

    private void windowSync(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException err){
            logMessages("[error in windowSync(int duration): " + err.getMessage() + "\nDevice is: " + currentDevice, LOG_LEVEL.ERROR);
        }
    }
}