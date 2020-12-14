package Tests;

import Properties.ConfProperties;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import Pages.LoginPage;

import java.util.concurrent.TimeUnit;

public class FirstTest {

    public static LoginPage loginPage;
    public static WebDriver driver;

    @BeforeClass
    public static void setup() {

        //определение пути до драйвера и его настройка
        System.setProperty("webdriver.chrome.driver", "E:\\Яна\\chromedriver.exe");
        //создание экземпляра драйвера
        WebDriver driver = new ChromeDriver();
        //окно разворачивается на полный экран
        driver.manage().window().maximize();
        //задержка на выполнение теста = 10 сек.
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //получение ссылки на страницу входа из файла настроек
        driver.get(ConfProperties.getProperty("loginpage"));

        loginPage = new LoginPage(driver);
    }

        @Test
        public void loginTest() throws InterruptedException {
            loginPage.clickLoginBtnFir();
            loginPage.inputLogin(ConfProperties.getProperty("login"));
            loginPage.inputPasswd(ConfProperties.getProperty("password"));
            Thread.sleep(10000);
            loginPage.clickLoginBtnSec();
            String user = loginPage.getUserName();
            Assert.assertEquals(ConfProperties.getProperty("name"), user);
        }

    @AfterClass
    public static void tearDown()
    {
        driver.quit();
    }
}