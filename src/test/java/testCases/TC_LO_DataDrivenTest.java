package testCases;

import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import BaseClass.setupClass;
import pageObjects.LoginPage;
import pageObjects.makeAppointment;
import utilititiesClass.excelUtility;

public class TC_LO_DataDrivenTest extends setupClass {
	/*
	 * @BeforeMethod() public void homepage_open() throws InterruptedException {
	 * makeAppointment makeappoint = new makeAppointment(driver);
	 * makeappoint.click_makeappointment(); Thread.sleep(2000); }
	 */

	@Test(dataProvider = "Login",dataProviderClass=utilititiesClass.dataProvider.class)
	public void UserName_Password_dataDrivenTest(String uname, String pw, String result) throws IOException {

		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4000));
			makeAppointment makeappoint = new makeAppointment(driver);
			makeappoint.click_makeappointment();
			// Thread.sleep(2000);

			LoginPage lp = new LoginPage(driver);
			lp.send_username(uname);
			lp.send_pasword(pw);
			lp.click_login();
			Thread.sleep(4000);
			//boolean logoutvalidation = lp.logoutelement_visible();
			if (result.equalsIgnoreCase("valid")) {
				Thread.sleep(4000);
				lp.click_menu();
				//Thread.sleep(4000);
				lp.click_logout();
				Assert.assertTrue(true);

			}

			else if (result.equalsIgnoreCase("invalid")) {
				
				lp.click_menu();
				Thread.sleep(4000);
				lp.click_home();
				Assert.assertTrue(true);

			} else {
				Assert.assertTrue(false);

			}

			/*
			 * String validlogin = lp.validlogin(); if
			 * (validlogin.equals("Make Appointment")) { Thread.sleep(2000);
			 * lp.click_menu(); Thread.sleep(2000); lp.click_logout(); Thread.sleep(2000);
			 * lp.click_login(); Assert.assertTrue(true);
			 * 
			 * }
			 * 
			 * else { Thread.sleep(2000); lp.click_menu(); Thread.sleep(2000);
			 * lp.click_home(); Assert.assertTrue(true); }
			 */

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	/*
	 * @DataProvider(name = "Login")
	 * 
	 * public String[][] getLoginData() throws IOException { String LoginData[][] =
	 * null; try { String path = ".\\testData\\Login_datadriventestnew.xlsx";
	 * 
	 * excelUtility excelutil = new excelUtility(path); int rows =
	 * excelutil.get_totalrows("sheet1"); int cols =
	 * excelutil.get_totalcells("sheet1", 1);
	 * 
	 * System.out.println("total rows--> " + rows);
	 * System.out.println("total cols--> " + cols);
	 * 
	 * LoginData = new String[rows][cols]; for (int i = 1; i <= rows; i++) { for
	 * (int j = 0; j < cols; j++) { LoginData[i - 1][j] =
	 * excelutil.get_cellvalue("sheet1", i, j); } } } catch (Exception e) {
	 * e.printStackTrace(); } System.out.println("login data array" + LoginData);
	 * return LoginData; }
	 */

	public String[][] Logindata;

	@DataProvider(name = "data")

	public String[][] getdata() {

		return new String[][] { { "John Doe", "ThisIsNotAPassword", "valid" },
				{ "John", "ThisIsNotAPassword", "invalid" }, { "John Doe", "ThisIAPassword", "invalid" },
				{ "Johoe", "ThisIsNotAPword", "invalid" } };

	}

}
