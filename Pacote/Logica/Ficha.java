package Logica;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Ficha{
    private Conexao_DB conexao;
    public String defeito;
    public int id_pecas;
    public int id_veiculo;
        
    public Conexao_DB getConexao() {
        return conexao;
    }

    public void setConexao(Conexao_DB conexao) {
        this.conexao = conexao;
    }
    public String getDefeito(){
        return this.defeito;
    }

    public int getId_veiculo() {
        return id_veiculo;
    }

    public int getId_peca(){
        return this.id_pecas;
    }

    public void setDefeito(String d){
        this.defeito = d;
    }

    public void setId_peca(int p){
        this.id_pecas = p;
    }

    public void setId_veiculo(int id_veiculo) {
        this.id_veiculo = id_veiculo;
    }
    
    // O seguinte método verifica se os campos de dados da interface estão vazios ou não. Caso sejam vazios o método irá retornar uma excessão, caso contrário o método insere as devidas informações no banco de dados
    
    public boolean Registrar_ficha(){
        if(this.getDefeito() != null && !this.getDefeito().isEmpty() && this.getId_veiculo() != 0 && this.getId_peca() != 0){
            try {
                String sql = "insert into ficha (veiculo_defeito, peca_necessaria, descricao_defeito) values (?,?,?)";
                Connection coon = conexao.getConnection();
                PreparedStatement stm = coon.prepareStatement(sql);

                stm.setInt(1, getId_veiculo());
                stm.setInt(2, getId_peca());
                stm.setString(3, getDefeito());
                stm.executeUpdate();
                return true;
            } catch (SQLException e) {
                System.out.println("Erro ao inserir os dados de ficha na base" + e);
            }
        }else{
            System.out.println("Erro, dados inválidos !");
        }
        return false;
    }
}
