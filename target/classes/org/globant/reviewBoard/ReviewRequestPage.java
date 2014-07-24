package org.globant.reviewBoard;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


class TableRow{
	public String[] data;
	public String team;
	
	public TableRow(){
		data = new String[4];
	}	
	
}

public class ReviewRequestPage {

	WebDriver driver; 
	List<TableRow> table;
	
	public ReviewRequestPage(WebDriver driver){
		this.driver = driver;
		table = new ArrayList<TableRow>();
	}	
		
	void generateTable(String team){
		System.out.println("Team: "+team);
		for(WebElement row : driver.findElements(By.className("odd"))){
			List<WebElement> cells = row.findElements(By.tagName("td"));
			TableRow tRow = new TableRow();
			tRow.team = team;
			for(int i = 1; i < 5;i ++){
				tRow.data[i-1] = cells.get(i).getText();
				System.out.print("\t"+tRow.data[i-1]);
			}
			
			System.out.println("\n");
			table.add(tRow);		
		}
		
		for(WebElement row : driver.findElements(By.className("even"))){
			List<WebElement> cells = row.findElements(By.tagName("td"));
			TableRow tRow = new TableRow();
			tRow.team = team;
			for(int i = 1; i < 5;i ++){
				tRow.data[i-1] = cells.get(i).getText();
				System.out.print("\t"+tRow.data[i-1]);
			}
			System.out.println("\n");
			table.add(tRow);
		}

		System.out.println("\n\n");
		
	}
		
	public void generateFile(String team){
		try {
	          File file = new File(team+".rtf");
	          FileOutputStream is = new FileOutputStream(file);
	          OutputStreamWriter osw = new OutputStreamWriter(is);    
	          Writer w = new BufferedWriter(osw);
	          
	          for(TableRow tr : table){
	        	  //w.write("Team: "+tr.team);
	        	  w.write("Summary:\t"+tr.data[0]+"\n");
	        	  w.write("Submitter:\t"+tr.data[1]+"\n");
	        	  w.write("Posted:\t"+tr.data[2]+"\n");
	        	  w.write("Last Updated:\t"+tr.data[3]+"\n\n");
	          }
	          
	          
	          w.close();
	        } catch ( IOException e ) {
	           e.printStackTrace();
	        }
	}
		
	
}
