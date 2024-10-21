package Interface_Grafica;

import javax.swing.*;
import Logica.Veiculo;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tela_Veiculo {
    public static JFrame janela_Veiculo(Veiculo veiculo){
        JFrame frame = new JFrame("Cadastro Veículo");
        frame.setSize(450,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 5, 10, 5);

        JLabel txt_1 = new JLabel("Modelo do Veículo");
        JTextField ent_1 = new JTextField(15);

        JLabel txt_2 = new JLabel("Fabricante");
        JTextField ent_2 = new JTextField(15);

        JLabel txt_3 = new JLabel("Cor");
        JTextField ent_3 = new JTextField(15);
        
        JLabel txt_4 = new JLabel("N° da Placa");
        JTextField ent_4 = new JTextField(15);
        
        JLabel txt_5 = new JLabel("N° do Dono");
        JTextField ent_5 = new JTextField(15);
        
        JButton btn = new JButton("Confirmar");
        btn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                veiculo.setModel(ent_1.getText());
                veiculo.setFab(ent_2.getText());
                veiculo.setCor(ent_3.getText());
                veiculo.setNum(ent_4.getText());

                try{
                    if(!ent_5.getText().isEmpty()){
                        int dono = Integer.parseInt(ent_5.getText());
                        veiculo.setDono(dono);
                    }else{
                        System.out.println("Favor, preencher todos os campos !");
                    }
                }catch (Exception erro){
                    System.out.println(erro);
                }

                if(veiculo.Cadastrar_veiculo()){
                    JLabel msg = new JLabel("Dados Cadastrados !");
                    gbc.gridx = 0;
                    gbc.gridy = 1;
                    frame.add(msg, gbc);
                    frame.dispose(); // fecha o layout quando o botão é clicado 
                }else{
                    JLabel msg = new JLabel("Erro ! Preencha os campos");
                    gbc.gridx = 0;
                    gbc.gridy = 1;
                    frame.add(msg, gbc);
                }
            }
        });
        
        // O código abaixo configura os elementos swing como o Label e o TextField em um padrão de linhas e colunas ja que o modelo de layout que está sendo seguido e implementado na interface swing é o GridBagConstraints
        
        //Modelo
        gbc.gridx = 0;
        gbc.gridy = 0;
        frame.add(txt_1, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        frame.add(ent_1, gbc);

        //Fabricante 
        gbc.gridx = 0;
        gbc.gridy = 1;
        frame.add(txt_2, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        frame.add(ent_2, gbc);

        //Cor
        gbc.gridx = 0;
        gbc.gridy = 2;
        frame.add(txt_3, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        frame.add(ent_3, gbc);

        //Placa
        gbc.gridx = 0;
        gbc.gridy = 3;
        frame.add(txt_4, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        frame.add(ent_4, gbc);

        //Id_Dono
        gbc.gridx = 0;
        gbc.gridy = 4;
        frame.add(txt_5, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        frame.add(ent_5, gbc);

        //botao
        gbc.gridx = 0;
        gbc.gridy = 6;
        frame.add(btn, gbc);

        frame.setVisible(true);

        return frame;
    }
}

