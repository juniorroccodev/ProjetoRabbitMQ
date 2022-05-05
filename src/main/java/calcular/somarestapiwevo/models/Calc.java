package calcular.somarestapiwevo.models;

import calcular.somarestapiwevo.dto.RequestCalcDTO;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@SequenceGenerator(name = "seq_calc", sequenceName = "seq_calc", allocationSize = 1, initialValue = 1)
@Setter
@Getter
@Builder
@ToString
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Calc implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_calc")
    private Long id;

    @NotNull (message = "Campo numero 1 é obrigatório")
    private Integer numero1;

    @NotNull (message = "Campo numero 2 é obrigatório")
    private Integer numero2;

    private Status status;

    // COnstrutor para ser usado na conversão DTO
    public Calc (Integer numero1, Integer numero2) {
        this.numero1 = numero1;
        this.numero2 = numero2;
    }

    // Converte entidade em DTO
    public RequestCalcDTO toDTO() {

        return new RequestCalcDTO(this.numero1, this.numero2);
    }
}
