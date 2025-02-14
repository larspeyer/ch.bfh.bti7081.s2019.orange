package ch.bfh.bti7081.ui.util.css;

public enum FlexWrap {

    NO_WRAP("nowrap"), WRAP("wrap"), WRAP_REVERSE("wrap-reverse");

    private String value;

    FlexWrap(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
