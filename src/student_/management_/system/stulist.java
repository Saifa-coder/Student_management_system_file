package student_.management_.system;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import static java.awt.Font.BOLD;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;





/**
 *
 * @author tukku
 */
public class stulist extends JFrame implements ActionListener  {
    private JTable table;
    private JScrollPane scroll;
    private DefaultTableModel model;
    private Container c;
    private JLabel label, nameLabel, idLabel, phnLabel, deptLabel;
    private JTextField tfname, tfid, tfphn, tfdept;
    private JButton addButton, updateButton, deleteButton, clearButton,txtButton;
    
    private String[] columns = {"Name","ID","PHONE","DEPARTMENT"};
    
    private String[] rows = new String[4];
    
       
       stulist(){
           initComponents();
       }
       
       public void initComponents(){
         
           this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           this.setSize(780,690);
           this.setLocationRelativeTo(null);
           this.setTitle("Student Management System");
           
            c = this.getContentPane();//assign to JFrame content pane in container object 
        c.setLayout(null);
         c.setBackground(Color.WHITE);
         
         Font font = new Font("Arial",BOLD,16);
         
         label = new JLabel("Student List");
         label.setFont(font);
         label.setBounds(140,10,250,50);
         c.add( label);
         
         nameLabel = new JLabel("Name   ");
         nameLabel.setFont(font);
         nameLabel.setBounds(10,80,140,30);
         c.add( nameLabel);
         
         tfname = new JTextField();
         tfname.setFont(font);
         tfname.setBounds(110,80,200,30);
         c.add( tfname);
         
         addButton = new JButton("Add");
         addButton.setFont(font);
         addButton.setBounds(400,80,100,30);
         c.add( addButton);
         
         
         
         
         idLabel = new JLabel("ID   ");
         idLabel.setFont(font);
         idLabel.setBounds(10,130,150,30);
         c.add( idLabel);
         
         tfid = new JTextField();
         tfid.setFont(font);
         tfid.setBounds(110,130,200,30);
         c.add( tfid);
         
         updateButton = new JButton("Update");
         updateButton.setFont(font);
         updateButton.setBounds(400,130,100,30);
         c.add( updateButton);
         
         
          phnLabel = new JLabel("Phone   ");
         phnLabel.setFont(font);
         phnLabel.setBounds(10,180,150,30);
         c.add( phnLabel);
         
         tfphn = new JTextField();
         tfphn.setFont(font);
         tfphn.setBounds(110,180,200,30);
         c.add( tfphn);
         
         deleteButton = new JButton("Delete");
         deleteButton.setFont(font);
         deleteButton.setBounds(400,180,100,30);
         c.add( deleteButton);
         
         
          deptLabel = new JLabel("Department");
         deptLabel.setFont(font);
         deptLabel.setBounds(10,230,150,30);
         c.add( deptLabel);
         
         tfdept = new JTextField();
         tfdept.setFont(font);
         tfdept.setBounds(110,230,200,30);
         c.add( tfdept);
         
         clearButton = new JButton("Clear");
         clearButton.setFont(font);
         clearButton.setBounds(400,230,100,30);
         c.add( clearButton);
         
         
          txtButton = new JButton("Save");
         txtButton.setFont(font);
         txtButton.setBounds(655,290,100,30);
         c.add( txtButton);
         
          txtButton.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e){
               try{
                //the file path
               File file = new File("Student List.txt");
               //if the file not exist create one
               if(!file.exists()){
                   file.createNewFile();
               }
               
               FileWriter fw = new FileWriter(file.getAbsoluteFile());
               BufferedWriter bw = new BufferedWriter(fw);
               
               //loop for jtable rows
               for(int i = 0; i < table.getRowCount(); i++){
                   //loop for jtable column
                   for(int j = 0; j < table.getColumnCount(); j++){
                       bw.write(table.getModel().getValueAt(i, j)+" ");
                   }
                   //break line at the begin 
                   //break line at the end 
                   bw.write("\n_________\n");
               }
               //close BufferedWriter
               bw.close();
               //close FileWriter 
               fw.close();
               JOptionPane.showMessageDialog(null, "Data Exported");
               
               }catch(Exception ex){
                   ex.printStackTrace();
               }
           }
        });
         
         
         table = new JTable();
         model = new DefaultTableModel();
         model.setColumnIdentifiers(columns);
         table.setModel(model);
         table.setFont(font);
         table.setSelectionBackground(Color.yellow);
         table.setBackground(Color.WHITE);
         table.setRowHeight(30);
         
         scroll = new JScrollPane(table);
         scroll.setBounds(10, 360, 740, 265);
         c.add(scroll);
         
         addButton.addActionListener(this);
         clearButton.addActionListener(this);
         deleteButton.addActionListener(this);
         updateButton.addActionListener(this);
         
         
         table.addMouseListener(new MouseAdapter (){
             
             public void mouseClicked(MouseEvent me){
             int numberOfRow =  table.getSelectedRow();
             
             
             String Name = model.getValueAt(numberOfRow, 0).toString();
                String ID = model.getValueAt(numberOfRow, 1).toString();
                String Phone = model.getValueAt(numberOfRow, 2).toString();
                String Department = model.getValueAt(numberOfRow, 3).toString();
                 
                tfname.setText(Name);
                 tfid.setText(ID);
                 tfphn.setText(Phone);
                  tfdept.setText(Department);
                 
             }
       });
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
        
        
           
           
           
       }
       
        @Override
    public void actionPerformed(ActionEvent ae) {
     
        if(ae.getSource()==addButton){
            rows[0] =tfname.getText();
            rows[1] =tfid.getText();
            rows[2] =tfphn.getText();
            rows[3] =tfdept.getText();
            model.addRow(rows);
            
            
            
            
            
        }
    
        else  if(ae.getSource()==clearButton){
    
          tfname.setText(""); 
          tfid.setText("");
          tfphn.setText("");
          tfdept.setText("");
    }
        else if(ae.getSource() == deleteButton){
          int numberOfRow =  table.getSelectedRow();
          
          if(numberOfRow>=0){
              model.removeRow(numberOfRow);
          }
          else{
              JOptionPane.showMessageDialog(null,"Select any row!");
          }
          
        }
       
        else if(ae.getSource() == updateButton){
             int numberOfRow =  table.getSelectedRow();
             
             String Name   = tfname.getText(); 
             String ID    =    tfid.getText();
                String Phone = tfphn.getText();
                   String Department =  tfdept.getText();
                   
                   model.setValueAt(Name, numberOfRow, 0);
             model.setValueAt(ID, numberOfRow, 1);
             model.setValueAt(Phone, numberOfRow, 2);
             model.setValueAt(Department, numberOfRow, 3);
            
        }
        
     
    }

   
     
    
}
