package pagepackage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class RegisterPage {
	WebDriver driver;

    @FindBy(xpath = "//*[@id=\"customer.firstName\"]")
    WebElement Firstname;

    @FindBy(xpath = "//*[@id=\"customer.lastName\"]")
    WebElement Lastname;

    @FindBy(xpath = "//*[@id=\"customer.address.street\"]")
    WebElement Address;

    @FindBy(xpath = "//*[@id=\"customer.address.city\"]")
    WebElement City;

    @FindBy(xpath = "//*[@id=\"customer.address.state\"]")
    WebElement State;

    @FindBy(xpath = "//*[@id=\"customer.address.zipCode\"]")
    WebElement Zipcode;

    @FindBy(xpath = "//*[@id=\"customer.phoneNumber\"]")
    WebElement Phonenumber;

    @FindBy(xpath = "//*[@id=\"customer.ssn\"]")
    WebElement Ssn;

    @FindBy(xpath = "//*[@id=\"customer.username\"]")
    WebElement Username;

    @FindBy(xpath = "//*[@id=\"customer.password\"]")
    WebElement Password;

    @FindBy(xpath = "//*[@id=\"repeatedPassword\"]")
    WebElement Confirm;

    @FindBy(xpath = "//*[@id=\"customerForm\"]/table/tbody/tr[13]/td[2]/input")
	public
	
    WebElement Register;

    // Constructor
    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Method to set all form values
    public void setValues(String firstName, String lastName, String address, String city, String state, String zipCode,
                          String phoneNumber, String ssn, String username, String password) {
        Firstname.sendKeys(firstName);
        Lastname.sendKeys(lastName);
        Address.sendKeys(address);
        City.sendKeys(city);
        State.sendKeys(state);
        Zipcode.sendKeys(zipCode);
        Phonenumber.sendKeys(phoneNumber);
        Ssn.sendKeys(ssn);
        Username.sendKeys(username);
        Password.sendKeys(password);
        Confirm.sendKeys(password);
    }

    
    public void clickRegister() {
        Actions actions = new Actions(driver);
        actions.moveToElement(Register).click().perform();
    }
}