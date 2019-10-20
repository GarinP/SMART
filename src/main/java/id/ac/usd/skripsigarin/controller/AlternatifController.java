package id.ac.usd.skripsigarin.controller;

import id.ac.usd.skripsigarin.entity.Alternatif;
import id.ac.usd.skripsigarin.entity.Kriteria;
import id.ac.usd.skripsigarin.entity.Sample;
import id.ac.usd.skripsigarin.exception.ResourceNotFoundException;
import id.ac.usd.skripsigarin.payload.SampleForm;
import id.ac.usd.skripsigarin.repository.KriteriaRepository;
import id.ac.usd.skripsigarin.repository.AlternatifRepository;
import id.ac.usd.skripsigarin.repository.SampleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/alternatif")
public class AlternatifController {

    private AlternatifRepository alternatifRepository;
    private KriteriaRepository kriteriaRepository;
    private SampleRepository sampleRepository;

    @Autowired
    public AlternatifController(AlternatifRepository alternatifRepository, KriteriaRepository kriteriaRepository, SampleRepository sampleRepository) {
        this.alternatifRepository = alternatifRepository;
        this.kriteriaRepository = kriteriaRepository;
        this.sampleRepository = sampleRepository;
    }

    @GetMapping
    public ModelAndView getAll(){
        ModelAndView modelAndView = new ModelAndView("alternatif/list");
        modelAndView.addObject("alternatifs", alternatifRepository.findAll());
        return modelAndView;
    }

    @GetMapping("add")
    public ModelAndView add(){
        ModelAndView modelAndView = new ModelAndView("alternatif/add");
        return modelAndView;
    }

    @GetMapping("{id}/edit")
    public ModelAndView edit(@PathVariable(value = "id") Long id){
        ModelAndView modelAndView = new ModelAndView("alternatif/edit");
        Alternatif alternatif = alternatifRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Alternatif", "id", id));
        modelAndView.addObject("alternatif", alternatif);
        return modelAndView;
    }

    @GetMapping("{id}/delete")
    public ModelAndView delete(@PathVariable(value = "id") Long id){
        alternatifRepository.deleteById(id);
        return new ModelAndView("redirect:/alternatif");
    }

    @Transactional
    @PostMapping("save")
    public ModelAndView save(@ModelAttribute Alternatif alternatif){

        Alternatif mhs = alternatifRepository.save(alternatif);

        List<Kriteria> kriterias = kriteriaRepository.findAll();
        for (Kriteria kriteria : kriterias) {
            sampleRepository.save(new Sample(kriteria, mhs, 0.0));
        }

        return new ModelAndView("redirect:/alternatif");
    }

    @PostMapping("edit")
    public ModelAndView edit(@ModelAttribute Alternatif alternatif){
        alternatifRepository.save(alternatif);
        return new ModelAndView("redirect:/alternatif");
    }

    @GetMapping("nilai/{id}")
    public ModelAndView listNilai(@PathVariable(value = "id") Long id){
        ModelAndView modelAndView = new ModelAndView("nilai/list");
        Alternatif alternatif = alternatifRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Alternatif", "id", id));
        modelAndView.addObject("alternatif", alternatif);
        return modelAndView;
    }

    @GetMapping("nilai/{id}/edit")
    public ModelAndView editNilai(@PathVariable(value = "id") Long id){
        ModelAndView modelAndView = new ModelAndView("nilai/edit");
        modelAndView.addObject("samples", sampleRepository.findSampleByAlternatifIdOrderByKriteriaId(id));
        return modelAndView;
    }

    @PostMapping("nilai/save")
    public ModelAndView saveNilai(@ModelAttribute SampleForm sampleForm){
        sampleRepository.saveAll(sampleForm.getSamples());
        ModelAndView modelAndView = new ModelAndView("redirect:/alternatif");
        modelAndView.addObject("swal", true);
        return modelAndView;
    }
}
