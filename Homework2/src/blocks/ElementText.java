package blocks;

public class ElementText extends Element {

    public ElementText(String content) {
        super(content);
        super.builder = new StringBuilder();
        this.appendName(content);
    }

    @Override
    protected void appendName(String content){
        super.builder.append(content);
    }
}
