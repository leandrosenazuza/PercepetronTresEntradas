package org.example;

public class PerceptronTresEntradas {

    double u = 0.0;
    Dados dados = new Dados();

    Pesos pesos = new Pesos();

    /**
     * @bias é o limiar de ativação
     * */
    Double bias = -0.5;

    /**
     * @n taxa de aprendizado
     * */
    Double n = 0.5;

    int y1 = 0;
    int epoca = 0;


    /**
     * Está sendo utilizado uma função de ativação degrau.
     * g(u) = 1, se u >= 0
     * g(u) = 0, se u < 0
     * */

    public int funcaoDeAtivacao(double u){
        if(u >= 0) return 1;
        else return 0;
    }

    public double calculoU(int i){
        return  (dados.x1[i]*pesos.w1 + dados.x2[i]*pesos.w2 + dados.x3[i]*pesos.w1) + bias;
    }

    /**
     * Se a saída do neurônio for igual a saída desejada, ele será ativado.
     *
     *
     * * */
    public Pesos executar(){
        pesos.epoca++;
        int i = 0;

        while(i < dados.y.length){
            boolean ativado = false;
            double u = calculoU(i);
            double gu = funcaoDeAtivacao(u);
            if(gu == dados.y[i]){
                ativado = true;
                System.out.println("&----------------------------------------&");
                System.out.println("Foi ativado? " + (ativado ? "Sim!" : "Não!") + " Valor objetivado: y= " + dados.y[i]);
                System.out.println("&----------------------------------------&");
                System.out.println("\n");
            }
            if(!ativado){
                System.out.println("================> y[" + i + "]: " + dados.y[i] + "<================");
                this.pesos.w1 = calculoNovoPeso(this.dados.y[i], this.dados.x1[i], i, gu) + this.pesos.w1;
                this.pesos.w2 = calculoNovoPeso(this.dados.y[i], this.dados.x2[i], i, gu) + this.pesos.w2;
                this.pesos.w3 = calculoNovoPeso(this.dados.y[i], this.dados.x3[i], i, gu) + this.pesos.w3;
                System.out.println("\n");
            }else{
                i++;
            }

        }

        System.out.println("*----------------------------------*");
        System.out.println("Os pesos final foram: ");
        System.out.println("w1: " + pesos.w1);
        System.out.println("w2: " + pesos.w2);
        System.out.println("w3: " + pesos.w3);
        System.out.println("bias: " + this.bias);
        System.out.println("Taxa de aprendizado: " + this.n);
        System.out.println("O modelo final fica: " + "u = " + pesos.w1 + "*x1 + " + pesos.w2 + "*x2 + " + pesos.w3+ "*x3 + (" + this.bias + ")");
        System.out.println("*----------------------------------*");
        System.out.println("\n");


        return pesos;

    }

    public Pesos executarNovoPeso(Pesos pesoEpocaAnterior){
        pesoEpocaAnterior.epoca++;
        int i = 0;

        while(i < dados.y.length){
            boolean ativado = false;
            double u = calculoU(i);
            double gu = funcaoDeAtivacao(u);
            if(gu == dados.y[i]){
                ativado = true;
                System.out.println("&----------------------------------------&");
                System.out.println("Foi ativado? " + (ativado ? "Sim!" : "Não!") + " Valor objetivado: y= " + dados.y[i]);
                System.out.println("&----------------------------------------&");
                System.out.println("\n");
            }
            if(!ativado){
                System.out.println("================> y[" + i + "]: " + dados.y[i] + "<================");
                pesoEpocaAnterior.w1 = calculoNovoPeso(this.dados.y[i], this.dados.x1[i], i, gu) + this.pesos.w1;
                pesoEpocaAnterior.w2 = calculoNovoPeso(this.dados.y[i], this.dados.x2[i], i, gu) + this.pesos.w2;
                pesoEpocaAnterior.w3 = calculoNovoPeso(this.dados.y[i], this.dados.x3[i], i, gu) + this.pesos.w3;

                System.out.println("\n");
            }else{
                i++;
            }

        }

        System.out.println("*----------------------------------*");
        System.out.println("Os pesos final foram: ");
        System.out.println("w1: " + pesoEpocaAnterior.w1);
        System.out.println("w2: " + pesoEpocaAnterior.w2);
        System.out.println("w3: " + pesoEpocaAnterior.w3);
        System.out.println("bias: " + this.bias);
        System.out.println("Taxa de aprendizado: " + this.n);
        System.out.println("O modelo final fica: " + "u = " + pesoEpocaAnterior.w1 + "*x1 + " + pesoEpocaAnterior.w2 + "*x2 + " + pesoEpocaAnterior.w3+ "*x3 + (" + this.bias + ")");
        System.out.println("*----------------------------------*");
        System.out.println("\n");


        if(pesos.w1 == pesoEpocaAnterior.w1 && pesos.w2 == pesoEpocaAnterior.w2 && pesos.w3 == pesoEpocaAnterior.w3) pesoEpocaAnterior.sucesso = true;
        return pesoEpocaAnterior;

    }



    /**
     * Calculo do novo peso
     *
     *  deltaWi = n (Yi - yi)xi
     *  O erro portanto é a taxa de aprendizado vezes o valor desejado menos o valor obtido multiplicado pela entrada
     * * */
    public double calculoNovoPeso(double Yi, double xi, int i, double gu){

        System.out.println("===============================================");

        System.out.println("n: " + this.n);

        System.out.println("Yi: " + this.dados.y[i]);

        System.out.println("yi: " + gu);

        System.out.println("xi: " + xi);

        double delta = this.n*(Yi - gu)*xi;

        System.out.println("Novo peso delta: " + delta);
        System.out.println("===============================================");
        System.out.println("\n");
        return delta;
    }

}
