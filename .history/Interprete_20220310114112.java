import java.util.HashMap;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Interprete {

    private HashMap<String, Integer> myVars;

	public Interprete() {
		myVars = new HashMap<String, Integer>();
	}

    public IOperationResult Operate(String expresion) {
		int state = Scanner.State(expresion);
		
		switch(state) {
		case 1:{
			return OperacionSuma(expresion);
		}
		
		case 2:{
			return null;
			// addOperation(expresion);
		}
		
		default:{
			
			//Using anonymous Inner class
			IOperationResult errorResult = new IOperationResult() {

				
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
   
    private IOperationResult OperacionSuma(String expresion) {
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
}
