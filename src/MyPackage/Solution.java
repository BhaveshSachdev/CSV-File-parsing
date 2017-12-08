/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyPackage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Bhavesh
 */
public class Solution 
{
    public static void main(String args[]) throws IOException
    {
        try
        {
            BufferedReader reader = new BufferedReader(new FileReader(
                "D:\\GitHub\\CSV-File-parsing\\interview_data_final.csv"));

            // read file line by line
            String line = null;
            Scanner scanner = null;
            int index = 0;
            int key = 0;
            
            //creating Array list structure to hold csv data based on age
            List<CSVData> listBelow30 = new ArrayList<>();
            List<CSVData> listAbove30 = new ArrayList<>();
            
            //skipping the headers of csv file
            reader.readLine();
            
            //code to parse csv file
            while ((line = reader.readLine()) != null) 
            {
                CSVData csvData = new CSVData();
                scanner = new Scanner(line);
                scanner.useDelimiter(",");
                
                //extracting data from each entry
                while (scanner.hasNext()) 
                {
                    String data = scanner.next();
                    if (index == 0) {
                        csvData.setFirstName(data);
                    } else if (index == 1) {
                        csvData.setLastName(data);
                    } else if (index == 2) {
                       key = Integer.parseInt(data);
                       csvData.setAge(key);
                    } else if (index == 3) {
                        csvData.setState(data);
                    } else {
                        System.out.println("invalid data:" + data);
                    }
                    index++;
                }
                if(key >= 30)
                   listAbove30.add(csvData);
                else
                   listBelow30.add(csvData);
                index = 0;
            }
            
            //Sorting the lists to group by state
            Collections.sort(listAbove30, CSVData.StateComparator);
            Collections.sort(listBelow30, CSVData.StateComparator);
        }
        
        catch(Exception e)
        {
            System.out.println("Exception occured");
        }
    }
}
