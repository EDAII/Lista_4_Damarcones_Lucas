

package model;


public class Oferta {
    private String pizzaria;
    private int preco;

    public Oferta(String pizzaria, int preco) {
        this.pizzaria = pizzaria;
        this.preco = preco;
    }

    public String getPizzaria() {
        return pizzaria;
    }

    public void setPizzaria(String pizzaria) {
        this.pizzaria = pizzaria;
    }

    public int getPreco() {
        return preco;
    }

    public void setPreco(int preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Oferta{" + "pizzaria=" + pizzaria + ", preco=" + preco + '}';
    }
    

}
