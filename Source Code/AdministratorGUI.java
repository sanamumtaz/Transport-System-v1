/**************************************************
 USERNAME: "admin"
 PASSWORD: "12345"
 ***************************************************/
package transport;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.*;

class AdminLoginGUI extends JFrame implements ActionListener {

    /* Admin logins uses a specific username & password 
    username: admin
    password: 12345*/
    JTextField t1, pf;

    AdminLoginGUI() {
        setLayout(null);
        setSize(400, 250);
        setTitle("Admin Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(240, 255, 255));

        JLabel head = new JLabel();
        head.setText("<html><u>Administrator Login</u></html>");
        head.setFont(new Font("Times New Roman", Font.BOLD, 30));
        head.setBounds(60, 10, 300, 30);
        add(head);

        JLabel l1 = new JLabel("Username:");
        JLabel l2 = new JLabel("Password:");
        pf = new javax.swing.JPasswordField(10);
        t1 = new JTextField();
        l1.setBounds(80, 60, 100, 30);
        t1.setBounds(190, 60, 100, 30);
        l2.setBounds(80, 110, 100, 30);
        pf.setBounds(190, 110, 100, 30);
        JButton login = new JButton("Login");
        login.setBounds(145, 170, 100, 30);
        login.addActionListener(this);
        add(l1);
        add(l2);
        add(t1);
        add(pf);
        add(login);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        // will check if login password and username true or not
        // then does this code given below
        String username = t1.getText();
        String u_correct = "admin";
        String password = pf.getText();
        String p_correct = "12345";

        if (username.equals(u_correct) == true && password.equals(p_correct) == true) {
            AdminGUI admin = new AdminGUI();
            admin.setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(new JFrame(), "Wrong username/password.");
        }

    }
}

class AdminGUI extends JFrame {
    /* Admin chooses what he wants to do.He can:
       - add/remove van - add/remove route -  add/remove students - View Requests*/
    /* If he chooses any remove option, the excel sheet where 
       respective data is stored, is opened */
    AdminGUI() {
        setLayout(new FlowLayout());
        setSize(300, 170);
        setTitle("Admin");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(240, 255, 255));

