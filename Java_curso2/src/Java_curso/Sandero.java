package Java_curso;

//uma classe pode receber o tipo de uma 'interface', como o Carro a seguir


public class Sandero implements Carro {


    @Override
    public void acelerar() {

    }

    @Override
    public void freiar() {

    }

    @Override
    public void parar() {

    }

    //Aqui uma instância de Sandero está recebendo o tipo da interface

    Carro meuCarro = new Sandero();
}
