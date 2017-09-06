package com.kp;

import com.hp.lft.sdk.internal.common.MessageFieldNames;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import com.hp.lft.sdk.*;
import com.hp.lft.sdk.mobile.*;
import com.hp.lft.report.*;
import unittesting.*;
import java.awt.*;
import java.io.*;
import java.lang.*;

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
    private static KPAppModel appModel;
    private static String DEVICE_LOGS_FOLDER;
    private static ApplicationDescription[] appDescription = new ApplicationDescription[1];
    private enum LOG_LEVEL {INFO, ERROR};
    private static String deviceID = "";
    private static String deviceDescription = "";

    public LeanFtTest() {
        //Change this constructor to private if you supply your own public constructor
    }

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        instance = new LeanFtTest();
        globalSetup(LeanFtTest.class);
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        globalTearDown();
    }

    @Before
    public void setUp() throws Exception {
        deviceID = System.getProperty("deviceID");
        deviceDescription = System.getProperty("deviceDescription");
        APP_VERSION = "41600005";
        APP_IDENTIFIER = "org.kp.m";
        DEVICE_LOGS_FOLDER = "";
        INSTALL_APP = true;
        UNINSTALL_APP = false;
        HIGHLIGHT = true;
        logMessages("Enter setUp()", LOG_LEVEL.INFO);

        try {
            device = initDevice();
            if (device != null) {
                Description desc = device.getDescription();
                appModel = new KPAppModel(device);

                appDescription[0] = new ApplicationDescription.Builder().identifier(APP_IDENTIFIER).packaged(false).version(APP_VERSION).build();
                app = device.describe(Application.class, appDescription[0]);
                currentDevice = "\"" + device.getName() + "\" (" + device.getId() + "), Model :" + device.getModel() + ", OS: " + device.getOSType() + " version: " + device.getOSVersion();

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

    @After
    public void tearDown() throws Exception {
        if (UNINSTALL_APP)
            app.uninstall();
    }

    @Test
    public void test() throws GeneralLeanFtException {
        if (!noProblem) return; // check if we had issues in initializing app and device
        if (!initApp()) return;
        windowSync(3000);
        logMessages("Entering test()", LOG_LEVEL.INFO);

        try {
            // Tap "Find a Facility" button
            logMessages("Tap \"Find a Facility\" button", LOG_LEVEL.INFO);
            if (HIGHLIGHT)
                appModel.KPApplication().FindAFacilityLabel().highlight();
            appModel.KPApplication().FindAFacilityLabel().tap();

            // Tap "Allow" to device's locations
            if (INSTALL_APP) {
                logMessages("Tap \"Allow\" to device's locations", LOG_LEVEL.INFO);
                if (HIGHLIGHT)
                    appModel.PackageInstallerApplication().AllowLocationsButton().highlight();
                appModel.PackageInstallerApplication().AllowLocationsButton().tap();
            }

            // Tap "Close" the important alert
            logMessages("Tap \"Close\" the important alert", LOG_LEVEL.INFO);
            if (HIGHLIGHT)
                appModel.KPApplication().CloseImportantMessageButton().highlight();
            appModel.KPApplication().CloseImportantMessageButton().tap();

            // Tap magnifying glass
            logMessages("Tap magnifying glass", LOG_LEVEL.INFO);
            windowSync(5000);
            if (HIGHLIGHT)
                appModel.KPApplication().SearchIconLabel().highlight();
            appModel.KPApplication().SearchIconLabel().tap();

            logMessages("Type zip code in search field", LOG_LEVEL.INFO);
            appModel.KPApplication().SearchAddressEditField().setText("90210");

            logMessages("Click Search...", LOG_LEVEL.INFO);
            if (device.getId().equals("0a9e0bfe")) { // special case for my Nexus 7
                TapArgs args = new TapArgs();
                args.setLocation(new Location(Position.TOP_LEFT, getTapOffsets()));
                app.describe(UiObject.class, new UiObjectDescription.Builder().accessibilityId("Google Map").className("View").mobileCenterIndex(19).build()).tap(args);
            }
            else {
                if (HIGHLIGHT)
                    appModel.KPApplication().OrgKpMIdCustomedMyLoUiObject().highlight();
                appModel.KPApplication().OrgKpMIdCustomedMyLoUiObject().tap();
            }

            logMessages("Open filters", LOG_LEVEL.INFO);
            if (HIGHLIGHT)
                appModel.KPApplication().FilterLabel().highlight();
            appModel.KPApplication().FilterLabel().tap();

            logMessages("select 'Emergency Services'", LOG_LEVEL.INFO);
            if (HIGHLIGHT)
                appModel.KPApplication().EmergencyServicesLabel().highlight();
            appModel.KPApplication().EmergencyServicesLabel().tap();

            logMessages("Click OK", LOG_LEVEL.INFO);
            if (HIGHLIGHT)
                appModel.KPApplication().FiltersOKButton().highlight();
            appModel.KPApplication().FiltersOKButton().tap();

            logMessages("Show list mode", LOG_LEVEL.INFO);
            if (HIGHLIGHT)
                appModel.KPApplication().ListToggle().highlight();
            appModel.KPApplication().ListToggle().tap();

            logMessages("Select 'Antioch Medical Center' facility", LOG_LEVEL.INFO);
            if (HIGHLIGHT)
                appModel.KPApplication().LosAngelesMedicalCentLabel().highlight();
            appModel.KPApplication().LosAngelesMedicalCentLabel().tap();

            if (INSTALL_APP) {
                logMessages("Allow...", LOG_LEVEL.INFO);
                if (HIGHLIGHT)
                    appModel.PackageInstallerApplication().AllowContactsButton().highlight();
                appModel.PackageInstallerApplication().AllowContactsButton().tap();
            }
            logMessages("\n****** Test Completed Successfully ******\n", LOG_LEVEL.INFO);

        } catch (GeneralReplayException grex) {
            // Err number -110 - device connectivity issues [errors 2036, 2022]
            if (grex.getErrorCode() == -110)
                logMessages("error -110 (device connectivity issues)\n" + grex.getMessage(), LOG_LEVEL.ERROR);
            // Err number '-111' - Object identification issues
            if (grex.getErrorCode() == -111) {
                // Object cannot be found. Verify that this object's properties match an object currently displayed in your application.
                logMessages("error -111 (object identification issue)\n" + grex.getMessage(), LOG_LEVEL.ERROR);
            }
        } catch (Exception ex) {
            logMessages(ex.getMessage(), LOG_LEVEL.ERROR);
            try {
                writeToFile(device.getLogs(), DEVICE_LOGS_FOLDER + "DeviceLog_" + device.getId() + "_" + getTimeStamp("yyyyMMdd_HHmmss") + ".log");
            } catch (Exception exx) {
                logMessages("Failed creating the device log file. " + ex.getMessage(), LOG_LEVEL.ERROR);
            }
        } finally {
            logMessages("Exit test()", LOG_LEVEL.INFO);
        }
    }

    private boolean initApp() {
        try {
            if (!device.getId().equals("0a9e0bfe")) return true;
            logMessages("Enter initApp (Init app after install steps)", LOG_LEVEL.INFO);
            appModel.KPApplication().SignInButton().tap();
            appModel.KPApplication().InvalidLoginOKButton().tap();

        } catch (GeneralLeanFtException err) {
            try {
                logMessages("error in initApp(): " + err.getMessage() + "\nDevice is: " + currentDevice + "\nStack:\n" + err.getStackTrace(), LOG_LEVEL.ERROR);
            } catch (Exception ex) {
                logMessages("error in initApp(): " + ex.getMessage() + "\nDevice is: " + currentDevice + "\nStack:\n" + ex.getStackTrace(), LOG_LEVEL.ERROR);
                return false;
            }
            return false;
        } catch (NullPointerException npEx) {
            logMessages("NullPointerException error in initApp() -> device.getLogs(): " + npEx.getMessage() + "\nDevice is: " + currentDevice + "\nStack:\n" + npEx.getStackTrace(), LOG_LEVEL.ERROR);
            return false;
        }
        logMessages("Exit initApp", LOG_LEVEL.INFO);
        return true;
    }

    private void windowSync(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException err){
            logMessages("[error in windowSync(int duration): " + err.getMessage() + "\nDevice is: " + currentDevice, LOG_LEVEL.ERROR);
        }
    }

    private Device initDevice() throws GeneralLeanFtException {
        Device retDevice = null;
        try {
            logMessages("Init device capabilities", LOG_LEVEL.INFO);
//            if (!deviceID.equals(""))
//                retDevice = MobileLab.lockDeviceById(deviceID);
//            else if (!deviceDescription.equals("")) {
//
//            }
//            else {
                DeviceDescription description = new DeviceDescription();
                description.setOsType("Android");
                //description.setOsVersion("4.4.2");
                //description.setName("Nexus 7");
                //description.setModel("Sony");
                //retDevice =  MobileLab.lockDevice(description);
                retDevice = MobileLab.lockDevice(description, appDescription, DeviceSource.MOBILE_CENTER);
//            }
            //retDevice = MobileLab.lockDevice(description, appDescription, DeviceSource.AMAZON_DEVICE_FARM);
        } catch (GeneralLeanFtException err) {
            logMessages("failed allocating device: " + err.getMessage(), LOG_LEVEL.ERROR);
        } catch (Exception ex) {
            logMessages("General error: " + ex.getMessage(), LOG_LEVEL.ERROR);
        } finally {
            logMessages("Exit initDevice()", LOG_LEVEL.INFO);
        }
        return retDevice;
    }

    private void writeToFile(String text, String fileName) {
        logMessages("In writeToFile() -> File length:" + text.length() + " File name: " + fileName, LOG_LEVEL.INFO);
        PrintWriter writer = null;
        try {
            File logFile = new File(fileName);
            writer = new java.io.PrintWriter(logFile);
            writer.println(text);
        } catch (FileNotFoundException fnfEx) {
            logMessages(fnfEx.getMessage(), LOG_LEVEL.ERROR);
        } finally {
            if (writer != null) writer.close();
        }
    }

    private Point getTapOffsets() throws GeneralLeanFtException {
        Point offsets = new Point(1130, 1260);      // Nexus 7
        if (device.getName().equals("Pixel")) offsets = new Point(946, 1680);   // Pixel // was (966, 1700)
        logMessages("Tapping on coordinates: X=" + offsets.getX() + " Y=" + offsets.getY(), LOG_LEVEL.INFO);
        return offsets;
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

//    private hashMap<String, String> parseDescription(String descriprion) {
//
//    }
}