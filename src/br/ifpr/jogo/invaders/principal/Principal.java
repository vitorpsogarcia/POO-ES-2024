package br.ifpr.jogo.invaders.principal;

import java.util.ArrayList;
import java.util.Scanner;
import br.ifpr.jogo.invaders.logica.LogicaCriacao;
import br.ifpr.jogo.invaders.modelo.Entidade;
import br.ifpr.jogo.invaders.modelo.NaveJogador;
import br.ifpr.jogo.invaders.modelo.Projetil;

public class Principal {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Entidade[][] matriz = LogicaCriacao.criaMatriz();
        NaveJogador nave = LogicaCriacao.criaNaveJogador();
        ArrayList<Projetil> tiros = new ArrayList<>();

        matriz[nave.getY()][nave.getX()] = nave;
        int opcao = 0;
        
        do {
            LogicaCriacao.imprimeMatriz(matriz);
            System.out.println("Digite 0 - Sair | 1 - Esq | 2 - Dir");
            opcao = teclado.nextInt();
            matriz[nave.getY()][nave.getX()] = null;
            
            LogicaCriacao.movimentarNave(nave, opcao);
            
            Projetil tiro = LogicaCriacao.criarProjetil(nave.getX());

            

            for (Projetil projetil : tiros) {
                if(projetil.getX() == tiro.getX() && projetil.getY() == tiro.getY())
                    matriz[tiro.getY()][tiro.getX()] = tiro;
                
            }
            tiros.add(tiro);

            matriz[nave.getY()][nave.getX()] = nave;
        } while (opcao != 0);

    }
}
