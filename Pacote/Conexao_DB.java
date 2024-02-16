import java.sql.*;

public class Conexao_DB {
    /*Esta classe será a responsável por criar uma conexão com o bando de dados. O driver utilizado
     * para esta conexão é o JDBC. As variáveis abaixo armazenarão os dados como usuário do banco de dados,
     * senha e o caminho da base de dados para realizar a conexão e por fim, serão passadas como parâmetros
     * no objeto Connection
     */

    public static String url = "jdbc:mysql://localhost:3306/oficina";
    public static String user = "root";
    public static String pws = "1605";

    /*Objeto responsável por estabelecer a conexão com o banco de dados por meio do JDBC */
    private Connection conexao = null;

    /*O método a seguir abrirá a conexão com a base de dados */
    public void OpenDB(){
        try {
            /*Observe que as variáveis criadas no inicio da classe estão sendo passadas como parâmetros
             * para abrir a conexão com a base de dados*/

            conexao = DriverManager.getConnection(url, user, pws);
            System.out.println("Conexão Estabelecida");
        } catch (Exception e) {
            /*Seguinte print mostrará uma mensagem de erro caso aconteça alguma exceção durante a conexão */

            System.out.println("Erro " + e.getMessage());
        }
    }

    /*O seguinte método encerrará a conexão com a base de dados */
    public void CloseDB() throws SQLException{
        conexao.close();
        System.out.println("Conexão Finalizada");
    }

    /*Por fim, o útlimo método da classe retornará a conexão. Isto será importante em outras classes da aplicação
     * para assegurar a conexão 
     */
    public Connection getConnection(){
        return conexao;
    }
}
