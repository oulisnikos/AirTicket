package songGallery;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class Song {
    public static final String SONG_CODE = "song_";
    private String code;
    private String title;
    private int etos;
    private Date time;
    private String singer;
    private String category;
    
    //Κατασκευαστής της κλάσης των Τραγουδιών
    Song()
    {
        this.code = null;
        this.title = null;
        this.etos = 0;
        this.time = null;
        this.singer = null;
        this.category = null;
    }
    //Κατασκευαστής της κλάσης των Εισητηρίων
    public Song(String code, String title, int etos, Date time,
            String singer, String category)
    {
        this.code = code;
        this.title = title;
        this.etos = etos;
        this.time = time;
        this.singer = singer;
        this.category = category;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getEtos() {
        return etos;
    }

    public void setEtos(int etos) {
        this.etos = etos;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    
      
    
    public static void saveToFile(List<Song> songs, File filePath) throws Exception {
        try
        {
            FileWriter writer = new FileWriter(filePath, false); 
            BufferedWriter buffer = new BufferedWriter(writer); 
            SimpleDateFormat format1 = new SimpleDateFormat("MM:ss");
            if (songs != null)
            {
                for(Song so : songs)
                {
                  buffer.write(so.code + "," + so.title + "," + so.etos + "," + format1.format(so.time)
                + "," + so.singer + "," + so.category + "\r\n");    
                }
            }
            buffer.close();
            writer.close();
        }
        catch(Exception ex)
        {
            throw ex;
        }
        
    }
    
    
}
