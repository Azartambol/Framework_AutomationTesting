package com.strore.Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
	Properties p;
	public ReadConfig()  
	{
       p=new Properties();
	   try {
			FileInputStream  fis = new FileInputStream("C:\\Users\\DELL\\Desktop\\NewEverything\\MyStore\\Configuration\\Config.properties");
			try 
			{
				p.load(fis);
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} 
		catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	public String getUrl()
	{
		return  p.getProperty("URL"); 
	}
	
	public String getBrowser()
	{
		return p.getProperty("Browser");
		
	}
	

	public String getEmail()
	{
		return  p.getProperty("Email"); 
	}
	

	public String getPass()
	{
		return  p.getProperty("Pass"); 
	}
	
	
}
