package herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.sql.Driver;
import java.time.Duration;
import java.util.Scanner;

public class MultiBrowserTesting {

    //declare global variables//
    static String baseUrl = "http://the-internet.herokuapp.com/login";
    static WebDriver driver;
    //main method//
    public static void main(String[] args) {
        //declare scanner for user input value//
        Scanner scanner = new Scanner(System.in);
        System.out.println("please enter browser name : ");
        String browser = scanner.nextLine();
        String useBrowser = browser.toLowerCase();
        scanner.close();
        //try and catch block for exeception//
        try {
            switch (useBrowser) {
                case "chrome":

                    System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
                    driver = new EdgeDriver();
                    break;
                case "edge":
                    System.setProperty("webdriver.msedge.driver", "drivers/msedgedriver.exe");//open in edge//
                    driver = new EdgeDriver();
                default:
                    System.out.println("wrong browser");


            }
            driver.get(baseUrl);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));


            System.out.println("Title of the page : " + driver.getTitle());
            //print the current URL//
            System.out.println(" Current URL : " + driver.getCurrentUrl());
            //print the page source//
            System.out.println("Page source  : " + driver.getPageSource());
            //enter email into the  emailfield //
            WebElement emailField = driver.findElement(By.id("username"));
            emailField.sendKeys("siddhi.munim@gmail.com");
            //enter password to password field//
            WebElement passwordField = driver.findElement(By.id("password"));
            passwordField.sendKeys("123test");
        }catch (Exception e){
            String massage = e.getMessage();

        }
        //close driver//
        driver.quit();



    }



}
