/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.mycompany.algoproyectojunits1;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Angel
 */
public class InterpreteTest {
    
    public InterpreteTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of ejecutar method, of class Interprete.
     */
    @Test
    public void testWrite() {
        Interprete interprete = new Interprete();
        String ValorEsperado = "hola";
        String evaluar = "(write 'hola)";
        interprete.Evaluar(evaluar);
        assertEquals(evaluar, ValorEsperado);
    }

    /*
     * CONDICIONALES
     */

    @Test
    public void testNumberp() {
        Interprete interprete = new Interprete();
        String ValorEsperado = "T";
        String evaluar = "(numberp 5)";
        interprete.Evaluar(evaluar);
        assertEquals(evaluar, ValorEsperado);
    }

    /*
     * PREDICADOS
     */
    @Test
    public void testEval() {
        Interprete interprete = new Interprete();
        String ValorEsperado = "8";
        String evaluar = "(eval (+ 5 3))";
        interprete.Evaluar(evaluar);
        assertEquals(evaluar, ValorEsperado);
    }

    @Test
    public void testCond() {
        Interprete interprete = new Interprete();
        String ValorEsperado = "T";
        Variable var = new Variables();
        String a = "A";
        String b = "B";
        var.setNombre(a);
        var.setValor(b);
        String evaluar = "(cond == a b)";
        interprete.Evaluar(evaluar);
        assertEquals(evaluar, ValorEsperado);
    }
    
}
