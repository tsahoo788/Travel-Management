
package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class AddCustomer extends JFrame implements ActionListener
{
    JLabel labelbuser,labelname;
    JComboBox comboid;
    JTextField tfnum,tfcountry,tfaddress,tfphone,tfmail;
    JRadioButton rmale,rfemale;
    JButton add,back;
    
    public AddCustomer(String username) 
    {
        setBounds(370, 100, 850, 520);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel lbuser = new JLabel("Username");
        lbuser.setBounds(30, 40, 150, 25);
        add(lbuser);
        
        labelbuser = new JLabel();
        labelbuser.setBounds(220, 40, 150, 25);
        add(labelbuser);
        
        JLabel lbid = new JLabel("Id");
        lbid.setBounds(30, 80, 150, 25);
        add(lbid);
        
        comboid = new JComboBox(new String[] {"Passport Id","Aadhar Card","Voter Id","Licence Id"});
        comboid.setBounds(220, 80, 150, 25);
        comboid.setBackground(Color.WHITE);
        add(comboid);
        
        JLabel lbidnum = new JLabel("Id Number");
        lbidnum.setBounds(30, 120, 150, 25);
        add(lbidnum);
        
        tfnum = new JTextField();
        tfnum.setBounds(220, 120, 150, 25);
        add(tfnum);
        
        JLabel lbname = new JLabel("Name");
        lbname.setBounds(30, 160, 150, 25);
        add(lbname);
        
        labelname = new JLabel();
        labelname.setBounds(220, 160, 150, 25);
        add(labelname);
        
        JLabel lbgender = new JLabel("Gender");
        lbgender.setBounds(30, 200, 150, 25);
        add(lbgender);
        
        rmale = new JRadioButton("Male");
        rmale.setBounds(220, 200, 70, 20);
        rmale.setBackground(Color.WHITE);
        add(rmale);
        
        rfemale = new JRadioButton("Female");
        rfemale.setBounds(290, 200, 70, 20);
        rfemale.setBackground(Color.WHITE);
        add(rfemale);
        
        ButtonGroup bg = new ButtonGroup();
        bg.add(rmale);
        bg.add(rfemale);
        
        JLabel lbcountry = new JLabel("Country");
        lbcountry.setBounds(30, 240, 150, 25);
        add(lbcountry);
        
        tfcountry = new JTextField();
        tfcountry.setBounds(220, 240, 150, 25);
        add(tfcountry);
        
        JLabel lbaddress = new JLabel("Address");
        lbaddress.setBounds(30, 280, 150, 25);
        add(lbaddress);
        
        tfaddress = new JTextField();
        tfaddress.setBounds(220, 280, 150, 25);
        add(tfaddress);
        
        JLabel lbphone = new JLabel("Phone");
        lbphone.setBounds(30, 320, 150, 25);
        add(lbphone);
        
        tfphone = new JTextField();
        tfphone.setBounds(220, 320, 150, 25);
        add(tfphone);
        
        JLabel lbmail = new JLabel("Email");
        lbmail.setBounds(30, 360, 150, 25);
        add(lbmail);
        
        tfmail = new JTextField();
        tfmail.setBounds(220, 360, 150, 25);
        add(tfmail);
        
        add=new JButton("Add");
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.setBounds(80, 410, 100, 25);
        add.addActionListener(this);
        add(add);
        
        back=new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(230, 410, 100, 25);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/newcustomer.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400, 500, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(390, 20, 450, 420);
        add(image);
        
        try        
        {
            DBConnection dc = new DBConnection();
            ResultSet rs = dc.s.executeQuery("select * from account where username = '"+username+"'");
            while(rs.next())
            {
                labelbuser.setText(rs.getString("username"));
                labelname.setText(rs.getString("name"));
            }
        }catch(Exception e){
        e.printStackTrace();
        }
        
        
        setVisible(true);
    }
    
     @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==add)
        {
            String username = labelbuser.getText();
            String id = (String)comboid.getSelectedItem();
            String number = tfnum.getText();
            String name = labelname.getText();
            String gender = null;
            if(rmale.isSelected())
            {
                gender = "Male";
            }
            else
            {
                gender = "Female";
            }
            String country = tfcountry.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String mail = tfmail.getText();
            
            try {
                DBConnection dc = new DBConnection();
                String query="insert into customerdetails values('"+username+"', '"+id+"','"+number+"','"+name+"','"+gender+"','"+country+"','"+address+"','"+phone+"','"+mail+"')";
                dc.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, "Customer Details Added Successfully");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        }
        else
        {
            setVisible(false);
        }
    }
}
