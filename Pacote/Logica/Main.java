package Logica;
import javax.swing.SwingUtilities;
import Interface_Grafica.Tela_Cliente;
import Interface_Grafica.Tela_Ficha;
import Interface_Grafica.Tela_Orcamento;
import Interface_Grafica.Tela_Veiculo;

import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {

        // Logo abaixo, são criadas todas as instâncias necessárias das classes que realizarão a lógica da aplicação. Cada classe instanciada recebe o objeto conexão da classe responsável por estabelecer a conexão com o banco de dados

        Conexao_DB conexao = new Conexao_DB();
        conexao.OpenDB();

        Cliente cliente = new Cliente();
        cliente.setConexao(conexao);

        Veiculo veiculo = new Veiculo();
        veiculo.setConexao(conexao);

        Ficha ficha = new Ficha();
        ficha.setConexao(conexao);

        Orcamento orcamento = new Orcamento();
        orcamento.setConexao(conexao);

        // O método swing abaixo é o responsável por executar cada interface em uma respectiva ordem. Quando uma interface for finalizada, então ela será fechada a chamará a interface a seguir

        SwingUtilities.invokeLater(()->{
            JFrame telaCliente = Tela_Cliente.janela_Cliente(cliente);
        
            telaCliente.addWindowListener(new java.awt.event.WindowAdapter(){
                public void windowClosed(java.awt.event.WindowEvent windowEvent){
                    JFrame telaVeiculo = Tela_Veiculo.janela_Veiculo(veiculo);

                    telaVeiculo.addWindowListener(new java.awt.event.WindowAdapter() {
                        public void windowClosed(java.awt.event.WindowEvent windowEvent){
                            JFrame telaFicha = Tela_Ficha.janela_Ficha(ficha);

                            telaFicha.addWindowListener(new java.awt.event.WindowAdapter() {
                                public void windowClosed(java.awt.event.WindowEvent windowEvent){
                                    Tela_Orcamento.janela_Orcamento(orcamento);
                                }
                            });
                        }
                    });
                }
            });
        });
    } 
}
