package croc.education.ws2023spb.knightsmove;

/**
 * Класс, реализующий фабричный метод, возвращающий обработчики, проверяющие, что последовательность клеток на шахматной
 * доске может быть пройдена ходом коня.
 *
 * @author Dmitry Malenok
 */
public final class KnightsMoveCheckerFactory {

    /**
     * Конструктор.
     */
    private KnightsMoveCheckerFactory() {
        // Конструктор задан только для того, чтобы экземпляр класса случайно не создали.

    }

    /**
     * Возвращает обработчик, проверяющий, что последовательность клеток на шахматной доске может быть пройдена ходом
     * коня.
     *
     * @return обработчик, проверяющий, что последовательность клеток на шахматной доске может быть пройдена ходом коня
     */
    public static KnightsMoveChecker get() {
        return positions -> {
            // Проверка наличия и достаточности позиций для хода коня
            if (positions.length < 2) {
                throw new IllegalMoveException("Not enough positions for a knight's move");
            }

            // Получение координат первой позиции
            int startX = getPositionX(positions[0]);
            int startY = getPositionY(positions[0]);

            // Проверка валидности первой позиции
            if (!isValidPosition(startX, startY)) {
                throw new IllegalMoveException("Invalid starting position");
            }

            // Проверка валидности последующих позиций и возможности хода коня
            for (int i = 1; i < positions.length; i++) {
                int endX = getPositionX(positions[i]);
                int endY = getPositionY(positions[i]);

                if (!isValidPosition(endX, endY)) {
                    throw new IllegalMoveException("Invalid position: " + positions[i]);
                }

                if (!isKnightMove(startX, startY, endX, endY)) {
                    throw new IllegalMoveException("Invalid knight's move: " + positions[i - 1] + " to " + positions[i]);
                }

                startX = endX;
                startY = endY;
            }


        };
    }

    static int getPositionX(String position) {
        return position.charAt(0) - 'a' + 1;
    }

    static int getPositionY(String position) {
        return Integer.parseInt(position.substring(1));
    }

    static boolean isValidPosition(int x, int y) {
        return x >= 1 && x <= 8 && y >= 1 && y <= 8;
    }

    static boolean isKnightMove(int startX, int startY, int endX, int endY) {
        int dx = Math.abs(startX - endX);
        int dy = Math.abs(startY - endY);
        return (dx == 1 && dy == 2) || (dx == 2 && dy == 1);
    }
    }

