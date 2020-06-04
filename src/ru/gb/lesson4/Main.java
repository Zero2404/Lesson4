package ru.gb.lesson4;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static class XO {

        private static final char DOT_HUMAN = 'X';
        private static final char DOT_AI = 'O';
        private static final char DOT_EMPTY = ' ';

        private static int fieldSizeX;
        private static int fieldSizeY;
        private static char[][] field;

        private static final Scanner SCANNER = new Scanner(System.in);
        private static final Random RANDOM = new Random();

        //main
        public static void main(String[] args) {
            int fieldSize = 3;
            while (true) {
                init(fieldSize);
                printFiled();
                playOnce(fieldSize);
                System.out.println("Играть с начала?");
                if (SCANNER.next().equals("NO")) {
                    break;
                }
            }
        }

        private static void playOnce(int fieldSize) {
            while (true) {
                humanTurn();
                printFiled();
                if (isWinnerExists(DOT_HUMAN)) {
                    System.out.println("Победил игрок!");
                    break;
                }
                if (isDraw()) {
                    System.out.println("Ничья!");
                    break;
                }

                aiTurn();
                printFiled();
                if (isWinnerExists(DOT_AI)) {
                    System.out.println("Победил Комп!");
                    break;
                }
                if (isDraw()) {
                    System.out.println("Ничья!");
                    break;
                }
            }
        }

        //InitFiled
        private static void init(int filedSize) {
            fieldSizeX = filedSize;
            fieldSizeY = filedSize;

            field = new char[fieldSizeY][fieldSizeX];

            for (int y = 0; y < fieldSizeY; y++) {
                for (int x = 0; x < fieldSizeX; x++) {
                    field[y][x] = DOT_EMPTY;
                }
            }
        }

        //printFiled
        private static void printFiled() {
            System.out.println("=============");

            for (int y = 0; y < fieldSizeY; y++) {
                System.out.print("| ");
                for (int x = 0; x < fieldSizeX; x++) {
                    System.out.print(field[y][x] + " | ");
                }
                System.out.println();
            }
        }

        //isValidFiled
        private static boolean isValidFiled(int x, int y) {
            return x >= 0 && x < fieldSizeX && y >= 0 && y < fieldSizeY;
        }

        //isNotEmptyField
        private static boolean isNotEmptyField(int x, int y) {
            return field[y][x] != DOT_EMPTY;
        }

        //humanTurn
        private static void humanTurn() {
            //3  1
            int x;
            int y;
            do {
                System.out.println("Введите координаты хода X и Y (от 1 до " + fieldSizeY + ") через пробел >>>");
                x = SCANNER.nextInt() - 1;
                y = SCANNER.nextInt() - 1;
            } while (!isValidFiled(x, y) || isNotEmptyField(x, y));
            field[y][x] = DOT_HUMAN;
        }

        //aiTurn
        private static void aiTurn() {
            int x;
            int y;
            do {
                x = RANDOM.nextInt(fieldSizeX);
                y = RANDOM.nextInt(fieldSizeY);
            } while (isNotEmptyField(x, y));
            field[y][x] = DOT_AI;
        }

        //isDraw
        private static boolean isDraw() {
            for (int y = 0; y < fieldSizeY; y++) {
                for (int x = 0; x < fieldSizeX; x++) {
                    if (field[y][x] == DOT_EMPTY) {
                        return false;
                    }
                }
            }
            return true;
        }

        //checkWin
        private static boolean isWinnerExists(char symb) {
            /*if (field[0][0] == symb && field[0][1] == symb && field[0][2] == symb) return true;
            if (field[1][0] == symb && field[1][1] == symb && field[1][2] == symb) return true;
            if (field[2][0] == symb && field[2][1] == symb && field[2][2] == symb) return true;

            if (field[0][0] == symb && field[1][0] == symb && field[2][0] == symb) return true;
            if (field[0][1] == symb && field[1][1] == symb && field[2][1] == symb) return true;
            if (field[0][2] == symb && field[1][2] == symb && field[2][2] == symb) return true;

            if (field[0][0] == symb && field[1][1] == symb && field[2][2] == symb) return true;
            if (field[2][0] == symb && field[1][1] == symb && field[0][2] == symb) return true;
            return false;*/
            for (int y = 0; y<fieldSizeY;y++ ){
                if (field[1] )
            }
        }

    }
}