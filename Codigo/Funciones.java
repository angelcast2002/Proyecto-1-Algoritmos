import java.util.ArrayList;

public class Funciones {
    
    private String argus;
    private ArrayList<String> params = new ArrayList<>();
    private String name;
    /**
     * 	Este constructor si lo utilizo
		@param argus - Param que recibe para que pueda operar correctamente
		@param eje - Operaciones de la funcion
     */
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

}
