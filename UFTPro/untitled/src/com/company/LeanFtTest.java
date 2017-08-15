package com.company;

import static org.junit.Assert.*;

import com.hp.lft.sdk.mobile.Application;
import com.hp.lft.sdk.mobile.ApplicationDescription;
import com.hp.lft.sdk.mobile.Device;
import com.hp.lft.sdk.mobile.MobileLab;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import com.hp.lft.sdk.*;
import com.hp.lft.verifications.*;

import unittesting.*;

public class LeanFtTest extends UnitTestClassBase {
    private Device device;
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
        device = initDevice();
        ApplicationDescription appDescription = new ApplicationDescription.Builder()
                .identifier("com.Advantage.aShopping").packaged(false).build();
        Application app = device.describe(Application.class, appDescription);

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void test() throws GeneralLeanFtException {
        kakapoopoo appmodel = new kakapoopoo(device);
        appmodel.AdvantageShoppingApplication().ConnectButton().highlight();
        appmodel.AdvantageShoppingApplication().ConnectButton().tap();
    }

    private Device initDevice() {
        try {
            System.out.println("Init device capabilities for test...");
            //DeviceDescription description = new DeviceDescription();
            //description.setOsType("Android");
            //description.setOsVersion("> 6.0");
            //description.setName("Nexus 7");
            //description.setModel("Sony");
            //return MobileLab.lockDevice(description);
            return MobileLab.lockDeviceById("0a9e0bfe");
        } catch (GeneralLeanFtException err) {
            System.out.println("[Error] failed allocating device: " + err.getMessage());
            return null;
        }
    }


}
