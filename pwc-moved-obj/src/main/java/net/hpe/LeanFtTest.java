package net.hpe;

import com.hp.lft.report.ReportException;
import com.hp.lft.report.Reporter;
import com.hp.lft.report.Status;
import org.junit.*;
import com.hp.lft.sdk.*;

import unittesting.*;
import com.hp.lft.sdk.mobile.*;



public class LeanFtTest extends UnitTestClassBase {
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
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void test() throws GeneralLeanFtException, InterruptedException {
        if (!noProblem) return;

        Thread.sleep(3000);
        try {
            logMessages("Tap Speakers", LOG_LEVEL.INFO);
            if (HIGHLIGHT) {
                //appModel.AOS().SPEAKERS().highlight();
                device.describe(Application.class, new ApplicationDescription.Builder()
                        .identifier("com.advantageonlineshopping.advantage")
                        .packaged(false).build())
                        .describe(Label.class, new LabelDescription.Builder()
                                .className("Label")
                                .resourceId("com.advantageonlineshopping.advantage:id/textViewCategory")
                                .text("SPEAKERS").build()).highlight();
            }
            appModel.AOS().SPEAKERS().tap();

            logMessages("Tap Bose", LOG_LEVEL.INFO);
            if (HIGHLIGHT)
                appModel.AOS().BOSESOUNDLINKBLUETOOTHSPEAKER().highlight();
            appModel.AOS().BOSESOUNDLINKBLUETOOTHSPEAKER().tap();

            logMessages("Tap to put/add to cart", LOG_LEVEL.INFO);
            if (HIGHLIGHT) {
                appModel.AOS().PUT_IN_CART().highlight();
                appModel.AOS().PUT_IN_CART().highlight();
            }
            appModel.AOS().PUT_IN_CART().tap();

        } catch (GeneralLeanFtException e) {
            logMessages(e.getMessage(), LOG_LEVEL.ERROR);
        }
    }

    private Device initDevice() throws GeneralLeanFtException {
        try {
            logMessages("Init device capabilities for test...", LOG_LEVEL.INFO);
            DeviceDescription description = new DeviceDescription();
            description.setOsType("Android");
            //description.setOsVersion("> 6.0");
            //description.setId("CB5A23UKKM");
            description.setName("Nexus 7");
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