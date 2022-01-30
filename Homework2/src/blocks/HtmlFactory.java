package blocks;

import java.util.ArrayList;

public class HtmlFactory extends ElementFactory {

    @Override
    public Element createNewElement(String name) {
        return new Element(name);
    }

    @Override
    public Element createNewElement(String name, String content) {
        return new Element(name, content);
    }

    @Override
    public Element createNewElement(String name, ElementAttribute attribute) {
        return new Element(name, attribute);
    }

    @Override
    public Table createTable(String tableName, int row, int col) {
        return new Table(tableName, row, col);
    }

    @Override
    public Table createTable(int row, int col) {
        return new Table(row, col);
    }

    @Override
    public ElementText createTextElement(String content) {
        return new ElementText(content);
    }

    @Override
    public ElementList createList() {
        return new ElementList();
    }

    @Override
    public ElementList createList(ElementListEnum listType) {
        return new ElementList(listType);
    }

    @Override
    public ElementList createList(ElementListEnum listType, ArrayList<Element> collection) {
        ElementList elementList = new ElementList(listType);

        for (Element current : collection){
            elementList.addElement(current);
        }
        return elementList;
    }

    @Override
    public ElementAttribute createAttribute(String name, String value) {
        return new ElementAttribute(name, value);
    }
}
