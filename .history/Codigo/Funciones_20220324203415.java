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
import java.util.ArrayList;
import java.util.ListIterator;

/**
 *
 * @author Angel
 */
public class Funciones {
    
    private String argus;
    private ArrayList<String> params = new ArrayList<>();
    private String name;
    /**
     * 	Este constructor si lo utilizo
     */

     //Constructor sin nada
     public Funciones() {
     }

    /**
     *
     * @param name
     * @param params
     * @param argus
     */
    public Funciones(String name, ArrayList<String> params,String argus) { //Sobrecargo mi constructor 
        this.params = params; //Asigno 
        this.argus = argus; //Asigno
        this.name = name;
    }

    /**
     *
     * @return
     */
    public String getName() {
        return this.name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     */
    public String getArgus() {
        return this.argus;
    }

    /**
     *
     * @param argus
     */
    public void setArgus(String argus) {
        this.argus = argus;
    }

    /**
     *
     * @return
     */
    public ArrayList<String> getParams() {
        return this.params;
    }

    /**
     *
     * @param params
     */
    public void setParams(ArrayList<String> params) {
        this.params = params;
    }

    /**
     *
     * @param argumento
     */
    public void recursividad(String argumento) {

        

    }

    /**
     *
     * @param expresion
     * @param newSepArg
     * @param parametro
     * @return
     */
    public int expresionesAritmeticasParam1(String expresion, ArrayList<String> newSepArg, String parametro) {
        int sum = 0;
        int result = 0;
        int add = 0;

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

    /**
     *
     * @param expresion
     * @param newSepArg
     * @param parametro
     * @return
     */
    public int ifAritmeticaParam1(String expresion, ArrayList<String> newSepArg, String parametro) {
        int sum = 0;
        int result = 0;
        int add = 0;
        boolean distOp = true;


        while (distOp) {
            if (!newSepArg.get(0).equals(expresion)) {
                newSepArg.remove(0);
            } else {
                distOp = false;
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

    /**
     *
     * @param expresion
     * @param newSepArg
     * @return
     */
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

    /**
     *
     * @param expresion
     * @param newSepArg
     * @return
     */
    public int ifAritmeticaParam2(String expresion, ArrayList<String> newSepArg) {
        int sum = 0;
        int result = 0;
        int add = 0;
        boolean distOp = true;


        while (distOp) {
            if (!newSepArg.get(0).equals(expresion)) {
                newSepArg.remove(0);
            } else {
                distOp = false;
            }
        }

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
                System.out.println(newSepArg);
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

