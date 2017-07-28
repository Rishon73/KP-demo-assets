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
import unittesting.*;
import java.awt.*;

public class LeanFtTest extends UnitTestClassBase {
    private String appIdentifier;
    private String currentDevice;
    private boolean INSTALL_APP;
    private boolean HIGHLIGHT;
    private Device device;
    private boolean dontStart = false;

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
        appIdentifier = "org.kp.m";
        INSTALL_APP = false;
        HIGHLIGHT = false;

        device = initDevice();
        if (device != null) {
            ApplicationDescription appDescription = new ApplicationDescription.Builder()
                    .identifier(appIdentifier).packaged(false).build();
            Application app = device.describe(Application.class, appDescription);

            currentDevice = "\"" + device.getName() + "\", Model:" + device.getModel() + ", OS=" + device.getOSType() + ", Version=" + device.getOSVersion();

            System.out.println("Device in use is " + currentDevice
                    + "\nApp in use: \"" + app.getName() + "\", v" + app.getVersion() + "\n***************************\n"
            );

            if (INSTALL_APP) {
                app.install();
            } else
                app.restart();

            initApp(device);
        }
        else {
            System.out.println("Device couldn't be allocated, exiting script");
            dontStart = true;
        }
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void test() throws GeneralLeanFtException {
        if (dontStart) return;

        // Tap "Find a Facility" button
        System.out.println("Tap \"Find a Facility\" button");
        if (HIGHLIGHT)
            device.describe(Application.class, new ApplicationDescription.Builder()
                    .identifier(appIdentifier).packaged(false).build()).describe(Label.class, new LabelDescription.Builder()
                    .text("Find a Facility").className("Label").resourceId("org.kp.m:id/sign_in_facility_locator").mobileCenterIndex(8).build()).highlight();
        device.describe(Application.class, new ApplicationDescription.Builder()
                .identifier(appIdentifier).packaged(false).build()).describe(Label.class, new LabelDescription.Builder()
                .text("Find a Facility").className("Label").resourceId("org.kp.m:id/sign_in_facility_locator").mobileCenterIndex(8).build()).tap();

        // Tap "Allow" to device's locations
        System.out.println("Tap \"Allow\" to device's locations");
        if (INSTALL_APP) {
            if (HIGHLIGHT)
                device.describe(Application.class, new ApplicationDescription.Builder()
                        .identifier("com.google.android.packageinstaller").packaged(false).build()).describe(Button.class, new ButtonDescription.Builder()
                        .text("Allow").className("Button").resourceId("com.android.packageinstaller:id/permission_allow_button").mobileCenterIndex(1).build()).highlight();
            device.describe(Application.class, new ApplicationDescription.Builder()
                    .identifier("com.google.android.packageinstaller").packaged(false).build()).describe(Button.class, new ButtonDescription.Builder()
                    .text("Allow").className("Button").resourceId("com.android.packageinstaller:id/permission_allow_button").mobileCenterIndex(1).build()).tap();
        }

        // Tap "Close" the important alert
        System.out.println("Tap \"Close\" the important alert");
        if (HIGHLIGHT)
            device.describe(Application.class, new ApplicationDescription.Builder()
                    .identifier(appIdentifier).packaged(false).build()).describe(Button.class, new ButtonDescription.Builder()
                    .text("Close").className("Button").resourceId("android:id/button2").mobileCenterIndex(0).build()).highlight();
        device.describe(Application.class, new ApplicationDescription.Builder()
                .identifier(appIdentifier).packaged(false).build()).describe(Button.class, new ButtonDescription.Builder()
                .text("Close").className("Button").resourceId("android:id/button2").mobileCenterIndex(0).build()).tap();

        // Tap magnifying glass
        System.out.println("Tap magnifying glass");
        if (HIGHLIGHT)
            device.describe(Application.class, new ApplicationDescription.Builder()
                    .identifier(appIdentifier).packaged(false).build()).describe(Label.class, new LabelDescription.Builder()
                    .accessibilityId("SearchIcon").className("Label").mobileCenterIndex(1).build()).highlight();
        device.describe(Application.class, new ApplicationDescription.Builder()
                .identifier(appIdentifier).packaged(false).build()).describe(Label.class, new LabelDescription.Builder()
                .accessibilityId("SearchIcon").className("Label").mobileCenterIndex(1).build()).tap();

        // Enter Search string
        System.out.println("Enter Search string");
        SearchAppModel appModel = new SearchAppModel(device);
        appModel.KPApplication().SearchAddreEditField().highlight();
        appModel.KPApplication().SearchAddreEditField().setText("94566");

        TapArgs args = new TapArgs();
        Point offset = new Point(1150,1280);
        args.setLocation(new Location(Position.TOP_LEFT, offset));

        System.out.println("Click Search...");
        device.describe(Application.class, new ApplicationDescription.Builder()
                .identifier(appIdentifier).packaged(false).build()).describe(UiObject.class, new UiObjectDescription.Builder()
                        .accessibilityId("Google Map").className("View").mobileCenterIndex(19).build()).tap(args);

        System.out.println("Open filters");
        if (HIGHLIGHT)
            device.describe(Application.class, new ApplicationDescription.Builder()
                    .identifier(appIdentifier).packaged(false).build()).describe(Label.class, new LabelDescription.Builder()
                    .accessibilityId("Filter").className("Label").mobileCenterIndex(0).build()).highlight();
        device.describe(Application.class, new ApplicationDescription.Builder()
                .identifier(appIdentifier).packaged(false).build()).describe(Label.class, new LabelDescription.Builder()
                .accessibilityId("Filter").className("Label").mobileCenterIndex(0).build()).tap();

        System.out.println("select 'Emergency Services'");
        if (HIGHLIGHT)
            device.describe(Application.class, new ApplicationDescription.Builder()
                    .identifier(appIdentifier).packaged(false).build()).describe(Label.class, new LabelDescription.Builder()
                    .text("Emergency Services").className("CheckedLabel").resourceId("org.kp.m:id/checked_row_text_view").mobileCenterIndex(3).build()).highlight();
        device.describe(Application.class, new ApplicationDescription.Builder()
                .identifier(appIdentifier).packaged(false).build()).describe(Label.class, new LabelDescription.Builder()
                .text("Emergency Services").className("CheckedLabel").resourceId("org.kp.m:id/checked_row_text_view").mobileCenterIndex(3).build()).tap();

        System.out.println("Click OK");
        if (HIGHLIGHT)
            device.describe(Application.class, new ApplicationDescription.Builder()
                    .identifier(appIdentifier).packaged(false).build()).describe(Button.class, new ButtonDescription.Builder()
                    .text("OK").className("Button").resourceId("android:id/button1").mobileCenterIndex(1).build()).highlight();
        device.describe(Application.class, new ApplicationDescription.Builder()
                .identifier(appIdentifier).packaged(false).build()).describe(Button.class, new ButtonDescription.Builder()
                .text("OK").className("Button").resourceId("android:id/button1").mobileCenterIndex(1).build()).tap();

        System.out.println("Show list mode");
        if (HIGHLIGHT)
            device.describe(Application.class, new ApplicationDescription.Builder()
                    .identifier(appIdentifier).packaged(false).build()).describe(Toggle.class, new ToggleDescription.Builder()
                    .accessibilityId("List").className("ToggleButton").resourceId("org.kp.m:id/locator_list_button").mobileCenterIndex(1).build()).highlight();
        device.describe(Application.class, new ApplicationDescription.Builder()
                .identifier(appIdentifier).packaged(false).build()).describe(Toggle.class, new ToggleDescription.Builder()
                .accessibilityId("List").className("ToggleButton").resourceId("org.kp.m:id/locator_list_button").mobileCenterIndex(1).build()).tap();

        System.out.println("Select 'Antioch Medical Center' facility");
        if (HIGHLIGHT)
            device.describe(Application.class, new ApplicationDescription.Builder()
                    .identifier(appIdentifier).packaged(false).build()).describe(Label.class, new LabelDescription.Builder()
                    .text("Antioch Medical Center").className("Label").resourceId("org.kp.m:id/locator_favorites_row_title").mobileCenterIndex(12).build()).highlight();
        device.describe(Application.class, new ApplicationDescription.Builder()
                .identifier(appIdentifier).packaged(false).build()).describe(Label.class, new LabelDescription.Builder()
                .text("Antioch Medical Center").className("Label").resourceId("org.kp.m:id/locator_favorites_row_title").mobileCenterIndex(12).build()).tap();

        if (INSTALL_APP) {
            System.out.println("Allow...");
            if (HIGHLIGHT)
                device.describe(Application.class, new ApplicationDescription.Builder()
                        .identifier("com.google.android.packageinstaller").packaged(false).build()).describe(Button.class, new ButtonDescription.Builder()
                        .text("Allow").className("Button").resourceId("com.android.packageinstaller:id/permission_allow_button").mobileCenterIndex(1).build()).highlight();
            device.describe(Application.class, new ApplicationDescription.Builder()
                    .identifier("com.google.android.packageinstaller").packaged(false).build()).describe(Button.class, new ButtonDescription.Builder()
                    .text("Allow").className("Button").resourceId("com.android.packageinstaller:id/permission_allow_button").mobileCenterIndex(1).build()).tap();
        }
    }

