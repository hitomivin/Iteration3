package sample;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.annotation.*;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;

@XmlRootElement(name = "statistik")
public class Statistik {

    private String postnr;
    private LocalDate startDag;
    private LocalDate slutDag;
    private int antalSmittede;
    private int antalDødsfald;
    private int antalIndlagt;
    private int antalRespirator;
    private float smittetryk;
    private ArrayList<Mutation> mutations;

    public Statistik(String postnr, LocalDate start, LocalDate slut) {
        this.postnr = postnr;
        this.startDag = start;
        this.slutDag = slut;
        this.antalSmittede = 0;
        this.mutations = new ArrayList<Mutation>();
    }

    public void addMutations(Mutation mutation) {
        this.mutations.add(mutation);
        this.antalSmittede += mutation.getAntalPatienter();
    }

    public void addMutations(ArrayList<Mutation> mutations) {
        for (Mutation m : mutations) {
            this.mutations.add(m);
            this.antalSmittede += m.getAntalPatienter();
        }
    }

    public String printStatistik() {
        String strMutation = """
            | %-14s | %8s |
            +----------------|----------+
            """;

        String summary;
        summary = "PostNr: " + this.postnr + "\n";
        summary += "Tidsperiode: " + this.startDag.toString() + " - " + this.slutDag.toString() + "\n\n";

        summary += "Antal af positive patienter: " + this.antalSmittede + "\n";

        if (this.mutations.size() > 0) {
            summary += "+----------------|----------+\n";
            summary += "| MutationsNavn  | Antal    |\n";
            summary += "+================|==========+\n";

            for (Mutation m : this.mutations) {
                summary += String.format(strMutation, m.getMutationsNavn(), m.getAntalPatienter());
            }
        }

        return summary;
    }



    @XmlElement(name = "postnr")
    public String getPostnr() {
        return postnr;
    }

    public void setPostnr(String postnr) {
        this.postnr = postnr;
    }

    @XmlElement(name = "startdag")
    public LocalDate getStartDag() {
        return startDag;
    }

    public void setStartDag(LocalDate startDag) {
        this.startDag = startDag;
    }

    @XmlElement(name = "slutdag")
    public LocalDate getSlutDag() {
        return slutDag;
    }

    public void setSlutDag(LocalDate slutDag) {
        this.slutDag = slutDag;
    }

    @XmlElement(name = "antal smittede")
    public int getAntalSmittede() {
        return antalSmittede;
    }

    public void setAntalSmittede(int antalSmittede) {
        this.antalSmittede = antalSmittede;
    }

    public int getAntalDødsfald() {
        return antalDødsfald;
    }

    public void setAntalDødsfald(int antalDødsfald) {
        this.antalDødsfald = antalDødsfald;
    }

    public int getAntalIndlagt() {
        return antalIndlagt;
    }

    public void setAntalIndlagt(int antalIndlagt) {
        this.antalIndlagt = antalIndlagt;
    }

    public int getAntalRespirator() {
        return antalRespirator;
    }

    public void setAntalRespirator(int antalRespirator) {
        this.antalRespirator = antalRespirator;
    }

    public float getSmittetryk() {
        return smittetryk;
    }

    public void setSmittetryk(float smittetryk) {
        this.smittetryk = smittetryk;
    }

    //@XmlElementWrapper(name = "mutations")
    //@XmlElement(name = "mutation")
    public ArrayList<Mutation> getMutations() {
        return mutations;
    }

    public void setMutations(ArrayList<Mutation> mutations) {
        this.mutations = mutations;
    }

}
