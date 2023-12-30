
package travel.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Dashboard extends JFrame implements ActionListener {

    JButton addPersonDetails,viewPersonDetails,updatePersonDetails,checkPackage,bookPackage,viewPackage,viewHotels,destinations,bookHotel,viewbookHotel,payments,calculator,notepad,about,deletePersonDetails ;
    String username;
    public Dashboard(String username) 
    {
        this.username=username;
//        setBounds(0, 0, 1600, 1000);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);
        
        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(0,0,102));
        p1.setBounds(0, WIDTH, 1400, 65);
        add(p1);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/dashboard.png"));
        Image i2 = i1.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel icon = new JLabel(i3);
        icon.setBounds(5, 0, 70, 70);
        p1.add(icon);
        
        
        JLabel heading = new JLabel("Dashboard");
        heading.setBounds(80, 10, 300, 40);
        heading.setForeground(Color.WHITE);
        heading.setFont(new Font("Tahoma",Font.BOLD,30));        
        p1.add(heading);
        
        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBackground(new Color(0,0,102));
        p2.setBounds(0, 65, 300, 650);
        add(p2);
        
        addPersonDetails = new JButton("Add Personal Details");
        addPersonDetails.setBounds(0, 2, 300, 50);
        addPersonDetails.setBackground(new Color(0,0,102));
        addPersonDetails.setForeground(Color.WHITE);
        addPersonDetails.setFont(new Font("Thaoma",Font.PLAIN,20));
        addPersonDetails.setMargin(new Insets(0,0,0,60));
        addPersonDetails.addActionListener(this);
        p2.add(addPersonDetails);
        
        updatePersonDetails = new JButton("Update Personal Details");
        updatePersonDetails.setBounds(0, 42, 300, 50);
        updatePersonDetails.setBackground(new Color(0,0,102));
        updatePersonDetails.setForeground(Color.WHITE);
        updatePersonDetails.setFont(new Font("Thaoma",Font.PLAIN,20));
        updatePersonDetails.setMargin(new Insets(0,0,0,30));
        updatePersonDetails.addActionListener(this);
        p2.add(updatePersonDetails);
        
        viewPersonDetails = new JButton("View Details");
        viewPersonDetails.setBounds(0, 82, 300, 50);
        viewPersonDetails.setBackground(new Color(0,0,102));
        viewPersonDetails.setForeground(Color.WHITE);
        viewPersonDetails.setFont(new Font("Thaoma",Font.PLAIN,20));
        viewPersonDetails.setMargin(new Insets(0,0,0,130));
        viewPersonDetails.addActionListener(this);
        p2.add(viewPersonDetails);
        
       deletePersonDetails = new JButton("Delete Personal Details");
        deletePersonDetails.setBounds(0, 122, 300, 50);
        deletePersonDetails.setBackground(new Color(0,0,102));
        deletePersonDetails.setForeground(Color.WHITE);
        deletePersonDetails.setFont(new Font("Thaoma",Font.PLAIN,20));
        deletePersonDetails.setMargin(new Insets(0,0,0,30));
        deletePersonDetails.addActionListener(this);
        p2.add(deletePersonDetails);
        
        checkPackage = new JButton("Check Package");
        checkPackage.setBounds(0, 162, 300, 50);
        checkPackage.setBackground(new Color(0,0,102));
        checkPackage.setForeground(Color.WHITE);
        checkPackage.setFont(new Font("Thaoma",Font.PLAIN,20));
        checkPackage.setMargin(new Insets(0,0,0,100));
        checkPackage.addActionListener(this);
        p2.add(checkPackage);
        
        bookPackage = new JButton("Book Package");
        bookPackage.setBounds(0, 202, 300, 50);
        bookPackage.setBackground(new Color(0,0,102));
        bookPackage.setForeground(Color.WHITE);
        bookPackage.setFont(new Font("Thaoma",Font.PLAIN,20));
        bookPackage.setMargin(new Insets(0,0,0,110));
        bookPackage.addActionListener(this);
        p2.add(bookPackage);
        
        viewPackage = new JButton("View Package");
        viewPackage.setBounds(0, 242, 300, 50);
        viewPackage.setBackground(new Color(0,0,102));
        viewPackage.setForeground(Color.WHITE);
        viewPackage.setFont(new Font("Thaoma",Font.PLAIN,20));
        viewPackage.setMargin(new Insets(0,0,0,110));
        viewPackage.addActionListener(this);
        p2.add(viewPackage);
        
        viewHotels = new JButton("View Hotels");
        viewHotels.setBounds(0, 282, 300, 50);
        viewHotels.setBackground(new Color(0,0,102));
        viewHotels.setForeground(Color.WHITE);
        viewHotels.setFont(new Font("Thaoma",Font.PLAIN,20));
        viewHotels.setMargin(new Insets(0,0,0,130));
        viewHotels.addActionListener(this);
        p2.add(viewHotels);
        
        bookHotel = new JButton("Book Hotel");
        bookHotel.setBounds(0, 322, 300, 50);
        bookHotel.setBackground(new Color(0,0,102));
        bookHotel.setForeground(Color.WHITE);
        bookHotel.setFont(new Font("Thaoma",Font.PLAIN,20));
        bookHotel.setMargin(new Insets(0,0,0,140));
        bookHotel.addActionListener(this);
        p2.add(bookHotel);
        
        viewbookHotel = new JButton("View Booked Hotel");
        viewbookHotel.setBounds(0, 362, 300, 50);
        viewbookHotel.setBackground(new Color(0,0,102));
        viewbookHotel.setForeground(Color.WHITE);
        viewbookHotel.setFont(new Font("Thaoma",Font.PLAIN,20));
        viewbookHotel.setMargin(new Insets(0,0,0,70));
        viewbookHotel.addActionListener(this);
        p2.add(viewbookHotel);
        
        destinations = new JButton("Destinations");
        destinations.setBounds(0, 402, 300, 50);
        destinations.setBackground(new Color(0,0,102));
        destinations.setForeground(Color.WHITE);
        destinations.setFont(new Font("Thaoma",Font.PLAIN,20));
        destinations.setMargin(new Insets(0,0,0,130));
        destinations.addActionListener(this);
        p2.add(destinations);
        
        payments = new JButton("Payments");
        payments.setBounds(0, 442, 300, 50);
        payments.setBackground(new Color(0,0,102));
        payments.setForeground(Color.WHITE);
        payments.setFont(new Font("Thaoma",Font.PLAIN,20));
        payments.setMargin(new Insets(0,0,0,150));
        payments.addActionListener(this);
        p2.add(payments);
        
        calculator  = new JButton("Calculator");
        calculator.setBounds(0, 482, 300, 50);
        calculator.setBackground(new Color(0,0,102));
        calculator.setForeground(Color.WHITE);
        calculator.setFont(new Font("Thaoma",Font.PLAIN,20));
        calculator.setMargin(new Insets(0,0,0,150));
        calculator.addActionListener(this);
        p2.add(calculator);
        
        notepad = new JButton("Notepad");
        notepad.setBounds(0, 522, 300, 50);
        notepad.setBackground(new Color(0,0,102));
        notepad.setForeground(Color.WHITE);
        notepad.setFont(new Font("Thaoma",Font.PLAIN,20));
        notepad.setMargin(new Insets(0,0,0,160));
        notepad.addActionListener(this);
        p2.add(notepad);
        
        about = new JButton("About");
        about.setBounds(0, 562, 300, 50);
        about.setBackground(new Color(0,0,102));
        about.setForeground(Color.WHITE);
        about.setFont(new Font("Thaoma",Font.PLAIN,20));
        about.setMargin(new Insets(0,0,0,180));
        about.addActionListener(this);
        p2.add(about);
        
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("Icons/home.jpg"));
        Image i5 = i4.getImage().getScaledInstance(1650, 1000, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image = new JLabel(i6);
        image.setBounds(0, 0, 1650, 1000);
        add(image);
        
        JLabel text = new JLabel("Travel and Tourism Management System");
        text.setBounds(400, 70, 1000, 70);
        text.setForeground(Color.black);
        text.setFont(new Font("Raleway",Font.PLAIN,50));
        image.add(text);
        
        setVisible(true);
    }
    
    
    
    public static void main(String[] args) {
        new Dashboard("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == addPersonDetails)
        {
            new AddCustomer(username);
        }
        else if(e.getSource() == viewPersonDetails)
        {
            new  ViewCustomer(username);
        }
        else if(e.getSource() == updatePersonDetails)
        {
            new UpdateCustomerDetails(username);
        }
        else if(e.getSource() == checkPackage)
        {
            new CheckPackage();
        }
        else if(e.getSource() == bookPackage)
        {
            new BookPackage(username);
        }
        else if(e.getSource() == viewPackage)
        {
            new ViewPackage(username);
        }
        else if(e.getSource() == viewHotels)
        {
            new CheckHotels();                    
        }
        else if(e.getSource() == destinations)
        {
            new Destinations();
        }
        else if(e.getSource() == bookHotel)
        {
            new BookHotel(username);
        }
        else if(e.getSource() == viewbookHotel)
        {
            new ViewBookedHotel(username);
        }
        else if(e.getSource() == payments)
        {
            new Payments();
        }
        else if(e.getSource() == deletePersonDetails)
        {
            new DeleteDetails(username);
        }
        else if(e.getSource() == calculator)
        {
            try {
                Runtime.getRuntime().exec("calc.exe");
            } catch (Exception ae) {
                ae.printStackTrace();
            }
        }
        else if(e.getSource() == notepad)
        {
            try {
                Runtime.getRuntime().exec("notepad.exe");
            } catch (Exception ae) {
                ae.printStackTrace();
            }
        }
        else if(e.getSource() == about)
        {
            new About();
        }
    }
}
