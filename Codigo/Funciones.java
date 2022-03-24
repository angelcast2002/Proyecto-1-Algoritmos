import java.util.ArrayList;
import java.util.ListIterator;

public class Funciones {
    
    private String argus;
    private ArrayList<String> params = new ArrayList<>();
    private String name;
    /**
     * 	Este constructor si lo utilizo
		@param argus - Param que recibe para que pueda operar correctamente
		@param eje - Operaciones de la funcion
     */

     //Constructor sin nada
     public Funciones() {
     }

    public Funciones(String name, ArrayList<String> params,String argus) { //Sobrecargo mi constructor 
        this.params = params; //Asigno 
        this.argus = argus; //Asigno
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArgus() {
        return this.argus;
    }

    public void setArgus(String argus) {
        this.argus = argus;
    }

    public ArrayList<String> getParams() {
        return this.params;
    }

    public void setParams(ArrayList<String> params) {
        this.params = params;
    }

    public void recursividad(String argumento) {

        

    }

    public int expresionesAritmeticasParam1(String expresion, ArrayList<String> newSepArg, String parametro) {
        int sum = 0;
        int result = 0;
        int add = 0;

        for (int i = 0; i < newSepArg.size(); i++) {
            if (newSepArg.get(i) != "+" || newSepArg.get(i) != "-" || newSepArg.get(i) != "*" || newSepArg.get(i) != "/" ) {
                newSepArg.remove(i);
            } 
        }

        try {
                                                    
            switch (expresion) {
                case "+":
                for (int l = 1; l < newSepArg.size(); l++) {
                    add += 1;
                    sum += Integer.parseInt(newSepArg.get(add));
                }
                result = sum;
                break;

                case "r":
                add = 1;
                sum = Integer.parseInt(parametro);
                for (int l = 0; l < newSepArg.size() - 2; l++) {
                    add += 1;
                    sum = sum - Integer.parseInt(newSepArg.get(add));
                }
                result = sum;
                break;

                case "*":
                add = 1;
                sum = Integer.parseInt(parametro);
                for (int l = 0; l < newSepArg.size() - 2; l++) {
                    add += 1;
                    sum = sum * Integer.parseInt(newSepArg.get(add));
                }
                result = sum;
                break;

                case "/":
                add = 1;
                sum = Integer.parseInt(parametro);
                for (int l = 0; l < newSepArg.size() - 2; l++) {
                    add += 1;
                    sum = sum / Integer.parseInt(newSepArg.get(add));
                }
                result = sum;
                break;
            }
        } catch (NumberFormatException e) {
            System.out.println("ERROR " + "el interprete no puede operar strings");
        }

        return result;
        
    }

    public int aritmeticaParam2(String expresion, ArrayList<String> newSepArg) {
        int sum = 0;
        int result = 0;
        int add = 0;

        try {
    
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
                sum = Integer.parseInt(newSepArg.get(1));
                for (int k = 0; k < newSepArg.size() - 2; k++) {
                    add += 1;
                    sum = sum - Integer.parseInt(newSepArg.get(add));
                }
                result = sum;
                break;

                case "*":
                add = 1;
                sum = Integer.parseInt(newSepArg.get(1));
                for (int k = 0; k < newSepArg.size() - 2; k++) {
                    add += 1;
                    sum = sum * Integer.parseInt(newSepArg.get(add));
                }
                result = sum;
                break;

                case "/":
                add = 1;
                sum = Integer.parseInt(newSepArg.get(1));
                for (int k = 0; k < newSepArg.size() - 2; k++) {
                    add += 1;
                    sum = sum / Integer.parseInt(newSepArg.get(add));
                }
                result = sum;
                break;
            }
        } catch (NumberFormatException e) {
            System.out.println("ERROR " + "el interprete no puede operar strings");
        }

        return result;

    }

}
