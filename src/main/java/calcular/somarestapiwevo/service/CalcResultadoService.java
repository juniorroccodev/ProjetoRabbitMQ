package calcular.somarestapiwevo.service;

import calcular.somarestapiwevo.models.CalcResultado;
import calcular.somarestapiwevo.repository.CalcResultadoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class CalcResultadoService {

    @Autowired
    private final CalcResultadoRepository calcResultadoRepository;

    @Transactional (rollbackFor = Exception.class)
    public CalcResultado salvar(CalcResultado resultado) {
        return calcResultadoRepository.save(resultado);
    }

    @Transactional (readOnly = true)
    public CalcResultado findById(Long id) {
        return calcResultadoRepository.findById(id).get();
    }

    @Transactional (readOnly = true)
    public CalcResultado findByResultado(Integer resultado) {
        return calcResultadoRepository.getResultado(resultado);
    }


}