package pageObjects;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends baseDriverClass {

	public LoginPage(WebDriver driver2) {
		super(driver2);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//input[@id='txt-username']")
	WebElement txt_username;
	@FindBy(xpath = "//input[@id='txt-password']")
	WebElement txt_password;
	@FindBy(xpath = "//button[@id='btn-login']")
	WebElement btn_login;
	@FindBy(xpath = "	//p[@class='lead text-danger']")
	WebElement txt_invalidlogin;
	@FindBy(xpath = "//h2[normalize-space()='Make Appointment']")
	WebElement next_validlogin;
	@FindBy(xpath = "//i[@class='fa fa-bars']")
	WebElement lnk_menu;
	@FindBy(xpath = "//a[normalize-space()='Logout']")
	WebElement lnk_logout;

	@FindBy(xpath = "//a[normalize-space()='Home']")
	WebElement lnk_home;
	@FindBy(xpath = "//*[@id=\"menu-toggle\"]")
	WebElement lnk1_menu;

	public boolean logoutelement_visible() {

		if (lnk_logout.isDisplayed() == true) {

			return true;
		} else {
			return false;

		}
	}

	public void click_home() {
		lnk_home.click();
	}

	public void send_username(String uname) {
		txt_username.sendKeys(uname);
	}

	public void send_pasword(String pw) {
		txt_password.sendKeys(pw);
	}

	public void click_login() {
		btn_login.click();

	}

	public String validlogin() {
		return next_validlogin.getText();
	}

	public String invalidlogin() {
		return txt_invalidlogin.getText();
	}

	public void click_menu() {
		lnk_menu.click();
	}

	public void click_menu1() {
		lnk1_menu.click();
	}

	public void click_logout() {
		lnk_logout.click();
	}
}
