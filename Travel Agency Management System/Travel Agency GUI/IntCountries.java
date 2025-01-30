import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class IntCountries extends JFrame {

    private Container c;
    private ImageIcon icon, bg_image;
    private JLabel label1, imgLabel;
    private Font f1, f2, f3;
    private ImageIcon logo;
    private JButton btn1, btn2, btn3, nBtn;
    private Cursor cursor;
    private JRadioButton country1, country2, country3, country4, country5;
    private ButtonGroup jButtonGroup;
    private int country = 0;

    IntCountries() {
        // Frame Layout
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Travel Agency Management system");
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
                bg_image = new ImageIcon(getClass().getResource("/images/International_page.jpg"));
                backgroundImage = bg_image.getImage();
            }

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;

                // Draw the background image with opacity, scaled to fit panel dimensions
                float opacity = 0.4f; // Adjust as needed
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

        // // Logo
        // logo = new ImageIcon(getClass().getResource("/images/LogoBlue.png"));
        // imgLabel = new JLabel(logo);
        // imgLabel.setBounds(30, 50, logo.getIconWidth(), logo.getIconHeight());
        // c.add(imgLabel);
        // backgroundPanel.add(imgLabel);

        // Fonts
        f1 = new Font("Serif", Font.BOLD, 30);
        f2 = new Font("Ariel", Font.ITALIC, 20);
        f3 = new Font("Ariel", Font.PLAIN, 20);

        // Cursor for JButtons and Radio Buttons
        cursor = new Cursor(Cursor.HAND_CURSOR);

        // Title
        label1 = new JLabel();
        label1.setText("Which Spot on the Map");
        label1.setBounds(60, 25, 500, 50);
        label1.setForeground(Color.decode("#153169"));
        label1.setFont(f1);
        c.add(label1);
        backgroundPanel.add(label1);

        label1 = new JLabel();
        label1.setText("Calls to You?");
        label1.setBounds(60, 65, 500, 50);
        label1.setForeground(Color.decode("#153169"));
        label1.setFont(f1);
        c.add(label1);
        backgroundPanel.add(label1);

        // Country JButtons
        country1 = new JRadioButton("France");
        country1.setBounds(80, 110, 100, 50);
        country1.setFont(f2);
        country1.setBackground(Color.decode("#F2F2F2"));
        country1.setOpaque(false);
        country1.setCursor(cursor);
        c.add(country1);
        backgroundPanel.add(country1);

        country2 = new JRadioButton("Italy");
        country2.setBounds(80, 140, 200, 50);
        country2.setFont(f2);
        country2.setBackground(Color.decode("#F2F2F2"));
        country2.setOpaque(false);
        country2.setCursor(cursor);
        c.add(country2);
        backgroundPanel.add(country2);

        country3 = new JRadioButton("Greece");
        country3.setBounds(80, 180, 200, 50);
        country3.setFont(f2);
        country3.setBackground(Color.decode("#F2F2F2"));
        country3.setOpaque(false);
        country3.setCursor(cursor);
        c.add(country3);
        backgroundPanel.add(country3);

        country4 = new JRadioButton("South Korea");
        country4.setBounds(80, 220, 200, 50);
        country4.setFont(f2);
        country4.setBackground(Color.decode("#F2F2F2"));
        country4.setOpaque(false);
        country4.setCursor(cursor);
        c.add(country4);
        backgroundPanel.add(country4);

        country5 = new JRadioButton("Thailand");
        country5.setBounds(80, 260, 200, 50);
        country5.setFont(f2);
        country5.setBackground(Color.decode("#F2F2F2"));
        country5.setOpaque(false);
        country5.setCursor(cursor);
        c.add(country5);
        backgroundPanel.add(country5);

        // To Group JButtons
        jButtonGroup = new ButtonGroup();
        jButtonGroup.add(country1);
        jButtonGroup.add(country2);
        jButtonGroup.add(country3);
        jButtonGroup.add(country4);
        jButtonGroup.add(country5);

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
        btn2.setBackground(Color.decode("#43426E"));
        ;
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

        class Handler implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                String place = ""; // Use a String to store the selected place

                if (e.getSource() == country1) {
                    place = "France"; // Set the place name as a string
                } else if (e.getSource() == country2) {
                    place = "Italy";
                } else if (e.getSource() == country3) {
                    place = "Greece";
                } else if (e.getSource() == country4) {
                    place = "South Korea";
                } else if (e.getSource() == country5) {
                    place = "Thailand";
                }

                // Store the selected place in DataStore as a string
                DataStore.setSelectedPlace(place);
            }
        }

        nBtn = new JButton("");
        nBtn.setBounds(0, 0, 0, 0);
        c.add(nBtn);

        Handler handler = new Handler();
        country1.addActionListener(handler);
        country2.addActionListener(handler);
        country3.addActionListener(handler);
        country4.addActionListener(handler);
        country5.addActionListener(handler);

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
        // btn3.addActionListener(new ActionListener() {
        //     public void actionPerformed(ActionEvent ae) {
        //         if (country == 1) {
        //             setVisible(false);
        //             InternationalFrance frame = new InternationalFrance();
        //             frame.setVisible(true);
        //         } else if (country == 2) {
        //             setVisible(false);
        //             InternationalItaly frame = new InternationalItaly();
        //             frame.setVisible(true);
        //         } else if (country == 3) {
        //             setVisible(false);
        //             InternationalGreece frame = new InternationalGreece();
        //             frame.setVisible(true);
        //         } else if (country == 4) {
        //             setVisible(false);
        //             InternationalSouthAfrica frame = new InternationalSouthAfrica();
        //             frame.setVisible(true);
        //         } else if (country == 5) {
        //             setVisible(false);
        //             InternationalIndonesia frame = new InternationalIndonesia();
        //             frame.setVisible(true);
        //         } else {
        //             JOptionPane.showMessageDialog(null, "Please select country.", "Warming!!!",
        //                     JOptionPane.WARNING_MESSAGE);
        //         }
        //     }
        // });

        btn3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                String selectedPlace = DataStore.getSelectedPlace(); // Get the selected place as a String

                if ("France".equals(selectedPlace)) {
                    setVisible(false);
                    InternationalFrance frame = new InternationalFrance();
                    frame.setVisible(true);
                } else if ("Italy".equals(selectedPlace)) {
                    setVisible(false);
                    InternationalItaly frame = new InternationalItaly();
                    frame.setVisible(true);
                } else if ("Greece".equals(selectedPlace)) {
                    setVisible(false);
                    InternationalGreece frame = new InternationalGreece();
                    frame.setVisible(true);
                } else if ("South Korea".equals(selectedPlace)) {
                    setVisible(false);
                    InternationalSouthAfrica frame = new InternationalSouthAfrica();
                    frame.setVisible(true);
                } else if ("Thailand".equals(selectedPlace)) {
                    setVisible(false);
                    InternationalIndonesia frame = new InternationalIndonesia();
                    frame.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Please select a place.", "Warning!!!",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        });
    }

    class Handler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == country1) {
                country = 1;
            } else if (e.getSource() == country2) {
                country = 2;
            } else if (e.getSource() == country3) {
                country = 3;
            } else if (e.getSource() == country4) {
                country = 4;
            } else if (e.getSource() == country5) {
                country = 5;
            }
        }
    }

    public static void main(String[] args) {

        IntCountries frame = new IntCountries();
        frame.setVisible(true);
    }
}
