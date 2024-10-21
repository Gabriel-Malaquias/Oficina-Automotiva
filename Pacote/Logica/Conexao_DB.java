package Logica;
import java.sql.*;

// Classe responsável por realizar a conexão da aplicação com o banco de dados

public class Conexao_DB {
    public static String url = "jdbc:mysql://localhost:3306/oficina";
    public static String user = "root"; 
    public static String pws = "1605"; 

    private Connection conexao;

    public void OpenDB(){
        try {
            conexao = DriverManager.getConnection(url, user, pws);
            System.out.println("Conexão Estabelecida: "); 
        } catch (Exception e) {
            System.out.println("Erro ao conectar: " + e.getMessage());
            conexao = null;
        }
    }

    public void CloseDB() throws SQLException{
        conexao.close();
        System.out.println("Conexão Finalizada");
    }

    public Connection getConnection(){
        return conexao;
    }
}
