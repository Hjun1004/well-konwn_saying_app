package org.example;

import java.util.Scanner;

public class Container {
    private static Scanner sc; // Scanner 만들어서3

    public static void init(){
        sc = new Scanner(System.in);
    }

    public static void close(){
        sc.close();
    }

    public static Scanner getScanner(){ // sc는 스캐너 클래스의 리모컨을 담을수 있다.
        return sc; //sc 리모컨을 반환하기 위해서 Scanner getScanner()로 해야한다.
    }
}
