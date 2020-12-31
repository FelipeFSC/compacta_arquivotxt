package projetocompacta;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Model {
    
   /*
    * True - Compactar
    * False - Descompactar
    */
    public void model( boolean valida ){
        
        String linha;
        String palavra = "";
        
        Compactar c = new Compactar();
        Descompactar d = new Descompactar();

        /* Lendo um arquivo existente */
        try {
            Scanner leitor;
            
            if( valida ){
                leitor = new Scanner(new FileInputStream("entrada.txt"));
            } else {
                leitor = new Scanner(new FileInputStream("saida.txt"));
            }
            
            while(leitor.hasNextLine()){
                linha = leitor.nextLine();
                
                // Identificando espaços duplos
                if( linha.length() == 0 ){
                    System.out.println("");
                }
                
                for(int i=0; i < linha.length(); i++) {
                    String letra = linha.charAt(i) + "";
                    
                    // Formando uma palavra
                    if( !letra.equals(" ") ){
                        palavra += linha.charAt(i);
                    }
                    
                    // Identificando palavras
                    if( letra.equals(" ") ){
                        
                        // Verifica se não esta entrando uma palavra vazia
                        if( !palavra.equals("") ){
                            if ( valida ) {
                                c.compacta( palavra );
                            } else {
                                d.descompacta( palavra );
                            }
                        }
                        
                        //System.out.print(text);
                        System.out.print(" ");
                        palavra = "";
                    }
                    
                    // Identificando quebra de linhas
                    if( i+1 == linha.length() ){
                        
                        if ( valida ) {
                            c.compacta( palavra );
                        } else {
                            d.descompacta( palavra );
                        }
                        
                        System.out.print("\n");
                        palavra = "";
                    }
                }
            }
            
        } catch (FileNotFoundException erro) {
            System.out.println("arquivo não encontrado.");
            
        }
    }
}
