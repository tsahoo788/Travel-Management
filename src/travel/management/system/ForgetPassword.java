package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class ForgetPassword extends JFrame implements ActionListener{

    JTextField tfuser,tfname,tfanswer,tfpass,tfquestion;
    JButton search,retrieve,back;
    Choice security;
    
    public ForgetPassword() 
    {
        setBounds(350,200,850,400);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/forgotpassword.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(580,70,200,200);
        add(image);
        
        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBounds(30, 30, 500, 280);
        add(p1);
        
        JLabel lbuser = new JLabel("Username");
        lbuser.setBounds(40, 20, 100, 25);
        lbuser.setFont(new Font("Tahoma",Font.BOLD,15));
        p1.add(lbuser);
        
        tfuser=new JTextField();
        tfuser.setBounds(200, 20, 180, 25);
        tfuser.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfuser);
        
        search = new JButton("Search");
        search.setBackground(Color.GRAY);
        search.setForeground(Color.WHITE);
        search.setBounds(390, 20, 100, 25);
        search.addActionListener(this);
        p1.add(search);
        
        JLabel name = new JLabel("Name");
        name.setBounds(40, 60, 100, 25);
        name.setFont(new Font("Tahoma",Font.BOLD,15));
        p1.add(name);
        
        tfname=new JTextField();
        tfname.setBounds(200, 60, 180, 25);
        tfname.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfname);
        
        JLabel lbquestion = new JLabel("Hints");
        lbquestion.setBounds(40, 100, 100, 25);
        lbquestion.setFont(new Font("Tahoma",Font.BOLD,12));
        p1.add(lbquestion);
        
        security = new Choice();
        security.add("Fav Marvel superhero");
        security.add("Your lucky number");
        security.add("Your childhood superhero");
        security.setBounds(200, 100, 180, 25);
        p1.add(security);
        
        JLabel lbanswer = new JLabel("Answer");
        lbanswer.setBounds(40, 140, 100, 25);
        lbanswer.setFont(new Font("Tahoma",Font.BOLD,15));
        p1.add(lbanswer);
        
        tfanswer = new JTextField();
        tfanswer.setBounds(200, 140, 180, 25);
        tfanswer.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfanswer);
        
        retrieve = new JButton("Retrieve");
        retrieve.setBackground(Color.GRAY);
        retrieve.setForeground(Color.WHITE);
        retrieve.setBounds(390, 140, 100, 25);
        retrieve.addActionListener(this);
        p1.add(retrieve);
        
        JLabel lbpass = new JLabel("password");
        lbpass.setBounds(40, 180, 100, 25);
        lbpass.setFont(new Font("Tahoma",Font.BOLD,15));
        p1.add(lbpass);
        
        tfpass = new JTextField();
        tfpass.setBounds(200, 180, 180, 25);
        tfpass.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfpass);
        
        back = new JButton("Back");
        back.setBackground(Color.GRAY);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        back.setBounds(130, 240, 100, 25);
        p1.add(back);
        
        setVisible(true);
        
    }
    
    
    
    
    public static void main(String[] args) {
        new ForgetPassword();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
    
        if(e.getSource()== search)
        {
            try{
                String query = "select * from account where username = '"+tfuser.getText()+"'";
                DBConnection dc = new DBConnection();
                
                ResultSet rs =dc.s.executeQuery(query);
                while(rs.next())
                {
                    tfname.setText(rs.getString("name"));
                }
            }catch(Exception ee)
            {
                ee.printStackTrace();
            }
            
        }
        else if(e.getSource() == retrieve)
        {
             try{
                String query = "select * from account where answer = '"+tfanswer.getText()+"'and username='"+tfuser.getText()+"'";
                DBConnection dc = new DBConnection();
                
                ResultSet rs =dc.s.executeQuery(query);
                while(rs.next())
                {
                    tfpass.setText(rs.getString("password"));
                }
            }catch(Exception ee)
            {
                ee.printStackTrace();
            }
        }
        else 
        {
            setVisible(false);
            new Login();
        }
    }
}
