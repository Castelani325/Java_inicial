import java.util.ArrayList;

public class Main { //sintaxe básica do JAVA
    public static void main(String[] args) {

        //Variaveis em JAVA

        //numeros
        byte exemplo_byte = 126; //apenas 8bit na memória (-128 a 127)
        short exemplo_short = 16000; // 16 bits (-32768 a 32767)
        int minha_idade = 20; // 32 bit (tipo inteiro -2^32 a 2^32)
        long exemplo_long = 160000000L; // 64 Bits
        float exemplo_float = 2.77F; //tipo flutuante, com virgula) -> pouca precisão
        double exemplo_double = 2.54687546876546876546854654; //float com precisão maior (64bits)

        //textos
        String meu_Nome = "Otavio"; //tipo texto (não é primitiva, é uma classe)
        char exemplo_char = 'a'; // Cabe apenas um caracater -> usa-se aspas simples
        var variavel_teste = "teste"; //tipo variavel(infere de acordo com o conteúdo atribuido) -> aspas duplas

        boolean bolaeno_teste = false; // tipo boaleado (true ou false)


        //Condicionais

        if (bolaeno_teste){
            System.out.println ("Verdadeiro");
        }
        //else if (){}

        else {
            System.out.println ("Falso");
        }

        //Vetores (lists)
        int[] exemplo_lista = {1,2,3,4,5};
        int tamanho_vetor = exemplo_lista.length; //retorna o tamanho de uma lista de int
        int tamanho_palavra = meu_Nome.length(); //retorna o tamanho de uma palavra quando se trata de uma String
        int[] nova_lista = new int[6]; // essa sintaxe declara uma nova lista sem atribuir valores, apenas dizendo qual será o tamanho dele

        ArrayList<String> nomes = new ArrayList<>(); // Cria um array dinamico, que pode adicionar e remover
        nomes.add("Otávio"); // Adiciona ao array dinamico
        nomes.add("Leticia");
        nomes.add("Luana");
        nomes.add("Marcelo");
        nomes.add("Dani");

        nomes.remove(nomes.get(0)); // Remove do array dinamico
        nomes.remove(1); // Remove do array dinamico

        System.out.println(nomes);


        //Loops
        //for

        for (int i = 0; i<nomes.size(); i++){ //inicio + final + incremento por repetição
            System.out.println(String.format("olá %s", nomes.get(i))); //insere uma variável dentro de um printl
            System.out.println(i); //insere uma variável dentro de um printl
        };
        //%s → string
        // %d → inteiro
        //%f → número decimal (float/double)

        for (String nome : nomes){ //esse tipo de for faz a verredura direta de arrays
            System.out.println(nomes);
        }

        //WHILE
        int i = 0;
        while(i<10) { //while funciona como uma condição de parada
            i++;
            System.out.println(i);
        }


        //Casting => Conversão de um tipo de dado para outro

        double resultado = 0.0;
        int resultadoInt = (int)resultado;

        int meuInt = 10;
        double meuDouble = (int) meuInt;

        String meuString = "10";
        int meuInt2 = Integer.parseInt(meuString); // de String para int

        String minhaString = String.valueOf(meuInt2); // de int para string

        System.out.println(resultadoInt);
        System.out.println(meuDouble);
        System.out.println(meuInt2);
        System.out.println(minhaString);


        //Testando commit via terminal

    }
}


