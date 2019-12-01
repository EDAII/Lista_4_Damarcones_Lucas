package utils;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Random;
import model.Pedido;
import java.util.StringJoiner;
import model.Oferta;
import model.Solicitacao;

public class Gerador {

    public static Random random = new Random();
    private static final int PRECOBASE = 15;
    private static String[] pizzarias = {
        "Pizzaria Hut",
        "Pizzaria Cesar",
        "Pizzaria Dominos",
        "Pizzaria Ratão",
        "Pizzaria Primo piato"
    };
    private static String[] clientes = {
        "Lucas", "Marcelo", "Matheus", "Fabiana", "Milene", "Romeu", "Gabriela",
        "Micaella", "João", "Keanu Reeves", "Ester", "Eduarda", "Péricles"
    };

    public static String[] pizzas = {
        "Calabresa",
        "Frango",
        "Calabresa",
        "Frango com catupiry",
        "Chocolate",
        "Califórnia",
        "Bacon",
        "Portuguesa",
        "Moda da casa",
        "A moda do chefe ;)",
        "Quatro queijos",
        "Vegetariana",
        "Americana",
        "Rapadura",
        "Beijinho",
        "Romeu e Julieta",
        "Marguerita",
        "Muçarela",
        "Brigadeiro",
        "Tradicional",
        "Escarola",
        "Mexicana",
        "Carioca",
        "Lombo com catupiry",
        "Vegetariana",
        "Parmegiana",
        "Do sogro",
        "Do chefe",
        "Quatro queijos estravaganza"
    };

    public static String newPizza() {
        int pos = random.nextInt(pizzas.length);

        return pizzas[pos];
    }

    public static String newCliente() {
        int pos = random.nextInt(clientes.length);
        return clientes[pos];
    }

    public static String newPizzaria() {
        int pos = random.nextInt(pizzarias.length);
        return pizzarias[pos];
    }
//        public static Pedido novoPedido(){
//            return new Pedido(newCliente(),newPizza(),newPizzaria());
//        }

    public static Hashtable<String, Integer> newCatalogo() {
        Hashtable<String, Integer> menu = new Hashtable<>();

        for (String s : pizzas) {
            menu.put(s, PRECOBASE + random.nextInt(15));
        }
        return menu;
    }

    public static String pedidoJSON(Pedido pedido) {
        StringJoiner sj = new StringJoiner(",", "{", "}");
        sj.add(pedido.getClienteJSON());
        sj.add(pedido.getPizzaJSON());
        sj.add(pedido.getPizzariaJSON());
        sj.add(pedido.getValorJSON());
        return sj.toString();
    }

    public static Oferta[] pizzariaPreco() {
        Oferta[] array = new Oferta[pizzarias.length];
        for (int i = 0; i < pizzarias.length; i++) {
            array[i] = new Oferta(pizzarias[i], PRECOBASE + random.nextInt(15));
        }

        return array;
    }

    public static ArrayList<Solicitacao> pedidos(int quantidade) {
        ArrayList<Solicitacao> pedidos = new ArrayList<>();
        for(int i =0 ;i< quantidade; i++)
        {
            pedidos.add(new Solicitacao(newCliente(), newPizza()));
        }
        return pedidos;
    }
}
