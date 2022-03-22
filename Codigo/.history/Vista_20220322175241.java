public class Vista {
    
    //Aqui pongo los colores que uso para que no se mire tan TRISTE la consola
    String red = "\033[31m";
    String green = "\033[32m"; 
    String reset = "\u001B[0m";

    public void prinrErr(String mensaje) { //Imprimo el mensaje que necesito con formato ROJO
        System.out.print(red + ">> " + mensaje + reset + "\n");
    }

    public void print(String mensaje) { //Imprimo el mensaje que necesito con formato VERDE
        System.out.print(green + ">> " + mensaje + reset + "\n");
    }
    
}
