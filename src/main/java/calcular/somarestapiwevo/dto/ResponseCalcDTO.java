package calcular.somarestapiwevo.dto;

import calcular.somarestapiwevo.models.Status;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

import java.io.Serializable;

@Builder
@Setter
@Getter
@ToString
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonInclude (JsonInclude.Include.NON_NULL)
public class ResponseCalcDTO implements Serializable {

    private Integer numero1;
    private Integer numero2;
    private Status status;
    private Integer resultado;

}
