package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseClass;
import net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForField.Read;
import utilities.ReadXLSData;

public class MyFirstTest extends BaseClass {

    @Test(dataProviderClass = ReadXLSData.class, dataProvider = "LoginData")
    public void LoginTest(String username, String password) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.linkText(locators.getProperty("Sign_In"))).click();
        driver.findElement(By.name(locators.getProperty("Email"))).sendKeys(username);
        driver.findElement(By.xpath(locators.getProperty("Next_button"))).click();
        driver.findElement(By.name(locators.getProperty("Password"))).sendKeys(password);
        driver.findElement(By.xpath(locators.getProperty("Login_button"))).click();   
    }

    // @DataProvider(name = "LoginData")
    // public Object[][] testData() {
    //     return new Object[][] {
    //         {"madhavjaintesting@gmail.com", "MyTesting@252401!"}
    //     };
}