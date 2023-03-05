package org.example;

import org.example.system.controller.SystemController;
import org.example.well_known.controller.Well_KnownController;
import org.example.well_known.entity.Well_Known;

import java.util.*;

public class App {
    // Main으로부터 new Scanner(System.in)이 들어왔다. // Container 때문에 필요 없어짐
    void run(){

        SystemController systemController = new SystemController();
        Well_KnownController wellKnownController = new Well_KnownController();

        System.out.println("== 명언 ==");

        while (true){
            System.out.print("명령) ");
            String 커맨드 = Container.getScanner().nextLine().trim(); // Container 클래스의 본사직원 getScanner 덕분에 Container.getScanner()만 써도 된다.
            Rq rq = new Rq(커맨드);

            switch (rq.getActionCode()){
                case "종료":
                    systemController.exit();
                    return; //여기서 return을 하면 함수 자체가 종료

                case "등록":
                    wellKnownController.write();
                    break;

                case "목록":
                    wellKnownController.list();
                    break;

                case "삭제":
                    wellKnownController.remove(rq);
                    break;

                case "수정":
                    wellKnownController.modify(rq);
                    break;
            }
        }
    }
}
