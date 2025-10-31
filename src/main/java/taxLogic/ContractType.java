package taxLogic;

public enum ContractType {
    CIVIL('C'),
    EMPLOYMENT('E');

    private final char code;

    ContractType(char code) {
        this.code = code;
    }

    public static ContractType fromCode(char code) {
        for (ContractType type : values()) {
            if (type.code == code) {
                return type;
            }
        }
        throw new IllegalArgumentException("Unknown type of contract:: " + code);
    }
}
