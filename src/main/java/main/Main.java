/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Oferta;
import model.Pedido;
import model.Solicitacao;
import utils.Application;
import utils.Comunicador;
import utils.Gerador;
import utils.Heap;

public class Main {

    public static void main(String[] args) {
        Comunicador.URL = "http://localhost:3000/pedidos";

        HashMap<String, Oferta> custoBeneficio = new HashMap<>();
        Heap heap = new Heap();

//        Pizzas mais baratas
        System.out.println("Geração de catálogo de pizzas mais baratas");

        Application.geraCatologo(heap, custoBeneficio);

        int QUANTIDADE = Gerador.random.nextInt(1000);
        ArrayList<Solicitacao> solicitacoes = Gerador.pedidos(QUANTIDADE);

        System.out.println("\nRealizando as vendas de pizza\n");
        for (int i = 0; i < solicitacoes.size(); i++) {

            Oferta oferta = Application.getOferta(custoBeneficio, solicitacoes, i);

            Pedido pedido = Application.doPedido(solicitacoes, i, oferta);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                Comunicador.sendPOST(Gerador.pedidoJSON(pedido));
                System.out.printf("Cliente: %s , pediu  %s por R$ %d pela pizzaria %s\n",
                        solicitacoes.get(i).getNome(),
                        solicitacoes.get(i).getPizza(),
                        oferta.getPreco(),
                        oferta.getPizzaria()
                );

            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

//        
//       
    }
}
