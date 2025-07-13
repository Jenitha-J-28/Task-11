package SeliniumAutomationTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowsTest {
WebDriver driver;
String Url = "https://the-internet.herokuapp.com/windows",parentWindow, childWindow, text, currentUrl,title;

public void launchBrowser() {
	driver = new ChromeDriver();
	driver.manage().window().maximize();
}
public void launchApp() {
	driver.get(Url);
	parentWindow = driver.getWindowHandle();
}
public void testWindow() throws InterruptedException {
	String newUrl = driver.findElement(By.xpath("//div[@id='content']//a[contains(text(),'Click Here')]")).getAttribute("href");;
	driver.switchTo().newWindow(WindowType.WINDOW);
	driver.get(newUrl);
	childWindow = driver.getWindowHandle();
	text = driver.findElement(By.xpath("//div[@class ='example']/h3")).getText();
	System.out.println("The Text in the new window is : " + text);

	}
public void switchWindow(String window) {
	driver.switchTo().window(window);
	title = driver.getTitle();
	System.out.println(title);
	currentUrl = driver.getCurrentUrl();
	System.out.println(currentUrl);
}
public void closeWindow() {
	driver.close();
	}
	public static void main(String[] args) throws InterruptedException {
		WindowsTest switchWindowTest = new WindowsTest();
		switchWindowTest.launchBrowser();
		switchWindowTest.launchApp();
		switchWindowTest.testWindow();
		switchWindowTest.closeWindow();
		switchWindowTest.switchWindow(switchWindowTest.parentWindow);
		switchWindowTest.closeWindow();

	}

}
