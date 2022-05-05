package calcular.somarestapiwevo.repository;

import calcular.somarestapiwevo.models.Calc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalcRepository extends JpaRepository<Calc, Long> {

}
