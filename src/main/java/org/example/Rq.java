package org.example;

import org.example.well_known.controller.Well_KnownController;

import java.util.HashMap;
import java.util.Map;

public class Rq {
    Well_KnownController wellKnownController = new Well_KnownController();
    //private String 커맨드;
    private String actionCode;
    private Map<String, String> params;
    //private String

    public Rq(String 커맨드){
        String[] commandBits = 커맨드.split("\\?", 2); // 최대 2개까지 나눈다.
        actionCode = commandBits[0];

        params = new HashMap<>();

        if(commandBits.length == 1){
            return;
        }

        String[] commandBit = commandBits[1].split("&",2);

        for(String sd : commandBit){
            String[] paramStr = sd.split("=",2);
            if(paramStr.length == 1){
                continue; //여기가 return이면 삭제id?=id=&id=2 가 들어왔을 떄 id = 2는 아예 처리가 안됨
            }
            params.put(paramStr[0],paramStr[1]);
        }
    }

    public String getActionCode(){
        return actionCode;
    }

    public String getParam(String name){
        return params.get(name);
    }

    public int getIntParam(String name , int defaultValue ){
        try{
            int delete_num = Integer.parseInt(params.get(name));
            return delete_num;

        }catch (NumberFormatException e){

        }
        return defaultValue;
    }

}
