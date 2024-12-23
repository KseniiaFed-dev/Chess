public class King extends ChessPiece {

    public King(String color) {
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

        return dx <= 1 && dy <= 1;
    }


    @Override
    public String getSymbol() {
        return "K";
    }


    public boolean isUnderAttack(ChessBoard board, int line, int column) {

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                ChessPiece piece = board.getPiece(i, j);
                if (piece != null && !piece.getColor().equals(this.getColor())) {
                    if (piece.canMoveToPosition(board, i, j, line, column)) {
                        return true;
                    }
                }
            }
        }
        return false; 
    }
}

