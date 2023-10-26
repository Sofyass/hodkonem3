package croc.education.ws2023spb.knightsmove;

/**
 * Класс, содержащий методы преобразования в объект расположения фигуры на шахматной доске из различных форматов.
 * 
 * @author Dmitry Malenok
 * @see ChessPosition
 */
public final class ChessPositionParser {

    /**
     * Конструктор.
     */
    private ChessPositionParser() {
        // Конструктор задан только для того, чтобы экземпляр класса случайно не создали.
    }

    /**
     * Разбирает наименование клетки шахматной доски, на которой находится фигура, в
     * <a href="https://w.wiki/7pFN">шахматной нотации</a> и возвращает соответствующий ей объект расположения фигуры на
     * шахматной доске.
     * 
     * @param position
     *            наименование клетки шахматной доски, на которой находится фигура
     * @return объект расположения фигуры на шахматной доске, соответствующий переданному наименованию клетки
     */
    public static ChessPosition parse(final String position) {
        if (position.length() != 2) {
            throw new IllegalArgumentException("Invalid position: " + position);
        }
        char xChar = position.charAt(0);
        int x = xChar - 'a' + 1;
        int y = Character.getNumericValue(position.charAt(1));
        return new ChessPositionImpl(x, y);
    }

    private static class ChessPositionImpl implements ChessPosition {

        private final int x;
        private final int y;

        public ChessPositionImpl(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int x() {
            return x;
        }

        @Override
        public int y() {
            return y;
        }

        @Override
        public String toString() {
            return (char) (x + 'a' - 1) + "" + y;
        }
    }
}



