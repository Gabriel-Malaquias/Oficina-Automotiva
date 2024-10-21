package Logica;
import java.sql.*;

public class Veiculo {
    private Conexao_DB conexao;
    private String modelo;
    private String fabricante;
    private String cor;
    private String num_placa;
    private int dono;
    
    public Conexao_DB getConexao() {
        return conexao;
    }

    public void setConexao(Conexao_DB conexao) {
        this.conexao = conexao;
    }

    public String getModel(){
        return this.modelo;
    }

    public String getFab(){
        return this.fabricante;
    }

    public String getCor(){
        return this.cor;
    }

    public String getNum(){
        return this.num_placa;
    }

    public int getDono() {
        return dono;
    }
    
    public void setModel(String m){
        this.modelo = m;
    }

    public void setFab(String f){
        this.fabricante = f;
    }

    public void setCor(String c){
        this.cor = c;
    }

    public void setNum(String n){
        this.num_placa = n;
    }

    public void setDono(int dono) {
        this.dono = dono;
    }
    
    // O seguinte método verifica se os campos de dados da interface estão vazios ou não. Caso sejam vazios o método irá retornar uma excessão, caso contrário o método insere as devidas informações no banco de dados
    
    public boolean Cadastrar_veiculo(){
        if(!this.getCor().isEmpty() && !this.getFab().isEmpty() && !this.getModel().isEmpty() && !this.getNum().isEmpty()){
            try {
                String sql = "insert into veiculo (modelo, fabricante, cor, placa, dono) values(?,?,?,?,?)";
                Connection coon = conexao.getConnection();
                PreparedStatement stm = coon.prepareStatement(sql);

                stm.setString(1, this.getModel());
                stm.setString(2, this.getFab());
                stm.setString(3, this.getCor());
                stm.setString(4, this.getNum());
                stm.setInt(5, this.getDono());
                stm.executeUpdate();
                stm.close();
            } catch (Exception e) {
                System.out.println(e);
            }
            return true;
        }else{
            return false;
        }
    }
}


