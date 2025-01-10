import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Home extends JFrame {

    private Container c;
    private ImageIcon icon, bg_image;
    private JLabel label1, imgLabel;
    private Font f1, f2, f3;
    private JButton btn1, btn2, btn3, btn4, nBtn;
    private Cursor cursor;

    Home() {
        // Frame Layout
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Travel Agency Management System");
        this.setSize(1020, 600);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        
        // Icon
        icon = new ImageIcon(getClass().getResource("/images/travel_logo.png"));
        this.setIconImage(icon.getImage());

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

        // Fonts
        f1 = new Font("Serif", Font.BOLD, 56);
        f2 = new Font("Ariel", Font.PLAIN, 20);
        f3 = new Font("Serif", Font.ITALIC, 20);

        // Title
        label1 = new JLabel();
        label1.setText("Your Dream");
        label1.setBounds(500, 130, 500, 65);
        label1.setFont(f1);
        label1.setForeground(Color.decode("#153169"));
        backgroundPanel.add(label1);

        label1 = new JLabel();
        label1.setText("Vacations is Here!");
        label1.setBounds(540, 200, 500, 65);
        label1.setFont(f1);
        label1.setForeground(Color.decode("#153169"));
        backgroundPanel.add(label1);

        label1 = new JLabel();
        label1.setText("Join us and stay connected");
        label1.setBounds(630, 300, 500, 65);
        label1.setFont(f3);
        label1.setForeground(Color.decode("#153169"));
        backgroundPanel.add(label1);

        // Cursor for JButtons
        cursor = new Cursor(Cursor.HAND_CURSOR);

        // JButtons
        btn1 = new JButton("Login");
        btn1.setBounds(520, 460, 200, 50);
        btn1.setFont(f2);
        btn1.setCursor(cursor);
        btn1.setForeground(Color.WHITE);
        btn1.setBackground(Color.decode("#43426E"));
        backgroundPanel.add(btn1);

        btn2 = new JButton("Register");
        btn2.setBounds(760, 460, 200, 50);
        btn2.setFont(f2);
        btn2.setCursor(cursor);
        btn2.setForeground(Color.WHITE);
        btn2.setBackground(Color.decode("#43426E"));
        backgroundPanel.add(btn2);

        btn3 = new JButton("Exit");
        btn3.setBounds(40, 460, 200, 50);
        btn3.setFont(f2);
        btn3.setCursor(cursor);
        btn3.setForeground(Color.WHITE);
        btn3.setBackground(Color.decode("#d1698b"));
        backgroundPanel.add(btn3);

        btn4 = new JButton("Admin Login");
        btn4.setBounds(280, 460, 200, 50);
        btn4.setFont(f2);
        btn4.setCursor(cursor);
        btn4.setForeground(Color.WHITE);
        btn4.setBackground(Color.decode("#43426E"));
        backgroundPanel.add(btn4);

        nBtn = new JButton("");
        nBtn.setBounds(0, 0, 0, 0);
        backgroundPanel.add(nBtn);

        // Add logo to the background
        ImageIcon logo = new ImageIcon(getClass().getResource("/images/travel_logo.png"));
        Image scaledImage = logo.getImage().getScaledInstance(500, 500, Image.SCALE_SMOOTH);
        ImageIcon scaledLogo = new ImageIcon(scaledImage);

        imgLabel = new JLabel(scaledLogo);
        imgLabel.setBounds(0, -30, 500, 500); // Adjust position and size of logo
        backgroundPanel.add(imgLabel);

        ImageIcon links = new ImageIcon(getClass().getResource("/images/links.png"));
        Image linksImage = links.getImage().getScaledInstance(230, 60, Image.SCALE_SMOOTH);
        ImageIcon linksScaled = new ImageIcon(linksImage);

        imgLabel = new JLabel(linksScaled);
        imgLabel.setBounds(230, 80, 1020, 600); // Adjust position and size of logo
        backgroundPanel.add(imgLabel);

        // Login
        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                setVisible(false);
                Login frame = new Login();
                frame.setVisible(true);
            }
        });

        // Register
        btn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                Registration frame = new Registration();
                frame.setVisible(true);
                setVisible(false);
            }
        });

        // Exit
        btn3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });

        // Admin Login
        btn4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                setVisible(false);
                AdminLogin frame = new AdminLogin();
                frame.setVisible(true);
                JOptionPane.showMessageDialog(null, "By default, Admin Name and Password is : 'admin'", "Information!",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }

    public static void main(String[] args) {
        Home frame = new Home();
        frame.setVisible(true);
    }
}
