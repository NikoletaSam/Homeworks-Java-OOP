package blocks;

public class Element {
    private String name;
    protected StringBuilder builder;
    protected String content;
    private StringBuilder tsvBuilder;

    public Element(String name) {
        this.name = name;
        this.builder = new StringBuilder();
        this.tsvBuilder = new StringBuilder();
        appendName(name);
        appendNameToTSVBuilder(name);
    }

    public Element(String name, String content){
        this.name = name;
        this.content = content;
        this.builder = new StringBuilder();
        this.tsvBuilder = new StringBuilder();
        appendNameAndContent(name, content);
        appendNameAndContentToTSVBuilder(name, content);
    }

    public Element(String name, ElementAttribute attribute){
        this.name = name;
        this.builder = new StringBuilder();
        this.tsvBuilder = new StringBuilder();
        appendNameAndAttribute(name, attribute);
        appendNameAndAttributeToTSVBuilder(name, attribute);
    }

    protected Element(ElementListEnum name){
        if (name == ElementListEnum.Unordered){
            this.name = "ul";
        }
        if (name == ElementListEnum.Ordered){
            this.name = "ol";
        }
        this.builder = new StringBuilder();
        this.appendName(this.name);
    }

    protected void appendNameAndAttributeToTSVBuilder(String name, ElementAttribute attribute){
        this.tsvBuilder.append("<")
                .append(name).append(" ")
                .append(attribute.getName())
                .append("='")
                .append(attribute.getValue())
                .append("'>");
    }

    protected void appendNameAndContentToTSVBuilder(String name, String content){
        this.tsvBuilder.append("<")
                .append(name)
                .append(">")
                .append(content);
    }

    protected void appendNameToTSVBuilder(String name){
        this.tsvBuilder.append("<")
                .append(name)
                .append(">");
    }

    protected void appendNameAndAttribute(String name, ElementAttribute attribute){
        this.builder.append("<")
                .append(name).append(" ")
                .append(attribute.getName())
                .append("='")
                .append(attribute.getValue())
                .append("'></")
                .append(name)
                .append(">");
    }

    protected void appendNameAndContent(String name, String content){
        this.builder.append("<")
                .append(name)
                .append(">")
                .append(content)
                .append("</")
                .append(name)
                .append(">");
    }

    protected void appendName(String name){
        this.builder.append("<")
                .append(name)
                .append("></")
                .append(name)
                .append(">");
    }

    public String getName() {
        return this.name;
    }

    public String getTextContent() {
        return this.content;
    }

    public void addElement(Element element) {
        int indexToAdd = builder.lastIndexOf("/") - 1;
        String textToAdd = element.render();

        builder.insert(indexToAdd, textToAdd);
    }

    public String render() {
        return this.builder.toString();
    }

    public String renderAsTSV() {
        return this.builder.toString()
                .replace(" ", "#")
                .replace("'", "")
                .replace("=", "!")
                .replace("<", "")
                .replace(">", "")
                .replace("><", "~")
                .replace("/div", "")
                .replace("/h1", "")
                .replace("/h2", "")
                .replace("/html", "");
    }
}
