import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LinkedinLoginTest {

    @Test
    public void successfulLinkedinLogin() {
        WebDriver webDriver = new FirefoxDriver();
        webDriver.get("https://www.linkedin.com");

        Assert.assertEquals(webDriver.getTitle(), "Expected", "Page title is wrong");

        WebElement userEmailField = webDriver.findElement(By.xpath("//*[@class='login-form']/*[@name='session_key']"));
        WebElement userPasswordField = webDriver.findElement(By.xpath(""));
        WebElement singInButton = webDriver.findElement(By.xpath(""));
    }
}
