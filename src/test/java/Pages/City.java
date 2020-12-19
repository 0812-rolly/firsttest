package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class City
{
    public WebDriver driver;
    private WebElement chekCity;

    public City(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(className = "MainHeader__city")
    private  WebElement city;

    @FindBy(className = "address")
    private WebElement address;

    public void clickChangeCity()
    {
        city.click();
    }

    public String getCityName()
    {
        String cityName = city.getText();
        return new String(cityName.getBytes(StandardCharsets.UTF_8));
    }

    public String getAddress()
    {
        return address.getText().split(",")[0];
    }

    public void clickCity(String city_name)
    {
        chekCity = driver.findElement(By.partialLinkText(city_name));
        chekCity.click();
    }
}
