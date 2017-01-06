package AutomationOneTrust;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import PageObjects.Home_Page;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
package AutomationOneTrust;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import PageObjects.Home_Page;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

        System.out.println("TC3: click Careers link\n");
        Home_Page.career(driver).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Prints all cities
        List<WebElement> Lists = driver.findElements(By.xpath("/html/body/section[2]/div/div/ul"));

        for (int j=0;j<Lists.size();j++){
            String thisCity = Lists.get(j).getText();
            //driver.findElement(By.linkText(thisCity)).click();
            System.out.println("Available cities: \n" + thisCity +"\n");

        }

        //loop thru all cities and prints all current opennings.
        for (WebElement cities: Lists) {

            //--debug section--
            //String city = "ATLANTA";
            //String city = "SAN FRANCISCO";
            //String city = "TORONTO";
            //get the object and put into a string array.
            String citys = cities.getText();
            String[] parts = citys.split("\n");

            //loop thru each city
            for (String objCity : parts) {

                System.out.println("City: \n" + objCity + "\n");
                driver.findElement(By.linkText(objCity)).click();
                myjobs(driver, objCity);
            }

        }
        //close browser window
        driver.close();
    }


    public static void myjobs(WebDriver driver,String city){

        if(city.equals("SAN FRANCISCO")){
            city = "san-francisco";
            String thisCity = city;
        }else{
            String thisCity = city.toLowerCase();
        }
        String thisCity = city.toLowerCase();
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\""+ thisCity + "\"]/div")));

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        List<WebElement> all_jobs = driver.findElements(By.xpath("/html/body/section[2]/div/div/div[2]"));
        for (WebElement jobs : all_jobs){
            System.out.println("Available jobs: \n" + jobs.getText()+"\n");
        }
    }

}


