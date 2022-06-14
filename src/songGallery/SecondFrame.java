
package songGallery;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import validator.DateValidator;
import validator.DateValidatorUsingDateFormat;


public class SecondFrame extends JFrame {
    private List<Song> allSongs;
    private int songCode;
    private boolean canLeave;
    private final JLabel name_lb;
    private final JTextField name_tx;
    private final JLabel year_lb;
    private final JTextField year_tx;
    private final JLabel cat_lb;
    private final JTextField time_tx;
    private final SpringLayout layout;
    private final JPanel panel;
    private final JButton save;
    private final JButton cancel;
    private final JButton store;
    private static final String[] song_categories = {"Rock", "Pop", "Jazz", "Hip Hop", "Blouse"};

    private final JComboBox cb_categories;
    private final JLabel category;
    private final JLabel singer_lb;
    private final JTextField singer_tx;
    private songMenu mb;

    //Κατασκευαστής του Frame για την εισαγωγή των τραγουδιών
    public SecondFrame()
    {
        this.allSongs = new ArrayList<>();
        this.songCode = 0;
        this.canLeave = true;
        
        this.layout = new SpringLayout();
        this.name_tx= new JTextField(13);
        this.name_lb = new JLabel("Title :");
        
        this.year_tx= new JTextField();;
        this.year_lb = new JLabel("Year :");
        
        this.time_tx= new JTextField();
        
        this.cat_lb = new JLabel("Song time:");
        
        //this.cb_itin = new JComboBox(itinerary);
        //this.itin_lb = new JLabel("Itinerary :");
        
        this.singer_lb = new JLabel("Singer:");
        this.singer_tx = new JTextField(10);
   

        this.cb_categories = new JComboBox(song_categories);
        this.category = new JLabel("Song Category :");
        
        this.panel = new JPanel();
        this.save = new JButton("Save");
        this.store = new JButton("Store");
        this.cancel = new JButton("Exit");
        
    }
    
    //Ορισμός των συντεταγμένων για τα Component στο SpringLayout
    private void putConstr(){
        this.layout.putConstraint(SpringLayout.WEST, this.name_lb,6,SpringLayout.WEST, this.panel);  
        this.layout.putConstraint(SpringLayout.NORTH, this.name_lb,6,SpringLayout.NORTH, this.panel);  
        this.layout.putConstraint(SpringLayout.WEST, this.name_tx, 120,SpringLayout.WEST, this.panel);  
        this.layout.putConstraint(SpringLayout.NORTH, this.name_tx,5,SpringLayout.NORTH, this.panel); 
        this.layout.putConstraint(SpringLayout.SOUTH, this.name_tx,25,SpringLayout.NORTH, this.panel);
        
        this.layout.putConstraint(SpringLayout.WEST, this.year_lb, 6, SpringLayout.WEST, this.panel);
        this.layout.putConstraint(SpringLayout.NORTH, this.year_lb, 40, SpringLayout.NORTH, this.panel);
        this.layout.putConstraint(SpringLayout.WEST, this.year_tx, 120, SpringLayout.WEST, this.panel);
        this.layout.putConstraint(SpringLayout.NORTH, this.year_tx, 40, SpringLayout.NORTH, this.panel);
        this.layout.putConstraint(SpringLayout.SOUTH, this.year_tx, 60, SpringLayout.NORTH, this.panel);
        
        this.layout.putConstraint(SpringLayout.WEST, this.cat_lb, 6, SpringLayout.WEST, this.panel);
        this.layout.putConstraint(SpringLayout.NORTH, this.cat_lb, 74, SpringLayout.NORTH, this.panel);
        this.layout.putConstraint(SpringLayout.WEST, this.time_tx, 120, SpringLayout.WEST, this.panel);
        this.layout.putConstraint(SpringLayout.NORTH, this.time_tx, 70, SpringLayout.NORTH, this.panel);
        this.layout.putConstraint(SpringLayout.SOUTH, this.time_tx, 90, SpringLayout.NORTH, this.panel);
        
        this.layout.putConstraint(SpringLayout.WEST, this.category, 280, SpringLayout.WEST, this.panel);
        this.layout.putConstraint(SpringLayout.NORTH, this.category, 6, SpringLayout.NORTH, this.panel);
        this.layout.putConstraint(SpringLayout.WEST, this.cb_categories, 420, SpringLayout.WEST, this.panel);
        this.layout.putConstraint(SpringLayout.NORTH, this.cb_categories, 6, SpringLayout.NORTH, this.panel);
        this.layout.putConstraint(SpringLayout.SOUTH, this.cb_categories, 26, SpringLayout.NORTH, this.panel);
        
        this.layout.putConstraint(SpringLayout.WEST, this.singer_lb, 280, SpringLayout.WEST, this.panel);
        this.layout.putConstraint(SpringLayout.NORTH, this.singer_lb, 40, SpringLayout.NORTH, this.panel);
        this.layout.putConstraint(SpringLayout.WEST, this.singer_tx, 420, SpringLayout.WEST, this.panel);
        this.layout.putConstraint(SpringLayout.NORTH, this.singer_tx, 40, SpringLayout.NORTH, this.panel);
        this.layout.putConstraint(SpringLayout.SOUTH, this.singer_tx, 60, SpringLayout.NORTH, this.panel);
        
        
        
        this.layout.putConstraint(SpringLayout.WEST, this.save, 100, SpringLayout.WEST, this.panel);
        this.layout.putConstraint(SpringLayout.NORTH, this.save, 200, SpringLayout.NORTH, this.panel);
        
        
        this.layout.putConstraint(SpringLayout.WEST, this.cancel, 300, SpringLayout.WEST, this.panel);
        this.layout.putConstraint(SpringLayout.NORTH, this.cancel, 200, SpringLayout.NORTH, this.panel);
        
        this.layout.putConstraint(SpringLayout.WEST, this.store, 500, SpringLayout.WEST, this.panel);
        this.layout.putConstraint(SpringLayout.NORTH, this.store, 200, SpringLayout.NORTH, this.panel);
        
    }

