package org.example;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestExample {

        @Test
        public void testSelenium() throws InterruptedException {
            WebDriver driver = new ChromeDriver();
            driver.get("https://www.selenium.dev/selenium/web/web-form.html");

            String title = driver.getTitle();
            assertEquals("Web form", title);

            driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

            WebElement textBox = driver.findElement(By.name("my-text"));
            WebElement passwordBox = driver.findElement(By.name("my-password"));
            WebElement textAreaBox = driver.findElement(By.name("my-textarea"));
            WebElement selectDropdown = driver.findElement(By.name("my-select"));
            Select select = new Select(selectDropdown);

            WebElement submitButton = driver.findElement(By.cssSelector("button"));

            textBox.sendKeys("Sample text in textBox");
            Thread.sleep(3000);
            passwordBox.sendKeys("Sample text in passwordBox");
            Thread.sleep(3000);
            textAreaBox.sendKeys("Sample text in textAreaBox");
            Thread.sleep(3000);
            select.selectByValue("2");
            Thread.sleep(3000);
            submitButton.click();

            Thread.sleep(3000);

            WebElement message = driver.findElement(By.id("message"));
            String value = message.getText();
            assertEquals("Received!", value);

            Thread.sleep(5000);

            driver.quit();
        }
}
