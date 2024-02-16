import java.util.Scanner;

public class Cliente {
    private String nome;
    private String telefone;
    private String CPF;

    Scanner scan = new Scanner (System.in);

    public String getNome(){
        return this.nome;
    }

    public void setNome(String n){
        this.nome = n;
    }

    public String getTel(){
        return this.telefone;
    }

    public void setTel(String t){
        this.telefone = t;
    }
    
    public String getCPF(){
        return this.CPF;
    }

    public void setCPF(String c){
        this.CPF = c;
    }

    /*O método abaixo será o responsável por cadastrar os dados do cliente. Ele contém uma lógica simples onde
    é mostrado uma mensagem de qual informação o usuário deve fornecer e logo em seguida, essa entrada é inserida
    e armazenada nas respectivas variáveis 
    */ 
    public void Cadastrar(){
        while (true){
            System.out.println("""
                    ============================
                        Cadastro do Cliente
                    ============================
                    """);

            System.out.println("Nome do Cliente: ");
            this.setNome(scan.nextLine());

            System.out.println("CPF: ");
            this.setCPF(scan.nextLine());

            System.out.println("Telefone para contato: ");
            this.setTel(scan.nextLine());

            if(!this.getNome().isEmpty() && !this.getTel().isEmpty() && !this.getCPF().isEmpty()){
                break;
            }else{
                System.out.println("Erro. Ainda faltam dados a serem preenchidos");
            }

            scan.close();
    }

}
}
