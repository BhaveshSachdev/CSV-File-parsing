/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyPackage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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
            }
        }
        
        catch(Exception e)
        {
            System.out.println("Exception occured");
        }
    }
}
