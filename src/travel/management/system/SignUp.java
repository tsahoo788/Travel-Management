package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignUp extends JFrame implements ActionListener{
    
    JButton create,back;
    JTextField tfusername,tfname,tfpass,tfans;
    Choice security;
    
    
    SignUp()
    {
        setBounds(350, 200, 900, 360);
//        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JPanel pl = new JPanel();
        pl.setBackground(new Color(133, 193, 233));
        pl.setBounds(0, 0, 500, 400);
        pl.setLayout(null);
        add(pl);
        
        JLabel lbusername = new JLabel("Username");
        lbusername.setFont(new Font("Tahoma",Font.BOLD,15));
        lbusername.setBounds(50, 20, 125, 25);
        pl.add(lbusername);
        
         tfusername = new JTextField();
        tfusername.setBounds(150, 20, 200, 25);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        pl.add(tfusername);
        
         JLabel lbname = new JLabel("Name");
        lbname.setFont(new Font("Tahoma",Font.BOLD,15));
        lbname.setBounds(50, 60, 125, 25);
        pl.add(lbname);
        
         tfname = new JTextField();
        tfname.setBounds(150, 60, 200, 25);
        tfname.setBorder(BorderFactory.createEmptyBorder());
        pl.add(tfname);
        
        JLabel lbpass = new JLabel("Password");
        lbpass.setFont(new Font("Tahoma",Font.BOLD,15));
        lbpass.setBounds(50, 100, 125, 25);
        pl.add(lbpass);
        
         tfpass = new JTextField();
        tfpass.setBounds(150, 100, 200, 25);
        tfpass.setBorder(BorderFactory.createEmptyBorder());
        pl.add(tfpass);
        
         JLabel lbsecurityquestion = new JLabel("Security Question");
        lbsecurityquestion.setFont(new Font("Tahoma",Font.BOLD,15));
        lbsecurityquestion.setBounds(50, 140, 125, 25);
        pl.add(lbsecurityquestion);
       
        security = new Choice();
        security.add("Fav Marvel superhero");
        security.add("Your lucky number");
        security.add("Your childhood superhero");
        security.setBounds(150, 140, 200, 25);
        pl.add(security);
        
        JLabel lbans = new JLabel("Answer");
        lbans.setFont(new Font("Tahoma",Font.BOLD,15));
        lbans.setBounds(50, 180, 125, 25);
        pl.add(lbans);
        
         tfans = new JTextField();
        tfans.setBounds(150, 180, 200, 25);
        tfans.setBorder(BorderFactory.createEmptyBorder());
        pl.add(tfans);
        
         create = new JButton("Create");
        create.setBackground(Color.WHITE);
        create.setForeground(new Color(133, 199, 233));
        create.setFont(new Font("Tahoma",Font.BOLD,14));
        create.setBounds(80, 240, 100, 30);
        create.addActionListener(this);
        pl.add(create);
        
         back = new JButton("Back");
        back.setBackground(Color.WHITE);
        back.setForeground(new Color(133, 199, 233));
        back.setFont(new Font("Tahoma",Font.BOLD,14));
        back.setBounds(230, 240, 100, 30);
        back.addActionListener(this);
        pl.add(back);
        
         ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/signup.png"));
        Image i2=i1.getImage().getScaledInstance(250, 250,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(580, 50, 250, 250);
        add(image);
        
        setVisible(true);
    }
     public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == create)
        {
            String username = tfusername.getText();
            String name = tfname.getText();
            String password = tfpass.getText();
            String question = security.getSelectedItem();
            String ans = tfans.getText();
            
            String query = "insert into account values('"+username+"','"+name+"','"+password+"','"+question+"','"+ans+"')";
            try{
                DBConnection db = new DBConnection();
                db.s.executeUpdate(query);
//                db.c.close();
                JOptionPane.showMessageDialog(null, "Account created successfully");
                setVisible(false);
                new Login();
            }catch(Exception ec){
            ec.printStackTrace();
            }
        }
        else if(e.getSource() == back)
        {
            setVisible(false);
            new Login();
        } 
    }
   
}
