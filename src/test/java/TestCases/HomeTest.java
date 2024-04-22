package TestCases;

import Helpers.JsonReader;
import Pages.HomePage;
import Pages.LoginPage;
import com.google.gson.JsonObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HomeTest extends BaseTest {


    private HomePage correspondencePage;
    private LoginPage loginPage;
    private JsonObject InternalInfo;
    @BeforeClass
    public void init() {

        InternalInfo = new JsonObject();
        JsonReader jsonReader = new JsonReader();
        /*
        read user data form the path of userInfo defined in test.properties file
        userInfo is a json object that now contains the user data in the file userData.json
         */
        InternalInfo = jsonReader.getJsonObject(System.getProperty("path.InternalInfo"));
        //correspondencePage = new CorrespondencePage(webDriver);
    }

    @BeforeClass
    public void login() {
        //open application URL
        webDriver.get(System.getProperty("target.homepage"));
        // initialize an object from login page
        LoginPage loginPage = new LoginPage(webDriver);
        // login with username and password provided from test.properties file
        loginPage.Login(System.getProperty("account.username"), System.getProperty("account.password"));
        // open dashboard page to avoid a bug in the system
        //webDriver.get(System.getProperty("target.homepage"));

    }
//
//    @BeforeClass
//    public void sideBar() {
//        correspondencePage.callmenu();
//    }

    @Test(priority = 1) //done
    public void assertCreateInternalCorrespondenceTest() {
//        String result = correspondencePage.createInternalCorrespondence(InternalInfo.get("attachmentsCount").getAsString(), InternalInfo.get("Footer").getAsString(), InternalInfo.get("InternalName").getAsString(), InternalInfo.get("SignerName").getAsString(), InternalInfo.get("Forward").getAsString(), InternalInfo.get("corType").getAsString());
//        System.out.println("result: " + result);
//        System.out.println("result length: " + result.length());
//        Assert.assertTrue(result.length() > 0);
    }
}
