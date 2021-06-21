package sample;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement()
public class Mutation {
    private String mutationsNavn;
    private int antalPatienter;

    public Mutation(String navn, int antal) {
        this.mutationsNavn = navn;
        this.antalPatienter = antal;
    }

    @XmlElement(name = "mutationsnavn")
    public String getMutationsNavn() {
        return mutationsNavn;
    }

    public void setMutationsNavn(String mutationsNavn) {
        this.mutationsNavn = mutationsNavn;
    }

    @XmlElement(name = "antal")
    public int getAntalPatienter() {
        return antalPatienter;
    }

    public void setAntalPatienter(int antalPatienter) {
        this.antalPatienter = antalPatienter;
    }
}
