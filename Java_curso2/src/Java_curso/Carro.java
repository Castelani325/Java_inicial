package Java_curso;

// Interface é tipo uma casca oca que dita como uma classe pode se parecer, herdando seus métodos, mesmo que os métodos também sejam ocos e sem conteúdo.
// É um jeito de reaproveitar uma casca de classe para criar diversas classe parecidas, mas com métodos que executam coisas diferentes
// EX : classe de carros -> Mobi, Sandero, Etios, Uno... Todos são carros, mas carros diferentes

public interface Carro {
    void acelerar();
    void freiar();
    void parar();

}
