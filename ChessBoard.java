public class ChessBoard {
    public ChessPiece[][] board;

    public ChessBoard(String white) {
        board = new ChessPiece[8][8];
    }

    public ChessPiece getPiece(int line, int column) {
        if (isValidPosition(line, column)) return board[line][column];
        return null;
    }

    public void setPiece(int line, int column, ChessPiece piece) {
        if (isValidPosition(line, column)) board[line][column] = piece;
    }

    public boolean isEmpty(int line, int column) {
        return isValidPosition(line, column) && board[line][column] == null;
    }

    public boolean isValidPosition(int line, int column) {
        return line >= 0 && line < 8 && column >= 0 && column < 8;
    }

    public boolean moveToPosition(int line, int column, int toLine, int toColumn) {
        if (!isValidPosition(line, column) || !isValidPosition(toLine, toColumn)) return false;
        ChessPiece piece = getPiece(line, column);
        if (piece == null || !piece.canMoveToPosition(this, line, column, toLine, toColumn)) return false;
        ChessPiece target = getPiece(toLine, toColumn);

        if (target != null && target.getColor().equals(piece.getColor())) return false;

        setPiece(toLine, toColumn, piece);
        setPiece(line, column, null);
        return true;
    }

    public void printBoard() {
        System.out.println("  a b c d e f g h");
        for (int i = 0; i < 8; i++) {
            System.out.print(8 - i + " ");
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == null) System.out.print(". ");
                else System.out.print(board[i][j].getSymbol() + " ");
            }
            System.out.println(8 - i);
        }
        System.out.println("  a b c d e f g h");
    }


    public boolean castling0() {

        return true;
    }

    public boolean castling7() {

        return true;
    }
}
