package Logica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/*Esta classe tem a finalidade de realizar o orçamento do serviço prestado na oficina para o cliente.
* Toda lógica será feita no método 'realizar_Orçamento'
*/
public class Orcamento {
    private int servico;
    private float preco_orc;
    private int ordem_pagamento;
    private float valor_Peca;
    private Conexao_DB conexao;

    public float getPreco_orc() {
        return preco_orc;
    }

    public void setPreco_orc(float preco_orc) {
        this.preco_orc = preco_orc;
    }

    public int getServico() {
        return servico;
    }

    public void setServico(int servico) {
        this.servico = servico;
    }

    public int getOrdem_pagamento() {
        return ordem_pagamento;
    }

    public void setOrdem_pagamento(int ordem_pagamento) {
        this.ordem_pagamento = ordem_pagamento;
    }

    public float getValor_Peca() {
        return valor_Peca;
    }

    public void setValor_Peca(float valor_Peca) {
        this.valor_Peca = valor_Peca;
    }

    public Conexao_DB getConexao() {
        return conexao;
    }

    public void setConexao(Conexao_DB conexao) {
        this.conexao = conexao;
    }

    // O método abaixo realiza a lógica que exibirá um orçamento ao usuário. Sua implementação é simples, o método consulta o respectivo id da peça necessária para realizar o serviço e retorna o preço desta peça para que possa ser feito o cálculo do orçamento. Observe que para retornar o valor do id, utilizamos a classe Sessao que o armazena de forma global

    public void realizar_Orcamento(int idpeca){
        try {
            ResultSet rs = null; //Objeto que lida com consultas SQL na aplicação
            String sql = "select preco from estoque_pecas where id_peca = ?;";
            Connection coon = conexao.getConnection();
            PreparedStatement stm = coon.prepareStatement(sql);
            
            stm.setInt(1, Sessao.getInstance().getIdPeca()); //Retorno do id da peça informado na classe ficha
            rs = stm.executeQuery();

            if(rs.next()){
                float consulta = rs.getFloat("preco"); //Consulta do preço da peça da base de dados
                this.setValor_Peca(consulta); //Inserção do respectivo preço da peça na variável 'valor_Peca'. Esta variável será utilizada na classe Orçamento para realizar o orçamento propriamente dito
            }else{
                System.out.println("Nenhum dado encontrado");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        //Calculo o orçamento com base no preço da peça e no valor do respectivo serviço realizado
        
        switch (this.getServico()) {
            case 1:
                float preco_1 = this.getValor_Peca() + 250;
                this.setPreco_orc(preco_1);
                break;
            case 2:
                float preco_2 = this.getValor_Peca() + 60;
                this.setPreco_orc(preco_2);
                break;
            case 3:
                float preco_3 = this.getValor_Peca() + 150; 
                this.setPreco_orc(preco_3);
                break;
        }
    }
}
