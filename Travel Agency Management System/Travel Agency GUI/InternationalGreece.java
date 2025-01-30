import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class InternationalGreece extends JFrame {

    private Container c;
    private ImageIcon icon,bg_image ;
    private JLabel label1, label2, label3, imgLabel;
    private Font f1, f2, f3, f4, f5;
    private ImageIcon logo;
    private JButton btn1, btn2, btn3, nBtn;
    private Cursor cursor;
    private ButtonGroup radioButtonGroup;
    private JRadioButton pack1, pack2, pack3;
    private int selected = 0;

    InternationalGreece() {
        // Frame Layout
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Travel Agency Managment System");
        this.setSize(1000, 500);
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
        bg_image = new ImageIcon(getClass().getResource("/images/greece_1.jpeg"));
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

        // Fonts
       f1 = new Font("Serif", Font.BOLD, 35);
       f2 = new Font("Segoe UI Semibold", Font.BOLD, 25);
       f3 = new Font("Segoe UI", Font.PLAIN, 25);
       f4 = new Font("Ariel", Font.ITALIC, 18);
       f5 = new Font("Ariel", Font.PLAIN, 20);

        // // Logo
        // logo = new ImageIcon(getClass().getResource("/images/LogoBlue.png"));
        // imgLabel = new JLabel(logo);
        // imgLabel.setBounds(30, 82, logo.getIconWidth(), logo.getIconHeight());
        // c.add(imgLabel);
        // backgroundPanel.add(imgLabel);

        // Cursor for JButtons and Radio Buttons
        cursor = new Cursor(Cursor.HAND_CURSOR);

        // Title
        label1 = new JLabel();
        label1.setText("3 Packs Available for Greece Tour!");
        label1.setBounds(240, 35, 600, 50);
        label1.setForeground(Color.decode("#153169"));
        label1.setFont(f1);
        c.add(label1);
        backgroundPanel.add(label1);

        // label2 = new JLabel();
        // label2.setText("Select One : ");
        // label2.setBounds(430, 70, 500, 50);
        // label2.setFont(f1);
        // c.add(label2);
        // backgroundPanel.add(label2);

        // Pack 1 Details
        pack1 = new JRadioButton("Pack 1");
        pack1.setBounds(190, 120, 100, 50);
        pack1.setFont(f3);
        pack1.setBackground(Color.decode("#F2F2F2"));
        pack1.setOpaque(false);
        c.add(pack1);
        backgroundPanel.add(pack1);

        label3 = new JLabel();
        label3.setText("* First Class");
        label3.setBounds(190, 150, 520, 50);
        label3.setFont(f4);
        c.add(label3);
        backgroundPanel.add(label3);

        label3 = new JLabel();
        label3.setText("* 5 Star Hotel");
        label3.setBounds(190, 180, 520, 50);
        label3.setFont(f4);
        c.add(label3);
        backgroundPanel.add(label3);

        label3 = new JLabel();
        label3.setText("* By Airplane");
        label3.setBounds(190, 210, 520, 50);
        label3.setFont(f4);
        c.add(label3);
        backgroundPanel.add(label3);

        label3 = new JLabel();
        label3.setText("* 5 Persons");
        label3.setBounds(190, 240, 520, 50);
        label3.setFont(f4);
        c.add(label3);
        backgroundPanel.add(label3);

        label3 = new JLabel();
        label3.setText("* 6 Days");
        label3.setBounds(190, 270, 520, 50);
        label3.setFont(f4);
        c.add(label3);
        backgroundPanel.add(label3);

        label3 = new JLabel();
        label3.setText("* Cost : $2500");
        label3.setBounds(190, 300, 520, 50);
        label3.setFont(f4);
        c.add(label3);
        backgroundPanel.add(label3);

        // Pack 2 Details
        pack2 = new JRadioButton("Pack 2");
        pack2.setBounds(425, 120, 100, 50);
        pack2.setFont(f3);
        pack2.setBackground(Color.decode("#F2F2F2"));
        pack2.setOpaque(false);
        c.add(pack2);
        backgroundPanel.add(pack2);

        label3 = new JLabel();
        label3.setText("* Second Class");
        label3.setBounds(425, 150, 500, 50);
        label3.setFont(f4);
        c.add(label3);
        backgroundPanel.add(label3);

        label3 = new JLabel();
        label3.setText("* 3 Star Hotel");
        label3.setBounds(425, 180, 500, 50);
        label3.setFont(f4);
        c.add(label3);
        backgroundPanel.add(label3);

        label3 = new JLabel();
        label3.setText("* By Airplane");
        label3.setBounds(425, 210, 500, 50);
        label3.setFont(f4);
        c.add(label3);
        backgroundPanel.add(label3);

        label3 = new JLabel();
        label3.setText("* 4 Persons");
        label3.setBounds(425, 240, 500, 50);
        label3.setFont(f4);
        c.add(label3);
        backgroundPanel.add(label3);

        label3 = new JLabel();
        label3.setText("* 4 Days");
        label3.setBounds(425, 270, 500, 50);
        label3.setFont(f4);
        c.add(label3);
        backgroundPanel.add(label3);

        label3 = new JLabel();
        label3.setText("* Cost : $1300");
        label3.setBounds(425, 300, 500, 50);
        label3.setFont(f4);
        c.add(label3);
        backgroundPanel.add(label3);

        // Pack 3 Details
        pack3 = new JRadioButton("Pack 3");
        pack3.setBounds(660, 120, 500, 50);
        pack3.setFont(f3);
        pack3.setBackground(Color.decode("#F2F2F2"));
        pack3.setOpaque(false);
        c.add(pack3);
        backgroundPanel.add(pack3);

        label3 = new JLabel();
        label3.setText("* Third Class");
        label3.setBounds(660, 150, 500, 50);
        label3.setFont(f4);
        c.add(label3);
        backgroundPanel.add(label3);

        label3 = new JLabel();
        label3.setText("* 2 Star Hotel");
        label3.setBounds(660, 180, 500, 50);
        label3.setFont(f4);
        c.add(label3);
        backgroundPanel.add(label3);

        label3 = new JLabel();
        label3.setText("* By Airplane");
        label3.setBounds(660, 210, 500, 50);
        label3.setFont(f4);
        c.add(label3);
        backgroundPanel.add(label3);

        label3 = new JLabel();
        label3.setText("* 4 Persons");
        label3.setBounds(660, 240, 500, 50);
        label3.setFont(f4);
        c.add(label3);
        backgroundPanel.add(label3);

        label3 = new JLabel();
        label3.setText("* 3 Days");
        label3.setBounds(660, 270, 500, 50);
        label3.setFont(f4);
        c.add(label3);
        backgroundPanel.add(label3);

        label3 = new JLabel();
        label3.setText("* Cost : $800");
        label3.setBounds(660, 300, 500, 50);
        label3.setFont(f4);
        c.add(label3);
        backgroundPanel.add(label3);

        // To group the radio buttons.
        radioButtonGroup = new ButtonGroup();
        radioButtonGroup.add(pack1);
        radioButtonGroup.add(pack2);
        radioButtonGroup.add(pack3);

        // JButtons
        btn1 = new JButton("Exit");
        btn1.setBounds(148, 375, 215, 50);
        btn1.setFont(f5);
        btn1.setCursor(cursor);
        btn1.setForeground(Color.WHITE);
        btn1.setBackground(Color.decode("#d1698b"));
        c.add(btn1);
        backgroundPanel.add(btn1);

        btn2 = new JButton("Back");
        btn2.setBounds(384, 375, 215, 50);
        btn2.setFont(f5);
        btn2.setCursor(cursor);
        btn2.setForeground(Color.WHITE);
        btn2.setBackground(Color.decode("#43426E"));;
        c.add(btn2);
        backgroundPanel.add(btn2);

        btn3 = new JButton("Pay");
        btn3.setBounds(617, 375, 215, 50);
        btn3.setFont(f5);
        btn3.setCursor(cursor);
        btn3.setForeground(Color.WHITE);
        btn3.setBackground(Color.decode("#43426E"));
        c.add(btn3);
        backgroundPanel.add(btn3);

        nBtn = new JButton("");
        nBtn.setBounds(0, 0, 0, 0);
        c.add(nBtn);

        Handler handler = new Handler();
        pack1.addActionListener(handler);
        pack2.addActionListener(handler);
        pack3.addActionListener(handler);

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
                setVisible(false);
                IntCountries frame = new IntCountries();
                frame.setVisible(true);
            }
        });

        // Next Button
        btn3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                if (selected == 0) {
                    JOptionPane.showMessageDialog(null, "You did not select any packs.", "Warning!",
                            JOptionPane.WARNING_MESSAGE);
                } else {
                    setVisible(false);
                    Payment frame = new Payment();
                    frame.setVisible(true);
                }
            }
        });
    }

    class Handler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == pack1) {
                selected = 1;
            } else if (e.getSource() == pack2) {
                selected = 2;
            } else if (e.getSource() == pack3) {
                selected = 3;
            }
        }
    }

    public static void main(String[] args) {

        InternationalGreece frame = new InternationalGreece();
        frame.setVisible(true);
    }
}
