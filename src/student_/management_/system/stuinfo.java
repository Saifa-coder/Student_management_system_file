 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student_.management_.system;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import static java.awt.Font.BOLD;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.io.File;
import java.io.BufferedWriter;
import java.io.FileWriter;





/**
 *
 * @author tukku
 */
public class stuinfo extends JFrame implements ActionListener  {
    private JTable table;
    private JScrollPane scroll;
    private DefaultTableModel model;
    private Container c;
    private JLabel label, nameLabel, idLabel, triLabel, cgLabel;
    private JTextField tfname, tfid, tftri, tfcg;
    private JButton addButton, updateButton, deleteButton, clearButton,txtButton;
    
    private String[] columns = {"Name","ID","TRIMESTER","CGPA"};
    
    private String[] rows = new String[4];
    
    
       
       stuinfo(){
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
         
         label = new JLabel("Student Info");
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
         
         
          triLabel = new JLabel("Trimester   ");
         triLabel.setFont(font);
         triLabel.setBounds(10,180,150,30);
         c.add( triLabel);
         
         tftri= new JTextField();
         tftri.setFont(font);
         tftri.setBounds(110,180,200,30);
         c.add( tftri);
         
         deleteButton = new JButton("Delete");
         deleteButton.setFont(font);
         deleteButton.setBounds(400,180,100,30);
         c.add( deleteButton);
         
         
          cgLabel = new JLabel("CGPA");
         cgLabel.setFont(font);
         cgLabel.setBounds(10,230,150,30);
         c.add( cgLabel);
         
         tfcg = new JTextField();
         tfcg.setFont(font);
         tfcg.setBounds(110,230,200,30);
         c.add( tfcg);
         
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
               File file = new File("Student Info.txt");
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
                String Trimester = model.getValueAt(numberOfRow, 2).toString();
                String CGPA = model.getValueAt(numberOfRow, 3).toString();
                 
                tfname.setText(Name);
                 tfid.setText(ID);
                 tftri.setText(Trimester);
                  tfcg .setText(CGPA);
                 
             }
             
             
       });
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
        
        
           
           
           
       }
     
       
       
        @Override
    public void actionPerformed(ActionEvent ae) {
     
        if(ae.getSource()==addButton){
            rows[0] =tfname.getText();
            rows[1] =tfid.getText();
            rows[2] =tftri.getText();
            rows[3] =tfcg.getText();
            model.addRow(rows);
            
            
            
            
            
        }
    
        else  if(ae.getSource()==clearButton){
    
          tfname.setText(""); 
          tfid.setText("");
          tftri.setText("");
          tfcg.setText("");
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
                String Trimester = tftri.getText();
                   String CGPA =  tfcg.getText();
                   
                   model.setValueAt(Name, numberOfRow, 0);
             model.setValueAt(ID, numberOfRow, 1);
             model.setValueAt(Trimester, numberOfRow, 2);
             model.setValueAt(CGPA, numberOfRow, 3);
            
        }
        
     
    }  
    
    
    
    
    
    
      
    

  
     
    
}
