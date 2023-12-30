package travel.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class ViewPackage extends JFrame implements ActionListener
{
    JButton back;

    public ViewPackage(String username) {
        setBounds(350, 150, 900, 450);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text = new JLabel("VIEW PACKAGE DETAILS");
        text.setFont(new Font("Tahoma",Font.BOLD,20));
        text.setBounds(60, 0, 300, 30);
        add(text);
        
        JLabel lbuser = new JLabel("Username");
        lbuser.setBounds(30, 50, 150, 25);
        add(lbuser);
        
        JLabel labeluser = new JLabel();
        labeluser.setBounds(190, 50, 150, 25);
        add(labeluser);
        
        JLabel lbpack = new JLabel("Package");
        lbpack.setBounds(30, 90, 150, 25);
        add(lbpack);
        
        JLabel labelpack = new JLabel();
        labelpack.setBounds(190, 90, 150, 25);
        add(labelpack);
        
        JLabel lbperson = new JLabel("Total Persons");
        lbperson.setBounds(30, 130, 150, 25);
        add(lbperson);
        
        JLabel labelperson = new JLabel();
        labelperson.setBounds(190, 130, 150, 25);
        add(labelperson);
        
         JLabel lbid = new JLabel("Id");
        lbid.setBounds(30, 170, 150, 25);
        add(lbid);
        
        JLabel labelid = new JLabel();
        labelid.setBounds(190, 170, 150, 25);
        add(labelid);
        
        JLabel lbnumber = new JLabel("Number");
        lbnumber.setBounds(30, 210, 150, 25);
        add(lbnumber);
        
        JLabel labelnumber = new JLabel();
        labelnumber.setBounds(190, 210, 150, 25);
        add(labelnumber);
        
        JLabel lbphone = new JLabel("Phone No");
        lbphone.setBounds(30, 250, 150, 25);
        add(lbphone);
        
        JLabel labelphone = new JLabel();
        labelphone.setBounds(190, 250, 150, 25);
        add(labelphone);
        
        JLabel lbprice = new JLabel("Price");
        lbprice.setBounds(30, 290, 150, 25);
        add(lbprice);
        
        JLabel labelprice = new JLabel();
        labelprice.setBounds(190, 290, 150, 25);
        add(labelprice);
        
        back=new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(110, 350, 100, 25);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/bookedDetails.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 20, 450, 350);
        add(image);
     
         try {
            DBConnection dc = new DBConnection();
            String query = "select * from bookpackage where username='"+username+"'";
            ResultSet rs = dc.s.executeQuery(query);
            while(rs.next())
            {
                labeluser.setText(rs.getString("username"));
                labelid.setText(rs.getString("id"));
                labelnumber.setText(rs.getString("number"));
                labelpack.setText(rs.getString("package"));
                labelprice.setText(rs.getString("price"));                
                labelphone.setText(rs.getString("phone"));
                labelperson.setText(rs.getString("persons"));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
    }
    
}
