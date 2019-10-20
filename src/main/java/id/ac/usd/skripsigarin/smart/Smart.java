package id.ac.usd.skripsigarin.smart;

import id.ac.usd.skripsigarin.entity.Alternatif;
import id.ac.usd.skripsigarin.entity.Kriteria;
import id.ac.usd.skripsigarin.repository.AlternatifRepository;
import id.ac.usd.skripsigarin.repository.KriteriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Smart {

    private AlternatifRepository alternatifRepository;

    private KriteriaRepository kriteriaRepository;

    @Autowired
    public Smart(AlternatifRepository alternatifRepository, KriteriaRepository kriteriaRepository) {
        this.alternatifRepository = alternatifRepository;
        this.kriteriaRepository = kriteriaRepository;
    }

    public void calculate() {
        List<Kriteria> kriterias = kriteriaRepository.findAll();
        List<Alternatif> alternatifs = alternatifRepository.findAll();
        double[] w;
        double[] max;
        double[] min;
        double[][] u;
        double wSum = 0.0;
        w = new double[kriterias.size()];
        max = new double[kriterias.size()];
        min = new double[kriterias.size()];
        u = new double[alternatifs.size()][kriterias.size()];

        for (Kriteria kriteria : kriterias) {
            wSum += kriteria.getBobot();
        }
        for (int i = 0; i < kriterias.size(); i++) {
            w[i] = kriterias.get(i).getBobot() / wSum;
        }

        for (int j = 0; j < kriterias.size(); j++) {
            double temp = Double.MIN_VALUE;
            double temp2 = Double.MAX_VALUE;
            for (Alternatif alternatif : alternatifs) {
                double nilai = alternatif.getSamples().get(j).getNilai();
                if (nilai > temp)
                    temp = nilai;
                max[j] = temp;
                if (nilai < temp2)
                    temp2 = nilai;
                min[j] = temp2;
            }
        }

        for (int i = 0; i < alternatifs.size(); i++) {
            for (int j = 0; j < kriterias.size(); j++) {
                u[i][j] = (alternatifs.get(i).getSamples().get(j).getNilai() - min[j]) / (max[j] - min[j]);
                u[i][j] = u[i][j] * w[j];
                System.out.print(u[i][j]+" ");

            }
            System.out.println();
        }
    }
}
