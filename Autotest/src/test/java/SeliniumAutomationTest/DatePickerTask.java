package SeliniumAutomationTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePickerTask {

	String url = "https://jqueryui.com/datepicker/";
	WebDriver driver;

	
	public void launchBrowser() {
		driver = new ChromeDriver();
			}
	public void launchApp() {
		driver.manage().window().maximize();
		driver.get(url);
	}
	public void selectDatePicker() throws InterruptedException {
		driver.switchTo().frame(driver.findElement(By.cssSelector(".demo-frame")));
		WebElement dateField = driver.findElement(By.xpath("//input[@id='datepicker']"));
		dateField.click();
		Thread.sleep(3000);
		driver.findElement(By.id("ui-datepicker-div"));
		driver.findElement(By.xpath("//a[@title='Next']")).click();
		driver.findElement(By.xpath("//a[@data-date='22']")).click();
		String month = driver.findElement(By.cssSelector(".ui-datepicker-month")).getText();
		String year = driver.findElement(By.cssSelector(".ui-datepicker-year")).getText();
		String date = driver.findElement(By.xpath("//a[@data-date='22']")).getText();
		System.out.println("The Selected Date is : " +date+"/"+month+"/"+year );
		driver.close();
		driver.quit();
		}
	public static void main(String[] args) throws InterruptedException {
		DatePickerTask runTest = new DatePickerTask();
		runTest.launchBrowser();
		runTest.launchApp();
		runTest.selectDatePicker();

	}

}
