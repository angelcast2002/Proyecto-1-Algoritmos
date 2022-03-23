import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Interprete {

    /**
     * Interprete
     */
    public class Interprete {

        // Utilidades
        Scanner sc = new Scanner(System.in);
        Vista vista = new Vista();
        String instruccion = "";

        // Variables
        List<Variable> variables = new ArrayList<>();

        /*
        * Pide las intrucciones por consola y las ejecuta
        */
        public void ejecutar() {

            Boolean estado = true;
            while (estado) {

                if (instruccion.length() > 0) {
                    System.out.print(">> ... ");
                } else {
                    System.out.print(">> ");
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
                            String result = evaluar(instruccion);
                        } else {
                            vista.prinrErr("[!] Las intrucciones deben iniciar con '(' y finalizar con ')'");
                        }

                        instruccion = "";
                    }
                }

            }

        }

        

    
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
                    vista.print(" :: COMANDOS DISPONIBLES :: \n");

                    vista.print("VARIABLES: ");
                    vista.print(" - exit: Finaliza el programa");
                    vista.print("       (exit)");

                    vista.print(" - help: Muestra los comandos disponibles");
                    vista.print("       (help)");

                    vista.print(" - write: imprime un mensaje en consola");
                    vista.print("       (write <expr>)");

                    vista.print(" - setq: Crea o modifica una variable");
                    vista.print("       (setq <nombre> <valor>)\n");

                    vista.print("LISTAS: ");
                    vista.print(" - first: Devuelve el primer elemento de una lista");
                    vista.print("       (first <lista>)");

                    vista.print(" - second, thirtd, nth: Devuelve n elemento de una lista");
                    vista.print("       (second <lista>) >> segundo elemento");
                    vista.print("       (thirtd <lista>) >> tercer elemento");
                    vista.print("       (nth n <lista>) >> n elemento");

                    vista.print(" - cons: Agrega un elemento al principio de una lista");
                    vista.print("       (cons <expr> <lista>)");

                    vista.print(" - append: Devuelve la union de dos listas");
                    vista.print("       (append <lista1> <lista2>)");

                    vista.print(" - list: Construye una lista con los elementos que recibe");
                    vista.print("       (list <expr1> <expr2> ... <exprN>)");

                    vista.print(" - last: Devuelve el ultimo elemento de una lista");
                    vista.print("       (last <lista>)\n");

                    vista.print("FUNCIONES: ");
                    vista.print(" - defun: Define una funcion");
                    vista.print("       (defun <nombre> (<parametros>) (<logica>))\n");

                    vista.print("CONDICIONALES: ");
                    vista.print(" - ecuals: Devuleve T o nil si dos expresiones son iguales");
                    vista.print("       (ecuals <expr1> <expr2>)");

                    vista.print(" - eval:  Devuleve el valor de 'expr' (operacion)");
                    vista.print("       (eval <expr>)");

                    vista.print(" - cond: evalua todas sus condiciones y devulve la primera que encuentre T");
                    vista.print("       (cond (<expr> <mensaje>))\n");

                    vista.print("PREDICADOS: ");
                    vista.print(" - null: Devuelve T si es null (nill) y nil si no");
                    vista.print("       (null <expr>)");

                    vista.print(" - atom: Devuelve T si es un atomo y nil si no");
                    vista.print("       (atom <expr>)");

                    vista.print(" - numberp: Devuelve T si es un numero y nil si no");
                    vista.print("       (numberp <expr>)\n");

                    break;

                case "write":
                    break;

                case "setq":
                    break;

                case "first":
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
        }
    }
}
