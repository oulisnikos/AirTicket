/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airticket;

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

/**
 *
 * @author oulis
 */
public class airMenu extends JMenuBar {
    private JMenu file;
    private JMenu action;
    private JMenu help;
    private JMenuItem add;
    private JMenuItem about;
    private JMenuItem list;
    private JMenuItem exit;
    
    public airMenu(){
        file = new JMenu("File");
        help = new JMenu("Help");
        action = new JMenu("Actions");
        exit = new JMenuItem("Exit");
        add = new JMenuItem("New Ticket");
        about = new JMenuItem("About");
        list = new JMenuItem("Ticket List");
        
        
    }
    
    public void prepareMenu(){
       file.add(add);
        action.add(list);
        file.add(action);
        file.add(exit);
        help.add(about);
        this.add(file);
        this.add(help);
        add.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                SecondFrame sc = null;
                try {
                    sc = new SecondFrame();
                } catch (ParseException ex) {
                    Logger.getLogger(airMenu.class.getName()).log(Level.SEVERE, null, ex);
                }
                sc.prepareFrame();
            }
        });
        exit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try {
                    new MainFrame().exitApp();
                } catch (IOException ex) {
                    Logger.getLogger(airMenu.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        about.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                FourthFrame ff = new FourthFrame();
                ff.prepareFrame();
            }
        });
        list.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                ThirdFrame tf = new ThirdFrame();
                try {
                    tf.prepareFrame();
                } catch (IOException ex) {
                    Logger.getLogger(airMenu.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }); 
    }
    
}
