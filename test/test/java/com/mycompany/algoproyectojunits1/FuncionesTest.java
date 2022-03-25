/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.mycompany.algoproyectojunits1;

import java.util.ArrayList;
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
public class FuncionesTest {
    
    public FuncionesTest() {
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
     * Test of getName method, of class Funciones.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Funciones instance = new Funciones();
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setName method, of class Funciones.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "";
        Funciones instance = new Funciones();
        instance.setName(name);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getArgus method, of class Funciones.
     */
    @Test
    public void testGetArgus() {
        System.out.println("getArgus");
        Funciones instance = new Funciones();
        String expResult = "";
        String result = instance.getArgus();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setArgus method, of class Funciones.
     */
    @Test
    public void testSetArgus() {
        System.out.println("setArgus");
        String argus = "";
        Funciones instance = new Funciones();
        instance.setArgus(argus);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getParams method, of class Funciones.
     */
    @Test
    public void testGetParams() {
        System.out.println("getParams");
        Funciones instance = new Funciones();
        ArrayList<String> expResult = null;
        ArrayList<String> result = instance.getParams();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setParams method, of class Funciones.
     */
    @Test
    public void testSetParams() {
        System.out.println("setParams");
        ArrayList<String> params = null;
        Funciones instance = new Funciones();
        instance.setParams(params);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of recursividad method, of class Funciones.
     */
    @Test
    public void testRecursividad() {
        System.out.println("recursividad");
        String argumento = "";
        Funciones instance = new Funciones();
        instance.recursividad(argumento);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of expresionesAritmeticasParam1 method, of class Funciones.
     */
    @Test
    public void testExpresionesAritmeticasParam1() {
        System.out.println("expresionesAritmeticasParam1");
        String expresion = "+";
        ArrayList<String> newSepArg = {"+", "5", "5"};
        String parametro = "5";
        Funciones instance = new Funciones();
        int expResult = 10;
        int result = instance.expresionesAritmeticasParam1(expresion, newSepArg, parametro);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ifAritmeticaParam1 method, of class Funciones.
     */
    @Test
    public void testIfAritmeticaParam1() {
        System.out.println("ifAritmeticaParam1");
        String expresion = "";
        ArrayList<String> newSepArg = null;
        String parametro = "";
        Funciones instance = new Funciones();
        int expResult = 0;
        int result = instance.ifAritmeticaParam1(expresion, newSepArg, parametro);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of aritmeticaParam2 method, of class Funciones.
     */
    @Test
    public void testAritmeticaParam2() {
        System.out.println("aritmeticaParam2");
        String expresion = "";
        ArrayList<String> newSepArg = null;
        Funciones instance = new Funciones();
        int expResult = 0;
        int result = instance.aritmeticaParam2(expresion, newSepArg);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ifAritmeticaParam2 method, of class Funciones.
     */
    @Test
    public void testIfAritmeticaParam2() {
        System.out.println("ifAritmeticaParam2");
        String expresion = "";
        ArrayList<String> newSepArg = null;
        Funciones instance = new Funciones();
        int expResult = 0;
        int result = instance.ifAritmeticaParam2(expresion, newSepArg);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
