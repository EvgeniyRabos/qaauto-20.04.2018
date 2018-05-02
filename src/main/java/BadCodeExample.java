import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.List;
import static java.lang.Thread.sleep;


public class BadCodeExample {

    public static void main(String args[]) throws InterruptedException {

        WebDriver webDriver = new FirefoxDriver();
        webDriver.get("https://www.google.com");

        int searchCounter = 0;

        WebElement searchField = webDriver.findElement(By.name("q"));
        searchField.sendKeys("Selenium");
        searchField.sendKeys(Keys.RETURN);
        sleep(3000);

        List<WebElement> searchresults = webDriver.findElements(By.xpath("//div[@class='srg']/div[@class='g']"));
        for (WebElement searchResult : searchresults) {
                System.out.println(searchResult.getText());
                System.out.println("------------------------------------------------------------------------------------");
                searchCounter++;
        }

        if (searchCounter>=1){
            System.out.println("Search term found in result");
        }

        sleep(1000);
        webDriver.close();
    }

}
