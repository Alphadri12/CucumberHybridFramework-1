package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utils.CommonUtils;
import Utils.ElementUtils;

public class RegisterPage {
	
	WebDriver driver;
	private ElementUtils elementUtils;
	
	public RegisterPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		elementUtils=new ElementUtils(driver);
	}
	
	@FindBy(id="input-firstname")
	private WebElement firstNameField;
	
	@FindBy(id="input-lastname")
	private WebElement lastNameField;
	
	@FindBy(id="input-email")
	private WebElement emailField;
	
	@FindBy(id="input-telephone")
	private WebElement telephoneField;
	
	@FindBy(id= "input-password")
	private WebElement passwordField;
	
	@FindBy(id= "input-confirm")
	private WebElement confirmPassword;
	
	@FindBy(name= "agree")
	private WebElement privacyPolicyOption;
	
	@FindBy(css= "input[type='submit']")
	private WebElement continueButton;
	
	@FindBy(xpath="//input[@name='newsletter'][@value='1']")
	private WebElement yesNewsLetterOption;
	
	@FindBy(xpath="//div[contains(@class,'alert-danger')]")
	private WebElement warningMessage;
	
	@FindBy(xpath="//input[@name='firstname']/following-sibling::div")
	private WebElement firstNameWarning;
	
	@FindBy(xpath= "//input[@name='lastname']/following-sibling::div")
	private WebElement lastNameWarning;
	
	@FindBy(xpath="//input[@name='email']/following-sibling::div")
	private WebElement emailWarning;
	
	@FindBy(xpath="//input[@name='telephone']/following-sibling::div")
	private WebElement telephoneWarning;
	
	@FindBy(xpath="//input[@name='password']/following-sibling::div")
	private WebElement passwordWarning;
	
	public void enterFirstName(String firstNameText) {
		
		elementUtils.typeTextIntoElement(firstNameField, firstNameText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		
	}
	
	public void enterLastName(String lastNameText) {
		
		elementUtils.typeTextIntoElement(lastNameField, lastNameText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		
	}
	
	public void enterEmailAddress(String emailText) {
		
		elementUtils.typeTextIntoElement(emailField, emailText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		
		
	}
	
	public void enterTelephone(String telephoneText) {
		
		elementUtils.typeTextIntoElement(telephoneField, telephoneText,CommonUtils.EXPLICIT_WAIT_BASIC_TIME );
		
		
	}
	
	public void enterPassword(String passwordText) {
		
		elementUtils.typeTextIntoElement(passwordField, passwordText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		
	}
	
	public void confirmPassword(String passwordText) {
		
		elementUtils.typeTextIntoElement(confirmPassword, passwordText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		
	}
	
	public void selectPrivacyPolicyOption() {
		
		
		elementUtils.clickOnElement(privacyPolicyOption, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public AccountSuccessPage clickOnContinueButton() {
		
		elementUtils.clickOnElement(continueButton, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		
		return new AccountSuccessPage(driver);
	}
	
	public void selectYesNewsLetterOption() {
		
		
		elementUtils.clickOnElement(yesNewsLetterOption, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		
	}
	
	public String getWarningMessageText() {
		
		
		return elementUtils.getTextFromElement(warningMessage, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public String getFirstNameWarning() {
		
		
		return elementUtils.getTextFromElement(firstNameWarning, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public String getLastNameWarning() {
		
		
		return elementUtils.getTextFromElement(lastNameWarning, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public String getEmailWarning() {
		
		
		return elementUtils.getTextFromElement(emailWarning, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public String getTelephoneWarning() {
		
		
		return elementUtils.getTextFromElement(telephoneWarning, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public String getPasswordWarning() {
		
		
		return elementUtils.getTextFromElement(passwordWarning, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}

}
