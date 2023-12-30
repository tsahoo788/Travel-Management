package travel.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class DeleteDetails extends JFrame implements ActionListener
{
    JButton back;
    String username;
    public DeleteDetails(String username) {
        this.username=username;
        setBounds(350, 70, 870, 600);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel lbuser = new JLabel("Username");
        lbuser.setBounds(30, 50, 150, 25);
        add(lbuser);
        
        JLabel labeluser = new JLabel();
        labeluser.setBounds(190, 50, 150, 25);
        add(labeluser);
        
        JLabel lbid = new JLabel("Id");
        lbid.setBounds(30, 100, 150, 25);
        add(lbid);
        
        JLabel labelid = new JLabel();
        labelid.setBounds(190, 100, 150, 25);
        add(labelid);
        
        JLabel lbnumber = new JLabel("Number");
        lbnumber.setBounds(30, 150, 150, 25);
        add(lbnumber);
        
        JLabel labelnumber = new JLabel();
        labelnumber.setBounds(190, 150, 150, 25);
        add(labelnumber);
        
        JLabel lbname = new JLabel("Name");
        lbname.setBounds(30, 200, 150, 25);
        add(lbname);
        
        JLabel labelname = new JLabel();
        labelname.setBounds(190, 200, 150, 25);
        add(labelname);
        
        JLabel lbgender = new JLabel("Gender");
        lbgender.setBounds(30, 250, 150, 25);
        add(lbgender);
        
        JLabel labelgender = new JLabel();
        labelgender.setBounds(190, 250, 150, 25);
        add(labelgender);
        
        JLabel lbcountry = new JLabel("Country");
        lbcountry.setBounds(420, 50, 150, 25);
        add(lbcountry);
        
        JLabel labelcountry = new JLabel();
        labelcountry.setBounds(600, 50, 150, 25);
        add(labelcountry);
        
        JLabel lbadd = new JLabel("Address");
        lbadd.setBounds(420, 100, 150, 25);
        add(lbadd);
        
        JLabel labeladd = new JLabel();
        labeladd.setBounds(600, 100, 150, 25);
        add(labeladd);
        
        JLabel lbphno = new JLabel("Phno");
        lbphno.setBounds(420, 150, 150, 25);
        add(lbphno);
        
        JLabel labelphno = new JLabel();
        labelphno.setBounds(600, 150, 150, 25);
        add(labelphno);
        
        JLabel lbemail = new JLabel("Email");
        lbemail.setBounds(420, 200, 150, 25);
        add(lbemail);
        
        JLabel labelemail = new JLabel();       
        labelemail.setBounds(600, 200, 150, 25);
        add(labelemail);
        
        back=new JButton("Delete");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(320, 300, 100, 25);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/viewall.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(10, 350, 600, 200);
        add(image);
        
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("Icons/viewall.jpg"));
        Image i5 = i4.getImage().getScaledInstance(600, 200, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image1 = new JLabel(i6);
        image1.setBounds(595, 350, 600, 200);
        add(image1);
        
        try {
            DBConnection dc = new DBConnection();
            String query = "select * from customerdetails where username='"+username+"'";
            ResultSet rs = dc.s.executeQuery(query);
            while(rs.next())
            {
                labeluser.setText(rs.getString("username"));
                labelid.setText(rs.getString("id"));
                labelnumber.setText(rs.getString("number"));
                labelname.setText(rs.getString("name"));
                labelgender.setText(rs.getString("gender"));
                labelcountry.setText(rs.getString("country"));
                labeladd.setText(rs.getString("address"));
                labelphno.setText(rs.getString("phone"));
                labelemail.setText(rs.getString("email"));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        setVisible(true);
    }
    
    
    
   

    @Override
    public void actionPerformed(ActionEvent ae) {
        try {
            DBConnection dc = new DBConnection();
            dc.s.executeUpdate("delete from account where username = '"+username+"'");
            dc.s.executeUpdate("delete from customerdetails where username = '"+username+"'");
            dc.s.executeUpdate("delete from bookhotel where username = '"+username+"'");
            dc.s.executeUpdate("delete from bookpackage where username = '"+username+"'");
            
            JOptionPane.showMessageDialog(null, "Data Deleted Successfully");
            
            System.exit(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
