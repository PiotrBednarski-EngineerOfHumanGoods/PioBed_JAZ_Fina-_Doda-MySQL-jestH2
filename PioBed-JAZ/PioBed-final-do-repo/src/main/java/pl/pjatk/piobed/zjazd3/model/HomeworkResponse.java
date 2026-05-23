package pl.pjatk.piobed.zjazd3.model;

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
