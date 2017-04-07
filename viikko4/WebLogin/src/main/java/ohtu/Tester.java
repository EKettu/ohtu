package ohtu;

import java.io.File;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public class Tester {

    public static void main(String[] args) {
        File pathBinary = new File("/Applications/firefox-sdk/bin/Firefox.app/Contents/MacOS/firefox");
        FirefoxBinary firefoxBinary = new FirefoxBinary(pathBinary);
        FirefoxProfile firefoxProfile = new FirefoxProfile();
        WebDriver driver = new FirefoxDriver(firefoxBinary, firefoxProfile);
//        WebDriver driver = new ChromeDriver();
//        System.setProperty("webdriver.chrome.driver", "/Applications/chromedriver"); 

        driver.get("http://localhost:4567");

        sleep(2);

        WebElement element = driver.findElement(By.linkText("login"));
        element.click();

        sleep(2);

        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("password"));
        element.sendKeys("akkep");
        element = driver.findElement(By.name("login"));

        sleep(2);
        element.submit();

        sleep(2);

        driver.quit();
//
//        wrongPassword();
//        noSuchUser();
//        createNewUser();
        testLogOut();
    }

    private static void wrongPassword() {

        File pathBinary = new File("/Applications/firefox-sdk/bin/Firefox.app/Contents/MacOS/firefox");
        FirefoxBinary firefoxBinary = new FirefoxBinary(pathBinary);
        FirefoxProfile firefoxProfile = new FirefoxProfile();
        WebDriver driver = new FirefoxDriver(firefoxBinary, firefoxProfile);

        driver.get("http://localhost:4567");

        sleep(2);

        WebElement element = driver.findElement(By.linkText("login"));
        element.click();

        sleep(2);

        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("password"));
        element.sendKeys("akkek");
        element = driver.findElement(By.name("login"));

        sleep(4);

        element.submit();
        sleep(4);

        driver.quit();

    }

    private static void noSuchUser() {
        File pathBinary = new File("/Applications/firefox-sdk/bin/Firefox.app/Contents/MacOS/firefox");
        FirefoxBinary firefoxBinary = new FirefoxBinary(pathBinary);
        FirefoxProfile firefoxProfile = new FirefoxProfile();
        WebDriver driver = new FirefoxDriver(firefoxBinary, firefoxProfile);

        driver.get("http://localhost:4567");

        sleep(2);

        WebElement element = driver.findElement(By.linkText("login"));
        element.click();

        sleep(3);
        element = driver.findElement(By.name("username"));
        element.sendKeys("liisa");
        element = driver.findElement(By.name("password"));
        element.sendKeys("akkep");
        element = driver.findElement(By.name("login"));

        sleep(3);

        element.submit();

        sleep(3);

        driver.quit();
    }

    private static void createNewUser() {
        File pathBinary = new File("/Applications/firefox-sdk/bin/Firefox.app/Contents/MacOS/firefox");
        FirefoxBinary firefoxBinary = new FirefoxBinary(pathBinary);
        FirefoxProfile firefoxProfile = new FirefoxProfile();
        WebDriver driver = new FirefoxDriver(firefoxBinary, firefoxProfile);

        driver.get("http://localhost:4567");

        sleep(2);

        WebElement element = driver.findElement(By.linkText("register new user"));
        element.click();

        sleep(3);
        element = driver.findElement(By.name("username"));
        element.sendKeys("tiina");
        element = driver.findElement(By.name("password"));
        element.sendKeys("kissa");
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys("kissa");
        element = driver.findElement(By.name("signup"));

        sleep(3);

        driver.quit();
    }

    private static void testLogOut() {
        File pathBinary = new File("/Applications/firefox-sdk/bin/Firefox.app/Contents/MacOS/firefox");
        FirefoxBinary firefoxBinary = new FirefoxBinary(pathBinary);
        FirefoxProfile firefoxProfile = new FirefoxProfile();
        WebDriver driver = new FirefoxDriver(firefoxBinary, firefoxProfile);

        driver.get("http://localhost:4567");

        sleep(2);

        WebElement element = driver.findElement(By.linkText("register new user"));
        element.click();

        sleep(3);
        element = driver.findElement(By.name("username"));
        element.sendKeys("maija");
        element = driver.findElement(By.name("password"));
        element.sendKeys("koira");
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys("koira");
        element = driver.findElement(By.name("signup"));

        sleep(2);

        element.submit();

        sleep(3);
        element = driver.findElement(By.linkText("continue to application mainpage"));
        element.click();

        sleep(3);

        element = driver.findElement(By.linkText("logout"));
        element.click();

        sleep(3);

        driver.quit();

    }

    private static void sleep(int n) {
        try {
            Thread.sleep(n * 1000);
        } catch (Exception e) {
        }
    }
}
