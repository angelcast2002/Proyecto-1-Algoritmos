/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto1;
import java.util.HashMap;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 *
 * @author Angel
 */


public class Interprete {

    private HashMap<String, Integer> myVars;

	public Interprete() {
            myVars = new HashMap<String, Integer>();
	}

    public ResultadoOperacion Operate(String expresion) {
        int state = Scanner.State(expresion);

        switch(state) {
        case 1:{
            return OperacionSuma(expresion);
        }

        case 2:{
            return OperacionResta(expresion);
        }

        default:{

            //Using anonymous Inner class
            ResultadoOperacion errorResult = new ResultadoOperacion() {


            @Override
            public void performOperation() {
                System.out.println("ERROR: Invalid expression");

            }

            @Override
            public void addResults(String key, String result) {
                // TODO Auto-generated method stub
            }

            };
            return errorResult;
        }

        }
		
    }
   
    private ResultadoOperacion OperacionSuma(String expresion) {
       Pattern pattern = Pattern.compile("([a-z]+|[0-9]+)", Pattern.CASE_INSENSITIVE); //
       Matcher matcher = pattern.matcher(expresion);
       Integer total = 0;
       
       while (matcher.find()) {
           total += Integer.parseInt(matcher.group().trim());
       }
       
       OperacionAritmetica resultado = new OperacionAritmetica();
       resultado.addResults(" suma ", "" + total);
       return resultado;
   }


    private ResultadoOperacion OperacionResta(String expresion) {
        Pattern pattern = Pattern.compile("([a-z]+|[0-9]+)", Pattern.CASE_INSENSITIVE); //
        Matcher matcher = pattern.matcher(expresion);
        Integer total = 0;
        Integer num1 = 0;
        Integer num2 = 0;
        matcher.find();
        num1 = Integer.parseInt(matcher.group().trim());
        num2 = Integer.parseInt(matcher.group().trim());

        total = num1 - num2;
        
        OperacionAritmetica resultado = new OperacionAritmetica();
        resultado.addResults(" resta ", "" + total);
        return resultado;
    }
}
