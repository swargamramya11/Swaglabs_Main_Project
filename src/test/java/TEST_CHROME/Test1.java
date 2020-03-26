package TEST_CHROME;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import BASE_CLASSES.EXCEL;
import BASE_CLASSES.LAUNCHBROWSER;
import PAGES.About_page;
import PAGES.Add_to_cart_page;
import PAGES.Login_page;
import PAGES.clicked_link_page;

public class Test1 extends EXCEL{
	WebDriver dr;
	Login_page L;
	Add_to_cart_page A;
	About_page A1;
	clicked_link_page c;
	EXCEL e=new EXCEL();
@BeforeMethod
public void launchBrowser()
 {
	 dr=LAUNCHBROWSER.launchbrowser("chrome","https://www.saucedemo.com/");
	 dr.manage().window().maximize();
	 
 }
//To check valid login
@Test(dataProvider="login1")
public void swaglabs(String Username,String Password) 
	{L=new Login_page(dr);
	 
		L.login_functions(Username,Password);
	}
//To check add to cart operation is performed or not
@Test(dataProvider="login2")
public void swaglabs2(String Username,String Password) 
	{L=new Login_page(dr);
	 A=new Add_to_cart_page(dr);
	 
		L.login_functions(Username,Password);
		A.functions();
	}
//To check if after clicking any link in about page the page is navigated to corressponding page or not
@Test(dataProvider="login5")
public void swaglabs5(String Username,String Password) 
	{L=new Login_page(dr);
	 A=new Add_to_cart_page(dr);
	 A1=new About_page(dr);
	 c=new clicked_link_page(dr);
		L.login_functions(Username,Password);
		A.functions();
		A1.about_functions();
		c.verify_page();
	}
//To check invalid login due to wrong username
@Test(dataProvider="login3")
public void swaglabs3(String Username,String Password) 
	{L=new Login_page(dr);
	 
	L.login_functions(Username,Password);
	}
//To check invalid login due to wrong password
@Test(dataProvider="login4")
public void swaglabs4(String Username,String Password) 
	{L=new Login_page(dr);
	L.login_functions(Username,Password);
	}
//close the browser
@AfterMethod
public void close()
{
	dr.close();
}
//provides data for valid login
@DataProvider(name="login1")
public String[][] provide_data1()
	{
		 String[][] td=new String[5][2];
		 td=e.read(1);
		 return td;
	}
//provides data for add to cart operations
@DataProvider(name="login2")
public String[][] provide_data2()
	{
		 String[][] td=new String[5][2];
		 td=e.read(2);
		 return td;
	}
//provides data for click on about link operations
@DataProvider(name="login5")
public String[][] provide_data5()
	{
		 String[][] td=new String[5][2];
		 td=e.read(3);
		 return td;
	}
//provides data for invalid login by giving wrong username
@DataProvider(name="login3")
public String[][] provide_data3()
	{
		 String[][] td=new String[5][2];
		 td=e.read(4);
		 return td;
	}
//provides data for invalid login by giving wrong password
@DataProvider(name="login4")
public String[][] provide_data4()
	{
		 String[][] td=new String[5][2];
		 td=e.read(5);
		 return td;
	}

}
