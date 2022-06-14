
package songGallery;


import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;


public class FourthFrame extends JFrame {
    private final JLabel app_name;
    private final JLabel student_am;
    private final JLabel student_name;
    private final JLabel date;
    private final SpringLayout layout;
    private final JPanel panel;
    private final JLabel image;
    
    public FourthFrame(){
        this.app_name = new JLabel("Song App");
        this.student_am = new JLabel("711141244");
        this.student_name = new JLabel("Α.Γ., ");
        this.date = new JLabel("04/06/2022");
        this.layout = new SpringLayout();
        this.panel = new JPanel();
        this.image  = new JLabel(new ImageIcon("assets\\vinyl.png"));
        
    }
    

    public void prepareFrame(){
        //this.panel.setSize(300, 200);
        
        this.panel.setLayout(layout);
        //this.setIconImage(img.getImage());
        this.setTitle("About");
        this.app_name.setForeground(Color.RED);
        this.student_name.setForeground(Color.RED);
        this.student_am.setForeground(Color.RED);
        this.date.setForeground(Color.RED);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        this.panel.add(this.student_name);
        this.panel.add(this.student_am);
        this.panel.add(this.app_name);
        this.panel.add(this.date);
        this.panel.add(this.image);
        this.putConstr();
        this.add(panel);
        this.setLocationRelativeTo(null);
        this.setBounds(400, 400, 300, 200);
        //airMenu mb = new airMenu();
        //this.setJMenuBar(mb);
        this.setVisible(true); 
    }
    
    //Ορισμός των συντεταγμένων για τα Component στο SpringLayout
    public void putConstr(){
            
        this.layout.putConstraint(SpringLayout.WEST, this.app_name, 10, SpringLayout.WEST, this.panel);
        this.layout.putConstraint(SpringLayout.NORTH, this.app_name, 10, SpringLayout.NORTH, this.panel);
        
        this.layout.putConstraint(SpringLayout.WEST, this.student_name, 10, SpringLayout.WEST, this.panel);
        this.layout.putConstraint(SpringLayout.NORTH, this.student_name, 30, SpringLayout.NORTH, this.panel);
        
        this.layout.putConstraint(SpringLayout.WEST, this.student_am, 120, SpringLayout.WEST, this.panel);
        this.layout.putConstraint(SpringLayout.NORTH, this.student_am, 30, SpringLayout.NORTH, this.panel);
        
        this.layout.putConstraint(SpringLayout.WEST, this.date, 10, SpringLayout.WEST, this.panel);
        this.layout.putConstraint(SpringLayout.NORTH, this.date, 50, SpringLayout.NORTH, this.panel);
        
        this.layout.putConstraint(SpringLayout.WEST, this.image, 10, SpringLayout.WEST, this.panel);
        this.layout.putConstraint(SpringLayout.NORTH, this.image, 70, SpringLayout.NORTH, this.panel);
        
    }
    
}