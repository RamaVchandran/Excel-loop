package Web_Table.org.forloopexcel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExcelLoop {

	public static void main(String[] args) throws InterruptedException, IOException {

		System.setProperty("webdriver.chrome.driver",
				"D:\\Automate tools\\Training\\org.forloopexcel\\Driver\\chromedriver.exe");
		// create chrome instance
		WebDriver driver = new ChromeDriver();
		driver.get("https://adactin.com/HotelApp/");
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("Ramachandran15");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Rama@1591");
		driver.findElement(By.xpath("//input[@id='login']")).click();
		
//		WebElement pageheader = driver.findElement(By.xpath(
//				"/html/body/blm-root/blm-app-layout/div/div/div/blm-user-management/div/blm-user-views/div/div/div[1]/h3"));
//		String manageuserheader = pageheader.getText();
//		System.out.println(manageuserheader);

		File excol = new File("D:\\Automate tools\\Training\\org.forloopexcel\\TestData\\Adactin.xlsx");
		FileInputStream stream = new FileInputStream(excol);
		Workbook w = new XSSFWorkbook(stream);
		Sheet s = w.getSheet("data");
		 int rowcount=s.getPhysicalNumberOfRows();
	        int colcount=s.getRow(0).getPhysicalNumberOfCells();
		
		
		for (int i = 0; i<=rowcount ; i++) {
			
			for(int j= 0;j<=colcount;i++){
				

			WebElement loc = driver.findElement(By.xpath("//select[@id='location']"));
			loc.sendKeys(s.getRow(i).getCell(j).getStringCellValue());
			
			Thread.sleep(5000);
			WebElement hotel = driver.findElement(By.xpath("//select[@id='hotels']"));
			hotel.sendKeys(s.getRow(i).getCell(j).getStringCellValue());
			

//			WebElement pageheader1 = driver.findElement(By.xpath("//a[text()='Search Hotel']"));
//			String createuserheader = pageheader1.getText();
//			System.out.println(createuserheader);

//			WebElement name = driver.findElement(By.xpath("//input[@formcontrolname='Name']"));
//			name.sendKeys(s.getRow(j).getCell(1).getStringCellValue());
//			String print = name.getText();
//			System.out.println(print);
//			WebElement username = driver.findElement(By.xpath("//input[@formcontrolname='UserName']"));
//			username.sendKeys(s.getRow(j).getCell(2).getStringCellValue());
//
//			WebElement emailid = driver.findElement(By.xpath("//input[@formcontrolname='EmailID']"));
//			emailid.sendKeys(s.getRow(j).getCell(3).getStringCellValue());
//
//			driver.findElement(By.xpath("//button[@class='blm-btn-create']")).click();
//			Thread.sleep(10000);
//
//			if (pageheader1.isDisplayed()) {
//
//				System.out.println("Username or EmailID Already Exists");
//				driver.findElement(By.xpath("//button[@class='blm-btn-cancel']")).click();
//
//			} else {
//
//				System.out.println("continue");
//
//			}

		}
	}
}
}