
package travel.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class BookPackage extends JFrame implements ActionListener{

    JLabel labeluser,idlb,labelnumber,labelphone,labelprice;
    Choice cPack;
    JTextField persontf;
    String username;
    JButton checkprice,bookpackage,back;
    
    public BookPackage(String username) {
        this.username=username;
        setBounds(200,150,1100,500);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel text = new JLabel("BOOK PACKAGE");
        text.setBounds(100, 10, 200, 30);
        text.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(text);
        
        JLabel lbuser = new JLabel("Username");
        lbuser.setFont(new Font("Tahoma",Font.PLAIN,15));
        lbuser.setBounds(40, 70, 100, 25);
        add(lbuser);
        
        labeluser = new JLabel();
        labeluser.setFont(new Font("Tahoma",Font.PLAIN,15));
        labeluser.setBounds(200, 70, 100, 25);
        add(labeluser);
        
        JLabel lbpack = new JLabel("Select Package");
        lbpack.setFont(new Font("Tahoma",Font.PLAIN,15));
        lbpack.setBounds(40, 110, 150, 25);
        add(lbpack);
        
        cPack=new Choice();
        cPack.add("Gold Package");
        cPack.add("Silver Package");
        cPack.add("Bronze Package");
        cPack.setBounds(200, 110, 150, 25);
        add(cPack);
        
        JLabel lbperson = new JLabel("Total Person");
        lbperson.setFont(new Font("Tahoma",Font.PLAIN,15));
        lbperson.setBounds(40, 150, 100, 25);
        add(lbperson);
        
        persontf = new JTextField("1");
        persontf.setFont(new Font("Tahoma",Font.PLAIN,15));
        persontf.setBounds(200, 150, 150, 25);
        add(persontf);
        
        JLabel lbid = new JLabel("Id");
        lbid.setFont(new Font("Tahoma",Font.PLAIN,15));
        lbid.setBounds(40, 190, 100, 25);
        add(lbid);
        
        idlb = new JLabel();
        idlb.setFont(new Font("Tahoma",Font.PLAIN,15));
        idlb.setBounds(200, 190, 150, 25);
        add(idlb);
        
         JLabel lbnumber = new JLabel("Number");
        lbnumber.setFont(new Font("Tahoma",Font.PLAIN,15));
        lbnumber.setBounds(40, 230, 100, 25);
        add(lbnumber);
       
        labelnumber = new JLabel();
        labelnumber.setFont(new Font("Tahoma",Font.PLAIN,15));
        labelnumber.setBounds(200, 230, 150, 25);
        add(labelnumber);
        
        JLabel lbphone = new JLabel("Phone");
        lbphone.setFont(new Font("Tahoma",Font.PLAIN,15));
        lbphone.setBounds(40, 270, 100, 25);
        add(lbphone);
       
        labelphone = new JLabel();
        labelphone.setFont(new Font("Tahoma",Font.PLAIN,15));
        labelphone.setBounds(200, 270, 150, 25);
        add(labelphone);
        
        JLabel lbpice = new JLabel("Total Price");
        lbpice.setFont(new Font("Tahoma",Font.PLAIN,15));
        lbpice.setBounds(40, 310, 100, 25);
        add(lbpice);
        
        labelprice = new JLabel();
        labelprice.setFont(new Font("Tahoma",Font.PLAIN,15));
        labelprice.setBounds(200, 310, 150, 25);
        add(labelprice);
        
        
         try {
            DBConnection dc = new DBConnection();
            String query = "select * from customerdetails where username='"+username+"'";
            ResultSet rs = dc.s.executeQuery(query);
            while(rs.next())
            {
                labeluser.setText(rs.getString("username"));
                idlb.setText(rs.getString("id"));
                labelnumber.setText(rs.getString("number"));
                labelphone.setText(rs.getString("phone"));
               
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        checkprice = new JButton("Check Price");
        checkprice.setBackground(Color.BLACK);
        checkprice.setForeground(Color.WHITE);
        checkprice.setBounds(60, 380, 120, 25);
        checkprice.addActionListener(this);
        add(checkprice);
        
        bookpackage=new JButton("Book Package");
        bookpackage.setBackground(Color.BLACK);
        bookpackage.setForeground(Color.WHITE);
        bookpackage.setBounds(200, 380, 120, 25);
        bookpackage.addActionListener(this);
        add(bookpackage);
        
        back=new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(340, 380, 120, 25);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/bookpackage.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(550, 20, 500, 400);
        add(l1);
         
        
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if(ae.getSource() == bookpackage)
        {
            try {
                DBConnection dc = new DBConnection();
                dc.s.executeUpdate("insert into bookpackage values('"+labeluser.getText()+"' , '"+cPack.getSelectedItem()+"' , '"+persontf.getText()+"' , '"+idlb.getText()+"' , '"+labelnumber.getText()+"' , '"+labelphone.getText()+"' , '"+labelprice.getText()+"')");
                
                JOptionPane.showMessageDialog(null, "Package Booked Successfully");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        }
        else if(ae.getSource() == checkprice)
        {
            String pack = cPack.getSelectedItem();
            int cost=0;
            if(pack.equals("Gold Package"))
            {
                cost += 30000;
            }
            else if(pack.equals("Silver Package"))
            {
                cost += 25000;
            }
            else
                cost += 20000;
            
            int persons = Integer.parseInt(persontf.getText());
            cost *= persons;
            labelprice.setText("Rs "+cost);
        }
        else
            setVisible(false);
        
    }
    
}
