package id.ac.usd.skripsigarin.entity;

import javax.persistence.*;

@Entity
public class Sample {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn
    private Kriteria kriteria;

    @ManyToOne
    @JoinColumn
    private Alternatif alternatif;

    private Double nilai;

    public Sample() {
    }

    public Sample(Kriteria kriteria, Alternatif alternatif, Double nilai) {
        this.kriteria = kriteria;
        this.alternatif = alternatif;
        this.nilai = nilai;
    }

    public Kriteria getKriteria() {
        return kriteria;
    }

    public void setKriteria(Kriteria kriteria) {
        this.kriteria = kriteria;
    }

    public Alternatif getAlternatif() {
        return alternatif;
    }

    public void setAlternatif(Alternatif alternatif) {
        this.alternatif = alternatif;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getNilai() {
        return nilai;
    }

//    public Integer getNilaiNorm() {
//        double input = nilai/ kriteria.getBobotStandarPsm();
//        if (input >= 0 && input < 0.2){
//            return 1;
//        }else if (input >= 0.2 && input < 0.4){
//            return 2;
//        }else if (input >= 0.4 && input < 0.6){
//            return 3;
//        }else if (input >= 0.6 && input < 0.8){
//            return 4;
//        }else if (input >= 0.8){
//            return 5;
//        }
//        return 0;
//    }
    public void setNilai(Double nilai) {
        this.nilai = nilai;
    }
}
