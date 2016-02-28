/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package portscanner;

import portscanner.Gui.DoneGui;
import javax.swing.JOptionPane;
/**
 *
 * @author thejavakid
 */
public class PortScanner {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DoneGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
	boolean ReRun = true;
	while (ReRun = true){
	    try {
		startGUI();
	    }catch(Exception e){
		    int reply = JOptionPane.showConfirmDialog(null, "Sorry, PortScanner has crashed. Do you wish to restart PortScanner?", "PortScanner has crashed.", JOptionPane.YES_NO_OPTION);
		    if (reply == JOptionPane.YES_OPTION) {
			ReRun = true;
		    }
		    else {
			System.exit(0);
		    }
	    }
	}
    }

    public static void startGUI(){
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DoneGui().setVisible(true);
            }
        });
    }
    
}
