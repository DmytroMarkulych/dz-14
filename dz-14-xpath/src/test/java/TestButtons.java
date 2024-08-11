import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class TestButtons {

    WebDriver driver;

    @Before
    public void setup() throws InterruptedException {
        // Initialize the ChromeDriver
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/buttons");
        Thread.sleep(1000);  // Replace with WebDriverWait for better practice
    }

    @Test
    public void clickOnButtonAndCheckMessageAfterClick() throws InterruptedException {

        WebElement button = driver.findElement(By.xpath("//button[text()='Click Me']"));
        button.click();
        Thread.sleep(500);
        WebElement message = driver.findElement(By.id("dynamicClickMessage"));
        assertEquals("You have done a dynamic click", message.getText());
    }
    @After
    public void teardown() {
        // Close the browser after the tests are done
        if (driver != null) {
            driver.quit();
        }
    }
}
