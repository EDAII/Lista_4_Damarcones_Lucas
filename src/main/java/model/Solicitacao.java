

package model;


public class Solicitacao {
    private String nome;
    private String pizza;

    public Solicitacao(String nome, String pizza) {
        this.nome = nome;
        this.pizza = pizza;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPizza() {
        return pizza;
    }

    public void setPizza(String pizza) {
        this.pizza = pizza;
    }
    
    
}
