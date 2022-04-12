package calcular.somarestapiwevo.service;

import calcular.somarestapiwevo.models.Calc;
import calcular.somarestapiwevo.repository.CalcRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class CalcService {

    @Autowired
    private final CalcRepository calcRepository;

    @Transactional (readOnly = true)
    public Calc findById(Long id) {
        return calcRepository.findById(id).get();
    }

    @Transactional (readOnly = true)
    public List<Calc> findAll() {
        return calcRepository.findAll();
    }

    @Transactional (rollbackFor = Exception.class)
    public Calc salvar(Calc calc) {
        return calcRepository.save(calc);
    }
    @Transactional (readOnly = true)
    public void delete(Long id){
        Calc calc = findById(id);
        calcRepository.delete(calc);
    }

}