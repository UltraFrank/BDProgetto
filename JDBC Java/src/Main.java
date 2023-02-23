import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JFrame;

public class Main {
    public Main() {
    }

    public static void main(String[] args) throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/unisa3?user=root&password=C0l4z10n3");
        JFrame frame = new Gui(conn);
        frame.setVisible(true);
    }
}