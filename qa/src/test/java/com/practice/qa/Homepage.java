package com.practice.qa;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Homepage extends Base {

	By getByFirstName = By.id("fd-golf-first-name-getupdates");
	By getByFormTitle = By.className("fd-golf-form-title");
	By getByCloseOverLayicon = By.className("fd-golf-close-btn");

	static Boolean isLoggedin = false;

	@FindAll({
		@FindBy(xpath = "//a[@href='#$getupdates?gnav=footer-shop']") ,
		@FindBy(xpath = "//li[@class='shop']//a[@href='#$getupdates']")
		})
	WebElement getUpdateLink;

	@FindBy(className = "fd-golf-form-container")
	WebElement getUpdateForm;

	@FindBy(className = "fd-golf-form-title")
	WebElement getUpdateFormTitle;

	@FindBy(xpath = "//input[@id='fd-golf-ford-gu-postal-updates']")
	WebElement getPostalMailCheckbox;

	@FindBy(xpath = "//input[@id='fd-golf-ford-gu-email-updates']")
	WebElement getEMailCheckbox;

	@FindBy(name = "firstName")
	WebElement getFirstNamebox;

	@FindBy(id = "fd-golf-last-name-getupdates")
	WebElement getLastNamebox;

	@FindBy(id = "fd-golf-street-address-getupdates")
	WebElement getStreetNamebox;

	@FindBy(id = "fd-golf-city-getupdates")
	WebElement getCityNamebox;

	@FindBy(id = "fd-golf-postal-code-getupdates")
	WebElement getZipbox;

	@FindBy(id = "fd-golf-email-address-getupdates")
	WebElement getEmailBox;

	@FindBy(id = "fd-golf-confirm-email-address-getupdates")
	WebElement getConfirmEmailBox;

	@FindBy(xpath = "//li[.='0-30 days']")
	WebElement getSurveyButton;

	@FindBy(xpath = "//Select[@aria-label='Select Vehicles']")
	WebElement getVehicleDropdown;

	@FindBy(id = "fd-golf-clone-btn")
	WebElement getAddVehicleButton;

	@FindBy(xpath = "//a[.='Submit']")
	WebElement getSubmitButton;

	@FindBy(xpath = "//table/tbody/tr[2]/td[6]")
	WebElement getFirstNameField;

	@FindBy(xpath = "//table/tbody/tr[2]/td[5]")
	WebElement getLastNameField;

	@FindBy(xpath = "//table/tbody/tr[2]/td[10]")
	WebElement getZipField;

	@FindBy(xpath = "//table/tbody/tr[2]/td[12]")
	WebElement getEmailField;

	@FindBy(xpath = "//table/tbody/tr[2]/td[7]")
	WebElement getAddressField;

	@FindBy(xpath = "//table/tbody/tr[2]/td[8]")
	WebElement getCityField;

	@FindBy(xpath = "(//table/tbody/tr[2]/td[2])[2]")
	WebElement getSzbrchr1Field;

	@FindBy(xpath = "//table/tbody/tr[2]/td[42]")
	WebElement getSzQAField;

	@FindBy(xpath = "//table/tbody/tr[2]/td[44]")
	WebElement getSzLangField;

	@FindBy(xpath = "//input[@id='fd-golf-ford-gu-email-updates']")
	WebElement getEmailCheckBox;
	@FindBy(xpath = "//input[@id='fd-golf-ford-gu-postal-updates']")
	WebElement getPostalMailCheckBox;
	@FindBy(xpath = "//span[@class='fd-golf-check-icon']")
	List<WebElement> checkboxes;
	@FindBy(className = "fd-golf-close-btn")
	WebElement getCloseOverlayIcon;
	@FindBy(css = ".fd-golf-gu-thankyou.fd-golf-base-thankyou")
	WebElement getThankYouMessage;
	
	String openWindowHandle;

	String C;

	public Homepage() {
		PageFactory.initElements(driver, this);
	}

	public void verifyHomepageTitle() {
		/*Assert.assertEquals(
				"Ford – New Cars, Trucks, SUVs, Crossovers & Hybrids | Vehicles Built Just for You‎ | Ford.com",
				driver.getTitle());*/
	}

	public void OpenGetUpdateForm() {
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(getUpdateLink));
		getUpdateLink.click();
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(getByFormTitle));

	}

	public void VerifyGetUpdateForm() {
		Assert.assertTrue(getEmailBox.isDisplayed(), "Get Updates Form is not opened");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertTrue(getEmailCheckBox.isSelected());
	}

	public void ClickOnSubmitButton() throws InterruptedException {
		getSubmitButton.click();
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(getThankYouMessage));
		getCloseOverlayIcon.click();
	}

	public void gotoHandRaiserAndLogin() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.open()");
		openWindowHandle = driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();
		for (String currentWindowHandle : handles) {
			if (!currentWindowHandle.equals(openWindowHandle)) {
				driver.switchTo().window(currentWindowHandle);
				driver.get("http://wwwqa.ngptoolsus.dealerconnection.com/manager/debug/testdb.jsp?expert=true");

				if (!isLoggedin) {
					driver.findElement(By.id("DEALER-WSLXloginUserIdInput")).sendKeys("Bchamess");
					driver.findElement(By.id("DEALER-WSLXloginPasswordInput")).sendKeys("Lps304");
					driver.findElement(By.xpath("//input[@value='Login']")).click();
					isLoggedin = true;
					new WebDriverWait(driver, 30).until(
							ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value='Continue']")));
					driver.findElement(By.xpath("//input[@value='Continue']")).click();
					new WebDriverWait(driver, 30).until(
							ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='SUBMITTED']")));
				}
			}
		}
	}

	public void searchSubmittedLead() {
		driver.findElement(By.xpath("//input[@name='SUBMITTED']")).click();

	}

	public void verifyFieldsOnTable(String lName, String zip, String szBrchr1, String szQA, String szLanguage) {
		System.out.println("First name .........." + getFirstNameField.getText());
		Assert.assertEquals(System.getProperty("fName"), getFirstNameField.getText());
		System.out.println("Last name .........." + getLastNameField.getText());
		Assert.assertEquals(lName, getLastNameField.getText());
		System.out.println("Zip .........." + getZipField.getText());
		Assert.assertEquals(zip, getZipField.getText());
		System.out.println("getSzbrchr1 .........." + getSzbrchr1Field.getText());
		Assert.assertTrue(!getSzbrchr1Field.getText().equals(""));
		System.out.println("getSzQA .........." + getSzQAField.getText());
		Assert.assertEquals(szQA, getSzQAField.getText());
		System.out.println("getSzLangField .........." + getSzLangField.getText());
		Assert.assertEquals(szLanguage, getSzLangField.getText());
	}

	public void verifyEmailOnTable(String email) {

		System.out.println("Email .........." + getEmailField.getText());
		Assert.assertEquals(email, getEmailField.getText());

	}

	public void verifyAddressOnTable(String street, String city) {
		System.out.println("Street .........." + getAddressField.getText());
		Assert.assertEquals(street, getAddressField.getText());
		System.out.println("City .........." + getCityField.getText());
		Assert.assertEquals(city, getCityField.getText());

	}

	public void fillBasicDetails(String fName, String lName, String zip) {
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(getByFirstName));
		System.setProperty("fName", fName + Common.generateRandomString());
		System.out.println("------------" + System.getProperty("fName"));
		getFirstNamebox.sendKeys(System.getProperty("fName"));
		getLastNamebox.sendKeys(lName);
		getZipbox.sendKeys(zip);
	}

	public void fillEmailOnGetUpdatesForm(String email) {
		getEmailBox.sendKeys(email);
		getConfirmEmailBox.sendKeys(email);
	}

	public void fillAddressOnGetUpdatesForm(String street, String city) {
		getStreetNamebox.sendKeys(street);
		getCityNamebox.sendKeys(city);
	}

	public void deSelectEmailCheckBox() {
		checkboxes.get(1).click();
		Assert.assertTrue(!getEmailCheckBox.isSelected());
	}

	public void selectPostalCheckBox() {
		checkboxes.get(0).click();

	}

	public void closeTab() {
		if (driver.getWindowHandles().size() > 1) {
			driver.close();
			driver.switchTo().window(openWindowHandle);
			driver.navigate().refresh();
			System.out.println(driver.getCurrentUrl());

		}
	}
}
