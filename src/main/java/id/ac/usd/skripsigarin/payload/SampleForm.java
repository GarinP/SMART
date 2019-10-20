package id.ac.usd.skripsigarin.payload;


import id.ac.usd.skripsigarin.entity.Sample;

import java.util.List;

public class SampleForm {

    private List<Sample> samples;

    public SampleForm(List<Sample> samples) {
        this.samples = samples;
    }

    public SampleForm() {
    }

    public List<Sample> getSamples() {
        return samples;
    }

    public void setSamples(List<Sample> samples) {
        this.samples = samples;
    }
}
