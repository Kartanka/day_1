package ru.kartanka.tests_package;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestsAT {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeTest
    public void before() throws NoAlertPresentException, InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 20);
      // Alert Message handling
      driver.get("http://demo.guru99.com/test/delete_customer.php");
   }

    @Test(priority =0)
    public void deleteCust() {
        driver.findElement(By.name("cusid")).sendKeys("53920");
        driver.findElement(By.name("submit")).click();
    }

    @Test(priority =1)
    public void Alert1() {
        wait.until(ExpectedConditions.alertIsPresent());
        // Switching to Alert
        Alert alert = driver.switchTo().alert();

        // Capturing alert message.
        String alertMessage = alert.getText();

        // Displaying alert message
        System.out.println(alertMessage);
        // Accepting alert
        alert.accept();
    }

    @Test(priority =2)
    public void Alert2() {

        wait.until(ExpectedConditions.alertIsPresent());

        // Switching to Alert
        Alert alert2 = driver.switchTo().alert();

        // Capturing alert message.
        String alertMessage2 = driver.switchTo().alert().getText();
        System.out.println(alertMessage2);
    }


   @AfterTest
   public void quitbrowser() {
      driver.quit();
   }
}

