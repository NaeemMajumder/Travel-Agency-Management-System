import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;

public class PaySuccess extends JFrame {

    private Container c;
    private ImageIcon icon, bg_image;
    private JLabel label1, imgLabel;
    private Font f1, f2;
    private ImageIcon logo;
    private JButton btn1, nBtn;
    private Cursor cursor;

    PaySuccess() {
        // Frame Layout
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Travel Agency Management System");
        this.setSize(900, 450);
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
                bg_image = new ImageIcon(getClass().getResource("/images/France.jpg"));
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

        // Logo
        ImageIcon logo = new ImageIcon(getClass().getResource("/images/travel_logo.png"));
        Image scaledImage = logo.getImage().getScaledInstance(400, 400, Image.SCALE_SMOOTH);
        ImageIcon scaledLogo = new ImageIcon(scaledImage);

        imgLabel = new JLabel(scaledLogo);
        imgLabel.setBounds(15, 0, 400, 400); // Adjust position and size of logo
        backgroundPanel.add(imgLabel);

        // Fonts
        f1 = new Font("Serif", Font.BOLD, 40);
        f2 = new Font("Areal", Font.PLAIN, 20);

        // Title
        label1 = new JLabel();
        label1.setText("Your Payment Has");
        label1.setBounds(430, 80, 500, 50);
        label1.setFont(f1);
        label1.setForeground(Color.decode("#153169"));
        c.add(label1);
        backgroundPanel.add(label1);

        label1 = new JLabel();
        label1.setText("Successfully Completed.");
        label1.setBounds(430, 130, 500, 50);
        label1.setForeground(Color.decode("#153169"));
        label1.setFont(f1);
        c.add(label1);
        backgroundPanel.add(label1);

        label1 = new JLabel();
        label1.setText("Happy Travel :)");
        label1.setBounds(430, 180, 500, 50);
        label1.setForeground(Color.decode("#153169"));
        label1.setFont(f1);
        c.add(label1);
        backgroundPanel.add(label1);

        // Cursor for JButtons
        cursor = new Cursor(Cursor.HAND_CURSOR);

        btn1 = new JButton("Finish");
        btn1.setBounds(475, 310, 200, 50);
        btn1.setFont(f2);
        btn1.setCursor(cursor);
        btn1.setForeground(Color.WHITE);
        btn1.setBackground(Color.decode("#43426E"));
        c.add(btn1);
        backgroundPanel.add(btn1);

        nBtn = new JButton("");
        nBtn.setBounds(0, 0, 0, 0);
        c.add(nBtn);

        // Add action listener to the Finish button
        btn1.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent ae) {
        // Sample order details
        int packageId = 101;
        int userId = 10011;
        String userEmail = "jodu@modu.com";
        String userName = "Jodu Modu";
        double amount = 100001;

        // Insert order details into the database
        insertOrderDetails(packageId, userId, userEmail, userName, amount);

        // Exit the application
        System.exit(0);
        }
        });
    }

    // Method to establish database connection
    public Connection connectToDatabase() {
        try {
            // Load the JDBC driver (MySQL Connector/J)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Database credentials
            String url = "jdbc:mysql://localhost:3306/travel_agency_database"; // Your DB name
            String user = "root"; // Your MySQL username
            String password = "voldemort"; // Your MySQL password

            // Establish connection
            Connection con = DriverManager.getConnection(url, user, password);
            return con;

        } catch (Exception e) {
            System.out.println("Database connection failed: " + e.getMessage());
            return null;
        }
    }

    // Method to insert order details into the database
    public void insertOrderDetails(int packageId, int userId, String userEmail, String userName, double amount) {
        Connection con = connectToDatabase();
        if (con != null) {
            try {

                // [Default Pack, France, international, 84353f1f, 15e00348, 2460d6dc,
                // naeem@gmail.com, naeem, 3000]

                // Example of accessing selectedData array from DataStore class
                String[] selectedData = DataStore.selectedData; // Accessing selectedData from DataStore

                String query = "INSERT INTO orderDetails (order_id, package_id, user_id, user_email, user_name, tour_pack, tour_type, tour_place, amount) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement pst = con.prepareStatement(query);

                // Set the values for the query parameters
                pst.setString(1, selectedData[3]);
                pst.setString(2, selectedData[4]);
                pst.setString(3, selectedData[5]);
                pst.setString(4, selectedData[6]);
                pst.setString(5, selectedData[7]);
                pst.setString(6, selectedData[0]);
                pst.setString(7, selectedData[2]);
                pst.setString(8, selectedData[1]);
                pst.setString(9, selectedData[8]);

                // Execute the query
                pst.executeUpdate();
                System.out.println("Order details inserted successfully.");

            } catch (SQLException e) {
                System.out.println("Error inserting data: " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        PaySuccess frame = new PaySuccess();
        frame.setVisible(true);
    }
}
