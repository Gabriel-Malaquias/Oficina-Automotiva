package Interface_Grafica;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Logica.Ficha;
import Logica.Orcamento;

public class Tela_Orcamento {
    public static JFrame janela_Orcamento(Orcamento orcamento){
        Ficha ficha = new Ficha();
        JFrame frame = new JFrame("Orçamento");
        frame.setSize(450,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 5, 10, 5);

        JLabel servicos = new JLabel("""
                <html>
                Tabela de Preços Mão de Obra 
                <br>
                <br>1 Mecânica em Geral: R$250,00
                <br>2 Troca de Óleo: R$60,00
                <br>3 Suspensão: R$150,00
                </html>
                """);

        JLabel txt_1 = new JLabel("Informe o serviço realizado");
        JTextField ent_1 = new JTextField(15);

        JButton btn_orc = new JButton("Calcular");

        JLabel preco = new JLabel("Preço R$");

        JLabel txt_2 = new JLabel("Pagamento Confirmado [S/N] ? ");
        JButton btn_1 = new JButton("SIM");
        JButton btn_2 = new JButton("NÃO");

        JLabel resposta = new JLabel("");

        btn_orc.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    if(!ent_1.getText().isEmpty()){
                        int servico = Integer.parseInt(ent_1.getText());
                        orcamento.setServico(servico);
                        orcamento.realizar_Orcamento(ficha.getId_peca());
                        
                        preco.setText("Preço R$" + orcamento.getPreco_orc());
                        frame.revalidate();
                        frame.repaint();
                    }else{
                        System.out.println("Erro, preencha os campos");
                    }
                }catch(Exception erro){
                    System.out.println(erro);
                }

            }
        });

        btn_1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                resposta.setText("Veículo Liberado da Oficina");
            }
        });

        
        btn_2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                resposta.setText("Veículo Retido na Oficina");
            }
        });
        
        // O código abaixo configura os elementos swing como o Label e o TextField em um padrão de linhas e colunas ja que o modelo de layout que está sendo seguido e implementado na interface swing é o GridBagConstraints

        //servicos
        gbc.gridx = 0;
        gbc.gridy = 0;
        frame.add(servicos, gbc);

        //serviço realizado
        gbc.gridx = 0;
        gbc.gridy = 1;
        frame.add(txt_1, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        frame.add(ent_1, gbc);

        //botao
        gbc.gridx = 0;
        gbc.gridy = 2;
        frame.add(btn_orc, gbc);

        //Exibir orçamento
        gbc.gridx = 0;
        gbc.gridy = 3;
        frame.add(preco, gbc);

        //Ordem de pagamento
        gbc.gridx = 0;
        gbc.gridy = 5;
        frame.add(txt_2, gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        frame.add(btn_1, gbc);

        gbc.gridx = 2;
        gbc.gridy = 5;
        frame.add(btn_2, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        frame.add(resposta, gbc);

        frame.setVisible(true);
        
        return frame;
    }
}
