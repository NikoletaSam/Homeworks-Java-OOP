package blocks;

import static blocks.ElementListEnum.Unordered;

public class ElementList extends Element  {
    private ElementListEnum listType;

    public ElementList() {
        super("ul");
        this.listType = Unordered;
        super.builder = new StringBuilder();
        super.appendName("ul");
    }

    public ElementList(ElementListEnum name){
        super(name);
        this.listType = name;
        super.builder = new StringBuilder();
        super.appendName(super.getName());
    }

    @Override
    public void addElement(Element element) {
        int indexToAdd = super.builder.lastIndexOf("/") - 1;
        String textToAdd = "<li>" + element.render() + "</li>";

        super.builder.insert(indexToAdd, textToAdd);
    }
}
