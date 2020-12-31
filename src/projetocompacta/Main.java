package projetocompacta;

public class Main {
    public static void main(String[] args) {
        Model m = new Model();
        
        m.model(true); // Compacta
        System.out.println("-----------------");
        m.model(false);// Descompacta
    }
}
