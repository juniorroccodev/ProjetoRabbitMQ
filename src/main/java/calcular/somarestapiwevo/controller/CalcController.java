package calcular.somarestapiwevo.controller;


import calcular.somarestapiwevo.dto.RequestCalcDTO;
import calcular.somarestapiwevo.dto.ResponseCalcDTO;
import calcular.somarestapiwevo.models.Calc;
import calcular.somarestapiwevo.models.Status;
import calcular.somarestapiwevo.service.CalcResultadoService;
import calcular.somarestapiwevo.service.CalcService;
import calcular.somarestapiwevo.rabbitmq.Producer;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RestController
@RequestMapping(value = "/resultados")
@CrossOrigin(origins = "*")
public class CalcController {

    private final CalcService calcService;
    private final CalcResultadoService calcResultadoService;
    private final Producer producer;


    @GetMapping (value = "/{id}")
    public ResponseEntity<Calc> findById(@PathVariable (value = "id") Long id) {
        Calc calc = calcService.findById(id);
        return ResponseEntity.ok().body(calc);
    }

    @GetMapping(value = "/")
    public ResponseEntity<List<ResponseCalcDTO>> listarTodos(){
        List<Calc> calculos = calcService.findAll();
        List<ResponseCalcDTO> listCalcDTO = new ArrayList<ResponseCalcDTO>();
        calculos.forEach(c -> {
            listCalcDTO.add(ResponseCalcDTO.builder()
                    .numero1(c.getNumero1())
                    .numero2(c.getNumero2())
                    .status(c.getStatus())
                    .build());
        });
        return ResponseEntity.ok(listCalcDTO);
    }

    @PostMapping (consumes = "application/json", produces = "application/json")
    public ResponseEntity<Calc> salvar(@RequestBody RequestCalcDTO requestCalcDto){
        Calc calc = requestCalcDto.toCalcClass();
        calc.setStatus(Status.PENDENTE);
        calcService.salvar(calc);
        producer.enviar(calc);
        return ResponseEntity.ok(calc);
    }

    @DeleteMapping (value = "/{id}", produces = "application/json")
    public ResponseEntity<Void> delete(@PathVariable  Long id) {
        calcService.delete(id);
        return ResponseEntity.noContent().build();
        }

}