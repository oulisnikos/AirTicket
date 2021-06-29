/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exetasimae2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;


public class MainFrame extends JFrame {
    private ArrayList<Employee> data;
    private int current;
    private int max;
    private int min;
    private final JLabel name_lb;
    private final JLabel name_tx;
    private final JLabel etos;
    private final JLabel eidiko;
    private final JLabel surname;
    private final JLabel orario;
    private final JLabel misthos;
    
    private final JLabel etos_tx;
    private final JLabel eidiko_tx;
    private final JLabel surname_tx;
    private final JLabel orario_tx;
    private final JLabel misthos_tx;
    
    private final SpringLayout layout;
    private final JPanel panel;
    private final JButton prev;
    private final JButton next;


    private final JButton calc;

    public MainFrame() throws ParseException, IOException{
        
        NumberFormatter mask = new NumberFormatter(new DecimalFormat("#0.#"));
        mask.setValueClass(Float.class);
        DefaultFormatterFactory factory = new DefaultFormatterFactory(mask);
        DateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
        
        this.layout = new SpringLayout();
        this.name_lb = new JLabel("Όνομα :");
        this.surname = new JLabel("Επώνυμο :");
        this.misthos = new JLabel("Βασικός Μισθός :");
        this.eidiko = new JLabel("Ειδικότητα :");
        this.etos = new JLabel("Έτος Πρόσληψης :");
        this.orario = new JLabel("Υ.Μ.Ω :");
        
        this.data = new ArrayList<Employee>();
        this.current = 0;
        
        readFile();
        System.out.println(data.size());
        this.max = data.size() - 1;
        this.min = 0;
        this.name_tx = new JLabel(data.get(current).getName());
        this.surname_tx = new JLabel(data.get(current).getSurname());
        this.misthos_tx = new JLabel(data.get(current).getMisthos());
        this.eidiko_tx = new JLabel(data.get(current).getEidiko());
        this.etos_tx = new JLabel(Integer.toString(data.get(current).getEtos()));
        this.orario_tx = new JLabel(Integer.toString(data.get(current).getOrario()));

        
        
        this.panel = new JPanel();
        this.prev = new JButton("Prev");
        this.next = new JButton("Next");    
        this.calc = new JButton("Calcualte");

    }
    
    public void putConstr(){
        this.layout.putConstraint(SpringLayout.WEST, this.name_lb,6,SpringLayout.WEST, this.panel);  
        this.layout.putConstraint(SpringLayout.NORTH, this.name_lb,6,SpringLayout.NORTH, this.panel);  
        this.layout.putConstraint(SpringLayout.WEST, this.name_tx, 120,SpringLayout.WEST, this.panel);  
        this.layout.putConstraint(SpringLayout.NORTH, this.name_tx,5,SpringLayout.NORTH, this.panel); 
        this.layout.putConstraint(SpringLayout.SOUTH, this.name_tx,25,SpringLayout.NORTH, this.panel); 
        
        this.layout.putConstraint(SpringLayout.WEST, this.surname, 6, SpringLayout.WEST, this.panel);  
        this.layout.putConstraint(SpringLayout.NORTH, this.surname,40,SpringLayout.NORTH, this.panel);  
        this.layout.putConstraint(SpringLayout.WEST, this.surname_tx, 120,SpringLayout.WEST, this.panel);  
        this.layout.putConstraint(SpringLayout.NORTH, this.surname_tx,40,SpringLayout.NORTH, this.panel);    
        this.layout.putConstraint(SpringLayout.SOUTH, this.surname_tx, 60,SpringLayout.NORTH, this.panel); 
        
        this.layout.putConstraint(SpringLayout.WEST, this.misthos, 6, SpringLayout.WEST, this.panel);
        this.layout.putConstraint(SpringLayout.NORTH, this.misthos, 70, SpringLayout.NORTH, this.panel);
        this.layout.putConstraint(SpringLayout.WEST, this.misthos_tx, 120, SpringLayout.WEST, this.panel);
        this.layout.putConstraint(SpringLayout.NORTH, this.misthos_tx, 70, SpringLayout.NORTH, this.panel);
        this.layout.putConstraint(SpringLayout.SOUTH, this.misthos_tx, 90, SpringLayout.NORTH, this.panel);
        
        this.layout.putConstraint(SpringLayout.WEST, this.eidiko, 6, SpringLayout.WEST, this.panel);
        this.layout.putConstraint(SpringLayout.NORTH, this.eidiko, 100, SpringLayout.NORTH, this.panel);
        this.layout.putConstraint(SpringLayout.WEST, this.eidiko_tx, 120, SpringLayout.WEST, this.panel);
        this.layout.putConstraint(SpringLayout.NORTH, this.eidiko_tx, 100, SpringLayout.NORTH, this.panel);
        this.layout.putConstraint(SpringLayout.SOUTH, this.eidiko_tx, 120, SpringLayout.NORTH, this.panel);
        
        this.layout.putConstraint(SpringLayout.WEST, this.etos, 6, SpringLayout.WEST, this.panel);
        this.layout.putConstraint(SpringLayout.NORTH, this.etos, 130, SpringLayout.NORTH, this.panel);
        this.layout.putConstraint(SpringLayout.WEST, this.etos_tx, 120, SpringLayout.WEST, this.panel);
        this.layout.putConstraint(SpringLayout.NORTH, this.etos_tx, 130, SpringLayout.NORTH, this.panel);
        this.layout.putConstraint(SpringLayout.SOUTH, this.etos_tx, 150, SpringLayout.NORTH, this.panel);
        
        this.layout.putConstraint(SpringLayout.WEST, this.orario, 280, SpringLayout.WEST, this.panel);
        this.layout.putConstraint(SpringLayout.NORTH, this.orario, 6, SpringLayout.NORTH, this.panel);
        this.layout.putConstraint(SpringLayout.WEST, this.orario_tx, 360, SpringLayout.WEST, this.panel);
        this.layout.putConstraint(SpringLayout.NORTH, this.orario_tx, 6, SpringLayout.NORTH, this.panel);
        this.layout.putConstraint(SpringLayout.SOUTH, this.orario_tx, 26, SpringLayout.NORTH, this.panel);
        
        this.layout.putConstraint(SpringLayout.WEST, this.prev, 100, SpringLayout.WEST, this.panel);
        this.layout.putConstraint(SpringLayout.NORTH, this.prev, 200, SpringLayout.NORTH, this.panel);
        
        this.layout.putConstraint(SpringLayout.WEST, this.calc, 190, SpringLayout.WEST, this.panel);
        this.layout.putConstraint(SpringLayout.NORTH, this.calc, 200, SpringLayout.NORTH, this.panel);
        
        this.layout.putConstraint(SpringLayout.WEST, this.next, 300, SpringLayout.WEST, this.panel);
        this.layout.putConstraint(SpringLayout.NORTH, this.next, 200, SpringLayout.NORTH, this.panel);
        
    }
    public void readFile() throws FileNotFoundException, IOException{
      FileReader file = new FileReader("data.txt");
      BufferedReader br = new BufferedReader(file);
      String line;
      String[] st;
      while(br.ready() && (line= br.readLine()) !=null){
        st = line.split("#");
        Employee emp = new Employee(st[0], st[1], st[2], st[3], Integer.parseInt(st[4]), Integer.parseInt(st[5]));
        this.data.add(emp);
      }
    }
    
