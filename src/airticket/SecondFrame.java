
package airticket;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;


public class SecondFrame extends JFrame {
    private final ImageIcon img;
    private final JLabel name_lb;
    private final JTextField name_tx;
    private final JLabel code_lb;
    private final JTextField code_tx;
    private final JLabel itin_lb;
    private final JLabel cost_lb;
    private final JFormattedTextField cost_tx;
    private final SpringLayout layout;
    private final JPanel panel;
    private final JButton book;
    private final JButton cancel;
    private static final String[] categories = {"Over 18", "Under 18", "Student"};
    private static final String[] times = {"", "13:00", "15:00", "17:00", "20:00"};
    private static final String[] itinerary = {"","ATH - SKG", "ATH - CRT", "ATH - CPR", "ATH - MYK"};
    private final JComboBox cb_times;
    private final JComboBox cb_itin;
    private final JComboBox cb_age;
    private final JLabel times_lb;
    private final JLabel category;
    private final JLabel dis_lb;
    private final JTextField dis_tx;
    private final JLabel final_p_lb;
    private final JLabel final_p;
    private final JButton calc;
    private final JLabel date_lb;
    private final JFormattedTextField date_tx;

    //Κατασκευαστής του Frame για την κράτηση εισήτηρίου και όλων των Component
    public SecondFrame() throws ParseException{
        
        NumberFormatter mask = new NumberFormatter(new DecimalFormat("#0.#"));
        mask.setValueClass(Float.class);
	DefaultFormatterFactory factory = new DefaultFormatterFactory(mask);
        DateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
        
        this.img = new ImageIcon("assets\\app_icon.png");
        this.layout = new SpringLayout();
        this.name_tx= new JTextField(13);
        this.name_lb = new JLabel("Full Name :");
        
        this.code_tx= new JTextField(13);
        this.code_lb = new JLabel("Ticket Code :");
        
        this.cost_tx= new JFormattedTextField(factory);
        
        this.cost_lb = new JLabel("Ticket Cost ($):");
        
        this.cb_itin = new JComboBox(itinerary);
        this.itin_lb = new JLabel("Itinerary :");
        
        this.dis_lb = new JLabel("Discount (%):");
        this.dis_tx = new JTextField(10);
        
        this.final_p_lb = new JLabel("Final Price :");
        this.final_p = new JLabel("  0.0 ");
        
        this.cb_times = new JComboBox(times);
        this.times_lb = new JLabel("Time :");
        this.cb_age = new JComboBox(categories);
        this.category = new JLabel("Category :");
        
        this.panel = new JPanel();
        this.book = new JButton("Book");
        this.cancel = new JButton("Cancel");
        
        
        this.date_lb = new JLabel("Date (dd/MM/yyyy):");
        this.date_tx = new JFormattedTextField(dateFormatter);        
        
        this.calc = new JButton("Calculate");

    }
    
