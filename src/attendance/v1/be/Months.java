/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.v1.be;

import java.text.DateFormatSymbols;
import java.time.YearMonth;
import java.util.Calendar;
import java.util.Date;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author macos
 */


public class Months {
    private String monthName;
    private int monthsNumber;
    private ObservableList<Months> list;
    public Months(String name, int numberOfDays)
    {
        this.monthsNumber = numberOfDays;
        this.monthName = name;
    }
    public Months()
    {
        int year = Calendar.getInstance().get(Calendar.YEAR);
        list = FXCollections.observableArrayList();
        for(int i = 0;i<12;i++)
                {
     DateFormatSymbols dfs = new DateFormatSymbols();
        String[] months = dfs.getMonths();
       Months e = new Months(months[i],i+1);
       list.add(e);
        
                }
    
        setList(list);
    }

    public String getMonthName() {
        return monthName;
    }

    public void setMonthName(String monthName) {
        this.monthName = monthName;
    }

    public int getMonthNumber() {
        return monthsNumber;
    }

    public void setMonthNumber(int monthNumber) {
        this.monthsNumber = monthNumber;
    }

    public ObservableList<Months> getList() {
        return list;
    }

    public void setList(ObservableList<Months> list) {
        this.list = list;
    }

    @Override
    public String toString() {
       return monthName;
    }
    
}
