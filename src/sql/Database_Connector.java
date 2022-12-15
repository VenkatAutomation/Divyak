package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Database_Connector 
{
	
	static WebDriver driver;
	
	public static void main(String[] args) throws SQLException {
		
	  String uname="";
	  String pass="";
	  String host="localhost";
	  String port = "3306";
	  
	  Connection con = DriverManager.getConnection("jdbc:mysql://"+host+":"+port+":"+"`logindetails`","root","Venkat@123");
		  Statement s = con.createStatement();
		  ResultSet rs = s.executeQuery("select * from LoginData");
		  while(rs.next())
		  {
			  uname=rs.getString("username");
			  pass=rs.getString("password");
		  }
		  
		  driver = new ChromeDriver();
		  
		  driver.get("https://demo.guru99.com/v4/index.php");
		  
		  driver.findElement(By.name("uid")).sendKeys(uname);
		  driver.findElement(By.name("password")).sendKeys(pass);
		  driver.findElement(By.name("btnLogin")).click();
		  
		  
	}

}
