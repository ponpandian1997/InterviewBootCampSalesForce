package oneDayInterviewProject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VerifyLeadCreation {

	public static void main(String[] args) throws InterruptedException {
		
		
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--disable-notification");
		ChromeDriver driver = new ChromeDriver(opt);
		// Step:1 Launch the browser (Chrome )
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Step3: Enter the Username, Password and click on the Login button.
		
		
	    driver.findElement(By.id("username")).click();
		driver.findElement(By.id("username")).sendKeys("ragunath.testleaf@gmail.com ");
		driver.findElement(By.id("password")).click();
		driver.findElement(By.id("password")).sendKeys("Ganesan@1727" ,Keys.ENTER);
		
		//Step4: Click on the App Launcher toggle button.
		WebElement app = driver.findElement(By.xpath("//div[@class='slds-icon-waffle']"));
		driver.executeScript("arguments[0].click();", app);
		//Step5: Click on the View All link.
		WebElement alllink = driver.findElement(By.xpath("//button[text()='View All']"));
		driver.executeScript("arguments[0].click();", alllink);
		
		//Step6: Type ‘Marketing’ in the search box and click on the Marketing link.
		driver.findElement(By.xpath("//input[@class='slds-input']")).sendKeys("Marketing" );
		driver.findElement(By.xpath("//div[@class='slds-app-launcher__tile-body slds-truncate']")).click();
		
		//Step7: Navigate to the Leads tab from the Marketing dash board
		
		WebElement leads = driver.findElement(By.xpath("//span[text()='Leads']"));
		driver.executeScript("arguments[0].click();", leads);
		
//Step8: Click on the New button to create a lead.
		
		 driver.findElement(By.xpath("//div[text()='New']")).click();
	
		
//Step9: Fill in all the mandatory fields (Salutation, First Name, Last Name, Company) with valid data
		 //setTimeout(function(){debugger;},5000);
		   driver.findElement(By.xpath("(//button[@class='slds-combobox__input slds-input_faux slds-combobox__input-value'])[1]")).click();
		 
		  driver.findElement(By.xpath("//span[text()='Mr.']")).click();
		
		//Enter the last name
		driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys("pandi");
        driver.findElement(By.xpath("//input[@name='Company']")).sendKeys("zoho");
		//selct the value
		 WebElement select = driver.findElement(By.xpath("(//span[text()='Open - Not Contacted'])[6]"));
		 driver.executeScript("arguments[0].click();", select);
		 
//Step10: Click on the Save button
		 driver.findElement(By.xpath("//button[text()='Save']")).click();
		 
//Step11: In the newly created Lead page, locate the dropdown near Submit for Approval button and  click on the Convert link.	
		 WebElement submit = driver.findElement(By.xpath("//button[@class='slds-button slds-button_icon-border-filled']"));
		 driver.executeScript("arguments[0].click();", submit);
		 
		 WebElement convert = driver.findElement(By.xpath("//a[@name='Convert']"));
		 driver.executeScript("arguments[0].click();", convert);
		 
		 
//Step12 : Click on the Opportunity Name input field, clear and enter a new opportunity name
		 
		 driver.findElement(By.xpath("(//span[@class='slds-radio_faux'])[5]")).click();
		 driver.findElement(By.xpath("(//input[@class=' input'])[4]")).clear();
		 driver.findElement(By.xpath("(//input[@class=' input'])[4]")).sendKeys("ponpandi-zoho");
//Step13: Click on the Convert button.		 
		 driver.findElement(By.xpath("//button[@class='slds-button slds-button_brand']")).click();
		 
		 
//Step14: Click on the Go to Leads button.
		 
		 //WebElement goleads = driver.findElement(By.xpath("//button[@class='slds-button slds-button_brand']"));
		 //driver.executeScript("arguments[0].click();", goleads);
		 driver.findElement(By.xpath("//button[text()='Go to Leads']")).click();
		 
//Step15 : Search the verified lead name in the Search box and verify the text ‘No items to display’
		 WebElement elem = driver.findElement(By.xpath("//input[@name='Lead-search-input']"));
		 driver.executeScript("arguments[0].click();", elem);
		 driver.findElement(By.xpath("//input[@name='Lead-search-input']")).sendKeys("ponpandi-zoho",Keys.ENTER);
		System.out.println("\n\nLeads Search Result: "+driver.findElement(By.xpath("//span[text()='No items to display.']")).getText());
			
		 
		 
//Step16: Navigate to the Opportunities tab and search for the opportunity linked with the converted lead
		
		 WebElement opportunities = driver.findElement(By.xpath("//span[text()='Opportunities']"));
		 
		 driver.executeScript("arguments[0].click();", opportunities);
		 
	
		 
////Step17-Search for the newly created opportunity
			WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='slds-input']")));
			driver.findElement(By.xpath("//input[@class='slds-input']")).sendKeys("ponpandi-zoho",Keys.ENTER);	
			WebElement title=driver.findElement(By.xpath("(//a[@title='ponpandi-zoho'])[1]"));
			wait1.until(ExpectedConditions.stalenessOf(title));
					
		 
		    WebElement name = driver.findElement(By.xpath("(//a[@title='ponpandi-zoho'])[1]"));
		    driver.executeScript("arguments[0].click();", name);
		

			String matchtext=driver.findElement(By.xpath("//lightning-formatted-text[@slot='primaryField']")).getText();
			if(matchtext.contains("ponpandi-zoho"))
				System.out.println("\n\nOpportunity is converted successfully");
			else
				System.out.println("Opportunity is not created");
		
		
		
	}	
		

	}


