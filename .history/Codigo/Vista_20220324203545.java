/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author Angel
 * @author Mario
 * @author Javier
 */
public class Vista {

    //Se definen los colores
    String red = "\033[31m";
    String green = "\033[32m"; 
    String reset = "\u001B[0m";

    /**
     *
     * @param mensaje es el mensaje que se muestra en consola
     */
    public void prinrErr(String mensaje) {
        System.out.print(red + "$$ " + mensaje + reset + "\n");
    }

    /**
     *
     * @param mensaje es el mensaje que se muestra en consola
     */
    public void print(String mensaje) {
        System.out.print(green + "$$ " + mensaje + reset + "\n");
    }
    
}

