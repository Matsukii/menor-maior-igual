/*
 * MIT License
 */
package menor.maior.igual;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

/**
 * @author Matsukii
 * @version java.0.4
 * @see veja tambem a versao em JavaScript! (me parece melhor que essa...)
 * 
 * Algoritimo para verificar se um numero informado e menor, igual ou maior ao pre definido
 */
public class maiorMenorIgual {
    
    public static void main(String[] args) {
        boolean y = false; // [true] -> imprime o valor ao iniciar o loop
        
        
        // valor 'correto', deixe -1 para gerar aleatorio
        float correto = 10;
        
        // controlam o loop de tentativas
        boolean acertou = false;
        int tentativas = 0;
        
        // numero maximo de tentativas
        int maxT = 10; 

        // define um numero aleatorio se for o correto nao foi alterado
        if(correto == -1){
            Random rand = new Random();
            correto = Float.valueOf(rand.nextInt(100));
        }
        
        String testar = "stop";
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        while(!acertou){
            if(tentativas == maxT){
                break;
            }
            prtv(y,correto);
            System.out.println("\nenvie 'stop' para parar \nInforme um numero:");
            
            try { testar = reader.readLine(); }
            catch (IOException e) {}
            
            if(testar.equals("stop")){ break; }
            if(testar.equals("show")){prtv(true, correto);}
            
            else if(testar.isEmpty()){
                System.out.println("\nenvie 'stop' para parar \nInforme um numero:");
            }
            else{
                try {
                    // testa o valor informado
                    tentativas = test(Float.parseFloat(testar), correto, tentativas);
                    
                    // sai do loop se estiver correto (poderia simplesmente usar o break, mas qual a graca ne?)
                    if(tentativas == -1){ acertou = true; }
                } 
                catch (NumberFormatException e) {
                    System.out.println("Valor informato nao e um numero");
                }
            }

        }
        
       
    }
    
    /**
     * testa ser o valor informado e menor, igual ou maior
     * 
     * @param n numero a ser testado
     * @param correto  numero correto para comparar
     * @param tentativas  numero correto para comparar
     * 
     * @return numero de tentativas (-1 se acertou)
     */
    public static int test(float n, float correto, int tentativas){
        String proximo = "";
        if(n > correto){
            if(n-5 < correto){proximo = "\n e esta proximo";}
            System.out.println("O numero informado ("+ n +") e maior que o correto" + proximo);
            tentativas++;
            return tentativas;
        }
        else if(n < correto){
            if(n+5 > correto){proximo = "\n e esta proximo";}
            System.out.println("O numero informado ("+ n +") e menor que o correto"  + proximo);
            tentativas++;
            return tentativas;
        }
        else if(n == correto){
            System.out.println("O numero esta correto! \n num = "+ n +"\n tentativas: "+ tentativas);
            return -1;
        }
        return -1;
    }

    /**
     * Imprime o valor gerado/definido se o parametro for verdadeiro
     * 
     * @param y [true] confirma imprimir valor gerado/definido
     * @param v valor a ser impresso
     * 
     * Por que uma funcao?
     * - evitar que a linha onde esta sendo chamada fique poluida...(mais do que ja esta)
     * 
     * Mesmo que o javaDoc seja maior que a funcao?
     * - sim
     */
    public static void prtv(boolean y, float v){
        if(y){ System.out.println(v); }
    }
}

