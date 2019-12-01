package model;

public class Pedido {

    private String cliente;
    private String pizza;
    private String pizzaria;
    private int valor;

    public Pedido(String cliente, String pizza, String pizzaria, int valor) {
        this.cliente = cliente;
        this.pizza = pizza;
        this.pizzaria = pizzaria;
        this.valor = valor;
    }

    public String getClienteJSON() {
        return "\"cliente\" : " + "\"" + cliente + "\"";
    }

    public String getPizzaJSON() {
        return "\"pizza\" : " + "\"" + pizza + "\"";
    }

    public String getPizzariaJSON() {
        return "\"pizzaria\" : " + "\"" + pizzaria + "\"";
    }

    public String getValorJSON() {
        return "\"valor\" : " + "\"" + valor + "\"";

    }

}
