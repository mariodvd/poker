package dia6;

import java.util.Arrays;

public class poker2 {

    public static void main(String[] args){
        String[] cartas = {"ASC", "2C", "3C", "4C", "5C", "6C", "7C", "8C", "9C", "10C", "JC", "QC", "KC", "ASD", "2D", "3D", "4D", "5D", "6D", "7D", "8D", "9D", "10D", "JD", "QD", "KD", "ASH", "2H", "3H", "4H", "5H", "6H", "7H", "8H", "9H", "10H", "JH", "QH", "KH", "ASS", "2S", "3S", "4S", "5S", "6S", "7S", "8S", "9S", "10S", "JS", "QS", "KS"};
        
        //creacion de las cartas
        Carta[] cartasJuego = new Carta [5];
        
        //por default
        String c1, c2, c3, c4, c5;
        c1 = cartas[(int) (Math.random() * cartas.length)];
        c2 = cartas[(int) (Math.random() * cartas.length)];
        c3 = cartas[(int) (Math.random() * cartas.length)];
        c4 = cartas[(int) (Math.random() * cartas.length)];
        c5 = cartas[(int) (Math.random() * cartas.length)];
        
        //creacion de las cartas
        cartasJuego[0] = new Carta(c1);
        cartasJuego[1] = new Carta(c2);
        cartasJuego[2] = new Carta(c3);
        cartasJuego[3] = new Carta(c4);
        cartasJuego[4] = new Carta(c5);
        System.out.println("Cartas del juego: ");
        for(int i=0; i<5; i++){
            System.out.println(cartasJuego[i].valorPalo());
        }
        
        //separar numeros de palos
        String[] numeros = new String[5];
        String[] palos = new String[5];
        for(int i=0; i<5; i++){
            if (cartasJuego[i].valor.equals("A")){
                numeros[i] = "1";
            } else if (cartasJuego[i].valor.equals("J")){
                numeros[i] = "11";
            } else if (cartasJuego[i].valor.equals("Q")){
                numeros[i] = "12";
            } else if (cartasJuego[i].valor.equals("K")){
                numeros[i] = "13";
            } else {
                numeros[i] = cartasJuego[i].valor;
            }    
            palos[i] = cartasJuego[i].palo;
        }
        System.out.println("Numeros: "+numeros[0]+" "+numeros[1]+" "+numeros[2]+" "+numeros[3]+" "+numeros[4]);
        System.out.println("Palos: "+palos[0]+" "+palos[1]+" "+palos[2]+" "+palos[3]+" "+palos[4]);
     
        //pasar numeros a int
        int[] numerosOrdenadosInt = new int[5];
        for(int i=0; i<5; i++){
            numerosOrdenadosInt[i] = Integer.parseInt(numeros[i]);
        }

        //ordenar numeros
        for (int i = 0; i < numerosOrdenadosInt.length - 1; i++) {
            for (int j = 0; j < numerosOrdenadosInt.length - 1; j++) {
                if (numerosOrdenadosInt[j] > numerosOrdenadosInt[j + 1]) {
                    int aux = numerosOrdenadosInt[j];
                    numerosOrdenadosInt[j] = numerosOrdenadosInt[j + 1];
                    numerosOrdenadosInt[j + 1] = aux;
                }
            }
        }
        System.out.println("Numeros ordenados: "+numerosOrdenadosInt[0]+" "+numerosOrdenadosInt[1]+" "+numerosOrdenadosInt[2]+" "+numerosOrdenadosInt[3]+" "+numerosOrdenadosInt[4]);
        
        
        //poker (4 numeros iguales)
        int d=0;
        if (numerosOrdenadosInt[0] == numerosOrdenadosInt[1] && numerosOrdenadosInt[1] == numerosOrdenadosInt[2] && numerosOrdenadosInt[2] == numerosOrdenadosInt[3] && numerosOrdenadosInt[3] == numerosOrdenadosInt[4]){
            System.out.println("Poker");
            d=1;
        }else if(numerosOrdenadosInt[1]==numerosOrdenadosInt[2] && numerosOrdenadosInt[2] == numerosOrdenadosInt[3] && numerosOrdenadosInt[3] == numerosOrdenadosInt[4] && numerosOrdenadosInt[4] == numerosOrdenadosInt[5]){
            System.out.println("Poker");
            d=1;
        }

        //contar numeros iguales
        int [] num = new int[14];
        for(int i=0; i<5; i++){
            num[numerosOrdenadosInt[i]]++;
        }
        //System.out.println("Numeros iguales: "+num[1]+" "+num[2]+" "+num[3]+" "+num[4]+" "+num[5]+" "+num[6]+" "+num[7]+" "+num[8]+" "+num[9]+" "+num[10]+" "+num[11]+" "+num[12]+" "+num[13]);

        //full (3 iguales y 2 iguales)
        for (int i = 1; i < num.length; i++) {
            if (num[i] == 3) {
                for (int j = 1; j < num.length; j++) {
                    if (num[j] == 2) {
                        System.out.println("Full");
                        d=1;
                    }
                }
            }
        }

        //color (todos los palos iguales)
        if (palos[0].equals(palos[1]) && palos[1].equals(palos[2]) && palos[2].equals(palos[3]) && palos[3].equals(palos[4])) {
            System.out.println("Color");
            d=1;
        }

        //escalera (todos los numeros en orden)
        int [] escalera = new int[14];
        for (int i =1; i<13; i++){
            escalera[i] = i;
        }
        if (Arrays.equals(escalera, numerosOrdenadosInt)){
            System.out.println("Escalera");
            d=1;
        }

        //trio 
        for (int i = 1; i < num.length; i++) {
            if (num[i] == 3) {
                System.out.println("Trio");
                d=1;
            }
        }
        //par doble
        int contador2 = 0 ;
        for (int i = 1; i < num.length; i++) {
            if (num[i] == 2) {
                contador2++;
                d=1;
            }
        }
        if (contador2 == 2) {
            System.out.println("Par doble");
        }   
        //par 
        for (int i = 1; i < num.length; i++) {
            if (num[i] == 2) {
                System.out.println("Par");
                d=1;
            }
        }
        //carta alta
        if (d==0){  
            for (int i = 1; i < num.length; i++) {
                if (num[i] == 1) {
                    System.out.println("Carta alta");
                }
            }
        }
    }
}