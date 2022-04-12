package calcular.somarestapiwevo.dto;

import calcular.somarestapiwevo.models.Calc;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@Setter
@Getter
@ToString
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class RequestCalcDTO implements Serializable {

    private Integer numero1;
    private Integer numero2;

    public Calc toCalcClass(){

        return new Calc(this.numero1, this.numero2);
    }

}
