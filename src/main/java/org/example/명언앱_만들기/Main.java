package org.example.명언앱_만들기;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Scanner 만들어서
        App ap = new App(sc); // App클래스에 줬다. new Scanner(System.in) 이 sc로 전달된다.
        ap.run();
    }
}