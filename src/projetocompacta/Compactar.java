package projetocompacta;

public class Compactar {
    
    static ListaEncadeada texto = new ListaEncadeada();
    
    public void compacta( String palavra ){
        String aux;
        
        TratamentoArquivo tratar = new TratamentoArquivo();
        
        if( texto.busca( palavra ) ){
            
            // Indice da palavra
            System.out.print( texto.buscaIndice(palavra) );
            
            // Mover a palavra para o inicio da lista
            aux = palavra;
            texto.removeOrdenado( palavra );
            texto.insereInicio( aux );
                    
        } else if( tratar.validaEspecial(palavra) ){
            String separados[] = tratar.separarEspecial( palavra );
                    
            for( String tratados: separados ){
                if( !tratados.equals(" ") && !tratados.equals("") ){
                    if( tratar.validaEspecial(tratados) ){
                        System.out.print(tratados);

                    }else{
                        if( texto.busca( tratados ) ){
                            System.out.print( texto.buscaIndice(tratados) );
                            // Lista Mover atualizada
                            
                            aux = tratados;
                            texto.removeOrdenado( tratados );
                            texto.insereInicio( aux );
                        } else {
                            System.out.print(tratados);
                            texto.insereInicio( tratados );
                                    
                        }
                    }
                }
            }
        } else {
            System.out.print(palavra);
            
            texto.insereInicio( palavra );     
        }
    }
}
