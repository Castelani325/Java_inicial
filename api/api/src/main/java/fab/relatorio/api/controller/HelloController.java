package fab.relatorio.api.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping
    public String olaMundo(){
        return "Hello World, Spring!";
    }


    //Para rodar o arquivo .jar que faz o servido backend funcionar, use o comando abaixo.
    //& "C:\Users\Otavi\.jdks\openjdk-24.0.1\bin\java.exe" "-Dspring.profiles.active=prod" "-DDATASOURCE_URL=jdbc:mysql://localhost/Alura_api" "-DDATASOURCE_USERNAME=root" "-DDATASOURCE_PASSWORD=root" -jar "D:\OneDrive\Área de Trabalho\Java_curso\api\api\target\api-0.0.1-SNAPSHOT.jar"


    //Use a URl abaixo para acessar a documentacao
    //http://localhost:8080/swagger-ui/index.html#/
}
