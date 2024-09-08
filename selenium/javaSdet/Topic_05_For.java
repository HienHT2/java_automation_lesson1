package javaSdet;

import java.util.ArrayList;
import java.util.List;

public class Topic_05_For {
    public static void  main(String[] args){
    //bieu thuc vong lap(loop)
        int number =100;
        //for classic
        for(int i=0;i<number;i++){
            System.out.println(i);
        }
        //collection List/set/Quee/Map
        List<String> name = new ArrayList<String>();
        name.add("Manual Testing");
        name.add("Automation Testing");
        name.add("Regrestion Testing");
        name.add("Comfirmation Testing");
        name.add("UI Testing");
        name.add("Mobile");
        for(String a:name){
            if(a.equals("Automation Testing")){
                System.out.println(a);
            }
        }
        //While
        int i=1000;
        while ((i<number)){
            System.out.println(i);
            i++;
        }
        //do-while
        do{//action truoc
            System.out.println(i);
            i++;
        }while (i<number);

    }
}