    private boolean initApp(Device device) {
        try {
            System.out.println("Init app after install steps...");

            device.describe(Application.class, new ApplicationDescription.Builder()
                    .identifier(appIdentifier).packaged(false).build()).describe(Button.class, new ButtonDescription.Builder()
                    .text("Sign In").className("Button").resourceId("org.kp.m:id/sign_in_button").mobileCenterIndex(0).build()).tap();
            device.describe(Application.class, new ApplicationDescription.Builder()
                    .identifier(appIdentifier).packaged(false).build()).describe(Button.class, new ButtonDescription.Builder()
                    .text("OK").className("Button").resourceId("android:id/button1").mobileCenterIndex(0).build()).tap();

        } catch (GeneralLeanFtException err) {
            System.out.println("[ERR] error in initAppAfterInstall(): " + err.getMessage() + "\nDevice is: " + currentDevice + "\nStack:\n" + err.getStackTrace());
            return false;
        }
        return true;
    }

    private void windowSync(int duration) {
        try {
            Thread.sleep(duration);
        } catch (InterruptedException err){
            System.out.println("[ERR] error in windowSync(int duration): " + err.getMessage() + "\nDevice is: " + currentDevice);
        }
    }

    private Device initDevice() {
        try {
            System.out.println("Init device capabilities for test...");
            DeviceDescription description = new DeviceDescription();
            description.setOsType("Android");
            description.setOsVersion("> 6.0");
            description.setName("Nexus 7");
            //description.setModel("Sony");
            return MobileLab.lockDevice(description);
        } catch (GeneralLeanFtException err) {
            System.out.println("[ERR] failed allocating device: " + err.getMessage());
            return null;
        }
    }
}