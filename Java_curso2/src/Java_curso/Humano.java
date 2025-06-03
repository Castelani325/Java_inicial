package Java_curso;

public class Humano extends SerVivo {
    String nome;

    public Humano(int idade, String nomenoconstrutor) { //isso é um construtor: serve para dizer como uma nova instancia dessa classe deve ser chamada/feita
        super(idade); // Isso serve para chamar um atributo que está na classe mãe
        this.nome = nomenoconstrutor;

    }

    @Override
    public void respirar() {
        System.out.println(this.idade);
        System.out.println("inalando gases da atmosfera...");
        }
    }

