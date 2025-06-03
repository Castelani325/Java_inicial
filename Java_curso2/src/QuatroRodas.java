
//Modificadores de acesso

//default (quando não declarado o modificador de acesso) : todos que estiverem no mesmo pacote terão acesso
//public : acessivel de qualquer pacote -> nao pode ter duas classes publicas dentro de um mesmo arquivo java
//private : acessivel apenas dentro do mesma classe
//protected : acessivel apenas dentro do mesmo arquivo


public class QuatroRodas {

    String modelo;

    public static void main(String[] arg) {
        System.out.println("teste");

    }

    public QuatroRodas(String modelo) {
        this.modelo = modelo;

    }

    public String acelerar() {
        System.out.println("Acelerando");
        return "oi";

    }


    //Polimorfismo : É a capacidade de uma mesma classe nos permitir atribuir diferentes resultados em um mesmo metodo, desde que em instancias diferentes.




}
