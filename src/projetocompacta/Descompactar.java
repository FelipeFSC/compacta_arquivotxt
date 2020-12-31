package projetocompacta;

public class Descompactar {

    static ListaEncadeada desco = new ListaEncadeada();

    public void descompacta(String palavra) {
        String aux;
        int indice;

        TratamentoArquivo tratar = new TratamentoArquivo();

        if (tratar.verificaInt(palavra)) {

            // Convertendo o numero String para inteiro Int
            indice = Integer.parseInt(palavra);

            /* Usando o indice para retornar a palavra e guardando 
                     * em auxiliar. */
            aux = desco.buscaValor(indice);
            System.out.print(aux);

            // Removendo o indice( palavra ) e a palavra repetida( aux )
            desco.removeOrdenado(palavra);
            desco.removeOrdenado(aux);
            // Inserindo valor no inicio da lista
            desco.insereInicio(aux);

        } else if (tratar.validaEspecial(palavra)) {
            String separados[] = tratar.separarEspecial(palavra);

            for (String tratados : separados) {
                if (!tratados.equals(" ") && !tratados.equals("")) {
                    if (tratar.validaEspecial(tratados)) {
                        System.out.print(tratados);
                    } else {
                        if (desco.busca(tratados)) {

                            indice = Integer.parseInt(tratados);

                            /* Usando o indice para retornar a palavra e guardando 
                                     * em auxiliar. */
                            aux = desco.buscaValor(indice);
                            System.out.print(aux);

                            // Removendo o indice( palavra ) e a palavra repetida( aux )
                            desco.removeOrdenado(tratados);
                            desco.removeOrdenado(aux);
                            // Inserindo valor no inicio da lista
                            desco.insereInicio(aux);
                        } else if (tratar.verificaInt(tratados)) {

                            // Convertendo o numero String para inteiro Int
                            indice = Integer.parseInt(tratados);

                            /* Usando o indice para retornar a palavra e guardando 
                                     * em auxiliar. */
                            aux = desco.buscaValor(indice);
                            System.out.print(aux);

                            // Removendo o indice( palavra ) e a palavra repetida( aux )
                            desco.removeOrdenado(tratados);
                            desco.removeOrdenado(aux);
                            // Inserindo valor no inicio da lista
                            desco.insereInicio(aux);

                        } else {
                            desco.insereInicio(tratados);
                            System.out.print(tratados);
                        }
                    }
                }
            }

        } else {

            /* Caso o valor não seja um Int significa que não é um indice
                 * E insere diretamente no inicio da lista e escreve 
                 * no arquivo */
            desco.insereInicio(palavra);
            System.out.print(palavra);
        }
    }
}
