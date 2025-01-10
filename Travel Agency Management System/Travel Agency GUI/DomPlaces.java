import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class DomPlaces extends JFrame {

    private Container c;
    private ImageIcon icon, bg_image;
    private JLabel label1, imgLabel;
    private Font f1, f2, f3;
    private ImageIcon logo;
    private JButton btn1, btn2, btn3, nBtn;
    private Cursor cursor;
    private JRadioButton place1, place2, place3, place4, place5;
    private ButtonGroup jButtonGroup;
    private int place = 0;

    DomPlaces() {
        // Frame Layout
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Travel Agency Management System");
        this.setSize(850, 460);
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
                bg_image = new ImageIcon(getClass().getResource("/images/domestic_page.jpg"));
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

        // Icon
        icon = new ImageIcon(getClass().getResource("/images/travel_logo.png"));
        this.setIconImage(icon.getImage());

        // logo
        ImageIcon logo = new ImageIcon(getClass().getResource("/images/travel_logo.png"));
        Image logoImage = logo.getImage().getScaledInstance(400, 400, Image.SCALE_SMOOTH);
        ImageIcon logoScaled = new ImageIcon(logoImage);

        imgLabel = new JLabel(logoScaled);
        imgLabel.setBounds(380, -20, 400, 400);
        backgroundPanel.add(imgLabel);

        // Fonts
        f1 = new Font("Serif", Font.BOLD, 30);
        f2 = new Font("Ariel", Font.ITALIC, 20);
        f3 = new Font("Ariel", Font.PLAIN, 20);

        // Cursor for JButtons and Radio Buttons
        cursor = new Cursor(Cursor.HAND_CURSOR);

        // Title
        label1 = new JLabel();
        label1.setText("The Country is Yours to ");
        label1.setBounds(60, 25, 500, 50);
        label1.setFont(f1);
        label1.setForeground(Color.decode("#153169"));
        c.add(label1);
        backgroundPanel.add(label1);

        label1 = new JLabel();
        label1.setText("Explore Where First?");
        label1.setBounds(60, 65, 500, 50);
        label1.setForeground(Color.decode("#153169"));
        label1.setFont(f1);
        c.add(label1);
        backgroundPanel.add(label1);

        // Country JButtons
        place1 = new JRadioButton("Cox's Bazar");
        place1.setBounds(80, 110, 200, 50);
        place1.setFont(f2);
        place1.setBackground(Color.decode("#F2F2F2"));
        place1.setOpaque(false);
        place1.setCursor(cursor);
        c.add(place1);
        backgroundPanel.add(place1);

        place2 = new JRadioButton("Sajek Valley");
        place2.setBounds(80, 150, 200, 50);
        place2.setFont(f2);
        place2.setBackground(Color.decode("#F2F2F2"));
        place2.setOpaque(false);
        place2.setCursor(cursor);
        c.add(place2);
        backgroundPanel.add(place2);

        place3 = new JRadioButton("Sreemangal");
        place3.setBounds(80, 190, 200, 50);
        place3.setFont(f2);
        place3.setBackground(Color.decode("#F2F2F2"));
        place3.setOpaque(false);
        place3.setCursor(cursor);
        c.add(place3);
        backgroundPanel.add(place3);

        place4 = new JRadioButton("Bandarban");
        place4.setBounds(80, 230, 200, 50);
        place4.setFont(f2);
        place4.setBackground(Color.decode("#F2F2F2"));
        place4.setOpaque(false);
        place4.setCursor(cursor);
        c.add(place4);
        backgroundPanel.add(place4);

        place5 = new JRadioButton("Rangamati");
        place5.setBounds(80, 270, 200, 50);
        place5.setFont(f2);
        place5.setBackground(Color.decode("#F2F2F2"));
        place5.setOpaque(false);
        place5.setCursor(cursor);
        c.add(place5);
        backgroundPanel.add(place5);

        // To Group JButtons
        jButtonGroup = new ButtonGroup();
        jButtonGroup.add(place1);
        jButtonGroup.add(place2);
        jButtonGroup.add(place3);
        jButtonGroup.add(place4);
        jButtonGroup.add(place5);

        btn1 = new JButton("Exit");
        btn1.setBounds(50, 340, 215, 50);
        btn1.setFont(f3);
        btn1.setCursor(cursor);
        btn1.setForeground(Color.WHITE);
        btn1.setBackground(Color.decode("#d1698b"));
        c.add(btn1);
        backgroundPanel.add(btn1);

        btn2 = new JButton("Back");
        btn2.setBounds(310, 340, 215, 50);
        btn2.setFont(f3);
        btn2.setCursor(cursor);
        btn2.setForeground(Color.WHITE);
        btn2.setBackground(Color.decode("#43426E"));;
        c.add(btn2);
        backgroundPanel.add(btn2);

        btn3 = new JButton("Next");
        btn3.setBounds(570, 340, 215, 50);
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
        place1.addActionListener(handler);
        place2.addActionListener(handler);
        place3.addActionListener(handler);
        place4.addActionListener(handler);
        place5.addActionListener(handler);

        // Action Listener for JButtons
        // Exit Button
        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });

        // Back Button
        btn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                DefPackTypes frame = new DefPackTypes();
                frame.setVisible(true);
                setVisible(false);
            }
        });

        // Next Button
        btn3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                if (place == 1) {
                    setVisible(false);
                    DomesticCoxsBazar frame = new DomesticCoxsBazar();
                    frame.setVisible(true);
                } else if (place == 2) {
                    setVisible(false);
                    DomesticSajekValley frame = new DomesticSajekValley();
                    frame.setVisible(true);
                } else if (place == 3) {
                    setVisible(false);
                    DomesticSreemangal frame = new DomesticSreemangal();
                    frame.setVisible(true);
                } else if (place == 4) {
                    setVisible(false);
                    DomesticBandarban frame = new DomesticBandarban();
                    frame.setVisible(true);
                } else if (place == 5) {
                    setVisible(false);
                    DomesticRangamati frame = new DomesticRangamati();
                    frame.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Please select Place.", "Warning!!!",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        });
    }

    class Handler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == place1) {
                place = 1;
            } else if (e.getSource() == place2) {
                place = 2;
            } else if (e.getSource() == place3) {
                place = 3;
            } else if (e.getSource() == place4) {
                place = 4;
            } else if (e.getSource() == place5) {
                place = 5;
            }
        }
    }

    public static void main(String[] args) {

        DomPlaces frame = new DomPlaces();
        frame.setVisible(true);
    }
}
