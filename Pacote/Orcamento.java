import java.util.Scanner;

public class Orcamento {
    /*Esta classe tem a finalidade de realizar o orçamento do serviço prestado na oficina para o cliente.
     * Toda lógica será feita no método 'realizar_Orçamento'
     */

    Scanner scan = new Scanner(System.in);
    
    public String toString(){
        return "Tabela de Preços Mão de Obra\n\n 1 Mecânica em Geral: R$250,00 \n 2 Troca de Óleo: R$60,00 \n 3 Suspensão: R$150,00 \n OBS: Digite os números 1,2,3 para identicar os serviços prestados";
    }

    /*Observe que o método precisará que a classe 'Operacoes_SQL' seja passada como parâmetro no momento
     * da sua execução. Isto será necessário para que seja possível resgatar o valor da peça consultado
     * no método 'consultar_ValoresPecas()' da classe Operacoes_SQL e assim, toda a lógica seja feita
     */
    public void realizar_Orcamento(Operacoes_SQL operacao){
        System.out.println("""
            ============================
                Orçamento
            ============================
                """);

        System.out.println(toString());

        System.out.print("" + "\nInforme o serviço realizado: ");
        int x = scan.nextInt();
        scan.nextLine();
        
        switch (x) {
            case 1:
                float preco_1 = operacao.getValor_Peca() + 250;
                System.out.println("O orcamento do serviço é de R$" + preco_1);
                break;
            case 2:
                float preco_2 = operacao.getValor_Peca() + 60;
                System.out.println("O orcamento do serviço é de R$" + preco_2);
                break;
            case 3:
                float preco_3 = operacao.getValor_Peca() + 150; 
                System.out.println("O orcamento do serviço é de R$" + preco_3);
                break;
        }

        System.out.println("Pagamento confirmado ? [S/N]");
        String resposta = scan.nextLine();

        if(resposta.equalsIgnoreCase("sim") || resposta.equalsIgnoreCase("s")){
            System.out.println("Carro liberado da oficina");
        }else if(resposta.equalsIgnoreCase("nao") || resposta.equalsIgnoreCase("n")){
            System.out.println("Carro retido na oficina");
        }
    }
}
