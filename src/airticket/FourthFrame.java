
package airticket;

/**
 *
 * @author MHTSOS
 */
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;


public class FourthFrame extends JFrame {
    private final ImageIcon img;
    private final JLabel app_name;
    private final JLabel student_am;
    private final JLabel student_name;
    private final JLabel date;
    private final SpringLayout layout;
    private final JPanel panel;
    
    public FourthFrame(){
        this.img = new ImageIcon("assets\\info.png");
        this.app_name = new JLabel("Air Ticket");
        this.student_am = new JLabel("711161204");
        this.student_name = new JLabel("DIMITRIS SEITOS, ");
        this.date = new JLabel("13/06/2021");
        this.layout = new SpringLayout();
        this.panel = new JPanel();
        
    }
    

    public void prepareFrame(){
        this.panel.setSize(500, 400);
        this.panel.setLayout(layout);
        this.setIconImage(img.getImage());
        this.setTitle("About");
        this.app_name.setForeground(Color.RED);
        this.student_name.setForeground(Color.RED);
        this.student_am.setForeground(Color.RED);
        this.date.setForeground(Color.RED);
        
        this.panel.add(this.student_name);
        this.panel.add(this.student_am);
        this.panel.add(this.app_name);
        this.panel.add(this.date);
        this.putConstr();
        this.add(panel);
        this.setLocationRelativeTo(null);
        this.setSize(500,400);
        //airMenu mb = new airMenu();
        //this.setJMenuBar(mb);
        this.setVisible(true); 
    }
    
    //Ορισμός των συντεταγμένων για τα Component στο SpringLayout
    public void putConstr(){
            
        this.layout.putConstraint(SpringLayout.WEST, app_name, 10, SpringLayout.WEST, panel);
        this.layout.putConstraint(SpringLayout.NORTH, app_name, 10, SpringLayout.NORTH, panel);
        
        this.layout.putConstraint(SpringLayout.WEST, student_name, 10, SpringLayout.WEST, panel);
        this.layout.putConstraint(SpringLayout.NORTH, student_name, 30, SpringLayout.NORTH, panel);
        
        this.layout.putConstraint(SpringLayout.WEST, student_am, 120, SpringLayout.WEST, panel);
        this.layout.putConstraint(SpringLayout.NORTH, student_am, 30, SpringLayout.NORTH, panel);
        
        this.layout.putConstraint(SpringLayout.WEST, date, 10, SpringLayout.WEST, panel);
        this.layout.putConstraint(SpringLayout.NORTH, date, 50, SpringLayout.NORTH, panel);
        
    }
    
}