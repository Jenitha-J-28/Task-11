package SeliniumAutomationTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;

public class DragAndDrop {
WebDriver driver;

public void OpenBrowsers() {
	driver = new ChromeDriver();
	//driver = new FirefoxDriver();
	//driver = new SafariDriver();
}
public void OpenWebsite() {
	driver.get("https://jqueryui.com/droppable/");
	driver.manage().window().maximize();
}
public void DargDropActions() {
	driver.switchTo().frame(driver.findElement(By.cssSelector(".demo-frame")));
	WebElement sourceElement = driver.findElement(By.id("draggable"));
	WebElement targetElement = driver.findElement(By.id("droppable"));
	String colourBefore = targetElement.getCssValue("background");
	System.out.println("The background colour of the target element after the drag and drop action is :" +colourBefore);
	Actions action = new Actions(driver);
	action.dragAndDrop(sourceElement, targetElement).build().perform();
	String colourAfter = targetElement.getCssValue("background");
	System.out.println("The background colour of the target element after the drag and drop action is :" +colourAfter);
	if(colourBefore.equalsIgnoreCase(colourAfter)) {
		System.out.println("The background colour not changed, Drag and drop action not done");
	}else {
		System.out.println("The background colour changed, Drag and drop action done");
	}
		
	String text = targetElement.getText();
	System.out.println("The Text of the target element after the drag and drop action is :" +text);
	
}
	public static void main(String[] args) {
		DragAndDrop mouseTest = new DragAndDrop();
		mouseTest.OpenBrowsers();
		mouseTest.OpenWebsite();
		mouseTest.DargDropActions();

	}

}
