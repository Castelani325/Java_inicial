package agenda_telefonica_package;
//import java.util.regex.Pattern;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import agenda_telefonica_package.agenda_telefonica.contato_telefonico;

//criar um menu para a agenda telefônica

public class Main {
    public static void main(String[] arg) {
        Scanner scanner = new Scanner (System.in);
        
        
        System.out.println("Bem-vindo à Agenda Telefônica!");

        System.out.printf("O que deseja fazer ? \n");
        System.out.printf("1 - Registrar Contato \n");
        System.out.printf("2 - Pesquisar contato pelo nome \n");
        System.out.printf("3 - Imprimir todos os contatos \n");
        System.out.printf("4 - Editar um contato \n");
        System.out.printf("5 - Deletar um contato \n");
        System.out.printf("6 - Sair \n");

       

        
        System.out.printf("Digite a opção desejada: (de 1 a 6) "); 
        int opcao = scanner.nextInt();
        scanner. nextLine(); // Consumir a quebra de linha pendente após nextInt()
        System.out.printf("Você escolheu a opção: %d%n", opcao);
        

        switch (opcao) {
            case 1: // Registrar contato OK
                System.out.println("Registrar Contato");
                                
                System.out.printf("Digite o NOME do contato: ");
                String nome = scanner.nextLine().toUpperCase(); // Convertendo o nome para maiúsculas
                

                
                System.out.printf("Digite o NÚMERO do contato: ");
                String numero = scanner.nextLine();

                String regex = "(\\d{2})(\\d{5})(\\d{4})";
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(numero);
                if (matcher.matches()) {
                    numero = String.format("(%s) %s-%s", matcher.group(1), matcher.group(2), matcher.group(3));
                } else {
                    System.out.printf("O numero inserido não condiz com o formato padrão (XX) XXXXX-XXXX");
                }

                System.out.printf("Digite o CPF do contato: (Apenas números) ");
                String cpf =scanner.nextLine();

                String regex1 = "(\\d{3})(\\d{3})(\\d{3})(\\d{2})";
                Pattern pattern1 = Pattern.compile(regex1);
                Matcher matcher1 = pattern1.matcher(cpf);
                if (matcher1.matches()) {
                    cpf = String.format("%s.%s.%s-%s", matcher1.group(1), matcher1.group(2), matcher1.group(3), matcher1.group(4));
                } else {
                    System.out.printf("O CPF inserido não condiz com o formato padrão XXX.XXX.XXX-XX");
            }


                contato_telefonico contato = new contato_telefonico(nome, numero, cpf);
                System.out.printf("Contato resgistrado com sucesso: \n Nome: %s\n Número : %s\n CPF: %s\n", contato.getNome(), contato.getNumero(), contato.getCpf());
                
                
                break;
        
            case 2: // Pesquisar contato pelo nome
                
                break;
        
            case 3: // Imprimir todos os contatos OK
                System.out.println("Imprimir todos os contatos");
                agenda_telefonica.contato_telefonico.imprimircontatos(); // Chama o método para imprimir todos os contatos
                
                System.out.println("Lista de contatos impressa com sucesso!");
                
                break;
        
            case 4: // Editar um contato
                
                break;
        
            case 5: // Deletar um contato
                
                break;
        
            case 6: // Sair do programa
                System.out.println("Saindo do programa. Até logo!");
                
                break;
        
            default:
                break;
        }

        if (opcao < 6) {
            Main.main(arg); // Chama o método main novamente para reiniciar o menu
        }


        scanner.close(); 



        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        // System.out.printf("Digite um número telefonico:");

        // java.util.Scanner scanner = new java.util.Scanner(System.in);
        // String numero_telefone = scanner.nextLine();

        // System.out.printf("Digite um nome para o numero %s%n", numero_telefone);
        // String nome = scanner.nextLine();

        // System.out.printf("Diga o DDD para o numero %s e nome %s ", numero_telefone.replace(numero_telefone, "CENSURADO"), nome);
        // String ddd = scanner.nextLine();

        // // Aplicar REGEX para formatar o numero de telefone
        // String regex = "(\\d{2})(\\d{5})(\\d{4})";
        // Pattern pattern = Pattern.compile(regex);
        // Matcher matcher = pattern.matcher(numero_telefone);

        // if (matcher.matches()) {
        //     numero_telefone = String.format("(%s) %s-%s", matcher.group(1), matcher.group(2), matcher.group(3));
        // } else {
        //     System.out.printf("Número de telefone inválido. Certifique-se de que o número esteja no formato correto.");
        //     scanner.close();
        //     return;
        // }

        // scanner.close();
        // System.out.printf("O Nome, número e ddd inseridos são : %s, %s e %s", nome, numero_telefone, ddd);
    }
}
