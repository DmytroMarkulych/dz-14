import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class TestForm {

    WebDriver driver;

    @Before
    public void setup() throws InterruptedException {
        // Initialize the ChromeDriver
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/webtables");
        Thread.sleep(500);
    }

    @Test
    public void createDataInForm() throws InterruptedException {
        WebElement buttonAdd = driver.findElement(By.xpath("//*[@id=\"addNewRecordButton\"]"));
        buttonAdd.click();
        Thread.sleep(500);

        WebElement fieldFirstName = driver.findElement(By.xpath("//*[@id=\"firstName\"]"));
        fieldFirstName.sendKeys("Кирило");

        WebElement fieldLastName = driver.findElement(By.xpath("//*[@id=\"lastName\"]"));
        fieldLastName.sendKeys("Буданов");

        WebElement fieldEmail = driver.findElement(By.xpath("//*[@id=\"userEmail\"]"));
        fieldEmail.sendKeys("frogUnger@test.ua");

        WebElement fieldAge = driver.findElement(By.xpath("//*[@id=\"age\"]"));
        fieldAge.sendKeys("33");

        WebElement fieldSalary = driver.findElement(By.xpath("//*[@id=\"salary\"]"));
        fieldSalary.sendKeys("1000");

        WebElement fieldDepartment = driver.findElement(By.xpath("//*[@id=\"department\"]"));
        fieldDepartment.sendKeys("SBU");

        WebElement buttonSubmit = driver.findElement(By.xpath("//*[@id=\"submit\"]"));
        buttonSubmit.click();

        Thread.sleep(500);

        WebElement fieldCreatedFirstName = driver.findElement(By.xpath("//div[contains(text(),'Кирило')]"));
        assertEquals("Кирило", fieldCreatedFirstName.getText());

        WebElement fieldCreatedLastName = driver.findElement(By.xpath("//div[contains(text(),'Буданов')]"));
        assertEquals("Буданов", fieldCreatedLastName.getText());

        WebElement fieldCreatedEmail = driver.findElement(By.xpath("//div[contains(text(),'frogUnger@test.ua')]"));  // Fixed the email verification XPath
        assertEquals("frogUnger@test.ua", fieldCreatedEmail.getText());

        WebElement fieldCreatedAge = driver.findElement(By.xpath("//div[contains(text(),'33')]"));
        assertEquals("33", fieldCreatedAge.getText());

        WebElement fieldCreatedSalary = driver.findElement(By.xpath("//div[contains(text(),'1000')]"));
        assertEquals("10000", fieldCreatedSalary.getText()); //Тут БАГ

        WebElement fieldCreatedDepartment = driver.findElement(By.xpath("//div[contains(text(),'SBU')]"));
        assertEquals("SBU", fieldCreatedDepartment.getText());

        Thread.sleep(500);

        WebElement buttonEdit = driver.findElement(By.xpath("//*[@id=\"edit-record-4\"]"));
        buttonEdit.click();

        Thread.sleep(500);

        WebElement fieldUpdateFirstName = driver.findElement(By.xpath("//*[@id=\"firstName\"]"));
        fieldUpdateFirstName.clear();
        fieldUpdateFirstName.sendKeys("Кирило Update");

        WebElement fieldUpdateLastName = driver.findElement(By.xpath("//*[@id=\"lastName\"]"));
        fieldUpdateLastName.clear();
        fieldUpdateLastName.sendKeys("Буданов Update");

        WebElement fieldUpdateEmail = driver.findElement(By.xpath("//*[@id=\"userEmail\"]"));
        fieldUpdateEmail.clear();
        fieldUpdateEmail.sendKeys("UpdatefrogUnger@test.ua");

        WebElement fieldUpdateAge = driver.findElement(By.xpath("//*[@id=\"age\"]"));
        fieldUpdateAge.clear();
        fieldUpdateAge.sendKeys("30");

        WebElement fieldUpdateSalary = driver.findElement(By.xpath("//*[@id=\"salary\"]"));
        fieldUpdateSalary.clear();
        fieldUpdateSalary.sendKeys("2000");

        WebElement fieldUpdateDepartment = driver.findElement(By.xpath("//*[@id=\"department\"]"));
        fieldUpdateDepartment.clear();
        fieldUpdateDepartment.sendKeys("SBU Update");


        WebElement buttonUpdateSubmit = driver.findElement(By.xpath("//*[@id=\"submit\"]"));
        buttonUpdateSubmit.click();

        Thread.sleep(500);

        WebElement fieldUpdatedFirstName = driver.findElement(By.xpath("//div[contains(text(),'Кирило Update')]"));
        assertEquals("Кирило Update", fieldUpdatedFirstName.getText());

        WebElement fieldUpdatedLastName = driver.findElement(By.xpath("//div[contains(text(),'Буданов Update')]"));
        assertEquals("Буданов Update", fieldUpdatedLastName.getText());

        WebElement fieldUpdatedEmail = driver.findElement(By.xpath("//div[contains(text(),'UpdatefrogUnger@test.ua')]"));  // Fixed the email verification XPath
        assertEquals("UpdatefrogUnger@test.ua", fieldUpdatedEmail.getText());

        WebElement fieldUpdatedAge = driver.findElement(By.xpath("//div[contains(text(),'30')]"));
        assertEquals("30", fieldUpdatedAge.getText());

        WebElement fieldUpdatedSalary = driver.findElement(By.xpath("//div[contains(text(),'2000')]"));
        assertEquals("12000", fieldUpdatedSalary.getText()); //Тут БАГ

        WebElement fieldUpdatedDepartment = driver.findElement(By.xpath("//div[contains(text(),'SBU Update')]"));
        assertEquals("SBU Update", fieldUpdatedDepartment.getText());

        Thread.sleep(500);
    }

    @After
    public void teardown() {
        // Close the browser after the tests are done
        if (driver != null) {
            driver.quit();
        }
    }
}
