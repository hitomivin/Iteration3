package sample;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

import java.io.File;

public class eksportXML {


    public static void eksportStatistik(String filename, Statistik st) {
        try {
            File file = new File(filename);
            JAXBContext jaxbContext = JAXBContext.newInstance(Statistik.class);

            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(st, file);
            jaxbMarshaller.marshal(st, System.out);
        } catch (JAXBException ex) {
            System.out.println("error exportXML");
            System.out.println(ex.getMessage());
            System.out.println(ex.getCause());
        }
    }

}
