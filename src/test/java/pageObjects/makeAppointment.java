package pageObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class makeAppointment extends baseDriverClass {
	public String appointmentconfirm;
	

	public makeAppointment(WebDriver driver2) {
		super(driver2);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//a[@id='btn-make-appointment']")
	WebElement btn_makeappointment;

	@FindBy(xpath = "//select[@id='combo_facility']")
	WebElement cmb_facility;

	@FindBy(xpath = "//input[@id='chk_hospotal_readmission']")
	WebElement chk_readmission;

	@FindBy(xpath = "//input[@id='radio_program_medicaid']")
	WebElement radio_healthcareprogram_medicaid;
	@FindBy(xpath = "//input[@id='radio_program_medicare']")
	WebElement radio_healthcareprogram_medicare;
	@FindBy(xpath = "//input[@id='txt_visit_date']")
	WebElement datepicker_visitdate;

	@FindBy(xpath = "//td[normalize-space()='31']")
	WebElement datepicker_selectfuturedate;
	

	@FindBy(xpath = "//td[normalize-space()='20']")
	WebElement datepicker_selectpastdate;

	

	
	@FindBy(xpath = "//textarea[@id='txt_comment']")
	WebElement txtarea_comment;

	@FindBy(xpath = "//button[@id='btn-book-appointment']")
	WebElement btn_bookappointment;
	

	@FindBy(xpath = "//h2[normalize-space()='Appointment Confirmation']")
	WebElement confirm_appointment;
	
	//h2[normalize-space()='Appointment Confirmation']

	public String  click_makeappointment() {
		btn_makeappointment.click();
		return btn_makeappointment.getText();
		
	}

	public void select_combo_facility(int index) {
		Select drpfacility = new Select(cmb_facility);
		drpfacility.selectByIndex(index);
	}

	public void click_chk_readmission() {
		chk_readmission.click();
	}

	public void click_radio_healthecareprogram_medicaid() {
		radio_healthcareprogram_medicaid.click();
	}
	
	public void click_radio_healthecareprogram_medicare() {
		radio_healthcareprogram_medicare.click();
	}

	public void pick_visitdateFuture() {
		datepicker_visitdate.click();
		datepicker_selectfuturedate.click();

	}

	public void send_comment(String comment) {
		txtarea_comment.sendKeys(comment);

	}

	public void click_bookappointment() {
		btn_bookappointment.click();
	}
	public String confirmappointment() {
		return confirm_appointment.getText();
		
	}
	
	

	

}
