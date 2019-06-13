package transport;

import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Transport {

    public static void main(String[] args) {
        WelcomeGUI welcome = new WelcomeGUI();
        welcome.setVisible(true);
    }
}

class WelcomeGUI extends JFrame implements ActionListener {
    // Welcome page
    WelcomeGUI() {
        setSize(500, 200);
        setTitle("NUST Transport Service");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(new Color(70, 130, 180));
        setLocationRelativeTo(null);

        JLabel welcome = new JLabel("Welcome   ", JLabel.CENTER);
        welcome.setFont(new Font("Harrington", Font.BOLD, 50));
        welcome.setForeground(Color.WHITE);
        welcome.setBounds(20, 35, 280, 70);
        JLabel bottom = new JLabel("NUST Transport Service", JLabel.CENTER);
        bottom.setFont(new Font("Harrington", Font.BOLD, 14));
        bottom.setForeground(Color.WHITE);
        bottom.setBounds(0, 130, 500, 30);
        add(welcome);
        add(bottom);

        JButton b1 = new JButton("Registration");
        b1.setFont(new Font("Calibri", Font.BOLD, 13));
        b1.setBounds(340, 40, 100, 25);
        add(b1);
        b1.addActionListener(this);

        JButton b2 = new JButton("Admin Login");
        b2.setFont(new Font("Calibri", Font.BOLD, 12));
        b2.setBounds(340, 70, 100, 25);
        add(b2);
        b2.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        String str1 = (String) event.getActionCommand();
        if (str1.equals("Registration")) {
            RouteGUI rt = new RouteGUI();
            rt.setVisible(true);
            this.dispose();
        }
        if (str1.equals("Admin Login")) {
            AdminLoginGUI a_login = new AdminLoginGUI();
            a_login.setVisible(true);
            this.dispose();
        }
    }
}

