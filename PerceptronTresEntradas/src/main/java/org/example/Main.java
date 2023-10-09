package org.example;


public class Main {
    public static void main(String[] args) {

        PerceptronTresEntradas perceptronTresEntradas = new PerceptronTresEntradas();

        apresentacao();
        Pesos pesos = perceptronTresEntradas.executar();
        pesos = perceptronTresEntradas.executarNovoPeso(pesos);
        if (pesos.sucesso){
            System.out.println("O modelo é um sucesso");
            System.out.println("w1: " + pesos.w1);
            System.out.println("w2: " + pesos.w2);
            System.out.println("w3: " + pesos.w3);
        }
    }
    private static void apresentacao() {
        System.out.println("O presente programa tem por objetivo utilizar de uma Rede Neural Perceptron, para criar um modelo para uma função degrau, a partir da tabela nutricional");
        System.out.println("São os dados: ");
        System.out.println("$============$");
        System.out.println("x1 | x2 | y");
        System.out.println(" 0 |  0 | 0");
        System.out.println(" 0 |  1 | 1");
        System.out.println(" 1 |  0 | 1");
        System.out.println(" 1 |  1 | 1");
        System.out.println("$============$");
    }
    }
