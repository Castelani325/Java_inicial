package Java_curso;

//Semelhante à 'interface', mas seus métodos podem ter conteúdo, mas não pode ser instanciado

public abstract class SerVivo {

    protected int idade;

    public SerVivo(int idade){ //isso é um construtor: serve para dizer como uma nova instancia dessa classe deve ser chamada/feita
        this.idade = idade;
    }
    public abstract void respirar();

    public void dormir(){
        System.out.println("mimindo...");
    }


}
