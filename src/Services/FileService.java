package Services;

import Models.Libro;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.*;
import java.util.List;

public class FileService {
    public static void toXML(List<Libro> listaLibros, String ruta) {
        XMLOutputFactory xof = XMLOutputFactory.newInstance();
        try {
            FileWriter fw = new FileWriter(ruta);
            XMLStreamWriter xsw = xof.createXMLStreamWriter(fw);

            xsw.writeStartDocument("UTF-8","1.0");
            xsw.writeStartElement("libros");

            for (Libro l : listaLibros) {
                xsw.writeStartElement("libro");

                xsw.writeAttribute("id", String.valueOf(l.getId()));

                xsw.writeStartElement("titulo");
                xsw.writeCharacters(l.getTitulo());
                xsw.writeEndElement();

                xsw.writeStartElement("autor");
                xsw.writeCharacters(l.getAutor());
                xsw.writeEndElement();

                xsw.writeStartElement("anopublicacion");
                xsw.writeCharacters(String.valueOf(l.getAnopublicacion()));
                xsw.writeEndElement();

                xsw.writeStartElement("xenero");
                xsw.writeCharacters(l.getXenero());
                xsw.writeEndElement();

                xsw.writeEndElement();
            }
            xsw.writeEndElement();
            xsw.writeEndElement();

            xsw.flush();
            xsw.close();
            fw.close();
            System.out.println("XML xerado correctamente");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void serializarLibro(String directorio, List<Libro> listaLibros){
        File arquivo = new File(directorio);

        try (FileOutputStream fos = new FileOutputStream(arquivo);
             ObjectOutputStream oos = new ObjectOutputStream(fos)
        ) {
            oos.writeObject(listaLibros);
            System.out.println("Serializado correctamente en: " + directorio);
        } catch (IOException e) {
            System.out.println("Erro durante a serializacion: " + e.getMessage());
        }
    }

    public static List<Libro> deserializadorLibros (String directorio) {
        File arquivo = new File(directorio);
        List<Libro> listaLibros = null;

        try (FileInputStream fis = new FileInputStream(arquivo);
        ObjectInputStream ois = new ObjectInputStream(fis)
        ) {

            listaLibros = (List<Libro>) ois.readObject();
            System.out.println("Deserializado correctamente");

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro durante a deserializacion: " + e.getMessage());
        }
        return listaLibros;
    }

}


