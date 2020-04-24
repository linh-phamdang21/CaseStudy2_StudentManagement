
package Main;

import view.LoginJDialog;
import view.MainFrame;

public class Main {
    public static void main(String[] args) {
        //new MainFrame().setVisible(true);
        LoginJDialog dialog = new LoginJDialog(null, true);
        dialog.setTitle("Login");
        dialog.setResizable(false);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }
}
