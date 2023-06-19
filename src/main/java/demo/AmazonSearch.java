package demo;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
//Selenium Imports
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
//Selenium Imports
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
///


public class AmazonSearch {
    ChromeDriver driver;
    public AmazonSearch()
    {
        System.out.println("Constructor: AmazonSearch");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    
    public  void search() throws InterruptedException {
        // Navigate to URL  https://www.google.com/
        driver.get("https://www.google.com");

        // Locate searh field Using Locator "ID" id="APjFqb"
        WebElement searchBox = driver.findElement(By.id("APjFqb"));
            
        // Send keys "amazon" Using Locator "XPath" //*[@id="APjFqb"].sendkeys("amazon")
        searchBox.sendKeys("amazon");

        // click on search button Using submit() "XPath" //*[@id="APjFqb"].submit()
        searchBox.submit();
        Thread.sleep(3000);

        // validate the search result  Using Locator "XPath" //h3[text() = "Amazon.in" or text() = "Amazon.com. Spend less. Smile more."]
        WebElement result = driver.findElement(By.xpath("//h3[text() = 'Amazon.in' or text() = 'Amazon.com. Spend less. Smile more.']"));
        System.out.println("Result displayed: " + result.getText());
        Thread.sleep(2000);
    }


}
