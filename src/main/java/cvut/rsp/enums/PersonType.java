package cvut.rsp.enums;

public enum PersonType
{
    PRODUCER("PRODUCER"), ACTOR("ACTOR"), DIRECTOR("DIRECTOR");

    private final String name;

    PersonType(String name) { this.name = name; }

    @Override
    public String toString() { return name; }
}
