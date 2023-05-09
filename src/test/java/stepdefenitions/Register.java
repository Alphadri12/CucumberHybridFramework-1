package stepdefenitions;

import java.util.Map;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Pages.AccountSuccessPage;
import Pages.HomePage;
import Pages.RegisterPage;
import Utils.CommonUtils;
import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class Register {
	WebDriver driver;
	private RegisterPage registerpage;
	private AccountSuccessPage accountsuccesspage;
	private CommonUtils commonUtils;
	
	
	@Given("User navigates to Register Account page")
	public void user_navigates_to_register_account_page() {
		
		driver=DriverFactory.getDriver();
		HomePage homepage=new HomePage(driver);
		homepage.clickOnMyAccount();
		registerpage= homepage.selectRegisterOption();
		
		driver.findElement(By.linkText("Register")).click();
	}

	@When("User enters the details into below  fields")
	public void user_enters_the_details_into_below_fields(DataTable dataTable) {
	    
		Map<String,String>dataMap=dataTable.asMap(String.class,String.class);
		 commonUtils=new CommonUtils();
		
		registerpage.enterFirstName(dataMap.get("firstName"));
		registerpage.enterLastName(dataMap.get("lastName"));
		registerpage.enterEmailAddress(commonUtils.getEmailWithTimeStamp());
		registerpage.enterTelephone(dataMap.get("telephone"));
		registerpage.enterPassword(dataMap.get("password"));
		registerpage.confirmPassword(dataMap.get("password"));
		
	}
	@When("User enters the details into below  fields with duplicate email")
	public void user_enters_the_details_into_below_fields_with_duplicate_email(DataTable dataTable) {
	    
		Map<String,String>dataMap=dataTable.asMap(String.class,String.class);
		
		registerpage.enterFirstName(dataMap.get("firstName"));
		registerpage.enterLastName(dataMap.get("lastName"));
		driver.findElement(By.id("input-email")).sendKeys(dataMap.get("email"));
		registerpage.enterTelephone(dataMap.get("telephone"));
		registerpage.enterPassword(dataMap.get("password"));
		registerpage.confirmPassword(dataMap.get("password"));
	}

	@And("User selects privacy policy")
	public void user_selects_privacy_policy() {
		
		registerpage.selectPrivacyPolicyOption();
	    
	}

	@When("User clicks on continue button")
	public void user_clicks_on_continue_button() {
		
		accountsuccesspage = registerpage.clickOnContinueButton();
	    
	}

	@Then("User account should get created successfully")
	public void user_account_should_get_created_successfully() {
		
	
	
	Assert.assertEquals("Your Account Has Been Created!", accountsuccesspage.getPageHeading());

	    
	}

	@When("User selects Yes for Newsletter")
	public void user_selects_yes_for_newsletter() {
		
		
		
		registerpage.selectYesNewsLetterOption();
	    
	}

	@Then("User account should get a proper warning about duplicate email.")
	public void user_account_should_get_a_proper_warning_about_duplicate_email() {
		
	    Assert.assertTrue(registerpage.getWarningMessageText().contains("Warning: E-Mail Address is already registered!"));
	}

	@When("User dont enter any details into fields")
	public void user_dont_enter_any_details_into_fields() {
		
		registerpage.enterFirstName(" ");
		registerpage.enterLastName(" ");
		driver.findElement(By.id("input-email")).sendKeys(" ");
		registerpage.enterTelephone(" ");
		registerpage.enterPassword(" ");
		registerpage.confirmPassword("");
		
	}


	@Then("User should get proper warning messages for every mandatory field.")
	public void user_should_get_proper_warning_messages_for_every_mandatory_field() {
		
		Assert.assertEquals("Warning: You must agree to the Privacy Policy!", registerpage.getWarningMessageText());
		Assert.assertEquals("First Name must be between 1 and 32 characters!", registerpage.getFirstNameWarning());
		Assert.assertEquals("Last Name must be between 1 and 32 characters!", registerpage.getLastNameWarning());
		Assert.assertEquals("E-Mail Address does not appear to be valid!", registerpage.getEmailWarning());
		Assert.assertEquals("Telephone must be between 3 and 32 characters!",registerpage.getTelephoneWarning());
		Assert.assertEquals("Password must be between 4 and 20 characters!", registerpage.getPasswordWarning());
	}
	
	
}
