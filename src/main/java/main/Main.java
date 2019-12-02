/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
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
            Application.sleep();

            try {
                Comunicador.sendPOST(Gerador.pedidoJSON(pedido));
                Application.printPedido(solicitacoes, i, oferta);

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
