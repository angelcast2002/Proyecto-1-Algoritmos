import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Interprete {

    
    Scanner sc = new Scanner(System.in);
    Vista vista = new Vista();
    String instruccion = "";
    
    List<Variable> variables = new ArrayList<>();
    

    public String evaluar(String instruccion) {
        
        instruccion = instruccion.trim();
        instruccion = instruccion.substring(0, instruccion.length() - 1);
        instruccion = instruccion.substring(1);
        instruccion = instruccion.replace("'(", "-");

        String[] lista = instruccion.split("(?=\\()|(?=-)");
        

        for (int i = 0; i < lista.length; i++) {

            String orden = lista[i];
            orden = orden.replace("-", "'(");
            
            String[] comando = orden.split(" ");
            
            switch (comando[0]) {
            
            case "help":
                vista.print(" -- HELP -- \n");

                vista.print("GENERAL-- ");
                vista.print(" - exit: Finaliza el programa");
                vista.print("       (exit)");

                vista.print(" - help: Muestra los comandos disponibles");
                vista.print("       (help)");


                vista.print(" - write: imprime un mensaje en consola");
                vista.print("       (write -->expr<--)");

                vista.print("VARIABLES-- ");
                vista.print(" - setq: Sirve para crear o editar el valor de una variable");
                vista.print("       (setq -->nombre<-- (valor))\n");

                vista.print("LISTAS-- ");
                vista.print(" - first: Regresa el primer valor de una lista");
                vista.print("       (first -->lista<--)");

                vista.print(" - second, thirtd, nth: Regresa el elemento n de una lista");
                vista.print("       (second -->lista<--) -- segundo elemento");
                vista.print("       (thirtd -->lista<--) -- tercer elemento");
                vista.print("       (nth n -->lista<--) -- n elemento");

                vista.print(" - cons: Agrega un elemento al principio de una lista");
                vista.print("       (cons <expr> -->lista<--)");

                vista.print(" - append: Devuelve la union de dos listas");
                vista.print("       (append <lista1> <lista2>)");

                vista.print(" - list: Crea una lista con los elementos que recibe");
                vista.print("       (list <expr1> <expr2> ... <exprN>)");

                vista.print(" - last: Regresa el ultimo elemento de una lista");
                vista.print("       (last -->lista<--)\n");

                vista.print("FUNCIONES-- ");
                vista.print(" - defun: Define una funcion");
                vista.print("       (defun <nombre> (<parametros>) (<logica>))\n");

                vista.print("CONDICIONALES-- ");
                vista.print(" - ecuals: Regresa True o nil al comparar dos expresiones");
                vista.print("       (ecuals <expr1> <expr2>)");

                vista.print(" - eval:  Regresa el valor de 'expr' (operacion)");
                vista.print("       (eval <expr>)");

                vista.print(" - cond: evalua todas sus condiciones y devulve la primera que encuentre T");
                vista.print("       (cond (<expr> <mensaje>))\n");

                vista.print("PREDICADOS-- ");
                vista.print(" - null: Regresa True si es null (nill) y nil si no");
                vista.print("       (null <expr>)");

                vista.print(" - atom: Regresa True si es un atomo y nil si no");
                vista.print("       (atom <expr>)");

                vista.print(" - numberp: Regresa True si es un numero y nil si no");
                vista.print("       (numberp <expr>)\n");

                break;

            case "write":
                try {

                    if (comando[1].split("")[0].equals("'")) {
                        vista.print(comando[1].substring(1));

                    } else if (isNumber(comando[1])) { 
                        vista.print(comando[1]);
                    } else {
                        Boolean existe = false;
                        String mensaje = "";
                        for (Variable variable : variables) {
                            if (variable.getNombre().equals(comando[1])) {
                                existe = true;
                                mensaje += variable.getValor() + " ";
                            }
                        }

                        vista.print(mensaje);

                        if (!existe)
                            vista.prinrErr("[!] " + comando[1] + " no esta definido como variable o funcion");
                    }
                } catch (Exception e) {
                    
                    orden = lista[i + 1];
                    orden = orden.replace("-", "'(");
                    comando = orden.split(" ");

                    if (comando[0].split("")[0].equals("'")) {
                        vista.print(orden.trim().substring(1));
                    } 

                    if (comando[0].split("")[0].equals("(")) {

                        
                        orden = orden.substring(0, orden.length() - 1);
                        orden = orden.substring(1);
                        String[] elementos = orden.split(" ");

                        String mensaje = "";

                        for (int j = 0; j < elementos.length; j++) {

                            
                            if (elementos[j].split("")[0].equals("'")) { 
                                mensaje += elementos[j].substring(1) + " ";
                            } else if (isNumber(elementos[j])) { 
                                mensaje += " " + elementos[j];
                            } else {
                                Boolean existe = false;
                                for (Variable variable : variables) {
                                    if (variable.getNombre().equals(elementos[j])) {
                                        existe = true;
                                        mensaje += variable.getValor() + " ";
                                    }
                                }

                                if (!existe)
                                    vista.prinrErr("[!] " + comando[1] + " no esta definido como variable o funcion");

                            }

                        }

                        vista.print(mensaje);

                    }
                }

                break;

            case "setq":

                String name = comando[1];

                boolean existeVariable = false;
                Variable oldVariable = null;
                for (Variable variable : variables) {
                    if (variable.getNombre().equals(name)){

                        existeVariable = true;
                        oldVariable = variable;

                    } 
                }

                try {
                    if (comando[2].split("")[0].equals("")) {

                        if (existeVariable) {
                            oldVariable.setValor(comando[2].trim().substring(1));
                        } else {
                            variables.add(new Variable(name, comando[2].trim().substring(1)));
                        }

                    }




                } catch (Exception e) {
                    
                }
                
                break;

            case "first":

                try {

                    String tempNombre = comando[1];
                    for (Variable variable : variables) {
                        if (variable.getNombre().equals(tempNombre)) {
                            if (variable.getValor().split(" ").length > 0) {
                                vista.print(variable.getValor().split(" ")[0]);
                                break;
                            } else {
                                vista.prinrErr("[!] La variable " + tempNombre + " no es una lista");
                                break;
                            }
                        }
                    }

                } catch (Exception e) { 
                    orden = lista[i + 1];
                    orden = orden.replace("-", "'(");
                    comando = orden.split(" ");

                    if (comando[0].split("")[0].equals("'")) {
                        orden = orden.trim().substring(2);
                        orden = orden.substring(0, orden.length() - 1);
                        vista.print(orden.split(" ")[0]);

                    } else if (comando[0].split("")[0].equals("(")) { 

                        
                        orden = orden.substring(0, orden.length() - 1);
                        orden = orden.substring(1);
                        String elemento = orden.split(" ")[0];

                        
                        if (elemento.split("")[0].equals("'")) { 
                            vista.print(elemento.substring(1));

                        } else if (isNumber(elemento)) { 
                            vista.print(elemento);
                            break;

                        } else { // Variable
                            Boolean existe = false;
                            for (Variable variable : variables) {
                                if (variable.getNombre().equals(elemento)) {
                                    existe = true;
                                    vista.print(variable.getValor());
                                    break;
                                }
                            }

                            if (!existe) {
                                vista.prinrErr("[!] " + elemento + " no esta definido como variable o funcion");
                            }

                        }

                    }
                }

                break;

            case "rest":
                break;

            case "second":
                break;

            case "thirtd":
                break;

            case "nth":
                break;

            case "cons": 
                break;

            case "append":
                break;

            case "list": 
                break;

            case "last":
                break;

            case "defun":
                break;

            case "ecuals":
                break;

            case "eval":
                break;

            case "cond":
                break;

            case "null":
                break;

            case "atom":
                break;

            case "numberp":
                break;

            }
        }
        return null;
    }

    public static boolean isNumber(String valor){

        if (valor == null || valor.equals("")) {
            return false;
        } 
    
        try {
            Integer.parseInt(valor);
            return true;
        } catch (NumberFormatException e) {
        }
        return false;
    }

    public static int contarCaracteres(String chain, char caracter) {
        int pos, contador = 0;
        
        pos = chain.indexOf(caracter);
        while (pos != -1) {
            contador++;
            pos = chain.indexOf(caracter, pos + 1);
        }
        return contador;
    }

}

