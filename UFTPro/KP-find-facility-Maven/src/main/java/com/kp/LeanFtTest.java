package com.kp;

import com.hp.lft.sdk.mobile.Button;
import com.hp.lft.sdk.mobile.Label;
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
import java.sql.Time;

public class LeanFtTest extends UnitTestClassBase {
    private static String APP_VERSION;
    private static String APP_IDENTIFIER;
    private static String currentDevice;
    private static boolean INSTALL_APP;
    private static boolean HIGHLIGHT;
    private static Device device;
    private static boolean noProblem;
    private static Application app;
    private static KPAppModel appModel;
    private static String DEVICE_LOGS_FOLDER;

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
        APP_VERSION = "41600005";
        APP_IDENTIFIER = "org.kp.m";
        DEVICE_LOGS_FOLDER = "C:\\Jenkins\\workspace\\MCDeviceLogs\\";
        INSTALL_APP = false;
        HIGHLIGHT = true;

        try {
            device = initDevice();
            if (device != null) {
                appModel = new KPAppModel(device);
                ApplicationDescription appDescription = new ApplicationDescription.Builder()
                        .identifier(APP_IDENTIFIER).packaged(false).version(APP_VERSION).build();
                app = device.describe(Application.class, appDescription);

                currentDevice = "\"" + device.getName() + "\" (" + device.getId() + ")\nModel :" + device.getModel() + ", OS: " + device.getOSType() + ", Version: " + device.getOSVersion();

                System.out.println("Device in use is " + currentDevice
                        + "\nApp in use: \"" + app.getName() + "\", v" + app.getVersion() + "\n***************************\n"
                );

                if (INSTALL_APP) {
                    System.out.println("Installing app: " + app.getName());
                    app.install();
                } else
                    app.restart();

            } else {
                System.out.println("Device couldn't be allocated, exiting script");
                noProblem = false;
            }
        } catch (GeneralReplayException grex) {
            if (grex.getErrorCode() == 2036) {
                System.out.println(grex.getMessage());
                noProblem = false;
            }
        }
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void test() throws GeneralLeanFtException {
        if (!initApp()) return;

        try {
            // Tap "Find a Facility" button
            System.out.println("Tap \"Find a Facility\" button");
            if (HIGHLIGHT)
                appModel.KPApplication().FindAFacilityLabel().highlight();
            appModel.KPApplication().FindAFacilityLabel().tap();

            // Tap "Allow" to device's locations
            System.out.println("Tap \"Allow\" to device's locations");
            if (INSTALL_APP) {
                if (HIGHLIGHT)
                    app.describe(Button.class, new ButtonDescription.Builder().text("Allow").className("Button").resourceId("com.android.packageinstaller:id/permission_allow_button").mobileCenterIndex(1).build()).highlight();
                app.describe(Button.class, new ButtonDescription.Builder().text("Allow").className("Button").resourceId("com.android.packageinstaller:id/permission_allow_button").mobileCenterIndex(1).build()).tap();
            }

            // Tap "Close" the important alert
            System.out.println("Tap \"Close\" the important alert");
            if (HIGHLIGHT)
                appModel.KPApplication().CloseButton().highlight();
            appModel.KPApplication().CloseButton().tap();

            // Tap magnifying glass
            System.out.println("Tap magnifying glass");
            if (HIGHLIGHT)
                appModel.KPApplication().SearchIconLabel().highlight();
            appModel.KPApplication().SearchIconLabel().tap();

            appModel.KPApplication().SearchAddressEditField().highlight();
            appModel.KPApplication().SearchAddressEditField().setText("90210");

            System.out.println("Click Search...");
            TapArgs args = new TapArgs();
            Point offset = new Point(1150, 1280);
            args.setLocation(new Location(Position.TOP_LEFT, offset));
            app.describe(UiObject.class, new UiObjectDescription.Builder().accessibilityId("Google Map").className("View").mobileCenterIndex(19).build()).tap(args);

            System.out.println("Open filters");
            if (HIGHLIGHT)
                appModel.KPApplication().FilterLabel().highlight();
            appModel.KPApplication().FilterLabel().tap();

            System.out.println("select 'Emergency Services'");
            if (HIGHLIGHT)
                appModel.KPApplication().EmergencyServicesLabel().highlight();
            appModel.KPApplication().EmergencyServicesLabel().tap();

            System.out.println("Click OK");
            if (HIGHLIGHT)
                appModel.KPApplication().FiltersOKButton().highlight();
            appModel.KPApplication().FiltersOKButton().tap();

            System.out.println("Show list mode");
            if (HIGHLIGHT)
                appModel.KPApplication().ListToggle().highlight();
            appModel.KPApplication().ListToggle().tap();

            System.out.println("Select 'Antioch Medical Center' facility");
            if (HIGHLIGHT)
                appModel.KPApplication().LosAngelesMedicalCentLabel().highlight();
            appModel.KPApplication().LosAngelesMedicalCentLabel().tap();

            if (INSTALL_APP) {
                System.out.println("Allow...");
                if (HIGHLIGHT)
                    app.describe(Button.class, new ButtonDescription.Builder().text("Allow").className("Button").resourceId("com.android.packageinstaller:id/permission_allow_button").mobileCenterIndex(1).build()).highlight();
                app.describe(Button.class, new ButtonDescription.Builder().text("Allow").className("Button").resourceId("com.android.packageinstaller:id/permission_allow_button").mobileCenterIndex(1).build()).tap();
            }
            System.out.println("\n*** Test Completed Successfully ***");

        } catch (GeneralReplayException grex) {
            System.out.println("///Debug: " + grex.getMessage() + "\n*Err number ==" + grex.getErrorCode() + "==///");
            // Err number -110 - device connectivity issues [errors 2036, 2022]
            if (grex.getErrorCode() == -110)
                System.out.println(grex.getMessage());
            // Err number '-111' - Object identification issues
            if (grex.getErrorCode() == -111) {
                //System.out.println("Object cannot be found. Verify that this object's properties match an object currently displayed in your application.");
                System.out.println(grex.getMessage());
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            System.out.println("In test() -> finally statement");
            String timeStamp = new java.text.SimpleDateFormat("yyyyMMdd_HHmmss").format(new java.util.Date());
            writeToFile(device.getLogs(), DEVICE_LOGS_FOLDER + "DeviceLog_" + device.getId() + "_" + timeStamp + ".txt");
        }
    }

    private boolean initApp() {
        try {
            System.out.println("Init app after install steps...");
            appModel.KPApplication().SignInButton().tap();
            appModel.KPApplication().InvalidLoginOKButton().tap();

            //app.describe(Button.class, new ButtonDescription.Builder().text("Sign In").className("Button").resourceId("org.kp.m:id/sign_in_button").mobileCenterIndex(0).build()).tap();
            //app.describe(Button.class, new ButtonDescription.Builder().text("OK").className("Button").resourceId("android:id/button1").mobileCenterIndex(0).build()).tap();

        } catch (GeneralLeanFtException err) {
            try {
                System.out.println("[Error] error in initApp(): " + err.getMessage() + "\nDevice is: " + currentDevice + "\nStack:\n" + err.getStackTrace());
            } catch (Exception ex) {
                System.out.println("[Error] error in initApp() -> device.getLogs(): " + ex.getMessage() + "\nDevice is: " + currentDevice + "\nStack:\n" + ex.getStackTrace());
                return false;
            }
            return false;
        }
        return true;
    }

    private void windowSync(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException err){
            System.out.println("[Error] error in windowSync(int duration): " + err.getMessage() + "\nDevice is: " + currentDevice);
        }
    }

    private Device initDevice() {
        try {
            System.out.println("Init device capabilities for test...");
            DeviceDescription description = new DeviceDescription();
            description.setOsType("Android");
            description.setOsVersion("> 6.0");
            //description.setName("Nexus 7");
            //description.setModel("Sony");
            return MobileLab.lockDevice(description);
            //return MobileLab.lockDeviceById("0a9e0bfe");
        } catch (GeneralLeanFtException err) {
            System.out.println("[Error] failed allocating device: " + err.getMessage());
            return null;
        }
    }

    private void writeToFile(String text, String fileName) {
        System.out.println("test length:" + text.length() + "\nFile name: " + fileName);
        PrintWriter writer = null;
        try {
            File logFile = new File(fileName);
            writer = new java.io.PrintWriter(logFile);
            writer.println(text);
        } catch (FileNotFoundException fnfEx) {
            System.out.println(fnfEx.getMessage());
        } finally {
            if (writer != null) writer.close();
        }
    }
}