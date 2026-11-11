package com.shop.source;

import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class ConsoleReader {
    public Path selectFile(List<Path> files) {
        Scanner scanner = new Scanner(System.in);
        final int INDEX_INCREMENT = 1;
        final int LOW_INPUT_BORDER = 1;

        if (files.isEmpty()) {
            throw new IllegalStateException("Папка пуста.");
        }

        for (int i = 0; i < files.size(); i++) {
            System.out.println((i + INDEX_INCREMENT) + ". " + files.get(i).getFileName());
        }
        System.out.println("Введите номер файла, который хотите посчитать:");

        int userNumber;

        while (true) {
            if (!scanner.hasNextInt()) {
                System.out.println("Неверный ввод. Введите число от 1 до " + files.size());
                scanner.next();
                continue;
            }

            userNumber = scanner.nextInt();

            if (userNumber >= LOW_INPUT_BORDER && userNumber <= files.size()) {
                break;
            }
            System.out.println("Неверный ввод. Введите число от 1 до " + files.size());
        }

        return files.get(userNumber - 1);
    }
}