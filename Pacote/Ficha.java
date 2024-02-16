import java.util.Scanner;

public class Ficha{
    public String defeito;
    public int id_pecas;
    public int id_veiculo;
    
    Scanner scan = new Scanner(System.in);

    public String getDefeito(){
        return this.defeito;
    }

    public int getId_veiculo() {
        return id_veiculo;
    }

    public int getId_peca(){
        return this.id_pecas;
    }

    public void setDefeito(String d){
        this.defeito = d;
    }

    public void setId_pecas(int p){
        this.id_pecas = p;
    }

    public void setId_veiculo(int id_veiculo) {
        this.id_veiculo = id_veiculo;
    }
    
    /*O método a seguir tem por finalidade cadastrar uma ficha do véiculo cadastrado na oficina para que assim
     * seja possível saber qual o problema apresentado e qual será a peça necessária para realizar o serviço. 
     * Ressaltando que todas as peças da ficticia oficina estão armazenadas no banco de dados com seus respectivos
     * id e outros informações
     */
    public void Registrar_ficha(){
        System.out.println("""
            ============================
                Ficha do Veículo
            ============================
                """);
                
        System.out.print("Informe o número de identificação do veículo: ");
        setId_veiculo(scan.nextInt());

        System.out.print("Informe o número de identificação da peça necessária para o serviço: ");
        setId_pecas(scan.nextInt());

        scan.nextLine();

        System.out.println("Descreva o problema do veículo: ");
        setDefeito(scan.nextLine());
    }
}
