package Logica;

//Classe Singleton que terá a finalidade de armazenar o id da peça do banco de dados

public class Sessao {
    private static Sessao instance; // Atributo estático que guarda a instância da classe
    private int idPeca; //Atributo que guardará o valor do id da peça

    private Sessao(){} // Criação de um construtor privado que irá evitar a criação de novas instâncias em outra classe

    public static Sessao getInstance(){ // Método que irá retornar a instância da classe em outras partes da aplicação
        if(instance == null){
            instance = new Sessao(); // Cria uma instância se não houver nenhuma
        }
        return instance; // Retorna a instância criada
    }

    public int getIdPeca() { //Método get de idpeca, isso irá retornar o valor do id
        return idPeca;
    }
    
    public void setIdPeca(int idPeca) { // Método set de idpeca, isso irá permitir inserir o valor de idpeca na classe Singleton
        this.idPeca = idPeca;
    }
}
