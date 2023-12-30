package travel.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class ViewBookedHotel extends JFrame implements ActionListener
{
    JButton back;

    public ViewBookedHotel(String username) {
        setBounds(300, 70, 1000, 600);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text = new JLabel("VIEW BOOKED HOTEL DETAILS");
        text.setFont(new Font("Tahoma",Font.BOLD,20));
        text.setBounds(60, 0, 400, 30);
        add(text);
        
        JLabel lbuser = new JLabel("Username");
        lbuser.setBounds(30, 50, 150, 25);
        add(lbuser);
        
        JLabel labeluser = new JLabel();
        labeluser.setBounds(190, 50, 150, 25);
        add(labeluser);
        
        JLabel lbhname = new JLabel("Hotel Name");
        lbhname.setBounds(30, 90, 150, 25);
        add(lbhname);
        
        JLabel labelhname = new JLabel();
        labelhname.setBounds(190, 90, 150, 25);
        add(labelhname);
        
        JLabel lbperson = new JLabel("Total Persons");
        lbperson.setBounds(30, 130, 150, 25);
        add(lbperson);
        
        JLabel labelperson = new JLabel();
        labelperson.setBounds(190, 130, 150, 25);
        add(labelperson);
        
        JLabel lbday = new JLabel("Total Days");
        lbday.setBounds(30, 170, 150, 25);
        add(lbday);
        
        JLabel labelday = new JLabel();
        labelday.setBounds(190, 170, 150, 25);
        add(labelday);
        
        JLabel lbac = new JLabel("AC / Non-AC");
        lbac.setBounds(30, 210, 150, 25);
        add(lbac);
        
        JLabel labelac = new JLabel();
        labelac.setBounds(190, 210, 150, 25);
        add(labelac);
        
        JLabel lbfood = new JLabel("Food Included");
        lbfood.setBounds(30, 250, 150, 25);
        add(lbfood);
        
        JLabel labelfood = new JLabel();
        labelfood.setBounds(190, 250, 150, 25);
        add(labelfood);
               
        JLabel lbid = new JLabel("Id");
        lbid.setBounds(30, 290, 150, 25);
        add(lbid);
        
        JLabel labelid = new JLabel();
        labelid.setBounds(190, 290, 150, 25);
        add(labelid);
        
        JLabel lbnumber = new JLabel("Number");
        lbnumber.setBounds(30, 330, 150, 25);
        add(lbnumber);
        
        JLabel labelnumber = new JLabel();
        labelnumber.setBounds(190, 330, 150, 25);
        add(labelnumber);
        
        JLabel lbphone = new JLabel("Phone No");
        lbphone.setBounds(30, 370, 150, 25);
        add(lbphone);
        
        JLabel labelphone = new JLabel();
        labelphone.setBounds(190, 370, 150, 25);
        add(labelphone);
        
        JLabel lbprice = new JLabel("Price");
        lbprice.setBounds(30, 410, 150, 25);
        add(lbprice);
        
        JLabel labelprice = new JLabel();
        labelprice.setBounds(190, 410, 150, 25);
        add(labelprice);
        
        back=new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(110, 500, 100, 25);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/bookedDetails.jpg"));
        Image i2 = i1.getImage().getScaledInstance(520, 500, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(420, 25, 520, 500);
        add(image);
     
         try {
            DBConnection dc = new DBConnection();
            String query = "select * from bookhotel where username='"+username+"'";
            ResultSet rs = dc.s.executeQuery(query);
            while(rs.next())
            {
                labeluser.setText(rs.getString("username"));
                labelhname.setText(rs.getString("name"));
                labelperson.setText(rs.getString("persons"));
                labelday.setText(rs.getString("days"));
                labelac.setText(rs.getString("room"));
                labelfood.setText(rs.getString("food"));
                labelid.setText(rs.getString("id"));
                labelnumber.setText(rs.getString("number"));
                labelphone.setText(rs.getString("phone"));
                labelprice.setText(rs.getString("price"));               
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
