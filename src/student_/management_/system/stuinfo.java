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
    private JLabel label, idLabel, firstNameLabel, lastNameLabel, phoneLabel;
    private JTextField tfId, tfName1, tfName2, tfPhone;
    private JButton addButton, updateButton, deleteButton, preAdvisingButton,txtButton;
    
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
         
         idLabel = new JLabel("Name   ");
         idLabel.setFont(font);
         idLabel.setBounds(10,80,140,30);
         c.add( idLabel);
         
         tfId = new JTextField();
         tfId.setFont(font);
         tfId.setBounds(110,80,200,30);
         c.add( tfId);
         
         addButton = new JButton("Add");
         addButton.setFont(font);
         addButton.setBounds(400,80,100,30);
         c.add( addButton);
         
         
         
         
         firstNameLabel = new JLabel("ID   ");
         firstNameLabel.setFont(font);
         firstNameLabel.setBounds(10,130,150,30);
         c.add( firstNameLabel);
         
         tfName1 = new JTextField();
         tfName1.setFont(font);
         tfName1.setBounds(110,130,200,30);
         c.add( tfName1);
         
         updateButton = new JButton("Update");
         updateButton.setFont(font);
         updateButton.setBounds(400,130,100,30);
         c.add( updateButton);
         
         
          lastNameLabel = new JLabel("Trimester   ");
         lastNameLabel.setFont(font);
         lastNameLabel.setBounds(10,180,150,30);
         c.add( lastNameLabel);
         
         tfName2 = new JTextField();
         tfName2.setFont(font);
         tfName2.setBounds(110,180,200,30);
         c.add( tfName2);
         
         deleteButton = new JButton("Delete");
         deleteButton.setFont(font);
         deleteButton.setBounds(400,180,100,30);
         c.add( deleteButton);
         
         
          phoneLabel = new JLabel("CGPA");
         phoneLabel.setFont(font);
         phoneLabel.setBounds(10,230,150,30);
         c.add( phoneLabel);
         
         tfPhone = new JTextField();
         tfPhone.setFont(font);
         tfPhone.setBounds(110,230,200,30);
         c.add( tfPhone);
         
         preAdvisingButton = new JButton("Clear");
         preAdvisingButton.setFont(font);
         preAdvisingButton.setBounds(400,230,100,30);
         c.add( preAdvisingButton);
         
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
         preAdvisingButton.addActionListener(this);
         deleteButton.addActionListener(this);
         updateButton.addActionListener(this);
         
        
         
         
          
         
         
          
   
         
         
         table.addMouseListener(new MouseAdapter (){
             
             public void mouseClicked(MouseEvent me){
             int numberOfRow =  table.getSelectedRow();
             
             
             String Name = model.getValueAt(numberOfRow, 0).toString();
                String ID = model.getValueAt(numberOfRow, 1).toString();
                String Trimester = model.getValueAt(numberOfRow, 2).toString();
                String CGPA = model.getValueAt(numberOfRow, 3).toString();
                 
                tfId.setText(Name);
                 tfName1.setText(ID);
                 tfName2 .setText(Trimester);
                  tfPhone .setText(CGPA);
                 
             }
             
             
       });
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
        
        
           
           
           
       }
     
       
       
        @Override
    public void actionPerformed(ActionEvent ae) {
     
        if(ae.getSource()==addButton){
            rows[0] =tfId.getText();
            rows[1] =tfName1.getText();
            rows[2] =tfName2.getText();
            rows[3] =tfPhone.getText();
            model.addRow(rows);
            
            
            
            
            
        }
    
        else  if(ae.getSource()==preAdvisingButton){
    
          tfId.setText(""); 
          tfName1.setText("");
          tfName2.setText("");
          tfPhone.setText("");
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
             
             String Name   = tfId.getText(); 
             String ID    =    tfName1.getText();
                String Trimester = tfName2.getText();
                   String CGPA =  tfPhone.getText();
                   
                   model.setValueAt(Name, numberOfRow, 0);
             model.setValueAt(ID, numberOfRow, 1);
             model.setValueAt(Trimester, numberOfRow, 2);
             model.setValueAt(CGPA, numberOfRow, 3);
            
        }
        
     
    }  
    
    
    
    
    
    
      
    

  
     
    
}
