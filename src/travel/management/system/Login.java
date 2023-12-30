package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{

    JButton login,signup,password;
    JTextField tfusername,tfpassword;
    Login() {
        setSize(900, 400);
        setLocation(350, 200);
        setLayout(null);
        
        getContentPane().setBackground(Color.WHITE);
        
        JPanel p1 = new JPanel();
        p1.setBackground(new Color(131,193,233));
        p1.setBounds(0,0,400,400);
        p1.setLayout(null);
        add(p1);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/login.png"));
        Image i2=i1.getImage().getScaledInstance(200, 200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(100, 80, 200, 200);
        p1.add(image);
        
        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBounds(400, 30, 450, 300);
        add(p2);
        
        JLabel jlusername = new JLabel("User-Name");
        jlusername.setBounds(60, 20, 100, 25);
        jlusername.setFont(new Font("SAN_SERIF",Font.PLAIN,15));
        p2.add(jlusername);
        
        tfusername = new JTextField();
        tfusername.setBounds(60, 50, 300, 30);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tfusername);
        
        JLabel jlpassword = new JLabel("Password");
        jlpassword.setBounds(60, 90, 100, 25);
        jlpassword.setFont(new Font("SAN_SERIF",Font.PLAIN,15));
        p2.add(jlpassword);
        
        tfpassword = new JTextField();
        tfpassword.setBounds(60, 120, 300, 30);
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tfpassword);
        
        login = new JButton("Login");
        login.setBounds(80, 180, 120, 30);
        login.setBackground(new Color(131,193,233));
        login.setForeground(Color.WHITE);
        login.setBorder(BorderFactory.createEmptyBorder());
        login.addActionListener(this);
        p2.add(login);
        
        signup = new JButton("Signup");
        signup.setBounds(240, 180, 120, 30);
        signup.setBackground(new Color(131,193,233));
        signup.setForeground(Color.WHITE);
        signup.setBorder(BorderFactory.createEmptyBorder());
        signup.addActionListener(this);
        p2.add(signup);
        
        password = new JButton("Forget Password");
        password.setBounds(160, 220, 120, 30);
        password.setBackground(new Color(131,193,233));
        password.setForeground(Color.WHITE);
        password.setBorder(BorderFactory.createEmptyBorder());
        password.addActionListener(this);
        p2.add(password);
        
        JLabel text = new JLabel("Trouble to login......");
        text.setBounds(300, 220, 150   ,20);
        text.setForeground(Color.red);
        p2.add(text);
        
        setVisible(true);
    }
    
    
    public static void main(String[] args) {
        Login l = new Login();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
    
        if(ae.getSource()==login)
        {
            try {
                String username = tfusername.getText();
                String pass = tfpassword.getText();
                
                String query = "select * from account where username = '"+username+"' and password = '"+pass+"'";
                DBConnection dc = new DBConnection();
               ResultSet rs = dc.s.executeQuery(query);
               if(rs.next())
               {
                   setVisible(false);
                   new Loading(username);                          
               }
               else
               {
                   JOptionPane.showMessageDialog(null, "Incorrect username or password");
               }
               
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        }
        else if(ae.getSource()==signup)
        {
            setVisible(false);
            new SignUp();
        }
        else
        {
            setVisible(false);
            new ForgetPassword();
        }
        
        
    }
    
}
