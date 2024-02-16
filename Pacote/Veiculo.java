import java.util.Scanner;

public class Veiculo {
    private String modelo;
    private String fabricante;
    private String cor;
    private String num_placa;
    private int dono;

    Scanner scan = new Scanner(System.in);

    public String getModel(){
        return this.modelo;
    }

    public String getFab(){
        return this.fabricante;
    }

    public String getCor(){
        return this.cor;
    }

    public String getNum(){
        return this.num_placa;
    }

    public int getDono() {
        return dono;
    }
    
    public void setModel(String m){
        this.modelo = m;
    }

    public void setFab(String f){
        this.fabricante = f;
    }

    public void setCor(String c){
        this.cor = c;
    }

    public void setNum(String n){
        this.num_placa = n;
    }

    public void setDono(int dono) {
        this.dono = dono;
    }
    
    /*O método a seguir será o responsável por armazenar os dados do veículo que der entrada
     * na oficina 
     */
    public void Cadastrar_veiculo(){
        while(true){
            System.out.println("""
                ============================
                    Cadastro do Veículo
                ============================
                    """);
                    
            System.out.print("Modelo: ");
            setModel(scan.nextLine());

            System.out.print("Fabricante: ");
            setFab(scan.nextLine());

            System.out.print("Cor: ");
            setCor(scan.nextLine());

            System.out.print("Número da Placa: ");
            setNum(scan.nextLine());

            System.out.print("Informe o número de identificação do dono: ");
            setDono(scan.nextInt());

            if(!this.getCor().isEmpty() && !this.getFab().isEmpty() && !this.getModel().isEmpty() && !this.getNum().isEmpty()){
                break;
            }else{
                System.out.println("Erro. Ainda faltam dados a serem preenchidos");
            }
        }
    
    }

}
