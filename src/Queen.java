public class Queen extends ChessPiece {


    public Queen(String color) {
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


        if (line == toLine || column == toColumn) {
            return !isPathBlocked(chessBoard, line, column, toLine, toColumn);
        }


        if (dx == dy) {
            return !isPathBlocked(chessBoard, line, column, toLine, toColumn);
        }

        return false;
    }


    private boolean isPathBlocked(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        int stepLine = (toLine - line) == 0 ? 0 : (toLine - line) > 0 ? 1 : -1;
        int stepColumn = (toColumn - column) == 0 ? 0 : (toColumn - column) > 0 ? 1 : -1;

        int currentLine = line + stepLine;
        int currentColumn = column + stepColumn;

        while (currentLine != toLine && currentColumn != toColumn) {
            if (chessBoard.getPiece(currentLine, currentColumn) != null) {
                return true;
            }
            currentLine += stepLine;
            currentColumn += stepColumn;
        }
        return false;
    }

    @Override
    public String getSymbol() {
        return "Q";
    }
}

