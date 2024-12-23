public class Bishop extends ChessPiece {


    public Bishop(String color) {
        super(color);
    }


    @Override
    public String getColor() {
        return color;
    }


    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {

        if (toLine < 0 || toLine >= 8 || toColumn < 0 || toColumn >= 8) {
            return false;
        }


        int dx = Math.abs(toLine - line);
        int dy = Math.abs(toColumn - column);


        return dx == dy;
    }


    @Override
    public String getSymbol() {
        return "B";
    }
}
