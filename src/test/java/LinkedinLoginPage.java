import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LinkedinLoginPage {

    private WebDriver webDriver;

    private WebElement userEmailField;
    private WebElement userPasswordField;
    private WebElement singInButton;

    public LinkedinLoginPage(WebDriver webDriver) {
 this.webDriver=webDriver;
    }

    private void initElements(){
        userEmailField = webDriver.findElement(By.xpath("//input[@id='login-email']"));
        userPasswordField = webDriver.findElement(By.xpath("//input[@id='login-password']"));
        singInButton = webDriver.findElement(By.xpath("//*[@id='login-submit']"));
    }


    public void login (String userEmail, String userPassword){
        initElements();
        userEmailField.sendKeys (userEmail);
        userPasswordField.sendKeys(userPassword);
        singInButton.click();
    }

    public boolean isSingInButtonDisplayed(){
        return singInButton.isDisplayed();
    }
    public String getCurrentPageTitle (){
        return webDriver.getTitle();
    }

}
