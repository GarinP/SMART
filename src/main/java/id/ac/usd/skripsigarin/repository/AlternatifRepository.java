package id.ac.usd.skripsigarin.repository;

import id.ac.usd.skripsigarin.entity.Alternatif;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlternatifRepository extends JpaRepository<Alternatif, Long> {
}
