/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automatal5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Andrea Plascencia
 */
public class AutomataL5 {
    
    int cont = 0;
    char [] caracter;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        AutomataL5 automata = new AutomataL5();
        
        System.out.println("EL LENGUAJE QUE CONTIENE LA SUBPALABRA BCAC\n");
        String cadena;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Por favor, ingresa una cadena: ");
        cadena = reader.readLine(); 
        
        int longitud = 0;
        automata.caracter = cadena.toCharArray();
        for(int i = 0; i < automata.caracter.length; i++) {
            if (automata.caracter[i] != 'a' && automata.caracter[i] != 'b' && automata.caracter[i] != 'c') {
                longitud++;
                break;
            }
        }
        if (longitud > 0) {
            automata.incorrecto();
        }
        else {
            //System.out.print("Inicia en ");
            automata.S();
        }
    }
    
    public void S(){
        //System.out.println("Estado S");
        if(cont < caracter.length){
            if(caracter[cont] == 'a'){
                cont++;
                S();
            }
            else if (caracter[cont] == 'c'){
                cont++;
                S();
            }
            else if (caracter[cont] == 'b') {
                cont++;
                A();
            }
        }
        else {
            incorrecto();
        }
     }//Fin S
    
    public void A(){
        //System.out.println("Estado A");
        if(cont < caracter.length){
            if(caracter[cont] == 'a'){
            cont++;
            S();
            }
            else if (caracter[cont] == 'b'){
                cont++;
                A();
            }
            else if (caracter[cont] == 'c') {
                cont++;
                B();
            }
        }
        else {
            incorrecto();
        }       
     }//Fin A
    
    public void B(){
        //System.out.println("Estado B");
        if(cont < caracter.length){
            if(caracter[cont] == 'b'){
            cont++;
            A();
            }
            else if (caracter[cont] == 'c'){
                cont++;
                S();
            }
            else if (caracter[cont] == 'a') {
                cont++;
                C();
            }
        }
        else {
            incorrecto();
        }       
     }//Fin B
    
    public void C(){
        //System.out.println("Estado C");
        if(cont < caracter.length){
            if(caracter[cont] == 'a'){
            cont++;
            S();
            }
            else if (caracter[cont] == 'b'){
                cont++;
                A();
            }
            else if (caracter[cont] == 'c') {
                cont++;
                D();
            }
        }
        else {
            incorrecto();
        }       
     }//Fin C
    
    public void D(){
        //System.out.println("Estado D");
        if(cont < caracter.length){
            if(caracter[cont] == 'a'){
            cont++;
            D();
            }
            else if (caracter[cont] == 'b'){
                cont++;
                D();
            }
            else if (caracter[cont] == 'c') {
                cont++;
                D();
            }
        }
        else {
            System.out.println("\nCADENA ACEPTADA\n");
        }       
     }//Fin D
    
    public void incorrecto(){
        System.out.println("\nCADENA INCORRECTA\n");
    }
    
}