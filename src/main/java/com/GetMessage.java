package com;

import com.Model.User;

public class GetMessage {
    String message;
    public static String getMessage(User u){
        String s;
        String age;
        if(u.getGender().equals("Ж"))
           s="Уважаемая ";
        else  s="Уважаемый";
        if(u.getBirthDate()>2000)
            age=" let";
        else age=" god";
        int age1=2020-u.getBirthDate();
        return s+u.getName()+"ваш год рожения "+u.getBirthDate()+"Vam "+age1+age;
    }
}
