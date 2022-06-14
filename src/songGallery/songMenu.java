package songGallery;

import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


public class songMenu extends JMenuBar {
    private JMenu file;
    private JMenuItem stat;
    private JMenuItem save;
    private JMenu help;
    private JMenuItem about;
    private JMenuItem exit;
    
    public songMenu(){
        this.file = new JMenu("File");
        this.stat = new JMenuItem("Statistics");
        this.save = new JMenuItem("Save as..");
        this.exit = new JMenuItem("Exit");
        this.help  = new JMenu("Help");
        this.about = new JMenuItem("About");
        
        
    }
    
    public void prepareMenu(){
        this.file.add(this.stat);
        this.file.add(this.save);
        this.file.add(this.exit);
    
        this.add(file);
        this.help.add(this.about);
        this.add(this.help);
        
    }
    
    public void setActionOnSave(ActionListener action)
    {
        this.save.addActionListener(action);
    }
    
    public void setActionOnAbout(ActionListener action)
    {
        this.about.addActionListener(action);
    }
    
    public void setActionOnExit(ActionListener action)
    {
        this.exit.addActionListener(action);
    }
    
    public void setActionOnStat(ActionListener action)
    {
        this.stat.addActionListener(action);
    }
    
}
