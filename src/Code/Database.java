/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Code;

import java.net.InetAddress;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author Admin
 */
public class Database {
    Statement tv;
    MainServer srv;
    boolean ok = true;
    public Database(MainServer _srv, String host, String port, String Username, String passowrd) {
        srv = _srv;
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String infoConnection = "jdbc:mysql://" + host + ":" + port + "/yahoo";
            Connection con = DriverManager.getConnection(
                    infoConnection, Username, passowrd);
            tv = con.createStatement();
            System.out.println("Connect OK");
            srv.jTextArea1.append("Connect DB Succerfully, Socket is Started port 2023\n");
            srv.jTextArea1.append("Server Started Addres:" + InetAddress.getLocalHost() + " or localhost address\n");
            srv.btnStart.setEnabled(false);
        } catch (Exception ex) {
            srv.jTextArea1.append("Failer to Connect SQL, please check Username and Password\n");
            srv.btnStart.setEnabled(true);
            ok = false;
            ex.printStackTrace();
        }
    }
}