    //Ορισμός των συντεταγμένων για τα Component στο SpringLayout
    public void putConstr(){
        this.layout.putConstraint(SpringLayout.WEST, this.name_lb,6,SpringLayout.WEST, this.panel);  
        this.layout.putConstraint(SpringLayout.NORTH, this.name_lb,6,SpringLayout.NORTH, this.panel);  
        this.layout.putConstraint(SpringLayout.WEST, this.name_tx, 120,SpringLayout.WEST, this.panel);  
        this.layout.putConstraint(SpringLayout.NORTH, this.name_tx,5,SpringLayout.NORTH, this.panel); 
        this.layout.putConstraint(SpringLayout.SOUTH, this.name_tx,25,SpringLayout.NORTH, this.panel); 
        
        this.layout.putConstraint(SpringLayout.WEST, this.itin_lb, 6, SpringLayout.WEST, this.panel);  
        this.layout.putConstraint(SpringLayout.NORTH, this.itin_lb,40,SpringLayout.NORTH, this.panel);  
        this.layout.putConstraint(SpringLayout.WEST, this.cb_itin, 120,SpringLayout.WEST, this.panel);  
        this.layout.putConstraint(SpringLayout.NORTH, this.cb_itin,40,SpringLayout.NORTH, this.panel);    
        this.layout.putConstraint(SpringLayout.SOUTH, this.cb_itin, 60,SpringLayout.NORTH, this.panel); 
        
        this.layout.putConstraint(SpringLayout.WEST, this.code_lb, 6, SpringLayout.WEST, this.panel);
        this.layout.putConstraint(SpringLayout.NORTH, this.code_lb, 70, SpringLayout.NORTH, this.panel);
        this.layout.putConstraint(SpringLayout.WEST, this.code_tx, 120, SpringLayout.WEST, this.panel);
        this.layout.putConstraint(SpringLayout.NORTH, this.code_tx, 70, SpringLayout.NORTH, this.panel);
        this.layout.putConstraint(SpringLayout.SOUTH, this.code_tx, 90, SpringLayout.NORTH, this.panel);
        
        this.layout.putConstraint(SpringLayout.WEST, this.cost_lb, 6, SpringLayout.WEST, this.panel);
        this.layout.putConstraint(SpringLayout.NORTH, this.cost_lb, 100, SpringLayout.NORTH, this.panel);
        this.layout.putConstraint(SpringLayout.WEST, this.cost_tx, 120, SpringLayout.WEST, this.panel);
        this.layout.putConstraint(SpringLayout.NORTH, this.cost_tx, 100, SpringLayout.NORTH, this.panel);
        this.layout.putConstraint(SpringLayout.SOUTH, this.cost_tx, 120, SpringLayout.NORTH, this.panel);
        
        this.layout.putConstraint(SpringLayout.WEST, this.date_lb, 6, SpringLayout.WEST, this.panel);
        this.layout.putConstraint(SpringLayout.NORTH, this.date_lb, 130, SpringLayout.NORTH, this.panel);
        this.layout.putConstraint(SpringLayout.WEST, this.date_tx, 120, SpringLayout.WEST, this.panel);
        this.layout.putConstraint(SpringLayout.NORTH, this.date_tx, 130, SpringLayout.NORTH, this.panel);
        this.layout.putConstraint(SpringLayout.SOUTH, this.date_tx, 150, SpringLayout.NORTH, this.panel);
        
        this.layout.putConstraint(SpringLayout.WEST, this.category, 280, SpringLayout.WEST, this.panel);
        this.layout.putConstraint(SpringLayout.NORTH, this.category, 6, SpringLayout.NORTH, this.panel);
        this.layout.putConstraint(SpringLayout.WEST, this.cb_age, 360, SpringLayout.WEST, this.panel);
        this.layout.putConstraint(SpringLayout.NORTH, this.cb_age, 6, SpringLayout.NORTH, this.panel);
        this.layout.putConstraint(SpringLayout.SOUTH, this.cb_age, 26, SpringLayout.NORTH, this.panel);
        
        this.layout.putConstraint(SpringLayout.WEST, this.times_lb, 280, SpringLayout.WEST, this.panel);  
        this.layout.putConstraint(SpringLayout.NORTH, this.times_lb,40,SpringLayout.NORTH, this.panel);  
        this.layout.putConstraint(SpringLayout.WEST, this.cb_times, 360,SpringLayout.WEST, this.panel);  
        this.layout.putConstraint(SpringLayout.NORTH, this.cb_times,40,SpringLayout.NORTH, this.panel);    
        this.layout.putConstraint(SpringLayout.SOUTH, this.cb_times, 60,SpringLayout.NORTH, this.panel);
        
        this.layout.putConstraint(SpringLayout.WEST, this.dis_lb, 280, SpringLayout.WEST, this.panel);
        this.layout.putConstraint(SpringLayout.NORTH, this.dis_lb, 70, SpringLayout.NORTH, this.panel);
        this.layout.putConstraint(SpringLayout.WEST, this.dis_tx, 360, SpringLayout.WEST, this.panel);
        this.layout.putConstraint(SpringLayout.NORTH, this.dis_tx, 70, SpringLayout.NORTH, this.panel);
        this.layout.putConstraint(SpringLayout.SOUTH, this.dis_tx, 90, SpringLayout.NORTH, this.panel);
        
        this.layout.putConstraint(SpringLayout.WEST, this.final_p_lb, 280, SpringLayout.WEST, this.panel);
        this.layout.putConstraint(SpringLayout.NORTH, this.final_p_lb, 100, SpringLayout.NORTH, this.panel);
        this.layout.putConstraint(SpringLayout.WEST, this.final_p, 360, SpringLayout.WEST, this.panel);
        this.layout.putConstraint(SpringLayout.NORTH, this.final_p, 100, SpringLayout.NORTH, this.panel);
        this.layout.putConstraint(SpringLayout.SOUTH, this.final_p, 120, SpringLayout.NORTH, this.panel);
        
        
        this.layout.putConstraint(SpringLayout.WEST, this.book, 100, SpringLayout.WEST, this.panel);
        this.layout.putConstraint(SpringLayout.NORTH, this.book, 200, SpringLayout.NORTH, this.panel);
        
        this.layout.putConstraint(SpringLayout.WEST, this.calc, 190, SpringLayout.WEST, this.panel);
        this.layout.putConstraint(SpringLayout.NORTH, this.calc, 200, SpringLayout.NORTH, this.panel);
        
        this.layout.putConstraint(SpringLayout.WEST, this.cancel, 300, SpringLayout.WEST, this.panel);
        this.layout.putConstraint(SpringLayout.NORTH, this.cancel, 200, SpringLayout.NORTH, this.panel);
        
    }
    
