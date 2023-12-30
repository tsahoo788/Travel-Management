
package travel.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Payments extends JFrame implements ActionListener
{

    JButton pay,back;
    public Payments() 
    {
        setBounds(350, 80, 800, 600);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/paytm.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(800, 600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 800, 600);
        add(image);
                
        pay= new JButton("Pay");
        pay.setBounds(50,50,80,40);
        pay.addActionListener(this);
        image.add(pay);
        
        back= new JButton("Back");
        back.setBounds(650,50,80,40);
        back.addActionListener(this);
        image.add(back);
        
        setVisible(true);
        
    }
    
    public static void main(String[] args) 
    {
        new Payments();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == pay)
        {
            setVisible(false);
            new Paytm();
        }
        else
        {
            setVisible(false);
        }
    }
    
}
