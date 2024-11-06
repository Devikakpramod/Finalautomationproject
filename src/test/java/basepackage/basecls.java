package basepackage;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

public class basecls {
    public static WebDriver driver;

    @BeforeTest 
    public void bfrtest() {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
    }

    
    public void takeScreenshot(String fileName) {
        
        File screenshotDir = new File("./screenshots");
        if (!screenshotDir.exists()) {
            screenshotDir.mkdir();
        }

        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);
        File dest = new File("./screenshots/" + fileName + ".png");

        try {
            FileUtils.copyFile(src, dest);
            System.out.println("Screenshot saved successfully to: " + dest.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Error saving screenshot: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
