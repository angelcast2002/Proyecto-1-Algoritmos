/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto1;

/**
 *
 * @author Angel
 */
public class OperacionAritmetica implements ResultadoOperacion {

    String key;
    String result;

    @Override
    public void performOperation() {
            System.out.println("El resultado de la operacion " + key + " es: " + result);
    }

    @Override
    public void addResults(String key, String result) {
            this.key = key;
            this.result = result;
    }
    
}
