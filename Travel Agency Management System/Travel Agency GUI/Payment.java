import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Payment extends JFrame {

    private Container c;
    private ImageIcon icon, bg_image;
    private JLabel label1, label2, label3, imgLabel;
    private Font f1, f2, f3, f4, f5, f6;
    private ImageIcon logo, img1, img2;
    private JTextField tf1, tf2, tf3;
    private JPasswordField pf;
    private JButton btn1, btn2, btn3, nBtn;
    private Cursor cursor;

    Payment() {
        // Frame Layout
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Travel Agency Management System");
        this.setSize(900, 450);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.decode("#F2F2F2"));

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

        // Logo and Images
        // Add logo to the background
        ImageIcon logo = new ImageIcon(getClass().getResource("/images/travel_logo.png"));
        Image scaledImage = logo.getImage().getScaledInstance(400, 400, Image.SCALE_SMOOTH);
        ImageIcon scaledLogo = new ImageIcon(scaledImage);

        imgLabel = new JLabel(scaledLogo);
        imgLabel.setBounds(10, -30, 400, 400); // Adjust position and size of logo
        backgroundPanel.add(imgLabel);

        img1 = new ImageIcon(getClass().getResource("/images/VisaCard.png"));
        imgLabel = new JLabel(img1);
        imgLabel.setBounds(620, 90, img1.getIconWidth(), img1.getIconHeight());
        c.add(imgLabel);
        backgroundPanel.add(imgLabel);

        img2 = new ImageIcon(getClass().getResource("/images/MasterCard.png"));
        imgLabel = new JLabel(img2);
        imgLabel.setBounds(705, 90, img2.getIconWidth(), img2.getIconHeight());
        c.add(imgLabel);
        backgroundPanel.add(imgLabel);

        // Fonts
        f1 = new Font("Serif", Font.BOLD, 32);
        f2 = new Font("Ariel", Font.BOLD, 25);
        f3 = new Font("Segoe UI", Font.ITALIC, 18);
        f4 = new Font("Segoe UI", Font.PLAIN, 15);
        f5 = new Font("Segoe UI Black", Font.PLAIN, 15);
        f6 = new Font("Ariel", Font.PLAIN, 20);

        // Title
        label1 = new JLabel();
        label1.setText("Complete Your Payment");
        label1.setBounds(430, 20, 500, 50);
        label1.setForeground(Color.decode("#153169"));
        label1.setFont(f1);
        c.add(label1);
        backgroundPanel.add(label1);

        label2 = new JLabel("We Accept Only");
        label2.setBounds(420, 85, 500, 50);
        label1.setForeground(Color.decode("#153169"));
        label2.setFont(f2);
        c.add(label2);
        backgroundPanel.add(label2);

        label2 = new JLabel("Card Details");
        label2.setBounds(420, 140, 500, 50);
        label1.setForeground(Color.decode("#153169"));
        label2.setFont(f2);
        c.add(label2);
        backgroundPanel.add(label2);

        // Name On Card
        label3 = new JLabel("Name On Card");
        label3.setBounds(430, 180, 500, 50);
        label3.setFont(f3);
        c.add(label3);
        backgroundPanel.add(label3);

        tf1 = new JTextField();
        tf1.setBounds(570, 190, 235, 30);
        tf1.setFont(f4);
        c.add(tf1);
        backgroundPanel.add(tf1);

        // Card Number
        label3 = new JLabel("Card Number");
        label3.setBounds(430, 220, 500, 50);
        label3.setFont(f3);
        c.add(label3);
        backgroundPanel.add(label3);

        tf2 = new JTextField();
        tf2.setBounds(570, 230, 235, 30);
        tf2.setFont(f4);
        tf2.setHorizontalAlignment(JTextField.CENTER);
        c.add(tf2);
        backgroundPanel.add(tf2);

        // Valid On
        label3 = new JLabel("Valid On");
        label3.setBounds(430, 260, 500, 50);
        label3.setFont(f3);
        c.add(label3);
        backgroundPanel.add(label3);

        tf3 = new JTextField();
        tf3.setBounds(520, 270, 90, 30);
        tf3.setFont(f4);
        tf3.setHorizontalAlignment(JTextField.CENTER);
        c.add(tf3);
        backgroundPanel.add(tf3);

        // CVV Code
        label3 = new JLabel("CVV Code");
        label3.setBounds(640, 260, 500, 50);
        label3.setFont(f3);
        c.add(label3);
        backgroundPanel.add(label3);

        pf = new JPasswordField();
        pf.setBounds(725, 270, 80, 30);
        pf.setHorizontalAlignment(JPasswordField.CENTER);
        pf.setEchoChar('*');
        pf.setFont(f5);
        c.add(pf);
        backgroundPanel.add(pf);

        // Cursor for JButtons
        cursor = new Cursor(Cursor.HAND_CURSOR);

        // JButtons
        btn1 = new JButton("Exit");
        btn1.setBounds(75, 325, 190, 50);
        btn1.setFont(f6);
        btn1.setCursor(cursor);
        btn1.setForeground(Color.WHITE);
        btn1.setBackground(Color.decode("#d1698b"));
        c.add(btn1);
        backgroundPanel.add(btn1);

        btn2 = new JButton("Back");
        btn2.setBounds(300, 325, 190, 50);
        btn2.setFont(f6);
        btn2.setCursor(cursor);
        btn2.setForeground(Color.WHITE);
        btn2.setBackground(Color.decode("#7c4e85"));
        btn2.setEnabled(false);
        c.add(btn2);
        backgroundPanel.add(btn2);

        btn3 = new JButton("Confirm Payment");
        btn3.setBounds(524, 325, 300, 50);
        btn3.setFont(f6);
        btn3.setCursor(cursor);
        btn3.setForeground(Color.WHITE);
        btn3.setBackground(Color.decode("#7c4e85"));
        c.add(btn3);
        backgroundPanel.add(btn3);

        nBtn = new JButton("");
        nBtn.setBounds(0, 0, 0, 0);
        c.add(nBtn);

        // To limit characters
        tf1.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                if (tf1.getText().length() >= 10)
                    e.consume();
            }
        });

        tf2.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                if (tf2.getText().length() >= 19)
                    e.consume();
            }
        });

        tf3.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                if (tf3.getText().length() >= 7)
                    e.consume();
            }
        });

        pf.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                if (pf.getText().length() >= 3)
                    e.consume();
            }
        });

        // Exit Button
        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });

        // Confirm Payment Button
        btn3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                String nameOnCard = tf1.getText();
                String cardNumber = tf2.getText();
                String validOn = tf3.getText();
                String cvvCode = pf.getText();

                if (nameOnCard.isEmpty() || cardNumber.isEmpty() || validOn.isEmpty() || cvvCode.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill all of the fields.", "Warning!",
                            JOptionPane.WARNING_MESSAGE);
                } else {
                    setVisible(false);
                    PaySuccess frame = new PaySuccess();
                    frame.setVisible(true);
                }
            }
        });
    }

    public static void main(String[] args) {

        Payment frame = new Payment();
        frame.setVisible(true);
    }
}
