package blocks;

public class Table extends Element {
    private int rows;
    private int cols;

    public Table(String name, int rows, int cols) {
        super(name);
        this.rows = rows;
        this.cols = cols;
        super.builder = new StringBuilder();
        appendTableWithName(name, rows, cols);
    }

    public Table(int rows, int cols){
        super("");
        this.rows = rows;
        this.cols = cols;
        super.builder = new StringBuilder();
        appendTable(rows, cols);
    }

    private void appendTable(int rows, int cols){
        super.builder.append("<table>");

        for (int row = 0; row < rows; row++) {
            builder.append("<tr>");
            for (int col = 0; col < cols; col++) {
                builder.append("<td></td>");
            }
            builder.append("</tr>");
        }

        builder.append("</table>");
    }

    private void appendTableWithName(String name, int rows, int cols){
        super.builder.append("<table name='")
                .append(name)
                .append("'>");

        for (int row = 0; row < rows; row++) {
            builder.append("<tr>");
            for (int col = 0; col < cols; col++) {
                builder.append("<td></td>");
            }
            builder.append("</tr>");
        }

        builder.append("</table>");
    }

    @Override
    public void addElement(Element element) {
        int indexToAdd = super.builder.indexOf("td") + 3;
        String textToAdd = element.render();

        super.builder.insert(indexToAdd, textToAdd);
    }


    public  void addElement(Element element, int row, int col){
        if ((row >= 1 && row <= this.rows) && (col >= 1 && col <= this.cols)){
            StringBuilder newBuilder = super.builder;
            int numOfColNeeded = row - 1;
            numOfColNeeded = (numOfColNeeded * this.cols) + (col - 1);

            String newString = newBuilder.toString();
            for (int i = 0; i < numOfColNeeded; i++) {
                newString = newString.replaceFirst("<td>", "....");
            }

            int indexToInsertElement = newString.indexOf("<td>") + 4;

            super.builder.insert(indexToInsertElement, element.render());
        }
    }
}