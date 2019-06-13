package transport;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.*;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;

class RouteGUI extends JFrame implements ActionListener {
    //Select Route
    JComboBox myComboBox;
    JButton go, here;
    public RouteGUI() {

        setLayout(new BorderLayout());
        setSize(310, 200);
        setTitle("Select Route");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(238, 232, 170));

        String[] options = {"Select Route", "G, I, F & H Sectors", "Laal Kurti,Adiala", 
            "Falcon Complex,Muslim Town", "Bahria,DHA"};
        myComboBox = new JComboBox(options);
        myComboBox.setSelectedIndex(0);
        DefaultListCellRenderer dlcr = new DefaultListCellRenderer();
        dlcr.setHorizontalAlignment(DefaultListCellRenderer.CENTER);
        myComboBox.setRenderer(dlcr);
        JPanel top = new JPanel();
        top.add(myComboBox);
        go = new JButton("Go");
        go.addActionListener(this);
        top.add(go);
        top.setOpaque(false);

        JPanel bottom = new JPanel();
        bottom.setOpaque(false);
        JPanel bottomRight = new JPanel();
        bottomRight.setOpaque(false);
        JPanel bottomLeft = new JPanel();
        bottomLeft.setOpaque(false);
        bottom.setLayout(new BoxLayout(bottom, BoxLayout.X_AXIS));
        JLabel no_route;
        no_route = new JLabel("Is your route not mentioned?");
        here = new JButton("Click Here");
        here.addActionListener(this);
        bottomLeft.add(no_route, BoxLayout.X_AXIS);
        bottomRight.add(here, BoxLayout.X_AXIS);

