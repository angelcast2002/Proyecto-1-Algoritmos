/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto1;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Angel
 */


public class Scanner {
    public static int State(String expresion) {

        // Se crea la expresion para la suma de enteros
        if (evaluate("^[(][ ]*[+][ ]+([a-z]+|[0-9]+)[ ]+([a-z]+|[0-9]+)[ ]*[)]$",expresion)) { 
            return 1;
        }
        
        // Se crea la expresion para la resta de enteros
        else if (evaluate("^[(][ ]*[-][ ]+([a-z]+|[0-9]+)[ ]+([a-z]+|[0-9]+)[ ]*[)]$",expresion)) {
            return 2;
        }

        // Se crea la expresion para la multiplicacion de enteros
        else if (evaluate("^[(][ ]*[*][ ]+([a-z]+|[0-9]+)[ ]+([a-z]+|[0-9]+)[ ]*[)]$",expresion)) {
            return 3;
        }

        // Se crea la expresion para la division de enteros
        else if (evaluate("^[(][ ]*[/][ ]+([a-z]+|[0-9]+)[ ]+([a-z]+|[0-9]+)[ ]*[)]$",expresion)) {
            return 4;
        }
        
        return 0;
    }

    private static boolean evaluate(String regex, String expresion){
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(expresion);
        return matcher.find();
    }
}
