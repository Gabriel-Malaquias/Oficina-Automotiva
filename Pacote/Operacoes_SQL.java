import java.sql.*;

public class Operacoes_SQL {
    /*Esta classe tem a finalidade de lidar com todas as operações SQL da aplicação para interagir e
     * manipular o banco de dados. Os métodos criados nesta classe em sua maioria são métodos que realizarão
     * a inserção de informações na base de dados. Somente um método realizá uma consulta SQL e mais detalhes
     * serão explicados na linha 110
     */

    private Conexao_DB conexao;
    private Cliente cliente;
    private Veiculo veiculo;
    private Ficha ficha;
    public float valor_Peca;
    
    public Conexao_DB getConexao() {
        return conexao;
    }

    public void setConexao(Conexao_DB conexao) {
        this.conexao = conexao;
    }

    public Cliente getCliente() {
        return cliente;
    }
    
    public Ficha getFicha() {
        return ficha;
    }

    public float getValor_Peca() {
        return valor_Peca;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }
        
    public void setFicha(Ficha ficha) {
        this.ficha = ficha;
    }

    public void setValor_Peca(Float valor_Peca) {
        this.valor_Peca = valor_Peca;
    }

    /*Realizará a inserção dos dados do cliente no banco de dados */
    public void Inserir_cliente(){
    
        try {
            String sql = "insert into cliente (nome, telefone, cpf) values (?,?,?)";
            Connection coon = conexao.getConnection();
            PreparedStatement stm = coon.prepareStatement(sql);

            stm.setString(1, cliente.getNome());
            stm.setString(2, cliente.getTel());
            stm.setString(3, cliente.getCPF());
            stm.executeUpdate();
            stm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /*Realizará a inserção dos dados do veículo no banco de dados */
    public void Inserir_veiculo(){
        try {
            String sql = "insert into veiculo (modelo, fabricante, cor, placa, dono) values(?,?,?,?,?)";
            Connection coon = conexao.getConnection();
            PreparedStatement stm = coon.prepareStatement(sql);

            stm.setString(1, veiculo.getModel());
            stm.setString(2, veiculo.getFab());
            stm.setString(3, veiculo.getCor());
            stm.setString(4, veiculo.getNum());
            stm.setInt(5, veiculo.getDono());
            stm.executeUpdate();
            stm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /*Relizará a inserção da ficha do veículo no banco de dados */
    public void Inserir_ficha(){
        try {
            String sql = "insert into ficha (veiculo_defeito, peca_necessaria, descricao_defeito) values (?,?,?)";
            Connection coon = conexao.getConnection();
            PreparedStatement stm = coon.prepareStatement(sql);

            stm.setInt(1, ficha.getId_veiculo());
            stm.setInt(2, ficha.getId_peca());
            stm.setString(3, ficha.getDefeito());
            stm.executeUpdate();
            stm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /*Relizará uma consulta do preço da peça necessária para realizar o conserto do veículo
    para que assim, seja possível calcular o orçamento do serviço. Este orçamento será realizado
    na classe Orçamento da aplicação. Observe que para saber o preço da peça, é necessário saber
    o id desta peça e por isso, este valor é resgatado no objeto Resultset
    */
    public void consultar_ValoresPecas(){
        try {
            ResultSet rs = null; //Objeto que lida com consultas SQL na aplicação
            String sql = "select preco from estoque_pecas where id_pecas = ?;";
            Connection coon = conexao.getConnection();
            PreparedStatement stm = coon.prepareStatement(sql);

            stm.setInt(1, ficha.getId_peca()); //Retorno do id da peça informado na classe ficha
            rs = stm.executeQuery();

            if(rs.next()){
                float consulta = rs.getFloat("preco"); //Consulta do preço da peça da base de dados
                setValor_Peca(consulta); //Inserção do respectivo preço da peça na variável 'valor_Peca'. Esta variável será utilizada na classe Orçamento para realizar o orçamento propriamente dito
            }else{
                System.out.println("Nenhum dado encontrado");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
