package base;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseClass {
    public static WebDriver driver;
    public static Properties prop = new Properties();
    public static Properties locators = new Properties();
    public static FileReader fr;
    public static FileReader fr1;

    @BeforeTest
    public void setUp() throws IOException {
        if (driver==null) {
            // System.out.println("The path is: " + System.getProperty("user.dir"));
            fr = new FileReader(System.getProperty("user.dir") + "\\src\\test\\resources\\configfiles\\config.properties");
            fr1 = new FileReader(System.getProperty("user.dir") + "\\src\\test\\resources\\configfiles\\locators.properties");
            prop.load(fr);
            locators.load(fr1);
        }

        if (prop.getProperty("browser").equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
            driver.get(prop.getProperty("testurl"));
        }
        else if (prop.getProperty("browser").equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
            driver.get(prop.getProperty("testurl"));
        }
        else if (prop.getProperty("browser").equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
            driver.get(prop.getProperty("testurl"));
        }
        else {
            driver = new SafariDriver();
            driver.get(prop.getProperty("testurl"));
        }
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
