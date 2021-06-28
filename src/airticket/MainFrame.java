//Dimitris Seitos
package airticket;

import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author MHTSOS
 */
public class MainFrame extends JFrame{ 
    private final ImageIcon backgroundImage; 
    private final ImageIcon img;
    private final JButton button1;
    private final JButton button2;
    private final JButton button3;
    private final JButton button4;
    private JLabel lb;
    private airMenu mb;
    
     public MainFrame() throws IOException{
        super();
        //this.backgroundImage = ImageIO.read(new File("C:\\Users\\oulis\\Documents\\NetBeansProjects\\AirTicket\\src\\airticket\\background.png"));
        this.img = new ImageIcon("assets\\app_icon.png");
        ImageIcon plus = new ImageIcon("assets\\plus_icon.png");
        ImageIcon info_but = new ImageIcon("assets\\info_but.png");
        ImageIcon clip_icon = new ImageIcon("assets\\clip_icon.png");
        ImageIcon logout_icon = new ImageIcon("assets\\logout_icon.png");
        this.backgroundImage = new ImageIcon(ImageIO.read(new File("assets\\background.png")));
        
        //JPanel panel = new JPanel();
        this.button1 = new JButton("Add new ticket", plus);
        this.button2 = new JButton("Ticket List", clip_icon);
        this.button3 = new JButton("About", info_but);
        this.button4 = new JButton("Exit", logout_icon);
        
        
    }
    
    public void prepareFrame() throws IOException{
        this.setIconImage(img.getImage());
        
        this.lb = new JLabel(this.backgroundImage);
        this.setContentPane(this.lb); 
        
        this.button1.setBounds(200, 100, 150, 50);
        this.button2.setBounds(200, 200, 150, 50);
        this.button3.setBounds(200, 300, 150, 50);
        this.button4.setBounds(200, 400, 150, 50);
        
        this.button1.setUI(new StyledButtonUI());
        this.button2.setUI(new StyledButtonUI());
        this.button3.setUI(new StyledButtonUI());
        this.button4.setUI(new StyledButtonUI());
        
        this.setTitle("Air Tickets");
        this.setSize(500, 600);
        this.setLayout(null);
        this.button1.setLocation(30, 30);
        this.add(button1);
        this.button2.setLocation(30, 160);
        this.add(button2);
        this.button3.setLocation(30, 290);
        this.add(button3);
        this.button4.setLocation(30, 450);
        this.add(button4);
        this.setLocationRelativeTo(null);
        this.mb = new airMenu();
        this.mb.prepareMenu();
        this.setJMenuBar(mb);
        //this.pack();
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        
        this.setVisible(true);
        
        
        this.button1.addActionListener((ActionEvent e) -> {
            SecondFrame sc = null;
            try {
                sc = new SecondFrame();
            } catch (ParseException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            sc.prepareFrame();
        });
        
        this.button2.addActionListener((ActionEvent e) -> {
            ThirdFrame tf = new ThirdFrame();
            try {
                tf.prepareFrame();
            } catch (IOException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        this.button3.addActionListener((ActionEvent e) -> {
            FourthFrame ff = new FourthFrame();
            ff.prepareFrame();
        });
        this.button4.addActionListener((ActionEvent e) -> {
            exitApp();
        });
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                exitApp();
            }
        });
    }
    
   
    
    public void exitApp() {
        int i = JOptionPane.showConfirmDialog(MainFrame.this, "Do you want to exit the app?");
        if (i == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }
    
}