    public List<Song> getAllSongs() {
        return allSongs;
    }

    public void setAllSongs(List<Song> allSongs) {
        this.allSongs = allSongs;
    }

    public int getSongCode() {
        return songCode;
    }

    public void setSongCode(int songCode) {
        this.songCode = songCode;
    }

    public boolean isCanLeave() {
        return canLeave;
    }

    public void setCanLeave(boolean canLeave) {
        this.canLeave = canLeave;
    }
    
    
    //Ορισμός χαρακτηριστικών για τα Component
    public void prepareFrame(){
        
        StyledButtonUI style = new StyledButtonUI();
        this.save.setUI(style);
        this.cancel.setUI(style);
        this.store.setUI(style);
        
        this.panel.setSize(500, 400);
        this.panel.setLayout(this.layout);
        
        this.time_tx.setColumns(13);
        this.year_tx.setColumns(5);
        
        this.panel.add(this.name_lb);
        this.panel.add(this.name_tx);
        
        this.panel.add(this.year_lb);
        this.panel.add(this.year_tx);
        
        
        this.panel.add(cat_lb);
        this.panel.add(time_tx);
        
        this.panel.add(this.save);
        this.panel.add(this.cancel);
        this.panel.add(this.store);
        
        this.panel.add(this.category);
        this.panel.add(this.cb_categories);
        
        this.panel.add(this.singer_lb);
        this.panel.add(this.singer_tx);
        
        
        // Put constraint on components
        this.putConstr();
        this.add(this.panel);
        this.pack();

        
        
        //Listener για το κουμπί της αποθήκευσης
        this.save.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                try {
                    SaveSong();
                    JOptionPane.showMessageDialog(SecondFrame.this, "Song saved successfuly ",
                    "Song Info", JOptionPane.INFORMATION_MESSAGE);
                    canLeave = true;
                }catch (Exception ex) {
                    Logger.getLogger(SecondFrame.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(SecondFrame.this, ex,
                    "Song Info", JOptionPane.ERROR_MESSAGE);
                }
                
            }
        });
        
        this.store.addActionListener(this.OnSaveActionListener());
        
        //Listener για το κουμπί της ακύρωσης
        this.cancel.addActionListener(this.OnExitActionListener());
        
        this.name_tx.getDocument().addDocumentListener(this.CustomDocumentListener());
        this.time_tx.getDocument().addDocumentListener(this.CustomDocumentListener());
        this.year_tx.getDocument().addDocumentListener(this.CustomDocumentListener());
        this.singer_tx.getDocument().addDocumentListener(this.CustomDocumentListener());
        
        //Listener για το κουμπί το κουμπί του κλεισίματος του Frame
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                exitApp();
            }
        });
        
        this.mb = new songMenu();
        this.mb.prepareMenu();
        this.setJMenuBar(mb);
        this.mb.setActionOnSave(this.OnSaveActionListener());
            
        
        this.mb.setActionOnAbout(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                FourthFrame ff = new FourthFrame();
                ff.prepareFrame();
            }
        });
        this.mb.setActionOnExit(this.OnExitActionListener());
        
        this.mb.setActionOnStat(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                ThirdFrame third = new ThirdFrame();
                third.prepareFrame(getAllSongs());
            }
        });
        
        
        //this.setIconImage(this.img.getImage());
        this.setTitle("Add New Song");
        this.setLocationRelativeTo(null);
        
        this.setBounds(400, 300, 700, 500);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setVisible(true);

        
        
    }
    
    public DocumentListener CustomDocumentListener()
    {
        return new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                setCanLeave(false);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                setCanLeave(false);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
               setCanLeave(false);  
            }
        };
    }
    
    public ActionListener OnSaveActionListener()
    {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                try
                {
                    JFileChooser js = new JFileChooser(new File("."));
                    js.setDialogTitle("Save Songs to File");
                    js.showSaveDialog(null);
                    Song.saveToFile(allSongs, js.getSelectedFile());
                }
                catch(Exception ex)
                {
                    Logger.getLogger(SecondFrame.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(SecondFrame.this, ex,
                    "Song Info", JOptionPane.ERROR_MESSAGE);
                }
            }
        };
    }
    
    public ActionListener OnExitActionListener()
    {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
               exitApp();
            }
        };
    }
    
    
    public void exitApp() {
        String extra = "";
        if(!canLeave)
        {
            extra = "Not all songs saved to File!!!\n";
        }
        int i = JOptionPane.showConfirmDialog(SecondFrame.this, "Do you want to exit the app?" + extra);
        if (i == JOptionPane.YES_OPTION) {
            clearData();
            System.exit(0);
        }
    }

    //Μέθοδος για την αποθήκευση τραγουδιού, η οποία ελέγχεί και κάποια πεδία
    public void SaveSong() throws Exception{
        DateValidator validator1 = new DateValidatorUsingDateFormat("MM:ss");
        DateValidator validator2 = new DateValidatorUsingDateFormat("YYYY");
        if (!validator2.isValid(this.year_tx.getText())) {
                throw new Exception("You do not give a valid year. " + this.year_tx.getText());
        }
        
        if(!validator1.isValid(time_tx.getText()))
        {
            throw new Exception("You do not give a valid song duration. [" + this.time_tx.getText() + "]");
        }
        
        SimpleDateFormat format = new SimpleDateFormat("MM:ss");
        Song s1 = new Song(Song.SONG_CODE + String.format("%02d", this.getSongCode()), this.name_tx.getText(), Integer.parseInt(year_tx.getText()),
               format.parse(time_tx.getText()), singer_tx.getText(), String.valueOf(cb_categories.getSelectedItem()));
        //s1.saveToFile();
        this.allSongs.add(s1);
        this.setSongCode(this.getSongCode() + 1);
        this.canLeave = false;
        clearData();
        //}
    }
    //Καθαρίζει όλα τα πεδία του Frame
    public void clearData(){
        this.name_tx.setText("");
        this.singer_tx.setText("");
        this.cb_categories.setSelectedIndex(0);
        this.time_tx.setText("");
        this.year_tx.setText("");
    }
    
}
