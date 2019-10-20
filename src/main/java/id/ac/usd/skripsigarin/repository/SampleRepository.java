package id.ac.usd.skripsigarin.repository;

import id.ac.usd.skripsigarin.entity.Sample;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SampleRepository extends JpaRepository<Sample, Long> {

    Sample findSampleByKriteriaIdAndAlternatifId(@Param("faktorId") Long faktorId, @Param("mahasiswaId") Long mahasiswaId);

    List<Sample> findSampleByAlternatifIdOrderByKriteriaId(@Param("mahasiswaId") Long faktorId);
}
