import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.*;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;

public class LMS
{
    WebDriver driver;
    @BeforeTest
    public void beforeTest()
    {
        WebDriverManager.firefoxdriver().setup();

        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @AfterTest
    public void afterTest()
    {
        //driver.quit();
    }

    @Test
    public void activity1()
    {
        //1. Verify the website title
        //Goal: Read the title of the website and verify the text

        driver.get("https://alchemy.hguy.co/lms/");

        String title = driver.getTitle();

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(title,"Alchemy LMS – An LMS Application");

        softAssert.assertAll();
    }


    @Test
    public void activity2()
    {
        //2. Verify the website heading
        //Goal: Read the heading of the website and verify the text

        driver.get("https://alchemy.hguy.co/lms/");

        String title = driver.findElement(By.xpath("//h1[contains(text(),\"Learn\")]")).getText();

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(title.toLowerCase(),"Learn from Industry Experts".toLowerCase());

        softAssert.assertAll();
    }

    @Test
    public void activity3()
    {
        //3. Verify the title of the first info box
        //Goal: Read the title of the first info box on the website and verify the text

        driver.get("https://alchemy.hguy.co/lms/");

        String title = driver.findElement(By.xpath("//h3[contains(text(),\"Actionable\")]")).getText();

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(title.trim().toLowerCase(),"Actionable Training".toLowerCase());

        softAssert.assertAll();
    }

    @Test
    public void activity4()
    {
        //4. Verify the title of the second most popular course
        //Goal: Read the title of the second most popular course on the website and verify the
        //text

        driver.get("https://alchemy.hguy.co/lms/");

        String title = driver.findElement(By.xpath("//h3[contains(text(),\"Email Marketing\")]")).getText();

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(title.trim().toLowerCase(),"Email Marketing Strategies".toLowerCase());

        softAssert.assertAll();
    }

    @Test
    public void activity5()
    {
        //5. Navigate to another page
        //Goal: Navigate to the “My Account” page on the site.

        driver.get("https://alchemy.hguy.co/lms/");

        driver.findElement(By.xpath("//a[contains(text(),\"My Account\")]")).click();

        String title= driver.getTitle();

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(title.trim().toLowerCase(),"My Account – Alchemy LMS".toLowerCase());

        softAssert.assertAll();
    }

    @Test
    public void activity6()
    {
        //6. Logging into the site
        //Goal: Open the website and log-in using the provided credentials.

        driver.get("https://alchemy.hguy.co/lms/");

        driver.findElement(By.xpath("//a[contains(text(),\"My Account\")]")).click();

        String title= driver.getTitle();

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(title.trim().toLowerCase(),"My Account – Alchemy LMS".toLowerCase());

        driver.findElement(By.xpath("//a[@href=\"#login\"]")).click();

        driver.findElement(By.id("user_login")).sendKeys("root");
        driver.findElement(By.id("user_pass")).sendKeys("pa$$w0rd");
        driver.findElement(By.id("wp-submit")).click();

        String userName = driver.findElement(By.xpath("//a[contains(text(),\"Howdy\")]/span")).getText();

        softAssert.assertEquals(userName.trim().toLowerCase(),"root");

        softAssert.assertAll();
    }

    @Test
    public void activity7()
    {
        //7. Count the number of courses
        //Goal: Navigate to the “All Courses” page and count the number of courses.

        driver.get("https://alchemy.hguy.co/lms/");

        driver.findElement(By.xpath("//a[contains(text(),\"All Courses\")]")).click();

        List<WebElement> elements = driver.findElements(By.xpath("//div[contains(@id,\"ld-course-list-content\")]/div/div"));

        System.out.println("Number of courses: " + elements.size());
    }


    @Test
    public void activity8()
    {
        //8. Contact the admin
        //Goal: Navigate to the “Contact Us” page and complete the form.

        driver.get("https://alchemy.hguy.co/lms/");

        driver.findElement(By.xpath("//a[contains(text(),\"Contact\")]")).click();

        driver.findElement(By.id("wpforms-8-field_0")).sendKeys("Test user");
        driver.findElement(By.id("wpforms-8-field_1")).sendKeys("test.user@test.com");
        driver.findElement(By.id("wpforms-8-field_3")).sendKeys("subject");
        driver.findElement(By.id("wpforms-8-field_2")).sendKeys("Message");
        driver.findElement(By.id("wpforms-submit-8")).click();

        String confMessage = driver.findElement(By.id("wpforms-confirmation-8")).getText();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(confMessage,"Thanks for contacting us! We will be in touch with you shortly.");
        softAssert.assertAll();
    }

    @Test
    public void activity9() throws InterruptedException {
        //9. Complete a simple lesson
        //Goal: Navigate to a particular lesson and complete it.

        driver.get("https://alchemy.hguy.co/lms/");

        driver.findElement(By.xpath("//a[contains(text(),\"All Courses\")]")).click();

        driver.findElement(By.xpath("//article[@id=\"post-69\"]/div[2]/p[2]/a")).click();

        driver.findElement(By.id("ld-expand-83")).click();

        //This above click is not working, even manually, says You don't have access to this content.
    }
}
