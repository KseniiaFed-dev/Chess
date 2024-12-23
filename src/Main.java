import java.awt.*;
import java.util.Scanner;

public class Main {

    public static ChessBoard buildBoard() {
        ChessBoard board = new ChessBoard("White");

        board.board[0][0] = new Rook("White");
        board.board[0][1] = new Horse("White");
        board.board[0][2] = new Bishop("White");
        board.board[0][3] = new Queen("White");
        board.board[0][4] = new King("White");
        board.board[0][5] = new Bishop("White");
        board.board[0][6] = new Horse("White");
        board.board[0][7] = new Rook("White");
        board.board[1][0] = new Pawn("White");
        board.board[1][1] = new Pawn("White");
        board.board[1][2] = new Pawn("White");
        board.board[1][3] = new Pawn("White");
        board.board[1][4] = new Pawn("White");
        board.board[1][5] = new Pawn("White");
        board.board[1][6] = new Pawn("White");
        board.board[1][7] = new Pawn("White");

        board.board[7][0] = new Rook("Black");
        board.board[7][1] = new Horse("Black");
        board.board[7][2] = new Bishop("Black");
        board.board[7][3] = new Queen("Black");
        board.board[7][4] = new King("Black");
        board.board[7][5] = new Bishop("Black");
        board.board[7][6] = new Horse("Black");
        board.board[7][7] = new Rook("Black");
        board.board[6][0] = new Pawn("Black");
        board.board[6][1] = new Pawn("Black");
        board.board[6][2] = new Pawn("Black");
        board.board[6][3] = new Pawn("Black");
        board.board[6][4] = new Pawn("Black");
        board.board[6][5] = new Pawn("Black");
        board.board[6][6] = new Pawn("Black");
        board.board[6][7] = new Pawn("Black");

        return board;
    }

    public static void main(String[] args) {
        ChessBoard board = buildBoard();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Чтобы проверить игру надо вводить команды:");
        System.out.println("'exit' - для выхода");
        System.out.println("'replay' - для перезапуска игры");
        System.out.println("'castling0' или 'castling7' - для рокировки по соответствующей линии");
        System.out.println("'move 2 a 3 a' - для передвижения фигуры");
        System.out.println("Проверьте могут ли фигуры ходить друг сквозь друга, корректно ли съедают друг друга, можно ли поставить шах и сделать рокировку?");
        board.printBoard();

        while (true) {
            String s = scanner.nextLine();
            if (s.equals("exit")) {
                break;
            } else if (s.equals("replay")) {
                System.out.println("Заново");
                board = buildBoard();
                Color currentPlayer = Color.WHITE;
                board.printBoard();
            } else {
                if (s.equals("castling0")) {
                    if (board.castling0()) {
                        System.out.println("Рокировка удалась");
                        board.printBoard();
                    } else {
                        System.out.println("Рокировка не удалась");
                    }
                } else if (s.equals("castling7")) {
                    if (board.castling7()) {
                        System.out.println("Рокировка удалась");
                        board.printBoard();
                    } else {
                        System.out.println("Рокировка не удалась");
                    }
                } else if (s.contains("move")) {
                    String[] parts = s.split(" ");
                    if (parts.length == 5) {
                        try {
                            int fromLine = Integer.parseInt(parts[1]) - 1;
                            int fromColumn = parts[2].toLowerCase().charAt(0) - 'a';
                            int toLine = Integer.parseInt(parts[3]) - 1;
                            int toColumn = parts[4].toLowerCase().charAt(0) - 'a';

                            if (board.moveToPosition(fromLine, fromColumn, toLine, toColumn)) {
                                System.out.println("Успешно передвинулись");
                                board.printBoard();
                            } else {
                                System.out.println("Передвижение не удалось");
                            }
                        } catch (Exception e) {
                            System.out.println("Вы что-то ввели не так, попробуйте еще раз");
                        }
                    }
                }
            }
        }
    }
}
