package blocks;

public class ElementAttribute {
    protected String name;
    protected String value;

    public ElementAttribute(String name, String value){
        this.name = name;
        this.value = value;
    }

    public String getName(){
        return this.name;
    }

    public String getValue(){
        return this.value;
    }
}
