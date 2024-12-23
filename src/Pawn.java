public class Pawn extends ChessPiece {


    public Pawn(String color) {
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


        if (column != toColumn) {
            return false;
        }


        if (line == toLine) {
            return false;
        }


        if (color.equals("White")) {
            
            if (line == 1 && toLine == 3 && column == toColumn) {
                return true; 
            } else if (toLine == line + 1 && column == toColumn) {
                return true;  
            }
        }


        if (color.equals("Black")) {

            if (line == 6 && toLine == 4 && column == toColumn) {
                return true;
            } else if (toLine == line - 1 && column == toColumn) {
                return true;
            }
        }

        return false;
    }


    @Override
    public String getSymbol() {
        return "P";
    }
}

