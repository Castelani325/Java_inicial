package agenda_telefonica_package;

import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;

//Criar um método para deletar o contato 

//Criar método para PESQUISAR o contato pelo nome OU numero de telefone

//Criar método para imprimir a agenda telefônica

public class agenda_telefonica {

    /////////////////// Classe para armazenar os dados do contato telefônico ///////////////////
    static class contato_telefonico {
        
        
        /////////////////// Atributos ///////////////////
        private String nome;
        private String numero;
        private String cpf;
        private static List<contato_telefonico> contatos = new ArrayList<>(); // Lista estática para armazenar todos os contatos
        

        /////////////////// Construtor da classe ///////////////////
        public contato_telefonico(String nome, String numero, String cpf){
            this.nome = nome;
            this.numero = numero;
            this.cpf = cpf;
            contatos.add(this); // Adiciona o contato à lista de contatos
        }

        /////////////////// Métodos ///////////////////

        // Método Setter para o nome
        public void setNovoNome(String nome_novo) {
            java.util.Scanner scanner = new java.util.Scanner(System.in); //abriu o scanner aqui
            System.out.printf("Digite o novo nome do contato: ");
            nome_novo = scanner.nextLine();
            scanner.close(); // fechou o scanner aqui

            if (nome_novo.isEmpty()) {
                System.out.printf("O nome_novo não pode ser vazio.");
            }

            this.nome = nome_novo.toUpperCase();
        }

        public void setNovoNumero(String numero_novo) {
            java.util.Scanner scanner = new java.util.Scanner(System.in);
            System.out.printf("Digite o novo número do contato: ");
            numero_novo = scanner.nextLine();
            scanner.close();

            if (numero_novo.isEmpty()) {
                System.out.printf("O numero_novo não pode ser vazio.");
            }

            // Aplicar REGEX para formatar o número de telefone
            String regex = "(\\d{2})(\\d{5})(\\d{4})";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(numero_novo);
            if (matcher.matches()) {
                numero_novo = String.format("(%s) %s-%s", matcher.group(1), matcher.group(2), matcher.group(3));
            } else {
                System.out.printf("O numero inserido não condiz com o formato padrão (XX) XXXXX-XXXX");
            }

            this.numero = numero_novo;
        }

        public void setNovoCpf(String cpf_novo) {
            java.util.Scanner scanner = new java.util.Scanner(System.in);
            System.out.printf("Digite o novo CPF do contato: ");
            cpf_novo = scanner.nextLine();
            scanner.close();

            if (cpf_novo.isEmpty()) {
                System.out.printf("O cpf_novo não pode ser vazio.");
            }

            // Aplicar REGEX para formatar o cpf_novo
            String regex = "(\\d{3})(\\d{3})(\\d{3})(\\d{2})";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(cpf_novo);
            if (matcher.matches()) {
                cpf_novo = String.format("%s.%s.%s-%s", matcher.group(1), matcher.group(2), matcher.group(3), matcher.group(4));
            } else {
                System.out.printf("O CPF inserido não condiz com o formato padrão XXX.XXX.XXX-XX");
            }

            this.cpf = cpf_novo;
        }

        // Métodos Getter para os atributos
        public String getNome() {
            return nome;
        }

        public String getNumero() {
            return numero;
        }

        public String getCpf() {
            return cpf;
        }
    
        // Método para imprimir todos os contatos
        public static void imprimircontatos() {
            for (int i = 0; i < contatos.size(); i++) {
                System.out.printf(contatos.get(i) + "\n"); 
            }
        }

        // Método para pesquisar contato por nome ou número
        
        
    
    }
}