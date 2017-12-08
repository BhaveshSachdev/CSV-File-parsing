/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyPackage;

import java.util.Comparator;

/**
 *
 * @author Bhavesh
 */
public class CSVData 
{
    private String firstName, lastName, State;
    private int age;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getState() {
        return State;
    }

    public void setState(String State) {
        this.State = State;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
    //using comparatpr to compare between State values
    public static Comparator<CSVData> StateComparator = new Comparator<CSVData>()
    {
        public int compare(CSVData data1, CSVData data2)
        {
            String state1 = data1.getState().toUpperCase();
            String state2 = data2.getState().toUpperCase();
            
            return state1.compareTo(state2);
        }
    };
}
