public class Horse extends ChessPiece {
    public Horse(String color) {
        super(color);
    }

    @Override
    public String getSymbol() {
        return color.equals ("White") ? "H" : "h";
    }

    @Override
    public boolean canMoveToPosition(ChessBoard board, int line, int column, int toLine, int toColumn) {
        int dx = Math.abs(line - toLine);
        int dy = Math.abs(column - toColumn);
        return (dx == 2 && dy == 1) || (dx == 1 && dy == 2);
    }
}
