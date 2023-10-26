package croc.education.ws2023spb.knightsmove;

/**
 * Приложение, проверяющее возможность прохождения последовательности клеток на шахматной доске ходом коня.
 */
public final class Application {

    /**
     * Основной метод приложения.
     *
     * @param args
     *            аргументы
     */
    public static void main(final String[] args) {
        String startingPosition = "a1";
        String endingPosition = "c2";

        try {
            if (!isValidPosition(startingPosition)) {
                throw new IllegalMoveException("Invalid starting position");
            }

            if (!isValidPosition(endingPosition)) {
                throw new IllegalMoveException("Invalid ending position");
            }

            if (isKnightMove(startingPosition, endingPosition)) {
                System.out.println("Конь может сделать ход из " + startingPosition + " в " + endingPosition);
            } else {
                System.out.println("Конь не может сделать ход из " + startingPosition + " в " + endingPosition);
            }
        } catch (IllegalMoveException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Извлекает координату X из строки позиции.
     *
     * @param position
     *            позиция
     * @return координата X
     */
    public static int getPositionX(String position) {
        char xChar = position.charAt(0);
        return xChar - 'a' + 1;
    }

    /**
     * Извлекает координату Y из строки позиции.
     *
     * @param position
     *            позиция
     * @return координата Y
     */
    public static int getPositionY(String position) {
        String yString = position.substring(1);
        return Integer.parseInt(yString);
    }

    /**
     * Проверяет, что координаты X и Y находятся в допустимом диапазоне от 1 до 8.
     *
     * @param x
     *            координата X
     * @param y
     *            координата Y
     * @return true, если координаты валидны, иначе false
     */
    public static boolean isValidPosition(int x, int y) {
        return x >= 1 && x <= 8 && y >= 1 && y <= 8;
    }

    /**
     * Проверяет, что позиция находится в допустимом диапазоне от a1 до h8.
     *
     * @param position
     *            позиция
     * @return true, если позиция валидна, иначе false
     */
    public static boolean isValidPosition(String position) {
        int x = getPositionX(position);
        int y = getPositionY(position);
        return isValidPosition(x, y);
    }

    /**
     * Проверяет, что конь может сделать ход из начальной позиции в конечную позицию.
     *
     * @param startingPosition
     *            начальная позиция
     * @param endingPosition
     *            конечная позиция
     * @return true, если ход возможен, иначе false
     */
    public static boolean isKnightMove(String startingPosition, String endingPosition) {
        int startX = getPositionX(startingPosition);
        int startY = getPositionY(startingPosition);
        int endX = getPositionX(endingPosition);
        int endY = getPositionY(endingPosition);

        int diffX = Math.abs(startX - endX);
        int diffY = Math.abs(startY - endY);

        return (diffX == 1 && diffY == 2) || (diffX == 2 && diffY == 1);
    }
}

