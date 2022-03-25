/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4Suite.java to edit this template
 */
package com.mycompany.algoproyectojunits1;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author Angel
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({com.mycompany.algoproyectojunits1.FuncionesTest.class, com.mycompany.algoproyectojunits1.VistaTest.class, com.mycompany.algoproyectojunits1.VariableTest.class, com.mycompany.algoproyectojunits1.InterpreteTest.class, com.mycompany.algoproyectojunits1.MainTest.class})
public class Algoproyectojunits1Suite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}
