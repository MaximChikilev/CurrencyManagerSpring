package ua.kiev.prog.demo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;

public interface CurrencyUnitRepository extends CrudRepository<CurrencyUnit, Integer> {
    @Query("SELECT AVG(p.rate) FROM CurrencyUnit p")
    Double getAverageRate();
    @Query("SELECT MAX (p.rate) FROM CurrencyUnit p")
    Double getMaxRate();
    @Query("SELECT p FROM CurrencyUnit p WHERE p.exchangedate = :date")
    CurrencyUnit findByDate(@Param("date") Date name);
}
