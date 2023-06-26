package bd.gov.dgfood.food.grain.license.api.json;

public class RequestProperty {
    private String key;
    private String value;

    public RequestProperty() {

    }

    public RequestProperty(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