        JButton b1 = new JButton("Add Van");
        JButton b2 = new JButton("Remove Van");
        JButton b3 = new JButton("Add Route");
        JButton b4 = new JButton("Remove Route");
        JButton b5 = new JButton("Students");
        JButton b6 = new JButton("Requests");
        add(b1);
        add(b2);
        add(b3);
        add(b4);
        add(b5);
        add(b6);
        ActionListener l = (final ActionEvent e) -> {
            if (e.getSource() == b1) {
                AddVanGUI a_van = new AddVanGUI();
                a_van.setVisible(true);
                this.dispose();
            } else if (e.getSource() == b3) {
                AddRouteGUI a_route = new AddRouteGUI();
                a_route.setVisible(true);
                this.dispose();
            } else if (e.getSource() == b2 || e.getSource() == b4) {
                // If admin wants to remove a route or van then Route&Van is opened
                try {

                    if ((new File("C:\\Users\\FMC\\Documents\\NetBeansProjects\\Transport\\Routes&Vans.xls")).exists()) {
                        Process p = Runtime
                                .getRuntime()
                                .exec("rundll32 url.dll,FileProtocolHandler C:\\Users\\FMC\\Documents\\NetBeansProjects\\Transport\\Routes&Vans.xls");
                        p.waitFor();

                    } else {
                        System.out.println("File does not exist");
                    }

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } else if (e.getSource() == b5) {
                // If admin wants to add/remove students, Students.xls is opened
                try {

                    if ((new File("C:\\Users\\FMC\\Documents\\NetBeansProjects\\Transport\\Students.xls")).exists()) {
                        Process p = Runtime
                                .getRuntime()
                                .exec("rundll32 url.dll,FileProtocolHandler C:\\Users\\FMC\\Documents\\NetBeansProjects\\Transport\\Students.xls");
                        p.waitFor();

                    } else {
                        System.out.println("File does not exist");
                    }

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }else if (e.getSource() == b6) {
                // If admin wants to view Requests, Request.xls is opened
                try {

                    if ((new File("C:\\Users\\FMC\\Documents\\NetBeansProjects\\Transport\\Request.xls")).exists()) {
                        Process p = Runtime
                                .getRuntime()
                                .exec("rundll32 url.dll,FileProtocolHandler C:\\Users\\FMC\\Documents\\NetBeansProjects\\Transport\\Request.xls");
                        p.waitFor();

                    } else {
                        System.out.println("File does not exist");
                    }

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            
        };
        b1.addActionListener(l);
        b2.addActionListener(l);
        b3.addActionListener(l);
        b4.addActionListener(l);
        b5.addActionListener(l);
        b6.addActionListener(l);
    }
}

class AddVanGUI extends JFrame implements ActionListener {
    // For adding a van in Routes&Vans van sheet
    JLabel l1, l2, l3, l4;
    JTextField t1, t2, t3, t4;

    AddVanGUI() {
        setVisible(true);
        setLayout(null);
        setSize(350, 350);
        setTitle("Add Vehicle");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(240, 255, 255));

        JLabel title = new JLabel(" ADD VEHICLE");
        title.setFont(new Font("Times New Roman", Font.BOLD, 20));
        title.setBounds(100, 5, 400, 30);
        l1 = new JLabel("Vehicle number:");
        l2 = new JLabel("Driver:");
        l3 = new JLabel("Route:");
        l4 = new JLabel("Type:");
        l1.setBounds(10, 50, 100, 30);
        l2.setBounds(10, 100, 100, 30);
        l3.setBounds(10, 150, 100, 30);
        l4.setBounds(10, 200, 100, 30);
        t1 = new JTextField();
        t2 = new JTextField();
        t3 = new JTextField();
        t4 = new JTextField();
        t1.setBounds(150, 50, 140, 30);
        t2.setBounds(150, 100, 140, 30);
        t3.setBounds(150, 150, 140, 30);
        t4.setBounds(150, 200, 140, 30);
        JButton a_van = new JButton("Add");
        a_van.setBounds(120, 260, 100, 30);
        a_van.addActionListener(this);
        add(title);
        add(l1);
        add(l2);
        add(l3);
        add(l4);
        add(t1);
        add(t2);
        add(t3);
        add(t4);
        add(a_van);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (t1.getText().equals("") || t2.getText().equals("")
                || t3.getText().equals("") || t4.getText().equals("")) {
            JOptionPane.showMessageDialog(new JFrame(), "Data not entered in some field(s)");
        } else {
            String n = t1.getText();
            String d = t2.getText();
            String r = t3.getText();
            String t = t4.getText();
            String su = "Suzuki";
            String hi = "Hiace";
            if (t.equals(hi) == true) {
                Driver dd = new Driver();
                Route rr = new Route();
                dd.setName(d);
                rr.setRoute_name(r);
                Vehicle h = new Hiace(n, dd, rr);
                ExcelReader1 R1 = new ExcelReader1();
                R1.add_Hiace(h);
            } else if (t.equals(su) == true) {
                Driver dd = new Driver();
                Route rr = new Route();
                dd.setName(d);
                rr.setRoute_name(r);
                Vehicle s = new Suzuki(n, dd, rr);
                ExcelReader1 R2 = new ExcelReader1();
                R2.add_Suzuki(s);
            }
            JOptionPane.showMessageDialog(new JFrame(), "Information Sent.");
            this.dispose();
        }
    }
}

class AddRouteGUI extends JFrame implements ActionListener {
// For adding a route in Routes&Vans route sheet
    JLabel l1, l2, l3, l4, l5;
    JTextField t1, t2, t3, t4, t5;

    AddRouteGUI() {
        setVisible(true);
        setLayout(null);
        setSize(350, 350);
        setTitle("Add Route");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(240, 255, 255));

        JLabel title = new JLabel(" ADD ROUTE");
        title.setFont(new Font("Times New Roman", Font.BOLD, 20));
        title.setBounds(100, 5, 400, 30);
        l1 = new JLabel("Route name:");
        l2 = new JLabel("Initial Stop:");
        l3 = new JLabel("Final Stop:");
        l4 = new JLabel("Total Stops:");
        l5 = new JLabel("Fare:");
        l1.setBounds(10, 50, 100, 30);
        l2.setBounds(10, 90, 100, 30);
        l3.setBounds(10, 130, 100, 30);
        l4.setBounds(10, 170, 100, 30);
        l5.setBounds(10, 210, 100, 30);
        t1 = new JTextField();
        t2 = new JTextField();
        t3 = new JTextField();
        t4 = new JTextField();
        t5 = new JTextField();
        t1.setBounds(150, 53, 140, 20);
        t2.setBounds(150, 93, 140, 20);
        t3.setBounds(150, 133, 140, 20);
        t4.setBounds(150, 173, 140, 20);
        t5.setBounds(150, 213, 140, 20);
        JButton a_route = new JButton("Add");
        a_route.setBounds(120, 260, 100, 30);
        a_route.addActionListener(this);
        add(title);
        add(l1);
        add(l2);
        add(l3);
        add(l4);
        add(l5);
        add(t1);
        add(t2);
        add(t3);
        add(t4);
        add(t5);
        add(a_route);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (t1.getText().equals("") || t2.getText().equals("")
                || t3.getText().equals("") || t4.getText().equals("")|| t5.getText().equals("")) {
            JOptionPane.showMessageDialog(new JFrame(), "Data not entered in some field(s)");
        } else {
            String r_n = t1.getText();
            String i_s = t2.getText();
            String f_s = t3.getText();
            String t_s = t4.getText();
            String f = t5.getText();

            Route route = new Route(r_n, i_s, f_s, t_s, f);
            ExcelReader1 R1 = new ExcelReader1();
            R1.add_route(route);
            JOptionPane.showMessageDialog(new JFrame(), "Information Sent.");
            this.dispose();
        }
    }
}
