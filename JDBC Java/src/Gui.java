import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;

public class Gui extends JFrame {
    private JPanel panel1;
    private JTabbedPane tabbedPane1;
    private JPanel panelMenuInsert;
    private JTextField textFieldInsert;
    private JButton OKButtonInsert;
    private JPanel panelMenuMod;
    private JTextField textFieldMod1;
    private JTextField textFieldMod2;
    private JButton OKButtonMod;
    private JPanel panelMenuDel;
    private JTextField textFieldDel;
    private JButton OKButtonDel;
    private JPanel panelMenuView;
    private JButton OKButtonView;
    private JTextArea textAreaView;
    private JTextField textFieldView;

    Gui(final Connection conn) throws SQLException {
        this.$$$setupUI$$$();
        this.add(this.panel1);
        this.setSize(600, 400);
        this.setResizable(false);
        this.setDefaultCloseOperation(3);
        this.OKButtonInsert.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String input = Gui.this.textFieldInsert.getText();
                if (input.length() > 0) {
                    String query = "insert into Aereo(Modello) values ('" + input + "')";
                    Statement st = null;


                    try {
                        st = conn.createStatement();
                        st.executeUpdate(query);
                    } catch (SQLException var6) {
                        throw new RuntimeException(var6);
                    }
                }

            }
        });
        this.OKButtonMod.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String idInput = Gui.this.textFieldMod1.getText();
                String titleInput = Gui.this.textFieldMod2.getText();
                if (!idInput.equals("") && !titleInput.equals("")) {
                    String query = "update Aereo set Modello = '" + titleInput + "' where Codice_Aereo = " + idInput;
                    System.out.println(query);
                    Statement st = null;


                    try {
                        st = conn.createStatement();
                        st.executeUpdate(query);
                    } catch (SQLException var7) {
                        throw new RuntimeException(var7);
                    }
                }

            }
        });
        this.OKButtonDel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String idInput = Gui.this.textFieldDel.getText();
                if (!idInput.equals("")) {
                    String query = "delete from Aereo where Codice_Aereo = " + idInput;
                    Statement st = null;


                    try {
                        st = conn.createStatement();
                        st.executeUpdate(query);
                    } catch (SQLException var6) {
                        throw new RuntimeException(var6);
                    }
                }

            }
        });
        this.OKButtonView.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Gui.this.textAreaView.setText((String) null);
                String idInput = Gui.this.textFieldView.getText();
                String query;
                Statement st;
                ResultSet rs;
                int Codice_Aereo;
                String Modello;
                if (!idInput.equals("")) {
                    query = "select * from Aereo where Codice_Aereo = " + idInput;
                    st = null;

                    try {
                        st = conn.createStatement();
                        rs = st.executeQuery(query);

                        while (rs.next()) {
                            Codice_Aereo = rs.getInt("Codice_Aereo");
                            Modello = rs.getString("Modello");
                            Gui.this.textAreaView.append("Codice_Aereo: " + Codice_Aereo + ", Modello: " + Modello + "\n");
                        }
                    } catch (SQLException var9) {
                        throw new RuntimeException(var9);
                    }
                } else {
                    query = "select * from Aereo";
                    st = null;

                    try {
                        st = conn.createStatement();
                        rs = st.executeQuery(query);

                        while (rs.next()) {
                            Codice_Aereo = rs.getInt("Codice_Aereo");
                            Modello = rs.getString("Modello");
                            Gui.this.textAreaView.append("Codice_Aereo: " + Codice_Aereo + ", Modello: " + Modello + "\n");
                        }
                    } catch (SQLException var8) {
                        throw new RuntimeException(var8);
                    }
                }
            }
        });
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        panel1 = new JPanel();
        panel1.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        tabbedPane1 = new JTabbedPane();
        panel1.add(tabbedPane1, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(200, 200), null, 0, false));
        panelMenuInsert = new JPanel();
        panelMenuInsert.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(3, 2, new Insets(0, 0, 0, 0), -1, -1));
        tabbedPane1.addTab("Inserisci", panelMenuInsert);
        final JLabel label1 = new JLabel();
        label1.setText("Inserisci il modello aereo:");
        panelMenuInsert.add(label1, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer1 = new com.intellij.uiDesigner.core.Spacer();
        panelMenuInsert.add(spacer1, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        textFieldInsert = new JTextField();
        panelMenuInsert.add(textFieldInsert, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        OKButtonInsert = new JButton();
        OKButtonInsert.setText("OK");
        panelMenuInsert.add(OKButtonInsert, new com.intellij.uiDesigner.core.GridConstraints(1, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        panelMenuMod = new JPanel();
        panelMenuMod.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(4, 2, new Insets(0, 0, 0, 0), -1, -1));
        tabbedPane1.addTab("Modifica", panelMenuMod);
        final JLabel label2 = new JLabel();
        label2.setText("Inserire Codice:");
        panelMenuMod.add(label2, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer2 = new com.intellij.uiDesigner.core.Spacer();
        panelMenuMod.add(spacer2, new com.intellij.uiDesigner.core.GridConstraints(3, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        textFieldMod1 = new JTextField();
        panelMenuMod.add(textFieldMod1, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JLabel label3 = new JLabel();
        label3.setText("Nuovo modello:");
        panelMenuMod.add(label3, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        textFieldMod2 = new JTextField();
        panelMenuMod.add(textFieldMod2, new com.intellij.uiDesigner.core.GridConstraints(1, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        OKButtonMod = new JButton();
        OKButtonMod.setText("OK");
        panelMenuMod.add(OKButtonMod, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        panelMenuDel = new JPanel();
        panelMenuDel.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(3, 2, new Insets(0, 0, 0, 0), -1, -1));
        tabbedPane1.addTab("Cancella", panelMenuDel);
        final JLabel label4 = new JLabel();
        label4.setText("Inserisci Codice da rimuovere:");
        panelMenuDel.add(label4, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer3 = new com.intellij.uiDesigner.core.Spacer();
        panelMenuDel.add(spacer3, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        textFieldDel = new JTextField();
        panelMenuDel.add(textFieldDel, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        OKButtonDel = new JButton();
        OKButtonDel.setText("OK");
        panelMenuDel.add(OKButtonDel, new com.intellij.uiDesigner.core.GridConstraints(1, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        panelMenuView = new JPanel();
        panelMenuView.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(3, 2, new Insets(0, 0, 0, 0), -1, -1));
        tabbedPane1.addTab("Visualizza", panelMenuView);
        textAreaView = new JTextArea();
        textAreaView.setEditable(false);
        textAreaView.setText("");
        panelMenuView.add(textAreaView, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(150, 50), null, 0, false));
        final JLabel label5 = new JLabel();
        label5.setText("Condizioni:");
        panelMenuView.add(label5, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        textFieldView = new JTextField();
        panelMenuView.add(textFieldView, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        OKButtonView = new JButton();
        OKButtonView.setText("OK");
        panelMenuView.add(OKButtonView, new com.intellij.uiDesigner.core.GridConstraints(1, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return panel1;
    }
}