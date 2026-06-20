package pl.pjatk.piobed.component;

/**
 * Drugi bean z definicji XML - w beans.xml ma przekazany przez constructor-arg
 * referencję do xmlFirstComponent.
 *
 * To odpowiednik wstrzykiwania zależności przez konstruktor, tylko opisany w XML
 * zamiast adnotacją @Component / @Autowired.
 */
public class XmlSecondComponent {

    private final XmlFirstComponent xmlFirstComponent;

    public XmlSecondComponent(XmlFirstComponent xmlFirstComponent) {
        this.xmlFirstComponent = xmlFirstComponent;
        System.out.println("Hello from XmlSecondComponent");
        this.xmlFirstComponent.printXmlMessage();
    }
}
