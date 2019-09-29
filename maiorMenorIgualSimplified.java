/*
 * MIT License
 */
package menor.maior.igual;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Matsukii
 * @version java.0.5.simplified
 * @see veja tambem a versao em Java supercomplicada!
 * @see veja tambem a versao em JavaScript! (me parece melhor que essa...)
 * 
 * Algoritimo para verificar se um numero informado e menor, igual ou maior ao pre definido
 */
public class maiorMenorIgualSimplified {
    
    public static void main(String[] args) {
        int certo = 10;
        String teste = "stop";
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.println("envie 'stop' para parar \nInforme um valor");
            try { teste = reader.readLine(); } catch (IOException e) {}
            
            if(Integer.valueOf(teste) == certo){
                System.out.println("Acertou: " + certo);
                break;
            }
            else if(Integer.valueOf(teste) > certo){
                System.out.println("O valor informado e maior");
            }
            else if(Integer.valueOf(teste) < certo){
                System.out.println("O valor informado e menor");
            }
            else if(teste.equals("stop")){
                break;
            }
        }
    }
}