        bottom.setBorder(BorderFactory.createTitledBorder(""));
        bottom.add(bottomLeft);
        bottom.add(bottomRight);
        bottom.setBackground(Color.BLACK);
        add(top, BorderLayout.NORTH);
        add(bottom, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == go) {
            /* Checking availability of seat by counting num of rows
             of respective route's Excel sheet */
            // Number of rows mean the number of students in that route's van
            String choice = (String) myComboBox.getSelectedItem();
            ExcelReader1 ex = new ExcelReader1();
            switch (choice) {
                case "G, I, F & H Sectors":
                    int i;
                    try {
                        i = ex.getRows(0);
                        if (i >= 18) {
                            NoSeatGUI ns = new NoSeatGUI();
                            ns.setVisible(true);
                        } else {
                            Form form = new Form();
                            form.setVisible(true);
                        }
                    } catch (WriteException | IOException | BiffException ex1) {
                        Logger.getLogger(RouteGUI.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                    break;
                case "Laal Kurti,Adiala":
                    int j;
                    try {
                        j = ex.getRows(1);
                        if (j >= 18) {
                            NoSeatGUI ns = new NoSeatGUI();
                            ns.setVisible(true);
                        } else {
                            Form form = new Form();
                            form.setVisible(true);
                        }
                    } catch (WriteException | IOException | BiffException ex1) {
                        Logger.getLogger(RouteGUI.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                    break;
                case "Falcon Complex,Muslim Town":
                    int k;
                    try {
                        k = ex.getRows(2);
                        if (k >= 8) {
                            NoSeatGUI ns = new NoSeatGUI();
                            ns.setVisible(true);
                        } else {
                            Form form = new Form();
                            form.setVisible(true);
                        }
                    } catch (WriteException | IOException | BiffException ex1) {
                        Logger.getLogger(RouteGUI.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                    break;
                case "Bahria,DHA":
                    int l;
                    try {
                        l = ex.getRows(3);
                        if (l >= 18) {
                            NoSeatGUI ns = new NoSeatGUI();
                            ns.setVisible(true);
                        } else {
                            Form form = new Form();
                            form.setVisible(true);
                        }
                    } catch (WriteException | IOException | BiffException ex1) {
                        Logger.getLogger(RouteGUI.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                    break;
            }

        } else if (event.getSource() == here){
            NoRoute nr = new NoRoute();
            nr.setVisible(true);
            this.dispose();
        }
    }
}

class NoRoute extends JFrame implements ActionListener {
    // If route is not mentioned then request for route
    JTextField t1, t2, t3;

    NoRoute() {
        setLayout(null);
        setSize(350, 300);
        setTitle("No Route Available");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(238, 232, 170));

        JLabel descrp1 = new JLabel(" PLEASE ENTER THE ROUTE AND YOUR");
        descrp1.setFont(new Font("Times New Roman", Font.BOLD, 16));
        JLabel descrp2 = new JLabel("PHONE NO. SO THAT WE CAN CONTACT");
        descrp2.setFont(new Font("Times New Roman", Font.BOLD, 16));
        JLabel descrp3 = new JLabel("         YOU IF ROUTE IS AVAILABLE");
        descrp3.setFont(new Font("Times New Roman", Font.BOLD, 16));
        JLabel line = new JLabel("========================================");
        line.setFont(new Font("Times New Roman", Font.BOLD, 20));
        line.setForeground(new Color(0, 0, 128));
        descrp1.setBounds(10, 5, 400, 30);
        descrp2.setBounds(10, 30, 400, 30);
        descrp3.setBounds(10, 55, 400, 30);
        line.setBounds(0, 70, 400, 30);
        
        add(descrp1); add(descrp2); add(descrp3); add(line);

        JLabel route = new JLabel("Route :");
        route.setBounds(40, 180, 100, 30);
        JLabel name = new JLabel("Name :");
        name.setBounds(40, 110, 100, 25);
        JLabel ph_no = new JLabel("Phone No. :");
        ph_no.setBounds(40, 147, 100, 25);
        add(route);
        add(ph_no);
        add(name);

        t1 = new JTextField(); t2 = new JTextField(); t3 = new JTextField();
        t1.setBounds(140, 110, 150, 25);
        t2.setBounds(140, 147, 150, 25);
        t3.setBounds(140, 180, 150, 25);
        add(t1); add(t2); add(t3);
        JButton send1 = new JButton("Send");
        send1.setFont(new Font("Times New Roman", Font.BOLD, 16));
        send1.setPreferredSize(new Dimension(70, 25));
        send1.setBounds(130, 230, 70, 25);
        add(send1);
        send1.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (t1.getText().equals("")||t2.getText().equals("")
                ||t3.getText().equals("")){
            JOptionPane.showMessageDialog(new JFrame(), "Data not entered in some field(s)");
        }else{
            String n = t1.getText();
            String c = t2.getText();
            String r = t3.getText();
            Request Rq = new Route_Request(n, c, r);
            ExcelReader1 R1 = new ExcelReader1();
            R1.add_Route_Request(Rq);
            JOptionPane.showMessageDialog(new JFrame(), "Information Sent.");
            this.dispose();
        }
    }
}

class NoSeatGUI extends JFrame implements ActionListener {
    // If route is available but seat in that route's van is not available
    
    JTextField t1, t2, t3;

    NoSeatGUI() {
        setLayout(null);
        setSize(350, 300);
        setTitle("No Seat Available");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(238, 232, 170));

        JLabel descrp1 = new JLabel("NO SEAT! PLEASE ENTER THE ROUTE AND YOUR");
        descrp1.setFont(new Font("Times New Roman", Font.BOLD, 14));
        JLabel descrp2 = new JLabel("PHONE NO. SO THAT WE CAN CONTACT");
        descrp2.setFont(new Font("Times New Roman", Font.BOLD, 16));
        JLabel descrp3 = new JLabel("         YOU IF SEAT IS AVAILABLE");
        descrp3.setFont(new Font("Times New Roman", Font.BOLD, 16));
        JLabel line = new JLabel("========================================");
        line.setFont(new Font("Times New Roman", Font.BOLD, 20));
        line.setForeground(new Color(0, 0, 128));
        descrp1.setBounds(10, 5, 400, 30);
        descrp2.setBounds(10, 30, 400, 30);
        descrp3.setBounds(10, 55, 400, 30);
        line.setBounds(0, 70, 400, 30);
        add(descrp1); add(descrp2); add(descrp3); add(line);

        JLabel route = new JLabel("Route :");
        route.setBounds(40, 180, 100, 30);
        JLabel name = new JLabel("Name :");
        name.setBounds(40, 110, 100, 25);
        JLabel ph_no = new JLabel("Phone No. :");
        ph_no.setBounds(40, 147, 100, 25);
        add(route); add(ph_no); add(name);

        t1 = new JTextField(); t2 = new JTextField(); t3 = new JTextField();
        t1.setBounds(140, 110, 150, 25); t2.setBounds(140, 147, 150, 25);
        t3.setBounds(140, 180, 150, 25);
        add(t1); add(t2); add(t3);
        JButton send = new JButton("Send");
        send.setFont(new Font("Times New Roman", Font.BOLD, 16));
        send.setPreferredSize(new Dimension(70, 25));
        send.setBounds(130, 230, 70, 25);
        add(send);
        send.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (t1.getText().equals("")||t2.getText().equals("")
                ||t3.getText().equals("")){
            JOptionPane.showMessageDialog(new JFrame(), "Data not entered in some field(s)");
        }else{
            String n = t1.getText();
            String c = t2.getText();
            String r = t3.getText();
            Request Rq = new Seat_Request(n, c, r);
            ExcelReader1 R3 = new ExcelReader1();
            R3.add_Seat_Request(Rq);
            JOptionPane.showMessageDialog(new JFrame(), "Information Sent.");
            this.dispose();
        }
    }
}

class Form extends JFrame implements ActionListener {

    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10;
    JTextField t1, t3, t5, t6, t7, t8, t9, t10;
    JComboBox myComboBox;
    String gender;

    Form() {
        setSize(600, 650);
        setLayout(null);
        setTitle("Registration Form");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel logo = new JLabel(new ImageIcon("NUST_VAN.png"));
        logo.setBounds(150, 10, 300, 100);
        add(logo);

        l1 = new JLabel("Name:"); l2 = new JLabel("Route:");
        l3 = new JLabel("Contact No. :"); l4 = new JLabel("Gender:");
        l5 = new JLabel("Address:"); l6 = new JLabel("Institute:");
        l7 = new JLabel("Class:"); l8 = new JLabel("Registraion No. :");
        l9 = new JLabel("Father\'s Name:"); l10 = new JLabel("Email Address:");

        t1 = new JTextField(); t3 = new JTextField();
        t5 = new JTextField(); t6 = new JTextField();
        t7 = new JTextField(); t8 = new JTextField();
        t9 = new JTextField(); t10 = new JTextField();
        JRadioButton gen1 = new JRadioButton("Male");
        JRadioButton gen2 = new JRadioButton("Female");
        String[] options = {"Select Route", "G, I, F & H sectors", "Laal Kurti,Adiala", 
            "Falcon Complex,Muslim Town", "Bahria,DHA"};
        myComboBox = new JComboBox(options);
        myComboBox.setSelectedIndex(0);
        DefaultListCellRenderer dlcr = new DefaultListCellRenderer();
        dlcr.setHorizontalAlignment(DefaultListCellRenderer.CENTER);
        myComboBox.setRenderer(dlcr);

        JButton send;
        send = new JButton("Send", new ImageIcon("send.gif"));
        send.addActionListener(this);
        l1.setBounds(50, 130, 100, 30); l2.setBounds(50, 170, 100, 30);
        l3.setBounds(50, 210, 100, 30); l4.setBounds(50, 250, 100, 30);
        l5.setBounds(50, 290, 100, 30); l6.setBounds(50, 330, 100, 30);
        l7.setBounds(50, 370, 100, 30); l8.setBounds(50, 410, 100, 30);
        l9.setBounds(50, 450, 100, 30); l10.setBounds(50, 490, 100, 30);
        t1.setBounds(170, 130, 400, 25); t3.setBounds(170, 210, 400, 25);
        t5.setBounds(170, 290, 400, 25); t6.setBounds(170, 330, 400, 25);
        t7.setBounds(170, 370, 400, 25);t8.setBounds(170, 410, 400, 25);
        t9.setBounds(170, 450, 400, 25); t10.setBounds(170, 490, 400, 25);
        gen1.setBounds(170, 250, 60, 30);
        gen1.addActionListener((ActionEvent e) -> {
            gender = "Male";
        });
        gen2.setBounds(270, 250, 100, 30);
        gen2.addActionListener((ActionEvent e) -> {
            gender = "Female";
        });
        myComboBox.setBounds(170, 170, 400, 25);
        send.setBounds(250, 550, 150, 30);
        add(l1); add(l2); add(l3); add(l4); add(l5); add(l6); add(l7); add(l8);
        add(l9); add(l10); add(t9); add(t10); add(gen1); add(gen2); add(t1);
        add(t3); add(t5); add(t6); add(t7); add(t8); add(myComboBox); add(send);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        String name = t1.getText();
        String c_n = t3.getText();
        String choice = (String) myComboBox.getSelectedItem();
        String add = t5.getText();
        String ins = t6.getText();
        String cls = t7.getText();
        String reg = t8.getText();
        String fth = t9.getText();
        String email = t10.getText();
        if (t1.getText().equals("") || t3.getText().equals("") || t5.getText().equals("")
                || t6.getText().equals("") || t7.getText().equals("") || t8.getText().equals("")
                || t9.getText().equals("") || t10.getText().equals("")) {
            JOptionPane.showMessageDialog(new JFrame(), "Data not entered in some field(s)");
        } else {
            Route rr = new Route();
            rr.setRoute_name(choice);
            Student st = new Student(name, gender, c_n, rr.getRoute_name(), reg, add, fth, email, ins, cls);
            ExcelReader1 ex = new ExcelReader1();
            try {
                ex.excelWritingStudent(st, rr);
            } catch (WriteException | IOException | BiffException ex1) {
                Logger.getLogger(Form.class.getName()).log(Level.SEVERE, null, ex1);
            }
            JOptionPane.showMessageDialog(new JFrame(), "Form Submitted.");
            this.dispose();
        }
    }
}
