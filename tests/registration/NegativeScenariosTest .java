import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class NegativeScenariosTest {
    WebDriver driver;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://yourwebsite.com/register");
    }

    @Test
    public void testInvalidEmailFormat() {
        driver.findElement(By.name("fullName")).sendKeys("Musa Zahid Warraich");
        driver.findElement(By.name("email")).sendKeys("musazahidwarraich");
        driver.findElement(By.name("password")).sendKeys("ForElite");
        driver.findElement(By.name("confirmPassword")).sendKeys("ForElite");
        driver.findElement(By.name("dob")).sendKeys("1996-06-12");
        driver.findElement(By.name("gender")).sendKeys("Male");
        driver.findElement(By.name("newsletter")).click();
        driver.findElement(By.tagName("button")).click();
        
        WebElement errorMessage = driver.findElement(By.id("emailErrorMessage"));
        Assert.assertTrue(errorMessage.isDisplayed(), "Error message for invalid email format is displayed");
    }

    @Test
    public void testPasswordMismatch() {
        driver.findElement(By.name("fullName")).sendKeys("Musa Zahid Warraich");
        driver.findElement(By.name("email")).sendKeys("musazahidwarraich@gmail.com");
        driver.findElement(By.name("password")).sendKeys("ForElite");
        driver.findElement(By.name("confirmPassword")).sendKeys("ForElite123");
        driver.findElement(By.name("dob")).sendKeys("1996-06-12");
        driver.findElement(By.name("gender")).sendKeys("Male");
        driver.findElement(By.name("newsletter")).click();
        driver.findElement(By.tagName("button")).click();
        
        WebElement errorMessage = driver.findElement(By.id("passwordErrorMessage"));
        Assert.assertTrue(errorMessage.isDisplayed(), "Error message for password mismatch is displayed");
    }

    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
