package portscanner;

import java.net.InetSocketAddress;
import java.net.Socket;
import portscanner.Gui.DoneGui;
import static portscanner.Gui.DoneGui.IP;
import static portscanner.Gui.DoneGui.Open_Ports;
import static portscanner.Gui.DoneGui.PortMax;
import static portscanner.Gui.DoneGui.PortMin;
import static portscanner.Gui.DoneGui.TimeOut;

/**
 *
 * @author thejavakid
 */
public class ScanPorts implements Runnable{

    @Override
    public void run() { 
    Open_Ports.setText(null);
    DoneGui.Progress.setValue(0);
    int Portmin = Integer.parseInt(PortMin.getText());
    int Portmax = Integer.parseInt(PortMax.getText());
    DoneGui.Progress.setMinimum(Portmin);
    DoneGui.Progress.setValue(Portmin);
    DoneGui.Progress.setMaximum(Portmax);
    int portNum = Portmin;
    double time = (((Integer.parseInt(TimeOut.getText())) * (Portmax-portNum))/1000.0/60.0);
    double decriment = time/Portmax;
    while(portNum < Integer.parseInt(PortMax.getText())){
            if(portIsOpen(IP.getText(), portNum, Integer.parseInt(TimeOut.getText()))){
                Open_Ports.setText(Open_Ports.getText() +portNum+",");
            }
        time = time-decriment;
        DoneGui.TR.setText("Time remaining(Worst case): "+ roundToHalf(time) +"m");
        DoneGui.Progress.setValue(DoneGui.Progress.getValue()+1);
        portNum++;
        DoneGui.PacketNumber.setText("On Port "+(portNum-Portmin)+"/"+(Portmax-Portmin));
        }
    DoneGui.TR.setText("Done!");
    }
    public boolean portIsOpen(String ip, int port, int timeout) {
        try {
            Socket socket = new Socket();
            socket.connect(new InetSocketAddress(ip, port), timeout);
            socket.close();
            return true;
        } catch (Exception notOpen) {
            return false;
        }
    }
    public static double roundToHalf(double d) {
        return Math.round(d * 10) / 10.0;
    }
}
//41
