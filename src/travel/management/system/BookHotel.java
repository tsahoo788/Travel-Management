
package travel.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class BookHotel extends JFrame implements ActionListener
{
    String username;
    JLabel labeluser,idlb,labelnumber,labelphone,labelprice;
    Choice chotel,cac,cfood;
    JTextField persontf,daytf;
    JButton checkprice,bookpackage,back;

    public BookHotel(String username) {
        setBounds(220,100,1100,550);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel text = new JLabel("BOOK HOTEL");
        text.setBounds(100, 10, 200, 30);
        text.setFont(new Font("Tahoma",Font.BOLD,20));
        text.setForeground(Color.MAGENTA);
        add(text);
        
         JLabel lbuser = new JLabel("Username");
        lbuser.setFont(new Font("Tahoma",Font.PLAIN,15));
        lbuser.setBounds(40, 70, 100, 25);
        add(lbuser);
        
        labeluser = new JLabel();
        labeluser.setFont(new Font("Tahoma",Font.PLAIN,15));
        labeluser.setBounds(200, 70, 100, 25);
        add(labeluser);
        
        JLabel lbhotel = new JLabel("Select Hotel");
        lbhotel.setFont(new Font("Tahoma",Font.PLAIN,15));
        lbhotel.setBounds(40, 110, 150, 25);
        add(lbhotel);
        
        chotel=new Choice();
        chotel.setBounds(200, 110, 150, 25);
        add(chotel);
        
        try {
            DBConnection dc = new DBConnection();
            ResultSet rs = dc.s.executeQuery("select * from hotel");
            while (rs.next()) {
                chotel.add(rs.getString("name"));                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        JLabel lbperson = new JLabel("Total Person");
        lbperson.setFont(new Font("Tahoma",Font.PLAIN,15));
        lbperson.setBounds(40, 150, 100, 25);
        add(lbperson);
        
        persontf = new JTextField("1");
        persontf.setFont(new Font("Tahoma",Font.PLAIN,15));
        persontf.setBounds(200, 150, 150, 25);
        add(persontf);
        
        JLabel lbday = new JLabel("No. Of Days");
        lbday.setFont(new Font("Tahoma",Font.PLAIN,15));
        lbday.setBounds(40, 190, 100, 25);
        add(lbday);
        
        daytf = new JTextField("1");
        daytf.setFont(new Font("Tahoma",Font.PLAIN,15));
        daytf.setBounds(200, 190, 150, 25);
        add(daytf);
        
        JLabel lbac = new JLabel("AC / Non-AC");
        lbac.setFont(new Font("Tahoma",Font.PLAIN,15));
        lbac.setBounds(40, 230, 100, 25);
        add(lbac);
       
        cac=new Choice();
        cac.add("AC");
        cac.add("Non-AC");
        cac.setBounds(200, 230, 150, 25);
        add(cac);
        
        JLabel lbfood = new JLabel("Food Included");
        lbfood .setFont(new Font("Tahoma",Font.PLAIN,15));
        lbfood .setBounds(40, 270, 100, 25);
        add(lbfood );
       
         cfood=new Choice();
        cfood.add("Yes");
        cfood.add("No");
        cfood.setBounds(200, 270, 150, 25);
        add(cfood);
        
        JLabel lbid = new JLabel("Id");
        lbid.setFont(new Font("Tahoma",Font.PLAIN,15));
        lbid.setBounds(40, 310, 100, 25);
        add(lbid);
        
        idlb = new JLabel();
        idlb.setFont(new Font("Tahoma",Font.PLAIN,15));
        idlb.setBounds(200, 310, 150, 25);
        add(idlb);
        
         JLabel lbnumber = new JLabel("Number");
        lbnumber.setFont(new Font("Tahoma",Font.PLAIN,15));
        lbnumber.setBounds(40, 350, 100, 25);
        add(lbnumber);
       
        labelnumber = new JLabel();
        labelnumber.setFont(new Font("Tahoma",Font.PLAIN,15));
        labelnumber.setBounds(200, 350, 150, 25);
        add(labelnumber);
        
        JLabel lbphone = new JLabel("Phone");
        lbphone.setFont(new Font("Tahoma",Font.PLAIN,15));
        lbphone.setBounds(40, 390, 100, 25);
        add(lbphone);
       
        labelphone = new JLabel();
        labelphone.setFont(new Font("Tahoma",Font.PLAIN,15));
        labelphone.setBounds(200, 390, 150, 25);
        add(labelphone);
        
         JLabel lbpice = new JLabel("Total Price");
        lbpice.setFont(new Font("Tahoma",Font.PLAIN,15));
        lbpice.setBounds(40, 420, 100, 25);
        add(lbpice);
        
        labelprice = new JLabel();
        labelprice.setFont(new Font("Tahoma",Font.PLAIN,15));
        labelprice.setBounds(200, 420, 150, 25);
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
        checkprice.setBounds(60, 470, 120, 25);
        checkprice.addActionListener(this);
        add(checkprice);
        
        bookpackage=new JButton("Book Hotel");
        bookpackage.setBackground(Color.BLACK);
        bookpackage.setForeground(Color.WHITE);
        bookpackage.setBounds(200, 470, 120, 25);
        bookpackage.addActionListener(this);
        add(bookpackage);
        
        back=new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(340, 470, 120, 25);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/book.jpg"));
        Image i2 = i1.getImage().getScaledInstance(530, 450, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(500, 20, 530, 450);
        add(l1);
        
        setVisible(true);
    }
    
    
    public static void main(String[] args) {
        new BookHotel("riki12");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    
        if(e.getSource() == checkprice)
        {
            try{
            DBConnection dc = new DBConnection();
            ResultSet rs = dc.s.executeQuery("select * from hotel where name ='"+chotel.getSelectedItem()+"'");
            while(rs.next())
            {
                int cost = Integer.parseInt(rs.getString("costperperson"));
                int room = Integer.parseInt(rs.getString("acroom"));
                int food = Integer.parseInt(rs.getString("foodinclude"));
                
                int person = Integer.parseInt(persontf.getText());
                int days = Integer.parseInt(daytf.getText());
                
                String acselected = cac.getSelectedItem();
                String foodselected = cfood.getSelectedItem();
                
                if(person * days > 0)
                {
                    int total = 0;
                    total += acselected.equals("AC") ? room : 0;
                    total += foodselected.equals("Yes") ? food : 0;
                    total += cost;
                    total = total * person * days;
                    
                    labelprice.setText("Rs "+total);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Please enter a valid number");
                }
            }
            }catch(Exception ac)
            {
                ac.printStackTrace();
            }
        }
        
        else if(e.getSource() == bookpackage)
        {
            try {
                DBConnection dc = new DBConnection();
                dc.s.executeUpdate("insert into bookhotel values('"+labeluser.getText()+"', '"+chotel.getSelectedItem()+"' , '"+persontf.getText()+"' , '"+daytf.getText()+"','"+cac.getSelectedItem()+"' , '"+cfood.getSelectedItem()+"' , '"+idlb.getText()+"','"+labelnumber.getText()+"' , '"+labelphone.getText()+"','"+labelprice.getText()+"')");
                JOptionPane.showMessageDialog(null, "Hotel Booked Successfully");
                setVisible(false);
            } catch (Exception ac) {
                ac.printStackTrace();
            }
        }
        else
        {
            setVisible(false);
        }
     }
}
