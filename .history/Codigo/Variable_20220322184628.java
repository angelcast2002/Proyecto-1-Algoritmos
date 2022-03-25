public class Variable {

    private String valor;
    private String nombre;

    public Variable(String nombre, String valor) {
        this.nombre = nombre;
        this.valor = valor;
    }

    public String getValor() {
        return this.valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
