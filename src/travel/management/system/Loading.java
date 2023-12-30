
package travel.management.system;

import java.awt.*;
import javax.swing.*;

public class Loading extends  JFrame implements Runnable 
{
    Thread th;
    JProgressBar bar;
    String username;
    
    public void run()
    {
        try {
            for(int i = 1;i<=101;i++)
            {
                int max = bar.getMaximum(); //100
                int value=bar.getValue();
                if(value < max) //101<100
                {
                    bar.setValue(bar.getValue()+1);
                }else
                {
                    setVisible(false);
                    new Dashboard(username);
                }
                Thread.sleep(50);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    Loading(String username)
    {
        th=new Thread(this);
        this.username=username;
        setBounds(500, 200, 650, 400);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text = new JLabel("Travel and Tourism Application");
        text.setBounds(50, 20  , 600, 40);
        text.setForeground(Color.BLUE);
        text.setFont(new Font("Raleway",Font.BOLD,35));
        add(text);
        
        bar = new JProgressBar();
        
        bar.setBounds(150, 100, 300, 35);
        bar.setStringPainted(true);
        add(bar);
        
        JLabel loading = new JLabel("Loading, Please wait...");
        loading.setBounds(200, 140  , 250, 30);
        loading.setForeground(Color.red);
        loading.setFont(new Font("Raleway",Font.BOLD,16));
        add(loading);
        
        JLabel lbusername = new JLabel("welcome "+username);
        lbusername.setBounds(20, 310  , 400, 40);
        lbusername.setForeground(Color.RED);
        lbusername.setFont(new Font("Raleway",Font.BOLD,15));
        add(lbusername);
        
        th.start();
        
        setVisible(true);
    }
    
}
