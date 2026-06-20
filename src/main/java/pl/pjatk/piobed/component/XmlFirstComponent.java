package pl.pjatk.piobed.component;

/**
 * Klasa BEZ adnotacji @Component - rejestrowana jako bean w pliku XML
 * (src/main/resources/beans.xml). Plik XML wczytuje się przez
 * @ImportResource("classpath:beans.xml") w PioBedApplication.
 *
 * Tradycyjny sposób definiowania beanów - obecnie używany rzadko, ale prowadzący
 * pokazywał go jako alternatywę dla @Component / @Configuration.
 */
public class XmlFirstComponent {

    public XmlFirstComponent() {
        System.out.println("Hello from XmlFirstComponent");
    }

    public void printXmlMessage() {
        System.out.println("XmlFirstComponent - printXmlMessage");
    }
}
