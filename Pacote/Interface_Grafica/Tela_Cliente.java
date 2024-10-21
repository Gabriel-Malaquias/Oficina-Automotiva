package Interface_Grafica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import Logica.Cliente;

public class Tela_Cliente{
    public static JFrame janela_Cliente(Cliente cliente){     
        JFrame frame = new JFrame("Cadastro de Cliente");
        frame.setSize(450,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridBagLayout());
        frame.setVisible(true);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 5, 10, 5);

        JLabel texto_1 = new JLabel("Nome do Cliente");
        JTextField entrada_1 = new JTextField(10);
        
        JLabel texto_2 = new JLabel("CPF");
        JTextField entrada_2 = new JTextField(11);

        JLabel texto_3 = new JLabel("Telefone");
        JTextField entrada_3 = new JTextField(11);
      
        JButton btn = new JButton("Confirmar");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cliente.setNome(entrada_1.getText());
                cliente.setCPF(entrada_2.getText());
                cliente.setTel(entrada_3.getText());

                if(cliente.Cadastrar_Cliente()){
                    JLabel msg_1 = new JLabel("Dados de Cliente Cadastrados");
                    gbc.gridx = 0;
                    gbc.gridy = 5;
                    frame.add(msg_1, gbc);
                    frame.dispose(); // fecha o layout quando o botão é clicado 
                }else{
                    JLabel msg_2 = new JLabel("Erro ! Preencha os campos ");
                    gbc.gridx = 0;
                    gbc.gridy = 5;
                    frame.add(msg_2, gbc);
                }
                frame.revalidate();
                frame.repaint();
                entrada_1.setText("");
                entrada_2.setText("");
                entrada_3.setText("");
            }
        });

        // O código abaixo configura os elementos swing como o Label e o TextField em um padrão de linhas e colunas ja que o modelo de layout que está sendo seguido e implementado na interface swing é o GridBagConstraints 

        //Nome
        gbc.gridx = 0;
        gbc.gridy = 0;
        frame.add(texto_1, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 0;
        frame.add(entrada_1, gbc);

        //CPF
        gbc.gridx = 0;
        gbc.gridy = 1;
        frame.add(texto_2, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 1;
        frame.add(entrada_2, gbc);

        //Telefone
        gbc.gridx = 0;
        gbc.gridy = 2;
        frame.add(texto_3, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        frame.add(entrada_3, gbc);

        //Botao
        gbc.gridx = 0;
        gbc.gridy = 4;
        frame.add(btn, gbc);

        return frame;
    }
}
