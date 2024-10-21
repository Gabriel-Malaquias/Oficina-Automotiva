package Logica;
import java.sql.*;
public class Cliente {
    private Conexao_DB conexao;
    private String nome;
    private String telefone;
    private String CPF;
    
    public Conexao_DB getConexao() {
        return conexao;
    }

    public void setConexao(Conexao_DB conexao) {
        this.conexao = conexao;
    }

    public String getNome(){
        return this.nome;
    }

    public void setNome(String n){
        this.nome = n;
    }

    public String getTel(){
        return this.telefone;
    }

    public void setTel(String t){
        this.telefone = t;
    }
    
    public String getCPF(){
        return this.CPF;
    }

    public void setCPF(String c){
        this.CPF = c;
    }

   // O seguinte método verifica se os campos de dados da interface estão vazios ou não. Caso sejam vazios o método irá retornar uma excessão, caso contrário o método insere as devidas informações no banco de dados

    public boolean Cadastrar_Cliente(){
        if(this.getNome() != null && !this.getNome().isEmpty() &&
        this.getCPF() != null && !this.getCPF().isEmpty() &&
        this.getTel() != null && !this.getTel().isEmpty()
        ){
            try{
                String sql = "insert into cliente (nome, telefone, cpf) values (?,?,?)";
                Connection coon = conexao.getConnection();
                PreparedStatement stm = coon.prepareStatement(sql);

                stm.setString(1, this.getNome());
                stm.setString(2, this.getTel());
                stm.setString(3, this.getCPF());
                stm.executeUpdate();
                stm.close();
            }catch(Exception e){
                System.out.println(e);
            }
            return true;
        }else{
            return false;
        }
    }

}

