package utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import main.Main;
import model.Oferta;
import model.Pedido;
import model.Solicitacao;

public class Application {

    public static void geraCatologo(Heap heap, HashMap<String, Oferta> custoBeneficio) {
        for (String s : Gerador.pizzas) {
            Oferta[] ofertas = Gerador.pizzariaPreco();
            heap.sort(ofertas);
            custoBeneficio.put(s, ofertas[0]);
            System.out.printf("Pizza: %s, Pizzaria: %s, valor: %d\n", s, ofertas[0].getPizzaria(), ofertas[0].getPreco());

        }
    }
    public static Oferta getOferta(HashMap<String, Oferta> custoBeneficio, ArrayList<Solicitacao> solicitacoes, int i) {
        Oferta oferta = custoBeneficio.get(solicitacoes.get(i).getPizza());
        return oferta;
    }
    
    
    
    public static Pedido doPedido(ArrayList<Solicitacao> solicitacoes, int i, Oferta oferta) {
        Pedido pedido = new Pedido(
                solicitacoes.get(i).getNome(),
                solicitacoes.get(i).getPizza(),
                oferta.getPizzaria(),
                oferta.getPreco()
        );
        return pedido;
    }
     public static void printPedido(ArrayList<Solicitacao> solicitacoes, int i, Oferta oferta) {
        System.out.printf("Cliente: %s , pediu  %s por R$ %d pela pizzaria %s\n",
                solicitacoes.get(i).getNome(),
                solicitacoes.get(i).getPizza(),
                oferta.getPreco(),
                oferta.getPizzaria()
        );
    }

    public static void sleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
