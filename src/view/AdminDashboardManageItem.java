package view;

public class AdminDashboardManageItem extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = 
        java.util.logging.Logger.getLogger(AdminDashboardManageItem.class.getName());

    public AdminDashboardManageItem() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        label1 = new java.awt.Label();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        jPanel1.setLayout(null);

        label1.setText("Admin Dashboard");
        jPanel1.add(label1);
        label1.setBounds(270, 60, 120, 40);

        jPanel1.add(jLabel1);
        jLabel1.setBounds(150, 60, 100, 40);

        jButton1.setText("Log out");
        jPanel1.add(jButton1);
        jButton1.setBounds(630, 50, 80, 25);

        jButton7.setText("Manage Items");
        jPanel1.add(jButton7);
        jButton7.setBounds(10, 200, 120, 25);

        jButton3.setText("Manage User");
        jPanel1.add(jButton3);
        jButton3.setBounds(140, 200, 120, 25);

        jButton4.setText("Manage Order");
        jButton4.addActionListener(this::jButton4ActionPerformed);
        jPanel1.add(jButton4);
        jButton4.setBounds(270, 200, 120, 25);

        jButton5.setText("Manage Delivery");
        jButton5.addActionListener(this::jButton5ActionPerformed);
        jPanel1.add(jButton5);
        jButton5.setBounds(400, 200, 120, 25);

        jButton6.setText("Reports");
        jButton6.addActionListener(this::jButton6ActionPerformed);
        jPanel1.add(jButton6);
        jButton6.setBounds(530, 200, 80, 25);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{"Item ID", "Item Name", "Price", "Category"}
        ));
        jScrollPane4.setViewportView(jTable1);

        jPanel1.add(jScrollPane4);
        jScrollPane4.setBounds(160, 280, 420, 200);

        jButton8.setText("Add");
        jButton8.addActionListener(this::jButton8ActionPerformed);
        jPanel1.add(jButton8);
        jButton8.setBounds(360, 500, 60, 25);

        jButton9.setText("Edit");
        jButton9.addActionListener(this::jButton9ActionPerformed);
        jPanel1.add(jButton9);
        jButton9.setBounds(430, 500, 60, 25);

        jButton10.setText("Delete");
        jPanel1.add(jButton10);
        jButton10.setBounds(500, 500, 70, 25);

        jButton11.setText("Save Changes");
        jButton11.addActionListener(this::jButton11ActionPerformed);
        jPanel1.add(jButton11);
        jButton11.setBounds(580, 500, 120, 25);

        jButton12.setText("Back");
        jPanel1.add(jButton12);
        jButton12.setBounds(10, 60, 80, 25);

        jLabel3.setIcon(new javax.swing.ImageIcon(
                "C:\\Users\\sriya\\OneDrive\\Documents\\WhatsApp Image 2025-12-03 at 18.08.32_88123ff1.jpg"));
        jPanel1.add(jLabel3);
        jLabel3.setBounds(0, 0, 730, 580);

        getContentPane().setLayout(new javax.swing.GroupLayout(getContentPane()));
        getContentPane().add(jPanel1);
        setSize(750, 600);
        setLocationRelativeTo(null);
    }

    // ------------------- BUTTON ACTIONS -------------------

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
        System.out.println("Manage Order Clicked");
    }

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {
        System.out.println("Manage Delivery Clicked");
    }

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {
        System.out.println("Reports Clicked");
    }

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {
        System.out.println("Add Clicked");
    }

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {
        System.out.println("Edit Clicked");
    }

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {
        System.out.println("Save Changes Clicked");
    }

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : 
                    javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> new AdminDashboardManageItem().setVisible(true));
    }

    // Variables declaration
    private javax.swing.JButton jButton1, jButton3, jButton4, jButton5, jButton6,
            jButton7, jButton8, jButton9, jButton10, jButton11, jButton12;
    private javax.swing.JLabel jLabel1, jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private java.awt.Label label1;
}
