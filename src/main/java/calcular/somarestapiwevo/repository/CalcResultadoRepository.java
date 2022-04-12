package calcular.somarestapiwevo.repository;

import calcular.somarestapiwevo.models.CalcResultado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CalcResultadoRepository extends JpaRepository<CalcResultado, Long> {

    @Query("select r from CalcResultado r where r.resultado = ?1")
    public CalcResultado getResultado(Integer resultado);
}
