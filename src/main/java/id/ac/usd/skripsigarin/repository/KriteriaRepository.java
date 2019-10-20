package id.ac.usd.skripsigarin.repository;

import id.ac.usd.skripsigarin.entity.Kriteria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KriteriaRepository extends JpaRepository<Kriteria, Long> {

}
