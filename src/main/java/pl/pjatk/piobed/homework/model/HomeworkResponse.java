package pl.pjatk.piobed.homework.model;

/**
 * Model odpowiedzi dla endpointów /homework.
 *
 * Klasa jest POJO (Plain Old Java Object) - zwykła klasa z polami, gettera/setterami
 * i konstruktorem bezargumentowym. Jackson używa tych konstrukcji do serializacji
 * obiektu do JSON-a i odwrotnie (deserializacji JSON -> obiekt).
 *
 * To przykład "modelu generowanego z JSON-a" - prowadzący wspominał ten temat
 * jako część zakresu kolokwium.
 */
public class HomeworkResponse {

    private String value;
    private String source;

    public HomeworkResponse() {
    }

    public HomeworkResponse(String value, String source) {
        this.value = value;
        this.source = source;
    }

    public String getValue() {
        return value;
    }

    public String getSource() {
        return source;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
