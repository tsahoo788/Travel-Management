
package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateCustomerDetails extends JFrame implements ActionListener {

    JLabel labelbuser,labelname;
    JTextField tfnum,tfcountry,tfaddress,tfphone,tfmail,tfid,tfgender;
    JButton add,back;
    
    public UpdateCustomerDetails(String username) {
        setBounds(370, 100, 850, 520);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel text = new JLabel("UPDATE  CUSTOMER  DETAILS");
        text.setBounds(250, 20, 500, 25);
        text.setFont(new Font("Raleway",Font.BOLD,20));
        add(text);
        
        JLabel lbuser = new JLabel("Username");
        lbuser.setBounds(30, 70, 150, 25);
        add(lbuser);
        
        labelbuser = new JLabel();
        labelbuser.setBounds(220, 70, 150, 25);
        add(labelbuser);
        
        JLabel lbid = new JLabel("Id");
        lbid.setBounds(30, 110, 150, 25);
        add(lbid);
        
         tfid = new JTextField();
        tfid.setBounds(220, 110, 150, 25);
        add(tfid);
        
        JLabel lbidnum = new JLabel("Id Number");
        lbidnum.setBounds(30, 150, 150, 25);
        add(lbidnum);
        
        tfnum = new JTextField();
        tfnum.setBounds(220, 150, 150, 25);
        add(tfnum);
        
        JLabel lbname = new JLabel("Name");
        lbname.setBounds(30, 190, 150, 25);
        add(lbname);
        
        labelname = new JLabel();
        labelname.setBounds(220, 190, 150, 25);
        add(labelname);
        
        JLabel lbgender = new JLabel("Gender");
        lbgender.setBounds(30, 230, 150, 25);
        add(lbgender);
        
        tfgender = new JTextField();
        tfgender.setBounds(220, 230, 150, 25);
        add(tfgender);
        
        JLabel lbcountry = new JLabel("Country");
        lbcountry.setBounds(30, 270, 150, 25);
        add(lbcountry);
        
        tfcountry = new JTextField();
        tfcountry.setBounds(220, 270, 150, 25);
        add(tfcountry);
        
        JLabel lbaddress = new JLabel("Address");
        lbaddress.setBounds(30, 310, 150, 25);
        add(lbaddress);
        
        tfaddress = new JTextField();
        tfaddress.setBounds(220, 310, 150, 25);
        add(tfaddress);
        
        JLabel lbphone = new JLabel("Phone");
        lbphone.setBounds(30, 350, 150, 25);
        add(lbphone);
        
        tfphone = new JTextField();
        tfphone.setBounds(220, 350, 150, 25);
        add(tfphone);
        
        JLabel lbmail = new JLabel("Email");
        lbmail.setBounds(30, 390, 150, 25);
        add(lbmail);
        
        tfmail = new JTextField();
        tfmail.setBounds(220, 390, 150, 25);
        add(tfmail);
        
        add=new JButton("Update");
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.setBounds(80, 440, 100, 25);
        add.addActionListener(this);
        add(add);
        
        back=new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(230, 440, 100, 25);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/update.png"));
        Image i2 = i1.getImage().getScaledInstance(250, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(480, 50, 250, 400);
        add(image);
        
        try        
        {
            DBConnection dc = new DBConnection();
            ResultSet rs = dc.s.executeQuery("select * from customerdetails where username = '"+username+"'");
            while(rs.next())
            {
                labelbuser.setText(rs.getString("username"));
                labelname.setText(rs.getString("name"));
                tfid.setText(rs.getString("id"));
                tfnum.setText(rs.getString("number"));
                tfgender.setText(rs.getString("gender"));
                tfcountry.setText(rs.getString("country"));
                tfaddress.setText(rs.getString("address"));
                tfphone.setText(rs.getString("phone"));
                tfmail.setText(rs.getString("email"));
            }
        }catch(Exception e){
        e.printStackTrace();
        }
        
        
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==add)
        {
            String username = labelbuser.getText();
            String id = tfid.getText();
            String number = tfnum.getText();
            String name = labelname.getText();
            String gender = tfgender.getText(); 
            String country = tfcountry.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String mail = tfmail.getText();
            
            try {
                DBConnection dc = new DBConnection();
                String query="update customerdetails set username='"+username+"', id = '"+id+"',number='"+number+"',name = '"+name+"',gender='"+gender+"',country='"+country+"',address='"+address+"',phone='"+phone+"',email='"+mail+"'";
                dc.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, "Update Details Added Successfully");
                setVisible(false);
            } catch (Exception ae) {
                ae.printStackTrace();
            }
            
        }
        else
        {
            setVisible(false);
        }
    }

}
