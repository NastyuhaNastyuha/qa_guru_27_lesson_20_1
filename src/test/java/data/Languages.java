package data;

import lombok.Getter;

@Getter
public enum Languages {
    RU("Русский", "RU");
    private final String name;
    private final String code;

    Languages(String name, String code) {
        this.name = name;
        this.code = code;
    }
}
