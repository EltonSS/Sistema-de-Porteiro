package ControleSistema;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.*;
import javax.swing.JOptionPane;

public class ConectaBanco {

    private String driver = "com.mysql.jdbc.Driver";
    private String caminho = "jdbc:mysql://localhost/db_porteiro";
    //private String caminho = "jdbc:mysql://dataserver/db_porteiro";
    private String usuario = "root";
    private String senha = "not00131300";
    public Connection conn;
    public ResultSet rs;
    public Statement stm;

    public void conexao() {
        try {
            System.setProperty("jdbc.Drivers", driver);
            conn = (Connection) DriverManager.getConnection(caminho, usuario, senha);
            //JOptionPane.showMessageDialog(null, "Conectado!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar conectar com o banco de dados!!\n Erro: " + ex.getMessage());
        }
    }

    public void executaSQL(String sql) {
        try {
            stm = (Statement) conn.createStatement(rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
            rs = stm.executeQuery(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao executar o SQL!!\n Erro: " + ex.getMessage());
        }
    }

    public void desconecta() {
        try {
            conn.close();
            //System.out.println("Desconectado!");
            //JOptionPane.showMessageDialog(null,"Desconectado!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar desconectar com o banco de dados!!\n Erro: " + ex.getMessage());
        }
    }
}
