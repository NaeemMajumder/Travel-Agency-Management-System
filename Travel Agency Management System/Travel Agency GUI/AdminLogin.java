import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.lang.*;
import java.io.*;
import java.nio.file.*;

public class AdminLogin extends JFrame {

    private Container c;
    private ImageIcon icon, logo, bg_image;
    private JLabel label1, imgLabel;
    private Font f1, f2, f3, f4, f5, f6;
    private JTextField tf1;
    private JButton btn1, btn2, btn3, nBtn;
    private JPasswordField tf2;
    private Cursor cursor;

    AdminLogin() {
        // Frame Layout
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Travel Agency Management System");
        this.setSize(850, 480);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.decode("#F2F2F2"));

        // Icon
        icon = new ImageIcon(getClass().getResource("/images/travel_logo.png"));
        this.setIconImage(icon.getImage());

        // // Logo
        // logo = new ImageIcon(getClass().getResource("/images/admin_login.jpg"));
        // imgLabel = new JLabel(logo);
        // imgLabel.setBounds(200, 50, logo.getIconWidth(), logo.getIconHeight());
        // c.add(imgLabel);

        // Fonts
        f1 = new Font("Serif", Font.BOLD, 56);
        f2 = new Font("Ariel", Font.PLAIN, 20);
        f3 = new Font("Segoe UI Semibold", Font.PLAIN, 35);
        f4 = new Font("Segoe UI", Font.ITALIC, 15);
        f5 = new Font("Segoe UI", Font.PLAIN, 19);
        f6 = new Font("Segoe UI", Font.PLAIN, 25);

        // Custom Panel for Background
        JPanel backgroundPanel = new JPanel() {
            private final Image backgroundImage;

            {
                // Load the background image
                bg_image = new ImageIcon(getClass().getResource("/images/bg4.png"));
                backgroundImage = bg_image.getImage();
            }

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;

                // Draw the background image with opacity, scaled to fit panel dimensions
                float opacity = 0.2f; // Adjust as needed
                g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, opacity));
                g2d.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);

                // Reset the composite to default for other components
                g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f));
            }
        };

        backgroundPanel.setLayout(null); // Use null layout for custom positioning
        setContentPane(backgroundPanel); // Set custom panel as content pane

        // Logo
        logo = new ImageIcon(getClass().getResource("/images/admin_login.png"));
        // imgLabel = new JLabel(logo);
        Image scaledImage = logo.getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH);
        ImageIcon scaledLogo = new ImageIcon(scaledImage);
        imgLabel = new JLabel(scaledLogo);
        imgLabel.setBounds(360, -60, 500, 500); // Adjust position and size of logo
        c.add(imgLabel);
        backgroundPanel.add(imgLabel);
        // imgLabel.setBounds(420, 10, logo.getIconWidth(), logo.getIconHeight());

        // Title
        label1 = new JLabel();
        label1.setText("Admin Login");
        label1.setBounds(80, 40, 500, 90);
        label1.setForeground(Color.decode("#153169"));
        label1.setFont(f1);
        c.add(label1);
        backgroundPanel.add(label1);

        // User Name
        label1 = new JLabel();
        label1.setText("Name");
        label1.setBounds(80, 130, 500, 50);
        label1.setFont(f4);
        c.add(label1);
        backgroundPanel.add(label1);

        tf1 = new JTextField();
        tf1.setBounds(80, 170, 250, 35);
        tf1.setForeground(Color.GRAY); 
        tf1.setText("Enter your username");
        tf1.setFont(f5);
        c.add(tf1);
        backgroundPanel.add(tf1);

        // Password
        label1 = new JLabel();
        label1.setText("Password");
        label1.setBounds(80, 210, 500, 50);
        label1.setFont(f4);
        c.add(label1);
        backgroundPanel.add(label1);

        tf2 = new JPasswordField();
        tf2.setBounds(80, 250, 250, 35);
        tf2.setFont(f2);
        tf2.setEchoChar('*');
        c.add(tf2);
        backgroundPanel.add(tf2);

        // Cursor for JButtons
        cursor = new Cursor(Cursor.HAND_CURSOR);

        // JButtons
        btn1 = new JButton("Exit");
        btn1.setBounds(60, 350, 215, 50);
        btn1.setFont(f2);
        btn1.setCursor(cursor);
        btn1.setForeground(Color.WHITE);
        btn1.setBackground(Color.decode("#d1698b"));
        c.add(btn1);
        backgroundPanel.add(btn1);

        btn2 = new JButton("Back");
        btn2.setBounds(310, 350, 215, 50);
        btn2.setFont(f2);
        btn2.setCursor(cursor);
        btn2.setForeground(Color.WHITE);
        btn2.setBackground(Color.decode("#7c4e85"));
        c.add(btn2);
        backgroundPanel.add(btn2);

        btn3 = new JButton("Login");
        btn3.setBounds(560, 350, 215, 50);
        btn3.setFont(f2);
        btn3.setCursor(cursor);
        btn3.setForeground(Color.WHITE);
        btn3.setBackground(Color.decode("#7c4e85"));
        c.add(btn3);
        backgroundPanel.add(btn3);

        nBtn = new JButton("");
        nBtn.setBounds(0, 0, 0, 0);
        c.add(nBtn);

        // Exit Button
        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });

        // Back Button
        btn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {

                setVisible(false);
                Home frame = new Home();
                frame.setVisible(true);
            }
        });

        // Login Button
        btn3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {

                String textField1 = tf1.getText().toLowerCase(); // Admin Name
                String textField2 = tf2.getText(); // Password

                if (textField1.isEmpty() || textField2.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill all of the fields.", "Warning!",
                            JOptionPane.WARNING_MESSAGE);
                } else {

                    try {

                        String userNameS = "Name : " + textField1;
                        String passwordS = "Password : " + textField2;
                        BufferedReader reader = new BufferedReader(new FileReader(".\\Data\\admin_data.txt"));

                        int totalLines = 0;
                        while (reader.readLine() != null)
                            totalLines++;
                        reader.close();

                        for (int i = 0; i <= totalLines; i++) {
                            String line = Files.readAllLines(Paths.get(".\\Data\\admin_data.txt")).get(i);
                            if (line.equals(userNameS)) {
                                String line2 = Files.readAllLines(Paths.get(".\\Data\\admin_data.txt")).get((i + 1));
                                if (line2.equals(passwordS)) {
                                    JOptionPane.showMessageDialog(null, "Admin Login Successful.", "Travel Agency!",
                                            JOptionPane.WARNING_MESSAGE);

                                    setVisible(false);
                                    Admin frame = new Admin();
                                    frame.setVisible(true);
                                    break;
                                }
                            }
                        }
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Invalid Name or Password!", "Warning!",
                                JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
        });
    }

    public static void main(String[] args) {

        AdminLogin frame = new AdminLogin();
        frame.setVisible(true);
    }
}
