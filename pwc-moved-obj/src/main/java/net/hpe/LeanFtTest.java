package net.hpe;

import static org.junit.Assert.*;

import com.hp.lft.report.Reporter;
import com.hp.lft.report.Status;
import org.junit.*;
import com.hp.lft.sdk.*;
import com.hp.lft.verifications.*;

import unittesting.*;
import net.hpe.AOSModel;
import com.hp.lft.sdk.mobile.*;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;


public class LeanFtTest extends UnitTestClassBase {
    private static String APP_VERSION;
    private static String APP_BUILD;
    private static String APP_IDENTIFIER;
    private static String currentDevice;
    private static boolean INSTALL_APP;
    private static boolean HIGHLIGHT;
    private static Device device;
    private static boolean noProblem =true;
    private static Application kpApp;
    private static AOSModel appModel;
    private static String DEVICE_LOGS_FOLDER;
    private static ApplicationDescription[] appDescription = new ApplicationDescription[1];
    //private static ApplicationDescription appDescription;

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
        if (!(appVersion == null)) {
            APP_VERSION = System.getProperty("appVersion");
        }

        APP_IDENTIFIER = "com.advantageonlineshopping.advantage";
        DEVICE_LOGS_FOLDER = "C:\\Jenkins\\workspace\\MCDeviceLogs\\";
        INSTALL_APP = true;
        HIGHLIGHT = true;

        ApplicationDescription ad = new ApplicationDescription();
        ad.setIdentifier(APP_IDENTIFIER);
        ad.setPackaged(true);
        ad.setVersion(APP_VERSION);
        appDescription[0]=ad;


        try {
            device = initDevice();
            if (device != null) {
                appModel = new AOSModel(device);

                //appDescription = new ApplicationDescription.Builder().identifier(APP_IDENTIFIER).packaged(false).version(APP_VERSION).build();
                currentDevice = "\"" + device.getName() + "\" (" + device.getId() + ")\nModel :" + device.getModel() + ", OS: " + device.getOSType() + ", Version: " + device.getOSVersion();
                System.out.println("=== " + currentDevice + " ===");
                //Application app = device.describe(Application.class, new ApplicationDescription.Builder().identifier(APP_IDENTIFIER).version(APP_VERSION).packaged(true).build());
                Application app = device.describe(Application.class, appDescription[0]);

//                System.out.println("Device in use is " + currentDevice
//                        + "\nApp in use: \"" + app.getName() + "\", v" + app.getVersion() + "\n***************************\n"
//                );

                if (INSTALL_APP) {
                    System.out.println("Installing app: " + app.getIdentifier());
                    System.out.println("Version: " + APP_VERSION);
                    //app.install();
                    app.launch();
                } else {
                    app.restart();
                }

            } else {
                String msg = "======= Device couldn't be allocated, exiting script =======";
                System.out.println(msg);
                noProblem = false;
                System.out.println("flynn");
                Reporter.reportEvent("Error",msg, Status.Failed);
                Assert.fail();
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
    public void test() throws GeneralLeanFtException, InterruptedException {
        if (!noProblem) return;

        Thread.sleep(3000);
        try {
            System.out.println("Tap Speakers");
            if(HIGHLIGHT){
                appModel.AOS().SPEAKERS().highlight();
            }
            appModel.AOS().SPEAKERS().tap();

            System.out.println("Tap Bose");
            if(HIGHLIGHT){
                appModel.AOS().BOSESOUNDLINKBLUETOOTHSPEAKER().highlight();
            }
            appModel.AOS().BOSESOUNDLINKBLUETOOTHSPEAKER().tap();

            System.out.println("Tap to put/add to cart");
            if(HIGHLIGHT){
                appModel.AOS().PUT_IN_CART().highlight();
                appModel.AOS().PUT_IN_CART().highlight();
            }
            appModel.AOS().PUT_IN_CART().tap();

        }catch (GeneralLeanFtException e){
            System.out.println(e.getMessage());
        }
    }

    private Device initDevice() throws GeneralLeanFtException {
        try {
            System.out.println("Init device capabilities for test...");
            DeviceDescription description = new DeviceDescription();
            description.setOsType("Android");
            description.setOsVersion("> 6.0");
            //description.setId("ce12160cf13ad41d05");
            //description.setId("CB5A23UKKM");
            //description.setName("Nexus 7");
            //description.setModel("Sony");
            //return MobileLab.lockDevice(description);
            return MobileLab.lockDevice(description, appDescription, DeviceSource.MOBILE_CENTER);
            //return MobileLab.lockDevice(description, appDescription, DeviceSource.AMAZON_DEVICE_FARM);
            //return MobileLab.lockDeviceById("0a9e0bfe");
        } catch (GeneralLeanFtException err) {
            System.out.println("[Error] failed allocating device: " + err.getMessage());
            return null;
        } catch (Exception ex) {
            System.out.println("[ERROR]: General error: " + ex.getMessage());
            return null;
        }
    }
}