package id.ac.usd.skripsigarin.controller;

import id.ac.usd.skripsigarin.repository.KriteriaRepository;
import id.ac.usd.skripsigarin.repository.AlternatifRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DashboardController {

    private AlternatifRepository alternatifRepository;
    private KriteriaRepository kriteriaRepository;

    @Autowired
    public DashboardController(AlternatifRepository alternatifRepository, KriteriaRepository kriteriaRepository) {
        this.alternatifRepository = alternatifRepository;
        this.kriteriaRepository = kriteriaRepository;
    }

    @GetMapping("/")
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("jumlahAltermatif", alternatifRepository.findAll().size());
        modelAndView.addObject("jumlahKriteria", kriteriaRepository.findAll().size());
        return modelAndView;
    }
}
