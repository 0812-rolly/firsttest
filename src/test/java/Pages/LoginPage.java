package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage
{
    public WebDriver driver;
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }

    @FindBy(className = "AuthPopup")
    private WebElement loginBtnFir;

    @FindBy(className = "SignIn__actions")
    private WebElement loginBtnSec;

    @FindBy(name = "login")
    private WebElement loginField;

    @FindBy(name = "pass")
    private WebElement passwdField;

    @FindBy(className = "HeaderUserName")
    private WebElement userMenu;

    @FindBy (className = "UserMenu__menu-item")
    private WebElement myProfile;

    public void inputLogin(String login) {
        loginField.sendKeys(login);
    }

    public void inputPasswd(String passwd) {
        passwdField.sendKeys(passwd);
    }

    public void clickLoginBtnFir()
    {
        loginBtnFir.click();
    }

    public void clickLoginBtnSec()
    {
        loginBtnSec.click();
    }

    public String getUserName() {
        return userMenu.getText();
    }

    public void clickUserMenu()
    {
        userMenu.click();
    }

    public void clickMyProfile()
    {
        myProfile.click();
    }

}
