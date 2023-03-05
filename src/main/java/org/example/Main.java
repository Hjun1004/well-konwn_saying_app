package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Container.init();

        App ap = new App(); // App클래스에 줬다. new Scanner(System.in) 이 sc로 전달된다.
        ap.run();

        Container.close();
    }
}