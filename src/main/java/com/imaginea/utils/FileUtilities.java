package com.imaginea.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;

public class FileUtilities {

	public boolean isLogFolderExists=false;
	public boolean isReportFolderExists= false;
	
	public void deleteExisitngFolder(String fPath){
		
		File file = new File(fPath);
		if(file.isDirectory()){
			try {
				FileUtils.cleanDirectory(file);
				FileUtils.forceDelete(file); 
		        FileUtils.forceMkdir(file);
			} catch (IOException e) {
				e.printStackTrace();
			} 
           
		}
	}
	
	
	public Properties getProperties(){
		File file = new File(System.getProperty("user.dir") + File.separator +"src"+ File.separator +"test"+ File.separator +"resources"+ File.separator +"sys.properties");
		FileInputStream fileInput=null;
		try {
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Properties properties = new Properties();
		try {
			properties.load(fileInput);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return properties;
	}
}
