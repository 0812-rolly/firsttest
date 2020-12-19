package Tests;

import Pages.LoginPage;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import Properties.ConfProperties;
import Pages.City;
import java.util.concurrent.TimeUnit;

public class SecondTest {
    public static LoginPage loginPage;
    public static City city;
    public static WebDriver driver;

    @BeforeClass
    public static void setup()
    {
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        city = new City(driver);
        //окно разворачивается на полный экран
        driver.manage().window().maximize();
        //задержка на выполнение теста = 10 сек.
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfProperties.getProperty("loginpage"));
    }

    @Test
    public void SecondTest() throws InterruptedException
    {
        city.clickChangeCity();
        city.clickCity(ConfProperties.getProperty("city"));
        String c = city.getCityName();
        Assert.assertEquals(ConfProperties.getProperty("city"), c);

        loginPage.clickLoginBtnFir();

        loginPage.inputLogin(ConfProperties.getProperty("login"));
        loginPage.inputPasswd(ConfProperties.getProperty("password"));

        Thread.sleep(5000);

        loginPage.clickLoginBtnSec();
        loginPage.clickUserMenu();
        loginPage.clickMyProfile();

        String cityInAddress = city.getAddress();
        Assert.assertEquals(c, cityInAddress);
    }

    @AfterClass
    public static void ExitDriver()
    {
        driver.quit();
    }
}