    public void getCurrent(){
      this.name_tx.setText(data.get(current).getName());
      this.surname_tx.setText(data.get(current).getSurname());
      this.misthos_tx.setText(data.get(current).getMisthos());
      this.eidiko_tx.setText(data.get(current).getEidiko());
      this.etos_tx.setText(Integer.toString(data.get(current).getEtos()));
      this.orario_tx.setText(Integer.toString(data.get(current).getOrario()));
    }
        
    public void getPrev(){
      if(current == 0){
        this.prev.setVisible(false);
      }
      else{
        current--;
        this.getCurrent();
      }
    }
    public void getNext(){
      if(current == this.max){
        this.next.setVisible(false);
      }
      else{
        current++;
        this.getCurrent();
      }
    }
    
    //Ορισμός χαρακτηριστικών για τα Component
    public void prepareFrame(){
        this.panel.setSize(500, 400);
        this.panel.setLayout(this.layout);
       
        this.panel.add(this.name_lb);
        this.panel.add(this.name_tx);
        
        this.panel.add(this.surname);
        this.panel.add(this.surname_tx);
        
        this.panel.add(this.eidiko);
        this.panel.add(this.eidiko_tx);
        
        this.panel.add(misthos);
        this.panel.add(misthos_tx);
        
        this.panel.add(this.prev);
        this.panel.add(this.next);
        this.panel.add(this.calc);
        
        this.panel.add(this.etos);
        this.panel.add(this.etos_tx);
        
        this.panel.add(this.orario);
        this.panel.add(this.orario_tx);

        this.putConstr();

        this.add(this.panel);
        this.pack();

        this.setTitle("Employees");
        this.setLocationRelativeTo(null);
        
        this.setSize(500,400);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
        
        //Listener για το κουμπί της ακύρωσης
        this.prev.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
              next.setVisible(true);
              getPrev();
            }
        });
        
        this.next.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
              prev.setVisible(true);
              getNext();
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

            }
        });

        
        
    }

    //Μέθοδος για την κράτηση εισητηρίου, η οποία ελέγχεί όλα τα πεδία αν είναι κενά και αν δεν είναι τότε τα γράφει στο αρχείο
    public void Book() throws IOException{
        
    }
    //Καθαρίζει όλα τα πεδία του Frame
//    public void clearData(){
//        this.name_tx.setText("");
//        this.final_p.setText("");
//        this.cb_times.setSelectedIndex(0);
//        this.dis_tx.setText("");
//        this.cb_age.setSelectedIndex(0);
//        this.cost_tx.setText("");
//        this.code_tx.setText("");
//        this.cb_itin.setSelectedIndex(0);
//    }
    
    //Μέθοδος για κλείσιμο του συγκεκριμένου παραθύρου
    public void exit(){
       int i = JOptionPane.showConfirmDialog(MainFrame.this, "Do you want to cancel booking?");
        if (i == JOptionPane.YES_OPTION) {
            this.dispose();
        } 
    }
    
}