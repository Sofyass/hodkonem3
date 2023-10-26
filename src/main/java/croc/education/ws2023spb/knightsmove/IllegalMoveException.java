package croc.education.ws2023spb.knightsmove;

/**
 * Исключение, выбрасываемое в случае, если при перемещении шахматного коня из текущей клетки в следующую происходит с
 * нарушением правил.
 * 
 * @author Dmitry Malenok
 */
public class IllegalMoveException extends Exception {
    private ChessPosition from;
    private ChessPosition to;

    public IllegalMoveException(ChessPosition from, ChessPosition to) {
        this.from = from;
        this.to = to;
    }

    public IllegalMoveException(String s) {
    }

    @Override
    public String getMessage() {
        return "Illegal move from " + from.toString() + " to " + to.toString();
    }
}