    //Ορισμός χαρακτηριστικών για τα Component
    public void prepareFrame(){
        
        
        this.book.setUI(new StyledButtonUI());
        this.cancel.setUI(new StyledButtonUI());
        this.calc.setUI(new StyledButtonUI());

        
        this.final_p.setForeground(Color.RED);
        this.dis_tx.setEditable(false);
        this.panel.setSize(500, 400);
        this.panel.setLayout(this.layout);
        
        this.cost_tx.setColumns(13);
        this.date_tx.setColumns(13);
        
        this.panel.add(this.name_lb);
        this.panel.add(this.name_tx);
        
        this.panel.add(this.code_lb);
        this.panel.add(this.code_tx);
        
        this.panel.add(this.itin_lb);
        this.panel.add(this.cb_itin);
        
        this.panel.add(cost_lb);
        this.panel.add(cost_tx);
        
        this.panel.add(this.book);
        this.panel.add(this.cancel);
        this.panel.add(this.calc);
        
        this.panel.add(this.category);
        this.panel.add(this.cb_age);
        
        this.panel.add(this.dis_lb);
        this.panel.add(this.dis_tx);
        
        this.panel.add(this.final_p_lb);
        this.panel.add(this.final_p);
        
        this.panel.add(this.times_lb);
        this.panel.add(this.cb_times);
        
        
        this.panel.add(this.date_lb);
        this.panel.add(this.date_tx);
        
        // Put constraint on components
        this.putConstr();
        
        //name_tx.setToolTipText("Full Name");
        // Set the window to be visible as the default to be false
        this.add(this.panel);
        this.pack();

        //this.add(datePicker);
        this.setIconImage(this.img.getImage());
        this.setTitle("Ιssuance of a new ticket");
        this.setLocationRelativeTo(null);
        
        this.setSize(500,400);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
        
        //Listener για το κουμπί της κράτησης
        this.book.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                try {
                    Book();
                    JOptionPane.showMessageDialog(SecondFrame.this, "Ticket book successfuly ",
                    "Book Info", JOptionPane.INFORMATION_MESSAGE);
                } catch (IOException ex) {
                    Logger.getLogger(SecondFrame.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(SecondFrame.this, ex,
                    "Book Info", JOptionPane.ERROR_MESSAGE);
                }
                
            }
        });
        
        //Listener για το κουμπί της ακύρωσης
        this.cancel.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
               clearData();
               exit(); 
            }
        });
        
        //Listener για το κουμπί το κουμπί του κλεισίματος του Frame
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                exit();
            }
        });
        
        //Listener για το κουμπί του υπολογισμού της τελικής τιμής
        this.calc.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                double price = 0.0;
                int discount = 0;
                if(cost_tx.getText().isEmpty()){
                   JOptionPane.showMessageDialog(SecondFrame.this, "Must give cost of ticket .",
                        "Book error", JOptionPane.WARNING_MESSAGE); 
                }
                if (cb_age.getSelectedIndex()==0 && !cost_tx.getText().isEmpty()){
                   dis_tx.setText("0");
                   discount = Integer.parseInt(dis_tx.getText());
                   price = Integer.parseInt(cost_tx.getText()) - Integer.parseInt(cost_tx.getText())*discount/100; 
                   final_p.setText(String.valueOf(price));
               } 
               else if (cb_age.getSelectedIndex()==1 && !cost_tx.getText().isEmpty()){
                   dis_tx.setText("50");
                   discount = Integer.parseInt(dis_tx.getText());
                   price = Integer.parseInt(cost_tx.getText()) - Integer.parseInt(cost_tx.getText())* discount/100; 
                   final_p.setText(String.valueOf(price));
               }
               if (cb_age.getSelectedIndex()==2 && !cost_tx.getText().isEmpty()){
                   dis_tx.setText("30");
                   discount = Integer.parseInt(dis_tx.getText());
                   price = Integer.parseInt(cost_tx.getText()) - Integer.parseInt(cost_tx.getText())*discount/100; 
                   final_p.setText(String.valueOf(price));
               }
            }
        });

        
        
    }

    //Μέθοδος για την κράτηση εισητηρίου, η οποία ελέγχεί όλα τα πεδία αν είναι κενά και αν δεν είναι τότε τα γράφει στο αρχείο
    public void Book() throws IOException{
        if (this.name_tx.getText().isEmpty()) {
            JOptionPane.showMessageDialog(SecondFrame.this, "Full Name is Required. ",
                "Book error", JOptionPane.ERROR_MESSAGE);
                throw new NullPointerException();
        }
        else if(this.cb_itin.getSelectedItem().toString().equals("")){
            JOptionPane.showMessageDialog(SecondFrame.this, "Must select at least one route .",
                "Book error", JOptionPane.ERROR_MESSAGE);
                throw new NullPointerException();
        }
        else if(this.code_tx.getText().isEmpty()){
            JOptionPane.showMessageDialog(SecondFrame.this, "Ticket Code is Required. ",
                "Book error", JOptionPane.ERROR_MESSAGE);
                throw new NullPointerException();
        }
        else if(this.cost_tx.getText().isEmpty()){
            JOptionPane.showMessageDialog(SecondFrame.this, "The Cost is empty. ",
                "Book error", JOptionPane.ERROR_MESSAGE);
            throw new NullPointerException();
        }
        else if(this.cb_times.getSelectedItem().toString().equals("")){
            JOptionPane.showMessageDialog(SecondFrame.this, "Must select at least one time .",
                "Book error", JOptionPane.ERROR_MESSAGE);
            throw new NullPointerException();
        }
        else if(this.date_tx.getText().isEmpty()){
            JOptionPane.showMessageDialog(SecondFrame.this, "Must inserrt valid date .",
                "Book error", JOptionPane.ERROR_MESSAGE);
            throw new NullPointerException();
        }
        else{
            Ticket t1 = new Ticket(code_tx.getText(), this.name_tx.getText(), this.cb_itin.getSelectedItem().toString(), this.cb_age.getSelectedItem().toString(),
                    this.cb_times.getSelectedItem().toString(), this.date_tx.getText(), 
                    Double.parseDouble(cost_tx.getText()), Integer.parseInt(this.dis_tx.getText()), Double.parseDouble(this.final_p.getText()));
            t1.saveTo();
            this.dispose();
            clearData();
        }
    }
    //Καθαρίζει όλα τα πεδία του Frame
    public void clearData(){
        this.name_tx.setText("");
        this.final_p.setText("");
        this.cb_times.setSelectedIndex(0);
        this.dis_tx.setText("");
        this.cb_age.setSelectedIndex(0);
        this.cost_tx.setText("");
        this.code_tx.setText("");
        this.cb_itin.setSelectedIndex(0);
    }
    
    //Μέθοδος για κλείσιμο του συγκεκριμένου παραθύρου
    public void exit(){
       int i = JOptionPane.showConfirmDialog(SecondFrame.this, "Do you want to cancel booking?");
        if (i == JOptionPane.YES_OPTION) {
            this.dispose();
        } 
    }
    
}
