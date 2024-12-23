abstract class ChessPiece {
    protected String color;

    public ChessPiece(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public abstract String getSymbol();

    public abstract boolean canMoveToPosition(ChessBoard board, int line, int column, int toLine, int toColumn);
}


class ChessPawn extends ChessPiece {
    public ChessPawn(String color) {
        super(color);
    }

    @Override
    public String getSymbol() {
        return color.equals("White") ? "P" : "p";
    }

    @Override
    public boolean canMoveToPosition(ChessBoard board, int line, int column, int toLine, int toColumn) {
        if (!board.isValidPosition(toLine, toColumn)) return false;
        int direction = color.equals("White") ? 1 : -1;

        if (toColumn == column && toLine == line + direction && board.isEmpty(toLine, toColumn)) return true;
        if (toColumn == column && line == (color.equals("White") ? 1 : 6) && toLine == line + 2 * direction
                && board.isEmpty(toLine, toColumn) && board.isEmpty(line + direction, column)) return true;
        return Math.abs(toColumn - column) == 1 && toLine == line + direction && !board.isEmpty(toLine, toColumn);
    }
}


class ChessRook extends ChessPiece {
    public ChessRook(String color) {
        super(color);
    }

    @Override
    public String getSymbol() {
        return color.equals("White") ? "R" : "r";
    }

    @Override
    public boolean canMoveToPosition(ChessBoard board, int line, int column, int toLine, int toColumn) {
        if (!board.isValidPosition(toLine, toColumn)) return false;
        if (line != toLine && column != toColumn) return false;

        int stepLine = Integer.compare(toLine, line);
        int stepColumn = Integer.compare(toColumn, column);
        int currentLine = line + stepLine, currentColumn = column + stepColumn;

        while (currentLine != toLine || currentColumn != toColumn) {
            if (!board.isEmpty(currentLine, currentColumn)) return false;
            currentLine += stepLine;
            currentColumn += stepColumn;
        }

        return board.isEmpty(toLine, toColumn) || !board.getPiece(toLine, toColumn).getColor().equals(this.color);
    }
}
