import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

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

    @Test
    public void successfulLinkedinLogin() {



        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(webDriver);
        Assert.assertEquals(linkedinLoginPage.getCurrentPageTitle(), "LinkedIn: Войти или зарегистрироваться", "Login page title is wrong");

        linkedinLoginPage.login("gethab@rambler.ru","1q2w3e4r5t6y");
        LinkedinHomePage linkedinHomePagePage = new LinkedinHomePage (webDriver);
        Assert.assertTrue(linkedinHomePagePage.isProfileMenuDisplayed(),
                "Profile menu is not displayed after login");


        //Fixme: use inheritance_
        Assert.assertEquals(linkedinLoginPage.getCurrentPageTitle(), "LinkedIn", "Home page title is wrong");
    }

    @Test
    public void verifyLoginWithEmptyUsernameAndPassword() {
        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(webDriver);
        linkedinLoginPage.login("","");
        Assert.assertTrue(linkedinLoginPage.isSingInButtonDisplayed(),
                "Sing in button is missing");
    }

    @Test
    public void successfulLinkedinPassLogin() {

        Assert.assertEquals(webDriver.getTitle(), "LinkedIn: Войти или зарегистрироваться", "Page title is wrong");

        WebElement userPasswordField = webDriver.findElement(By.xpath("//input[@id='login-password']"));
        WebElement userEmailField = webDriver.findElement(By.xpath("//input[@id='login-email']"));
        WebElement singInButton = webDriver.findElement(By.xpath("//*[@id='login-submit']"));

        userEmailField.sendKeys("gethab@rambler.ru");
        userPasswordField.sendKeys("1q2w3e4r5t6y");
        singInButton.click();

        Assert.assertEquals(webDriver.getTitle(), "LinkedIn", "Page title is wrong");
    }

    @Test
    public void wrongLinkedinPassLoginWr() {

        Assert.assertEquals(webDriver.getTitle(), "LinkedIn: Войти или зарегистрироваться", "Page title is wrong");

        WebElement userEmailField = webDriver.findElement(By.xpath("//input[@id='login-email']"));
        WebElement userPasswordField = webDriver.findElement(By.xpath("//input[@id='login-password']"));
        WebElement singInButton = webDriver.findElement(By.xpath("//*[@id='login-submit']"));

        userEmailField.sendKeys("gethab@rambler");
        userPasswordField.sendKeys("1q2w3e4r5t6y");
        singInButton.click();

        Assert.assertEquals(webDriver.getTitle(), "LinkedIn", "Page title is wrong");
    }

    @Test
    public void WrongLinkedinLoginPassWr() {

        Assert.assertEquals(webDriver.getTitle(), "LinkedIn: Войти или зарегистрироваться", "Page title is wrong");

        WebElement userEmailField = webDriver.findElement(By.xpath("//input[@id='login-email']"));
        WebElement userPasswordField = webDriver.findElement(By.xpath("//input[@id='login-password']"));
        WebElement singInButton = webDriver.findElement(By.xpath("//*[@id='login-submit']"));

        userEmailField.sendKeys("gethab@rambler.ru");
        userPasswordField.sendKeys("1q2w3e4r5t6");
        singInButton.click();

        Assert.assertEquals(webDriver.getTitle(), "LinkedIn", "Page title is wrong");
    }
}

