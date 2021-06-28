
package airticket;

/**
 *
 * @author MHTSOS
 */

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SpringLayout;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

//Κλάση για το παράθυρο με την λίστα των εισητηρίων
public final class ThirdFrame extends JFrame {
    private final ImageIcon img;
    private final JTable table;
    private final JPanel panel;
    private final JScrollPane pan;
    private final SpringLayout layout;
    private final JButton exit;
    private final JButton refresh;
    private final JButton new_Ticket;
    private final JLabel count_lb;
    private final JLabel count_tx;
    
    
    //Κατασκευαστής του Frame οποίος κατασκευάζει όλα τα Components 
    public ThirdFrame(){
        this.img = new ImageIcon("assets\\app_icon.png");
        ImageIcon plus = new ImageIcon("assets\\plus_icon.png");
        ImageIcon refresh_icon = new ImageIcon("assets\\refresh.png");
        ImageIcon logout_icon = new ImageIcon("assets\\logout_icon.png");
        this.layout = new SpringLayout();
        
        this.exit = new JButton("Exit", logout_icon);
        this.new_Ticket = new JButton("New Ticket", plus);
        this.refresh = new JButton(refresh_icon);
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Code");
        model.addColumn("Full Name");
        model.addColumn("Intinerary");
        model.addColumn("Categorye");
        model.addColumn("Time");
        model.addColumn("Date");
        model.addColumn("Cost");
        model.addColumn("Discount");
        model.addColumn("Final Price");
        this.table = new JTable(model);
        this.table.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        this.pan = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        this.panel = new JPanel();
        this.count_lb = new JLabel("Total tickets :");
        this.count_tx = new JLabel("0");
        
    }
    
    //Καθορισμός των χαρακτηριστικών τψν Component 
    public void prepareFrame() throws IOException{
        
        this.new_Ticket.setUI(new StyledButtonUI());
        this.exit.setUI(new StyledButtonUI());
        this.refresh.setUI(new StyledButtonUI());
        
        this.setIconImage(img.getImage());
        this.setTitle("Ticket List");
        this.setLocationRelativeTo(null);
        
        JTableHeader header = table.getTableHeader();
        header.setBackground(Color.CYAN);
        
        this.count_tx.setForeground(Color.RED);
          
        
        this.table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        this.pan.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        this.pan.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        
        //Καθορίζουμε το μήκος του πρώτου κελιού
        this.table.getColumnModel().getColumn(0).setPreferredWidth(150);

        this.panel.setSize(800, 500);
        this.panel.setLayout(layout);
        this.panel.add(pan);
        this.panel.add(refresh);
        this.panel.add(exit);
        this.panel.add(new_Ticket);
        
        this.panel.add(count_lb);
        this.panel.add(count_tx);
        
        this.putConstr();
        
        DefaultTableModel model = (DefaultTableModel)this.table.getModel();
        Ticket.readFrom(model);
        this.count_tx.setText(String.valueOf(model.getRowCount()));
        
        this.add(this.panel);
        this.pack();
        
        this.setSize(800, 500);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
        
        //Listener για το κουμπι του refresh
        this.refresh.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                try {
                    DefaultTableModel model = (DefaultTableModel)table.getModel();
                    Ticket.readFrom(model);
                    count_tx.setText(String.valueOf(model.getRowCount()));
                    
                } catch (IOException ex) {
                    Logger.getLogger(ThirdFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        //Listener για το κουμπι του νέου εισητηρίου
        this.new_Ticket.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                SecondFrame sc = null;
            try {
                sc = new SecondFrame();
            } catch (ParseException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            sc.prepareFrame();
            }
        });
        
        //Listener για το κουμπι της εξόδου
        this.exit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                exit();
            }
        });
        
    }
    
    //Ορισμός των συντεταγμένων των Components στο SpringLayout
    public void putConstr(){
        //Ορίζουμε από τα άκρα του παραθύρου την απόσταση των Component
        this.layout.putConstraint(SpringLayout.WEST, this.pan,6,SpringLayout.WEST, this.panel);  
        this.layout.putConstraint(SpringLayout.NORTH, this.pan,6,SpringLayout.NORTH, this.panel);   
        this.layout.putConstraint(SpringLayout.NORTH, this.pan,5,SpringLayout.NORTH, this.panel); 
        
        this.layout.putConstraint(SpringLayout.WEST, this.refresh, 720, SpringLayout.WEST, this.panel);
        this.layout.putConstraint(SpringLayout.NORTH, this.refresh, 10, SpringLayout.NORTH, this.panel);
        
        this.layout.putConstraint(SpringLayout.WEST, this.exit, 700, SpringLayout.WEST, this.panel);
        this.layout.putConstraint(SpringLayout.NORTH, this.exit, 420, SpringLayout.NORTH, this.panel);
        
        this.layout.putConstraint(SpringLayout.WEST, this.new_Ticket, 500, SpringLayout.WEST, this.panel);
        this.layout.putConstraint(SpringLayout.NORTH, this.new_Ticket, 420, SpringLayout.NORTH, this.panel);
        
        this.layout.putConstraint(SpringLayout.WEST, this.count_lb, 500, SpringLayout.WEST, this.panel);
        this.layout.putConstraint(SpringLayout.NORTH, this.count_lb, 10, SpringLayout.NORTH, this.panel);
        this.layout.putConstraint(SpringLayout.WEST, this.count_tx, 600, SpringLayout.WEST, this.panel);
        this.layout.putConstraint(SpringLayout.NORTH, this.count_tx, 10, SpringLayout.NORTH, this.panel);
        
        
    }
    
    //Μέθοδος για έξοδος από το Frame
    public void exit(){
       int i = JOptionPane.showConfirmDialog(ThirdFrame.this, "Do you want to cancel booking?");
        if (i == JOptionPane.YES_OPTION) {
            this.dispose();
        } 
    }
    
}