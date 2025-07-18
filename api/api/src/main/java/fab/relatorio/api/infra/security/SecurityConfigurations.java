package fab.relatorio.api.infra.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfigurations {


    @Autowired
    private SecurityFilter securityFilter;


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // Desativa a proteção contra Cross-Site Request Forgery (CSRF).
                // Isto é comum para APIs stateless onde os clientes não são navegadores.
                .csrf(csrf -> csrf.disable())

                // Configura as regras de autorização para requisições HTTP.
                .authorizeHttpRequests(auth -> auth
                        // Permite todas as requisições POST para o endpoint "/login".
                        // Isto substitui o obsoleto antMatchers().
                        .requestMatchers(HttpMethod.POST, "/login").permitAll()
                        // Exige autenticação para qualquer outra requisição.
                        // Eu também corrigi um erro de digitação do seu código original ("anuRequest" para "anyRequest").
                        .anyRequest().authenticated()
                )
                .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)
                // Configura o gerenciamento de sessão para ser stateless (sem estado).
                // Isso garante que nenhuma sessão seja criada ou usada pelo Spring Security,
                // o que é ideal para APIs REST.
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        // Constrói e retorna a SecurityFilterChain configurada.
        return http.build();
    }
    //csrf() = desabilitarmos proteção contra-ataques do tipo CSRF (Cross-Site Request Forgery)
    //sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) = Desabilita o formulário padrão do String (StatFull) e torna StateLess

    @Bean
    public AuthenticationManager autheticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder (){
        return new BCryptPasswordEncoder();
    }

}

