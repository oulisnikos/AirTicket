package airticket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class Ticket {
    private String code;
    private String custName;
    private String itinerary;
    private String category;
    private String time;
    private String date;
    private double cost;
    private int discount;
    private double price;
    
    //Κατασκευαστής της κλάσης των Εισητηρίων
    Ticket()
    {
        this.code = null;
        this.custName = null;
        this.itinerary = null;
        this.category = null;
        this.time = null;
        this.date = null;
        this.cost = 0.0;
        this.discount = 0;
        this.price = 0.0;
    }
    //Κατασκευαστής της κλάσης των Εισητηρίων
    public Ticket(String code, String custName, String itinerary, String category,
            String time, String date, double cost, int discount, double price)
    {
        this.code = code;
        this.custName = custName;
        this.itinerary = itinerary;
        this.category = category;
        this.time = time;
        this.date = date;
        this.cost = cost;
        this.discount = discount;
        this.price = price;
    }
    
    //Getters και Setters 
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getItinerary() {
        return itinerary;
    }

    public void setItinerary(String itinerary) {
        this.itinerary = itinerary;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String Time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }  
    
    public void saveTo() throws IOException{
        FileWriter writer = new FileWriter("Files\\booked_tickets.csv", true); 
        BufferedWriter buffer = new BufferedWriter(writer);  
        buffer.write(this.code + "," + this.custName + "," + this.itinerary + "," + this.category + "," + this.time
        + "," + this.date + "," + this.cost + "," + this.discount + "," + this.price + "\r\n");  
        buffer.close();
        writer.close();
    }
    
    public static void readFrom(DefaultTableModel model) throws FileNotFoundException, IOException{
        String[] line = null;
        model.setNumRows(0);
        
        FileReader fileReader = new FileReader( "Files\\booked_tickets.csv");
        BufferedReader br = new BufferedReader(fileReader);
        while(br.ready()){
            //Χωρίζω την γραμμή με κόμμα και παίρνω το κάθε στοιχείο.
            line = br.readLine().split(",");
            if(line != null){
                model.addRow(new Object[]{line[0], line[1], line[2], line[3], line[4], line[5], line[6], line[7], line[8]});
            }
        }
    }
    
    
}
