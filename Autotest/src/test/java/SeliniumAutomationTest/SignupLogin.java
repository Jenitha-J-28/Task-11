package SeliniumAutomationTest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SignupLogin {
WebDriver driver;
String url = "https://www.guvi.in/";

public void OpenBrowser() {
	driver = new ChromeDriver();
	}
public void OpenWebsite() {
	driver.get("https://www.guvi.in/");
	driver.manage().window().maximize();
}
public void SignUpAction() throws InterruptedException {
	driver.findElement(By.xpath("//div[@class='⭐️rwl3jt-0 pr-3']//a[text()='Sign up']")).click();
	driver.findElement(By.xpath("//form[@id='signup-form']//input[@id='name']")).sendKeys("Jenitha Jeyasekaran");
	driver.findElement(By.xpath("//form[@id='signup-form']//input[@id='email']")).sendKeys("jenithaJeyasekaran28@gmail.com");
	driver.findElement(By.xpath("//form[@id='signup-form']//input[@id='password']")).sendKeys("Kevin18*");
	driver.findElement(By.xpath("//form[@id='signup-form']//input[@id='mobileNumber']")).sendKeys("7708888456");
	//Scroll down to click on SignUp button
	WebElement element = driver.findElement(By.id("mobile-sign"));
	Thread.sleep(3000);
	Actions action = new Actions(driver);
	WebElement signupButton = driver.findElement(By.xpath("//form[@id='signup-form']//div[@id='mobile-sign']//a[text()='Sign Up']"));
	JavascriptExecutor  jsExecuter = (JavascriptExecutor) driver;
	jsExecuter.executeScript("arguments[0].scrollIntoView(true);",element);
	//Actions action = new Actions(driver);
	//action.scrollToElement(signupButton).build().perform();
	jsExecuter.executeScript("arguments[0].click();",signupButton);
	String titleafterReg = driver.getTitle();
	System.out.println("The registration successfully completed and the page title is: " +titleafterReg);
	
}
public void LoginAction() throws InterruptedException
{
	driver.get(url);
	driver.findElement(By.id("login-btn")).click();
	driver.findElement(By.xpath("//form[@id='login-form']//input[@id='email']")).sendKeys("jenithaJeyasekaran28@gmail.com");
	driver.findElement(By.xpath("//form[@id='login-form']//input[@id='password']")).sendKeys("Kevin18*");
	//Scroll down
	WebElement elementLogin = driver.findElement(By.id("mobile-sign"));
	Thread.sleep(3000);
	Actions action = new Actions(driver);
	WebElement loginButton = driver.findElement(By.id("mobile-login"));
	JavascriptExecutor  jsExecuter = (JavascriptExecutor) driver;
	jsExecuter.executeScript("arguments[0].scrollIntoView(true);",elementLogin);
	jsExecuter.executeScript("arguments[0].click();",loginButton);
	String titleafterLog = driver.getTitle();
	System.out.println("Successfully loggedin and the page title is: " +titleafterLog);
	driver.close();
	
}
	public static void main(String[] args) throws InterruptedException {
		SignupLogin testSignup = new SignupLogin();
		testSignup.OpenBrowser();
		testSignup.OpenWebsite();
		testSignup.SignUpAction();
		testSignup.LoginAction();

	}

}
