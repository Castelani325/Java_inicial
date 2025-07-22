package fab.relatorio.api.Domain.Consulta;


import fab.relatorio.api.Domain.medico.Medico;
import fab.relatorio.api.Domain.paciente.Paciente;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Table (name = "consulta")
@Entity (name = "consulta")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode (of ="id")
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "medico_id")
    private Medico medico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    private LocalDateTime data;
}
