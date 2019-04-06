package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import page.AddContact;
import page.HomePage;
import page.LoginPage;
import util.BrowserFactory;

public class AddContactTest {

	@Test
	@Parameters({"Loginemail","password", "name", "nompany", "email", "phone", "address", "city", "state", "zip"})
	public void AddingContact(String Loginemail, String password, String name, String company, String email, String phone, String address, String city, String state, String zip ) {
		
		WebDriver driver = BrowserFactory.startBrowser("chrome", "http://techfios.com/test/billing/?ng=login/");

		LoginPage logintotechfios= PageFactory.initElements(driver, LoginPage.class);	

		logintotechfios.Login(Loginemail, password);
		
		HomePage home= PageFactory.initElements(driver, HomePage.class);
		
		home.NavigateToAddContact();
		
		AddContact contact =PageFactory.initElements(driver, AddContact.class);
		
		contact.FillingUpAddressForm(name, company, email, phone, address, city, state, zip);
		
		driver.close();
		driver.quit();
	}
}
