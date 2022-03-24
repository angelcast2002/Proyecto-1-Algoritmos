import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Arrays;
import java.util.ListIterator;

public class Interprete {

    
    Scanner sc = new Scanner(System.in);
    Vista vista = new Vista();
    String instruccion = "";
    
    List<Variable> variables = new ArrayList<>();
    List<Funciones> funciones = new ArrayList<>();

    public void ejecutar() {

        Boolean estado = true;
        while (estado) {

            if (instruccion.length() > 0) {
                System.out.print("$$ ... ");
            } else {
                System.out.print("$$ ");
            }
            String tempInstruccion = sc.nextLine().toLowerCase();
            instruccion += " " + tempInstruccion;

            if (instruccion.equals(" (exit)")) {
                estado = false;
            } else {
                int parentesisApertura = contarCaracteres(instruccion, '(');
                int parentesisCierre = contarCaracteres(instruccion, ')');

                // Ver si se ha completado la intruccion
                if (parentesisApertura == parentesisCierre) {

                    if (parentesisCierre > 0) {
                        String result = Evaluar(instruccion);
                    } else {
                        vista.prinrErr("[Error] Las intrucciones inician con -- ( -- y finalizan con -- ) --");
                    }

                    instruccion = "";
                }
            }

        }

    }

    public String Evaluar(String instruccion) {
        
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
                    if (comando[2].split("")[0].equals("")) 
                    {

                        if (existeVariable) {
                            oldVariable.setValor(comando[2].trim().substring(1));
                        } else {
                            variables.add(new Variable(name, comando[2].trim().substring(1)));
                        }

                    } else if (isNumber(comando[2])) 
                    {
                        if (existeVariable) {

                            oldVariable.setValor(comando[2].trim());

                        } else {
                            variables.add(new Variable(name, comando[2].trim()));
                        }

                    } else 
                    {

                        Boolean exists = false;

                        for (Variable variable : variables) {
                            if (variable.getNombre().equals(comando[2])) {
                                exists = true;
                                if (existeVariable) {
                                    oldVariable.setValor(variable.getValor());
                                } else {
                                    variables.add(new Variable(name, variable.getValor()));
                                }
                            }
                        }

                        if (!exists) {
                            vista.prinrErr("ERROR " + comando[2] + " no es una variable definida");
                        }

                    }

                } catch (Exception e) {
                    
                    orden = lista[i + 1];
                    orden = orden.replace("-", "(");
                    comando = orden.split(" ");

                    if (comando[0].split("")[0].equals("'")) {
                        if (existeVariable) {
                            oldVariable.setValor(orden.trim().substring(1));
                        } else {
                            variables.add(new Variable(name, orden.trim().substring(1)));
                        }
                    }

                    if (comando[0].split("")[0].equals("(")) {

                        orden = orden.substring(0, orden.length() - 1);
                        orden = orden.substring(1);
                        String[] elements = orden.split(" ");

                        String mensaje = "";

                        for (int j = 0; j < elements.length; j++) {
                            
                            if (elements[j].split("")[0].equals("")) {
                                mensaje += elements[j].substring(1) + " ";
                            } else if (isNumber(elements[j])) {
                                mensaje += elements[j] + " ";
                            } else {
                                Boolean exists = false; 
                                for (Variable variable : variables) {
                                    if (variable.getNombre().equals(elements[j])){
                                        exists = true;
                                        mensaje += variable.getValor() + " ";
                                    }
                                }

                                if (!exists) {
                                    vista.prinrErr("ERROR " + comando[1] + " no es una variable definida");
                                }

                            }
                        }

                        if (existeVariable) {
                            oldVariable.setValor(mensaje);
                        } else {
                            variables.add(new Variable(name, mensaje));
                        }

                    }

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

                        } else { 
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
            
                try {

                    String tempNombre = comando[1];
                    String tempLista = "";
                    for (Variable variable : variables) {
                        if (variable.getNombre().equals(tempNombre)) {
                            if (variable.getValor().split(" ").length > 0) {

                                for (int j = 0; j < variable.getValor().split(" ").length; j++) {
                                    if (j != 0) {
                                        tempLista += variable.getValor().split(" ")[j] + " ";
                                    }
                                }
                                break;
                            } else {
                                vista.prinrErr("[!] La variable " + tempNombre + " no es una lista");
                                break;
                            }
                        }
                    }
                    vista.print("(" + tempLista + ")");

                } catch (Exception e) { 
                    orden = lista[i + 1];
                    orden = orden.replace("-", "'(");
                    comando = orden.split(" ");

                    if (comando[0].split("")[0].equals("'")) {
                        orden = orden.trim().substring(2);
                        orden = orden.substring(0, orden.length() - 1);

                        String[] tempOrder = orden.split(" ");
                        String tempLista = "";

                        for (int j = 0; j < tempOrder.length; j++) {
                            if (j != 0) {
                                tempLista += tempOrder[j] + " ";
                            }
                        }

                        vista.print(tempLista);

                    } else if (comando[0].split("")[0].equals("(")) { 

                        
                        orden = orden.substring(0, orden.length() - 1);
                        orden = orden.substring(1);
                        String[] elementos = orden.split(" ");
                        String tempList = "";

                        for (int j = 0; j < elementos.length; j++) {
                            if (j != 0) {

                                
                                if (elementos[j].split("")[0].equals("'")) { 
                                    tempList += elementos[j].substring(1) + " ";

                                } else if (isNumber(elementos[j])) { 
                                    tempList += elementos[j] + " ";

                                } else { 
                                    Boolean existe = false;
                                    for (Variable variable : variables) {
                                        if (variable.getNombre().equals(elementos[j])) {
                                            existe = true;
                                            tempList += variable.getValor() + " ";
                                        }
                                    }

                                    if (!existe) {
                                        vista.prinrErr(
                                                "[!] " + elementos[j] + " no esta definido como variable o funcion");
                                    }

                                }

                            }
                        }

                        vista.print(tempList);

                    }
                }

                break;

            case "second":
            try {

                String tempNombre = comando[1];
                for (Variable variable : variables) {
                    if (variable.getNombre().equals(tempNombre)) {
                        if (variable.getValor().split(" ").length > 1) {
                            vista.print(variable.getValor().split(" ")[1]);
                            break;
                        } else {
                            vista.prinrErr("[!] No existen suficientes elementos en la lista");
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
                    if (orden.split(" ").length > 1) {
                        vista.print(orden.split(" ")[1]);
                    } else {
                        vista.prinrErr("[!] No existen suficientes elementos en la lista");
                    }

                } else if (comando[0].split("")[0].equals("(")) { 

                  
                    orden = orden.substring(0, orden.length() - 1);
                    orden = orden.substring(1);
                    String elemento = orden.split(" ")[1];

                    
                    if (elemento.split("")[0].equals("'")) { 
                        if (orden.split(" ").length >= 1) {
                            vista.print(orden.split(" ")[1].substring(1));
                        } else {
                            vista.prinrErr("[!] No existen suficientes elementos en la lista");
                        }
                        break;
                    } else if (isNumber(elemento)) { 
                        if (orden.split(" ").length > 1) {
                            vista.print(elemento);
                        } else {
                            vista.prinrErr("[!] No existen suficientes elementos en la lista");
                        }
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

            case "thirtd":
            try {

                String tempNombre = comando[1];
                for (Variable variable : variables) {
                    if (variable.getNombre().equals(tempNombre)) {
                        if (variable.getValor().split(" ").length > 2) {
                            vista.print(variable.getValor().split(" ")[2]);
                            break;
                        } else {
                            vista.prinrErr("[!] No existen suficientes elementos en la lista");
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
                    if (orden.split(" ").length > 2) {
                        vista.print(orden.split(" ")[2]);
                    } else {
                        vista.prinrErr("[!] No existen suficientes elementos en la lista");
                    }

                } else if (comando[0].split("")[0].equals("(")) { 

                    
                    orden = orden.substring(0, orden.length() - 1);
                    orden = orden.substring(1);
                    String elemento = orden.split(" ")[2];

                    
                    if (elemento.split("")[0].equals("'")) { 
                        if (orden.split(" ").length > 2) {
                            vista.print(orden.split(" ")[2].substring(1));
                        } else {
                            vista.prinrErr("[!] No existen suficientes elementos en la lista");
                        }
                        break;
                    } else if (isNumber(elemento)) { 
                        if (orden.split(" ").length > 2) {
                            vista.print(elemento);
                        } else {
                            vista.prinrErr("[!] No existen suficientes elementos en la lista");
                        }
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

            case "nth":
            try {

                String tempNombre = comando[2];
                int index = Integer.parseInt(comando[1]);
                try {
                    for (Variable variable : variables) {
                        if (variable.getNombre().equals(tempNombre)) {
                            if (variable.getValor().split(" ").length >= index) {
                                vista.print(variable.getValor().split(" ")[index - 1]);
                                break;
                            } else {
                                vista.prinrErr("[!] No existen suficientes elementos en la lista");
                                break;
                            }
                        }
                    }
                } catch (Exception e) {
                    vista.prinrErr("[!] La posicion " + index + " no es valida");
                }

            } catch (Exception e) {

                int index = Integer.parseInt(comando[1]);

                
                orden = lista[i + 1];
                orden = orden.replace("-", "'(");
                comando = orden.split(" ");

                if (comando[0].split("")[0].equals("'")) {
                    orden = orden.trim().substring(2);
                    orden = orden.substring(0, orden.length() - 1);
                    if (orden.split(" ").length >= index) {
                        vista.print(orden.split(" ")[index - 1]);
                    } else {
                        vista.prinrErr("[!] No existen suficientes elementos en la lista");
                    }

                } else if (comando[0].split("")[0].equals("(")) { 

                    
                    orden = orden.substring(0, orden.length() - 1);
                    orden = orden.substring(1);
                    String elemento = orden.split(" ")[index - 1];

                    
                    if (elemento.split("")[0].equals("'")) { 
                        if (orden.split(" ").length >= index) {
                            vista.print(orden.split(" ")[index - 1].substring(1));
                        } else {
                            vista.prinrErr("[!] No existen suficientes elementos en la lista");
                        }
                        break;
                    } else if (isNumber(elemento)) { 
                        if (orden.split(" ").length >= index) {
                            vista.print(elemento);
                        } else {
                            vista.prinrErr("[!] No existen suficientes elementos en la lista");
                        }
                        break;

                    } else { 
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

            case "cons": 
                String listaCompleta = "";

                if (comando[1].split("")[0].equals("'")) { 
                    listaCompleta += comando[1].substring(1) + " ";

                } else if (isNumber(comando[1])) { 
                    vista.print(comando[1]);
                    listaCompleta += comando[1] + " ";

                } else { 
                    Boolean existe = false;
                    String mensaje = "";
                    for (Variable variable : variables) {
                        if (variable.getNombre().equals(comando[1])) {
                            existe = true;
                            mensaje += variable.getValor() + " ";
                        }
                    }

                    listaCompleta += mensaje;

                    if (!existe) {
                        vista.prinrErr("[!] " + comando[1] + " no esta definido como variable o funcion");
                    }
                }

                try {
                   
                    orden = lista[i + 1];
                    orden = orden.replace("-", "'(");
                    comando = orden.split(" ");

                    if (comando[0].split("")[0].equals("'")) { 

                        listaCompleta += orden.trim().substring(1) + " ";

                    } else if (comando[0].split("")[0].equals("(")) { 
                        
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
                                    vista.prinrErr("[!] " + comando[0] + " no esta definido como variable o funcion");

                            }

                        }

                        listaCompleta += mensaje;
                    }
                } catch (Exception e) {
                    vista.prinrErr("[!] Error en sintaxis cerca de 'cons'. Debe ingresar una lista como parametro");
                    break;
                }

                listaCompleta = listaCompleta.replace(")", "");
                vista.print(listaCompleta);
                break;

            case "append":
            listaCompleta = "";

                int n = 1;
                while (n <= 2) {

                    try {
                        
                        orden = lista[i + n];
                        orden = orden.replace("-", "'(");
                        comando = orden.split(" ");

                        if (comando[0].split("")[0].equals("'")) { 

                            listaCompleta += orden.trim().substring(1) + " ";

                        } else if (comando[0].split("")[0].equals("(")) { 

                            
                            orden = orden.substring(0, orden.length() - 1);
                            orden = orden.substring(1);
                            String[] elementos = orden.split(" ");

                            String mensaje = "";

                            for (int j = 0; j < elementos.length; j++) {

                                
                                if (elementos[j].split("")[0].equals("'")) { 
                                    mensaje += elementos[j].substring(1) + " ";
                                } else if (isNumber(elementos[j])) { 
                                    mensaje += elementos[j] + " ";
                                } else { 
                                    Boolean existe = false;
                                    for (Variable variable : variables) {
                                        if (variable.getNombre().equals(elementos[j])) {
                                            existe = true;
                                            mensaje += variable.getValor() + " ";
                                        }
                                    }

                                    if (!existe) {
                                        vista.prinrErr(
                                                "[!] " + comando[0] + " no esta definido como variable o funcion");
                                    }

                                }

                            }

                            listaCompleta += mensaje;

                        }
                        n += 1;
                    } catch (Exception e) {
                        vista.prinrErr("[!] Error en sintaxis cerca de 'cons'. Debe ingresar una lista como parametro");
                        break;
                    }

                }

                listaCompleta = listaCompleta.replace(")", "");
                vista.print(listaCompleta);

                break;

            case "list":

            listaCompleta = "";
                for (int j = 0; j < comando.length; j++) {
                    if (j != 0) {

                        if (comando[j].split("")[0].equals("'")) { 
                            listaCompleta += comando[j].substring(1) + " ";

                        } else if (isNumber(comando[j])) { 
                            listaCompleta += comando[j] + " ";

                        } else { 
                            Boolean existe = false;
                            for (Variable variable : variables) {
                                if (variable.getNombre().equals(comando[1])) {
                                    existe = true;
                                    listaCompleta += variable.getValor() + " ";
                                }
                            }

                            if (!existe)
                                vista.prinrErr("[!] " + comando[1] + " no esta definido como variable o funcion");
                        }

                    }
                } 
            
            
                break;

            case "last":
            try {

                String tempNombre = comando[1];
                for (Variable variable : variables) {
                    if (variable.getNombre().equals(tempNombre)) {
                        if (variable.getValor().split(" ").length > 0) {
                            int ultimaPos = variable.getValor().split(" ").length - 1;
                            vista.print(variable.getValor().split(" ")[ultimaPos]);
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
                    vista.print(orden.split(" ")[-1]);

                } else if (comando[0].split("")[0].equals("(")) { 

                    
                    orden = orden.substring(0, orden.length() - 1);
                    orden = orden.substring(1);

                    int ultimaPos = orden.split(" ").length - 1;

                    String elemento = orden.split(" ")[ultimaPos];

                    
                    if (elemento.split("")[0].equals("'")) { 
                        vista.print(elemento.substring(1));

                    } else if (isNumber(elemento)) { 
                        vista.print(elemento);
                        break;

                    } else { 
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

            case "defun":
            
            //Guardar los parametros
            String parametros = lista[1];
            parametros = parametros.replace("(", "");
            parametros = parametros.replace(")", "");
            parametros = parametros.replace(" ", ",");

            String[] sepParam = parametros.split(",");
            ArrayList<String> newSepParam = new ArrayList<>();
            for (int j = 0; j < sepParam.length; j++) {
                newSepParam.add(sepParam[j]); 
            }
            newSepParam.removeAll(Arrays.asList(null," "));


            //Guardar nombre funcion
            String nombreFuncion = comando[1];

            //Se inicializa argumento
            String argumento = "";

            //Guardar lo que hace la funcion (si hay 3 elementos en lista, se esta creando la funcion)
            if (lista.length == 3) {
                argumento = lista[2];
                argumento = argumento.replace("(", "");
                argumento = argumento.replace(")", "");
                argumento = argumento.replace(" ", ",");
            }

            //Evalua si ya existe la funcion 
            boolean existeFuncion = false;
            Funciones oldFuncion = null;
            for (Funciones funcionList : funciones) {

                if (funcionList.getName().equals(nombreFuncion)) {
                    existeFuncion = true;
                    oldFuncion = funcionList;
                }

            }

            //EXISTE LA FUNCION, EVALUA LA FUNCION CON PARAMETROS DADOS
            if (existeFuncion) {
                //Error en caso de que exista algun error
                boolean error = false;

                if (lista.length > 2) {
                    //Si lista es mayor a 2, significa que el usuario ha intentado crear una funcion con el mismo nombre
                    System.out.println("ERROR: " + "La funcion " + oldFuncion.getName() + " ya fue creada.");
                } else {
                    //No ha agregado un argumento a la funcion ya creado
                    String arg1 = oldFuncion.getArgus();
                    String[] sepArg = arg1.split(",");
                    ArrayList<String> newSepArg = new ArrayList<>();
                    for (int j = 0; j < sepArg.length; j++) {
                        newSepArg.add(sepArg[j]); 
                    }
                    newSepArg.removeAll(Arrays.asList(null," "));
    
                    //Funcion de 1 parametro
                    if (newSepParam.size() == 1) {
                        String parametro = newSepParam.get(0);
    
                        //parametro temporal para evaluar funcion (defun suma (a) (+ a 10)) parametro temporal es a
                        String tempParam = oldFuncion.getParams().get(0);
                        //si el argumento contiene el parametro temporal
                        if (newSepArg.contains(tempParam)) {
                            //encuentra el parametro en el argumento
                            ListIterator<String> iterator = newSepArg.listIterator();
                            while (iterator.hasNext()) {
                                String next = iterator.next();
                                if (next.equals(tempParam)) {
                                    //cambia el parametro temporal dentro del argumento por el parametro ingresado para evaluar la funcion
                                    iterator.set(parametro);
                                }
                            }
    
                        } else {
                            System.out.println("ERROR: El parametro no se encuentra en el argumento de la funcion");
                            error = true;
                        }

                        //PARA RECURSIVIDAD WIP
                        String nombreTemp = nombreFuncion;

                        if (newSepArg.contains(nombreFuncion)) {
                            //encuentra el parametro en el argumento
                            ListIterator<String> iterator = newSepArg.listIterator();
                            while (iterator.hasNext()) {
                                String next = iterator.next();
                                if (next.equals(nombreTemp)) {
                                    iterator.set("");
                                }
                            }
                        }

                        if (!error) {
                            for (int j = 0; j < sepArg.length; j++) {
                                if (newSepArg.get(j).equals("if")) {
        
                                } else if (newSepArg.get(j).equals("+") || newSepArg.get(j).equals("r") || newSepArg.get(j).equals("*") || newSepArg.get(j).equals("/")) {
                                    //Expresion aritmetica
                                    String expresion = newSepArg.get(j);
        
                                    try {
    
                                        int sum = 0;
                                        int result = 0;
                                        int add = 0;
                                        switch (expresion) {
                                            case "+":
                                            for (int k = 1; k < newSepArg.size(); k++) {
                                                add += 1;
                                                sum += Integer.parseInt(newSepArg.get(add));
                                            }
                                            result = sum;
                                            break;
        
                                            case "r":
                                            add = 1;
                                            sum = Integer.parseInt(parametro);
                                            for (int k = 0; k < newSepArg.size() - 2; k++) {
                                                add += 1;
                                                sum = sum - Integer.parseInt(newSepArg.get(add));
                                            }
                                            result = sum;
                                            break;
        
                                            case "*":
                                            add = 1;
                                            sum = Integer.parseInt(parametro);
                                            for (int k = 0; k < newSepArg.size() - 2; k++) {
                                                add += 1;
                                                sum = sum * Integer.parseInt(newSepArg.get(add));
                                            }
                                            result = sum;
                                            break;
        
                                            case "/":
                                            add = 1;
                                            sum = Integer.parseInt(parametro);
                                            for (int k = 0; k < newSepArg.size() - 2; k++) {
                                                add += 1;
                                                sum = sum / Integer.parseInt(newSepArg.get(add));
                                            }
                                            result = sum;
                                            break;
                                        }
                                        System.out.println(result);
                                    } catch (NumberFormatException e) {
                                        System.out.println("ERROR " + "el interprete no puede operar strings");
                                    }
                                } //fin de argumento siendo expresion aritmetica
                            }
                        }     
                    } else if (newSepParam.size() == 2) { //Funcion de dos parametros

                    } else {

                    }
                }

            } else {
                //NO EXISTE LA FUNCION
                funciones.add(new Funciones(nombreFuncion, newSepParam, argumento));
            }

            //NO EXISTE NINGUNA FUNCION
            if (funciones.isEmpty()) {
                
                funciones.add(new Funciones(nombreFuncion, newSepParam, argumento)); 
                System.out.println("se agrego la primera funcion");
                
            }

                break;

            case "ecuals":
                String nom = comando[1];
                String nom2 = comando[2];
                Variable _var1 = null;
                Variable _var2 = null;
                
                try{

                    for(Variable variable : variables){
                        if(variable.getNombre().equals(nom)){
                            _var1 = variable;
                        }
                    }

                    for(Variable variablee : variables){
                        if(variablee.getNombre().equals(nom2)){
                            _var2 = variablee;
                        }
                    }

                    if(_var1.getValor().equals(_var2.getValor())){
                        vista.print("T");
                    }else {
                        vista.print("nil");
                        
                    }

                } catch(Exception e){
                    vista.prinrErr("[!] Una o ambas variables no existen!");
                    
                }
                break;

            case "eval":
                String eval = lista[1];
                char aa = ' ';
                char ab = ' ';
                int num1 = 0;
                int num2 = 0;
                try {

                    if(eval.charAt(1) == '+'){
                        aa = eval.charAt(3);
                        ab = eval.charAt(5);
                        num1 = Integer.parseInt(String.valueOf(aa));
                        num2 = Integer.parseInt(String.valueOf(ab));
                        System.out.println(num1 + num2);
                    }else if(eval.charAt(1) == 'r'){
                        aa = eval.charAt(3);
                        ab = eval.charAt(5);
                        num1 = Integer.parseInt(String.valueOf(aa));
                        num2 = Integer.parseInt(String.valueOf(ab));
                        System.out.println(num1 - num2);
                    }else if(eval.charAt(1) == '*'){
                        aa = eval.charAt(3);
                        ab = eval.charAt(5);
                        num1 = Integer.parseInt(String.valueOf(aa));
                        num2 = Integer.parseInt(String.valueOf(ab));
                        System.out.println(num1 * num2);
                    }else if(eval.charAt(1) == '/'){
                        aa = eval.charAt(3);
                        ab = eval.charAt(5);
                        num1 = Integer.parseInt(String.valueOf(aa));
                        num2 = Integer.parseInt(String.valueOf(ab));
                        System.out.println(num1 / num2);
                    }else{
                        vista.prinrErr("[!] Comando no reconocido, intente con {+, r, *, /}");
                    }
                    
                } catch (Exception e) {
                    //TODO: handle exception
                    vista.prinrErr("[!] Comando no reconocido, intente con {+, r, *, /}");
                }
                
                break;

            case "cond":
                break;

            case "null":

                String nu = comando[1];
                    Variable varNu = null;

                for(Variable variabless : variables){
                    if(variabless.getValor() != null){
                        varNu = variabless;
                        vista.print("T");
                    }else{
                        vista.print("nil");
                    }
                }
                break;

            case "atom":
                try {

                    String tempNombre = comando[1];
                    for (Variable variable : variables) {
                        if (variable.getNombre().equals(tempNombre)) {
                            if (variable.getValor().split(" ").length > 0) {
                                vista.print("T --");
                                break;
                            } else {
                                vista.print("nil --");
                                break;
                            }
                        }
                    }

                } catch (Exception e) { 
                    orden = lista[i + 1];
                    orden = orden.replace("-", "'(");
                    comando = orden.split(" ");
                    if(comando.length > 0){
                        vista.print("nil");
                    }else{
                        vista.print("T");
                    }
                    
                }

                break;

            case "numberp":

            String val = comando[1];
            Variable vall = null;
            String abc = "";


            for(Variable varrr : variables){
                if(varrr.getNombre().equals(val)){
                    vall = varrr;
                    val = vall.getValor();
                }
            }

            if(vall == null){
                if(isNumber(val)){
                    vista.print("T");
                }else{
                    vista.print("nil");
                }
            }else{
                abc = vall.getValor().trim();

                if(isNumber(abc)){
                    vista.print("T");
                }else{
                    vista.print("nil");
                }
            }
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

