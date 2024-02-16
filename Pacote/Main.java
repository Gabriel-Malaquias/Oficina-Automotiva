import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        Conexao_DB conexao = new Conexao_DB();
        Operacoes_SQL operacao = new Operacoes_SQL();

        Cliente cliente = new Cliente();
        Veiculo veiculo = new Veiculo();
        Ficha ficha = new Ficha();
        Orcamento orcamento = new Orcamento();

        conexao.OpenDB();
        conexao.getConnection();

        operacao.setConexao(conexao);
        operacao.setCliente(cliente);
        operacao.setVeiculo(veiculo);
        operacao.setFicha(ficha);

        cliente.Cadastrar();
        veiculo.Cadastrar_veiculo();
        ficha.Registrar_ficha();

        /*operacao.Inserir_cliente();
        operacao.Inserir_veiculo();
        operacao.Inserir_ficha();*/
        operacao.consultar_ValoresPecas();

        orcamento.realizar_Orcamento(operacao);

        conexao.CloseDB();
    }
}
