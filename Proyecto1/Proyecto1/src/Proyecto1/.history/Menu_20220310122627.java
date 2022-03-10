/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Proyecto1;
import java.util.Scanner;

/**
 *
 * @author Angel
 */
public class Menu {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // TODO code application logic here
        Interprete miLispInterpreter = new Interprete();

		Scanner in = new Scanner(System.in);
		
		System.out.println("Bienvenido al interpreter Lisp ingrese una expresion o escriba exit para salir");
		String opt = "";
		do {
			opt = in.nextLine();
			
			if (!opt.equals("exit")) {
				miLispInterpreter.Operate(opt).performOperation();
			}
			
		}while (!opt.equals("exit"));
    }
    
}
