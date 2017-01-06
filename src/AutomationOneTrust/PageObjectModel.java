package AutomationOneTrust;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import PageObjects.Home_Page;
import org.openqa.selenium.interactions.Actions;

/**
 * Created by ksong on 1/5/2017.
 * 1.enter the careers page
 *2.Print the name of each city and all current open positions
 *3.upload to GitHub and send me link.
 */
public class PageObjectModel {

    //private static WebDriver driver = null;
    public static void main(String[] args) {

        System.out.println("*******************");
        System.out.println("Browser Type: launching chrome browser.");

        //launch chrome driver and disable developer mode
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\Chrome driver\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--test-type");
        WebDriver driver = new ChromeDriver(options);

        //maximize chrome browser
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Navigate to onetrust.com
        System.out.println("TC1: Navigate to one Trust site.");
        driver.get("https://onetrust.com/");

        //use pageobjects
        Actions action = new Actions(driver);

        System.out.println("TC2: Hover over Company link");
        action.moveToElement(Home_Page.company(driver)).build().perform();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        System.out.println("TC3: click Careers link\n");
        Home_Page.career(driver).click();

        //Prints all cities
        List<WebElement> listcities = Home_Page.cities(driver);
        for (WebElement city: listcities){

            String cities = city.getText();
            System.out.println("Available cities: \n" + cities +"\n");
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        }

        //Prints all the jobs
        driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
        List<WebElement> atljobs = driver.findElements(By.xpath("//*[@id=\"atlanta\"]/div"));
        for (WebElement jobs : atljobs){
            System.out.println("Available jobs: \n" + jobs.getText()+"\n");
        }

        //close browser window
        driver.close();
    }

}
