package calcular.somarestapiwevo;

import calcular.somarestapiwevo.models.Calc;
import calcular.somarestapiwevo.models.CalcResultado;
import calcular.somarestapiwevo.models.Status;
import calcular.somarestapiwevo.service.CalcResultadoService;
import calcular.somarestapiwevo.service.CalcService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

@SpringBootTest
public class UnitaryTest {

    @Autowired
    private CalcService calcService;

    @Autowired
    private CalcResultadoService calcResultadoService;

    @Test
    public void testaGravacao(){
        var calculo = Calc.builder()
                .numero1(7)
                .numero2(7)
                .status(Status.PENDENTE)
                .build();
        System.out.println(calculo.toString());
        //calcService.save(calculo);


        var resultado = CalcResultado.builder()
                .calcs(Arrays.asList(calculo))
                .resultado(calculo.getNumero1() + calculo.getNumero2())
                .build();
        //calcResultadoService.save(resultado);
    }

    @Test
    public void getResultado(){
        CalcResultado resultado = calcResultadoService.findByResultado(4);
        System.out.println(resultado.getCalcs());
    }


}
