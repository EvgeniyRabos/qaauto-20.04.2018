import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LinkedinLoginTest {

    WebDriver webDriver;

    @BeforeMethod
    public void before() {
        webDriver = new FirefoxDriver();
        webDriver.get("https://www.linkedin.com");
    }

    @AfterMethod
    public void after() {
        webDriver.close();
    }

    @DataProvider
    public Object[][] ValidDataProvider() {
        return new Object[][]{
                {"gethab@rambler.ru", "1q2w3e4r5t6y"},
                //{"gethab@rambler.RU", "1q2w3e4r5t6y"}
        };
    }

        @DataProvider
        public Object[][] NegativeDataProvider() {
            return new Object[][]{
                    { "gethab@rambler", "1q2w3e4r5t6y" },
                    { "gethab@rambler.ru", "1q2w3e4r5t" }
            };

    }

    @Test(dataProvider = "ValidDataProvider")
    public void successfulLoginTest(String userEmail,String userPassword) {
        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(webDriver);
        Assert.assertTrue(linkedinLoginPage.isPageLoaded(),
                "Login page is not loaded");

        linkedinLoginPage.login(userEmail, userPassword);

        LinkedinHomePage linkedinHomePage = new LinkedinHomePage(webDriver);

        Assert.assertEquals(linkedinHomePage.isPageLoaded(),
                "Home page is not loaded");
         
    }

    @Test
    public void verifyLoginWithEmptyUsernameAndPassword() {
        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(webDriver);
        linkedinLoginPage.login("", "");
        Assert.assertTrue(linkedinLoginPage.isPageLoaded(), "Sing In button is missing");
    }

    @Test(dataProvider = "NegativeDataProvider")
     public void verifyLoginWithValidUsernameAndShortPassword(String userEmail, String userPassword) {
        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(webDriver);

        linkedinLoginPage.login(userEmail, userPassword);
        LinkedinLoginSubmitPage linkedinLoginSubmitPage = new LinkedinLoginSubmitPage(webDriver);

        Assert.assertEquals(linkedinLoginSubmitPage.isPageLoaded(),
                "При заполнении формы были допущены ошибки. Проверьте и исправьте отмеченные поля.",
                "Error message text is wrong.");
    }

}

