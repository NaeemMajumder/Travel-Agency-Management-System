import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class DefPackTypes extends JFrame {

    private Container c;
    private ImageIcon icon, bg_image;
    private JLabel label1, imgLabel;
    private Font f1, f2, f3;
    private ImageIcon logo;
    private JButton btn1, btn2, btn3, nBtn;
    private Cursor cursor;
    private JRadioButton international, domestic;
    private ButtonGroup radioButtonGroup;
    private int defPack = 0;

    DefPackTypes() {
        // Frame Layout
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Travel Agency Management System");
        this.setSize(900, 400);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.decode("#F2F2F2"));

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

        backgroundPanel.setLayout(null);
        setContentPane(backgroundPanel);

        // Icon
        icon = new ImageIcon(getClass().getResource("/images/travel_logo.png"));
        this.setIconImage(icon.getImage());

        // Logo
        // logo = new ImageIcon(getClass().getResource("/images/LogoBlue.png"));
        // imgLabel = new JLabel(logo);
        // imgLabel.setBounds(30, 50, logo.getIconWidth(), logo.getIconHeight());
        // c.add(imgLabel);
        // backgroundPanel.add(imgLabel);



        ImageIcon domestic_img = new ImageIcon(getClass().getResource("/images/domestic.jpg"));
        Image DomesticImage = domestic_img.getImage().getScaledInstance(250, 150, Image.SCALE_SMOOTH);
        ImageIcon domesticScaled = new ImageIcon(DomesticImage);

        imgLabel = new JLabel(domesticScaled);
        imgLabel.setBounds(320, 70, 300, 220);
        backgroundPanel.add(imgLabel);


        ImageIcon international_img = new ImageIcon(getClass().getResource("/images/international.jpg"));
        Image internationalImage = international_img.getImage().getScaledInstance(250, 150, Image.SCALE_SMOOTH);
        ImageIcon internationalScaled = new ImageIcon(internationalImage);

        imgLabel = new JLabel(internationalScaled);
        imgLabel.setBounds(40, 70, 300, 220);
        backgroundPanel.add(imgLabel);








        // Fonts
        f1 = new Font("Serif", Font.BOLD, 35);
        f2 = new Font("Ariel", Font.ITALIC, 23);
        f3 = new Font("Ariel", Font.PLAIN, 20);

        // Cursor for JButtons and Radio Buttons
        cursor = new Cursor(Cursor.HAND_CURSOR);

        // Title
        label1 = new JLabel();
        label1.setText("Choose Your Travel Horizon");
        label1.setBounds(150, 10, 500, 50);
        label1.setFont(f1);
        label1.setForeground(Color.decode("#153169"));
        c.add(label1);
        backgroundPanel.add(label1);

        // International Radio Button
        international = new JRadioButton("International");
        international.setBounds(110, 260, 300, 50);
        international.setFont(f2);
        international.setCursor(cursor);
        international.setOpaque(false);
        c.add(international);
        backgroundPanel.add(international);

        // Domestic Radio Button
        domestic = new JRadioButton("Domestic");
        domestic.setBounds(400, 260, 300, 50);
        domestic.setFont(f2);
        domestic.setCursor(cursor);
        domestic.setOpaque(false);
        c.add(domestic);
        backgroundPanel.add(domestic);

        // To group radio buttons
        radioButtonGroup = new ButtonGroup();
        radioButtonGroup.add(international);
        radioButtonGroup.add(domestic);

        // Jbuttons
        btn1 = new JButton("Exit");
        btn1.setBounds(650, 260, 160, 45);
        btn1.setFont(f3);
        btn1.setCursor(cursor);
        btn1.setForeground(Color.WHITE);
        btn1.setBackground(Color.decode("#d1698b"));
        c.add(btn1);
        backgroundPanel.add(btn1);


        btn2 = new JButton("Back");
        btn2.setBounds(650, 175, 160, 45);
        btn2.setFont(f3);
        btn2.setCursor(cursor);
        btn2.setForeground(Color.WHITE);
        btn2.setBackground(Color.decode("#43426E"));
        c.add(btn2);
        backgroundPanel.add(btn2);

        btn3 = new JButton("Next");
        btn3.setBounds(650, 90, 160, 45);
        btn3.setFont(f3);
        btn3.setCursor(cursor);
        btn3.setForeground(Color.WHITE);
        btn3.setBackground(Color.decode("#43426E"));
        c.add(btn3);
        backgroundPanel.add(btn3);

        nBtn = new JButton("");
        nBtn.setBounds(0, 0, 0, 0);
        c.add(nBtn);

        Handler handler = new Handler();
        international.addActionListener(handler);
        domestic.addActionListener(handler);

        // Exit Button
        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });

        // Back Button
        btn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                Packs frame = new Packs();
                frame.setVisible(true);
                setVisible(false);
            }
        });

        // Next Button
        btn3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                if (defPack == 1) {
                    IntCountries frame = new IntCountries();
                    frame.setVisible(true);
                    setVisible(false);
                    dispose();
                } else if (defPack == 2) {
                    DomPlaces frame = new DomPlaces();
                    frame.setVisible(true);
                    setVisible(false);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Please select tour type.", "Warning!",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        });
    }

    class Handler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == international) {
                defPack = 1;
            } else if (e.getSource() == domestic) {
                defPack = 2;
            }
        }
    }

    public static void main(String[] args) {

        DefPackTypes frame = new DefPackTypes();
        frame.setVisible(true);
    }
}