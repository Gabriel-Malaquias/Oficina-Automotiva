package Interface_Grafica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import Logica.Ficha;
import Logica.Sessao;

public class Tela_Ficha {
    public static JFrame janela_Ficha(Ficha ficha){
        JFrame frame = new JFrame("Ficha do Veículo");
        frame.setSize(450,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 5, 10, 5);

        JLabel texto_1 = new JLabel("N° de Identificação do Veículo");
        JTextField entrada_1 = new JTextField(15);

        JLabel texto_2 = new JLabel("Descreva o problema do veículo");
        JTextField entrada_2 = new JTextField(15);

        JLabel texto_3 = new JLabel("N° de Identifcação da peça");
        JTextField entrada_3 = new JTextField(15);

        JButton btn = new JButton("Salvar");
        btn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                ficha.setDefeito(entrada_2.getText());

                try{
                    if(!entrada_1.getText().isEmpty() && !entrada_2.getText().isEmpty()){
                        int id_car = Integer.parseInt(entrada_1.getText());
                        int peca = Integer.parseInt(entrada_3.getText());
                        ficha.setId_veiculo(id_car);
                        ficha.setId_peca(peca);
                        Sessao.getInstance().setIdPeca(peca);
                    }
                }catch(Exception erro){
                    System.out.println(erro);
                }

                if(ficha.Registrar_ficha()){
                    JLabel msg_1 = new JLabel("Dados Enviados !");
                    gbc.gridx = 0;
                    gbc.gridy = 5;
                    frame.add(msg_1, gbc);
                    frame.dispose(); // fecha o layout quando o botão é clicado 
                }else{
                    JLabel msg_2 = new JLabel("Erro ! Preencha os campos");
                    gbc.gridx = 0;
                    gbc.gridy = 5;
                    frame.add(msg_2, gbc);                
                }
                frame.revalidate();
                frame.repaint();
            }
        });
        
        // O código abaixo configura os elementos swing como o Label e o TextField em um padrão de linhas e colunas ja que o modelo de layout que está sendo seguido e implementado na interface swing é o GridBagConstraints
        
        //Id_car
        gbc.gridx = 0;
        gbc.gridy = 0;
        frame.add(texto_1, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        frame.add(entrada_1, gbc);

        //Descrição
        gbc.gridx = 0;
        gbc.gridy = 1;
        frame.add(texto_2, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        frame.add(entrada_2, gbc);

        //peça
        gbc.gridx = 0;
        gbc.gridy = 2;
        frame.add(texto_3, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        frame.add(entrada_3, gbc);

        //botao
        gbc.gridx = 0;
        gbc.gridy = 3;
        frame.add(btn, gbc);

        frame.setVisible(true);
        return frame;
    }
}
