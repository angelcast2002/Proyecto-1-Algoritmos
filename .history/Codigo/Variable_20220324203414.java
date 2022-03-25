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
public class Variable {

    private String valor;
    private String nombre;

    /**
     *
     * @param nombre
     * @param valor
     */
    public Variable(String nombre, String valor) {
        this.nombre = nombre;
        this.valor = valor;
    }

    /**
     *
     * @return
     */
    public String getValor() {
        return this.valor;
    }

    /**
     *
     * @param valor
     */
    public void setValor(String valor) {
        this.valor = valor;
    }

    /**
     *
     * @return
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     *
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}

