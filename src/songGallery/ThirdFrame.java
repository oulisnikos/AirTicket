
package songGallery;



import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

//Κλάση για το παράθυρο με την λίστα των εισητηρίων
public final class ThirdFrame extends JFrame {
    private List<Song> allSongs;
    private JLabel total_lb;
    private JLabel total_tx;
    
    private JLabel category_tx;
    
    private JLabel bigsong_tx;
    
    private JLabel smallsong_tx;
    
    private JPanel panel;
    private SpringLayout layout;
    
    
    
    //Κατασκευαστής του Frame οποίος κατασκευάζει όλα τα Components 
    public ThirdFrame() 
    {
        this.allSongs = null;
        this.total_lb = null;
        this.total_tx = null;
        this.category_tx = null;
        this.bigsong_tx = null;
        this.smallsong_tx = null;
    }
    
    
    //Καθορισμός των χαρακτηριστικών τψν Component 
    public void prepareFrame(List<Song> iSongs)
    {
        this.allSongs =  iSongs;
        this.total_lb = new JLabel("Total songs :");
        this.total_tx = new JLabel();
        this.total_tx.setForeground(Color.RED);
        
        this.category_tx = new JLabel();
        this.category_tx.setForeground(Color.RED);
        
        this.bigsong_tx = new JLabel();
        this.bigsong_tx.setForeground(Color.RED);
        
        this.smallsong_tx = new JLabel();
        this.smallsong_tx.setForeground(Color.RED);
        
        
        this.layout = new SpringLayout();
        this.panel = new JPanel();
        
        
        
        
        this.panel.setSize(500, 200);
        this.panel.setLayout(layout);
        
        this.panel.add(this.category_tx);
        
        this.panel.add(this.total_lb);
        this.panel.add(this.total_tx);
        
        this.panel.add(this.bigsong_tx);
        
        this.panel.add(this.smallsong_tx);
        
        
        this.findStatistic();
        this.putConstr();
        this.add(this.panel);
        this.pack();
        
        this.setTitle("Statistics");
        this.setBounds(400, 400, 500, 200);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
        
        
        
    }
    
    //Ορισμός των συντεταγμένων των Components στο SpringLayout
    private void putConstr(){
        //Ορίζουμε από τα άκρα του παραθύρου την απόσταση των Component        
        this.layout.putConstraint(SpringLayout.WEST, this.total_lb, 6, SpringLayout.WEST, this.panel);
        this.layout.putConstraint(SpringLayout.NORTH, this.total_lb, 6, SpringLayout.NORTH, this.panel);
        this.layout.putConstraint(SpringLayout.WEST, this.total_tx, 100, SpringLayout.WEST, this.panel);
        this.layout.putConstraint(SpringLayout.NORTH, this.total_tx, 6, SpringLayout.NORTH, this.panel);
        
        
        this.layout.putConstraint(SpringLayout.WEST, this.category_tx, 6, SpringLayout.WEST, this.panel);
        this.layout.putConstraint(SpringLayout.NORTH, this.category_tx, 30, SpringLayout.NORTH, this.panel);
        
        
        this.layout.putConstraint(SpringLayout.WEST, this.bigsong_tx, 6, SpringLayout.WEST, this.panel);
        this.layout.putConstraint(SpringLayout.NORTH, this.bigsong_tx, 54, SpringLayout.NORTH, this.panel);
        
        
        this.layout.putConstraint(SpringLayout.WEST, this.smallsong_tx, 6, SpringLayout.WEST, this.panel);
        this.layout.putConstraint(SpringLayout.NORTH, this.smallsong_tx, 78, SpringLayout.NORTH, this.panel);
        
        
    }
    
    public void findStatistic()
    {
        Map<String, Integer> map = null;
        Song big = null;
        Song small = null;
        String category = "";
        int songs = 0;
        SimpleDateFormat format1 = new SimpleDateFormat("MM:ss");
        try
        {
            this.total_tx.setText(String.valueOf(this.allSongs.size()));
            map = new HashMap<>();
            if (this.allSongs != null && !this.allSongs.isEmpty())
            {
                big = this.allSongs.get(0);
                small = this.allSongs.get(0);
                for(Song so : this.allSongs)
                {
                    if(!map.containsKey(so.getCategory()))
                    {
                        map.put(so.getCategory(), 1);
                    }
                    else
                    {
                        int total = map.get(so.getCategory()) + 1;
                        map.put(so.getCategory(), total);
                    }
                    if (so.getTime().compareTo(big.getTime()) == 1)
                    {
                        big = so;
                    }
                    if (so.getTime().compareTo(small.getTime()) == 0)
                    {
                        small = so;
                    }
                }
                
                for (Map.Entry<String, Integer> entry : map.entrySet()) 
                {
                    if(entry.getValue() > songs)
                    {
                        category = entry.getKey();
                        songs = entry.getValue();
                    }
                }
                category_tx.setText(category + " and has " + String.valueOf(songs) + " songs!");
                bigsong_tx.setText(big.getTitle() + " has the biggest duration and  is " + format1.format(big.getTime()));
                smallsong_tx.setText(small.getTitle() + " has the smallest duration and  is " + format1.format(small.getTime()));
            }
        }
        catch(Exception e)
        {
            Logger.getLogger(SecondFrame.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    //Μέθοδος για έξοδος από το Frame
    public void exit(){
       int i = JOptionPane.showConfirmDialog(ThirdFrame.this, "Do you want to cancel booking?");
        if (i == JOptionPane.YES_OPTION) {
            this.dispose();
        } 
    }
    
}