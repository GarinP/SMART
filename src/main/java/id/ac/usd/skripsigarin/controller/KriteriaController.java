package id.ac.usd.skripsigarin.controller;

import id.ac.usd.skripsigarin.entity.Alternatif;
import id.ac.usd.skripsigarin.entity.Kriteria;
import id.ac.usd.skripsigarin.entity.Sample;
import id.ac.usd.skripsigarin.exception.ResourceNotFoundException;
import id.ac.usd.skripsigarin.repository.KriteriaRepository;
import id.ac.usd.skripsigarin.repository.AlternatifRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/kriteria")
public class KriteriaController {

    private KriteriaRepository kriteriaRepository;
    private AlternatifRepository alternatifRepository;

    @Autowired
    public KriteriaController(KriteriaRepository kriteriaRepository, AlternatifRepository alternatifRepository) {
        this.kriteriaRepository = kriteriaRepository;
        this.alternatifRepository = alternatifRepository;
    }

    @GetMapping
    public ModelAndView getAll(){
        ModelAndView modelAndView = new ModelAndView("kriteria/list");
        modelAndView.addObject("kriterias", kriteriaRepository.findAll(new Sort(Sort.Direction.ASC, "id")));
        return modelAndView;
    }

    @GetMapping("add")
    public ModelAndView add(){
        ModelAndView modelAndView = new ModelAndView("kriteria/add");
        return modelAndView;
    }

    @GetMapping("{id}/edit")
    public ModelAndView edit(@PathVariable(value = "id") Long id){
        ModelAndView modelAndView = new ModelAndView("kriteria/edit");
        Kriteria kriteria = kriteriaRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Kriteria", "id", id));
        modelAndView.addObject("kriteria", kriteria);
        return modelAndView;
    }

    @GetMapping("{id}/delete")
    public ModelAndView delete(@PathVariable(value = "id") Long id){
        kriteriaRepository.deleteById(id);
        return new ModelAndView("redirect:/kriteria");
    }

    @PostMapping("edit")
    public ModelAndView edit(@ModelAttribute("kriteriaForm") Kriteria kriteria){
        kriteriaRepository.save(kriteria);
        return new ModelAndView("redirect:/kriteria");
    }

    @Transactional
    @PostMapping("save")
    public ModelAndView save(@ModelAttribute("kriteriaForm") Kriteria kriteria){
        Kriteria kriteria1 = kriteriaRepository.save(kriteria);

        List<Alternatif> alternatifs = alternatifRepository.findAll();
        for (Alternatif alternatif : alternatifs) {
            alternatif.getSamples().add(new Sample(kriteria1, alternatif, 0.0));
        }
        return new ModelAndView("redirect:/kriteria");
    }

}
