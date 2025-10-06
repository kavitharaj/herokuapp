package BaseClass;

import java.io.FileInputStream;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.baseDriverClass;
import utilititiesClass.excelUtility;

public class setupClass {

	public WebDriver driver;
	public Actions act;
	public String homepage;
	public String makeappointment;
	public String appointmentconfirm;

	@BeforeClass
	public void setup_method() throws IOException {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6000));
		FileInputStream properyfile = new FileInputStream(
				System.getProperty("user.dir") + "\\testData\\config.properties");
		Properties p = new Properties();
		p.load(properyfile);
		String url = p.getProperty("url");

		driver.get(url);
		driver.manage().window().maximize();
		act = new Actions(driver);

	}


	@AfterClass
	public void closewindow() {
		driver.quit();
	}

	public void windowhandles() {
		Set<String> windowids = driver.getWindowHandles();

		List<String> list_windowids = new ArrayList(windowids);
		homepage = list_windowids.get(0);
		makeappointment = list_windowids.get(1);
		appointmentconfirm = list_windowids.get(2);

	}

}
