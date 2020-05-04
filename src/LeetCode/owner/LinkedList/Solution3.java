package LeetCode.owner.LinkedList;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by zinan.ji on 2020-04-23.
 */
public class Solution3 {
    public int rand35(){
        return (int)(Math.random()*35);
    }

    public int rand47() {
        int i = rand35()*2;
        if (i>35){

        }
        return 0;
    }

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = Solution3.class.getDeclaredMethod("test",String.class,int.class);
        String result = (String) method.invoke(null,"fuck",2);
        System.out.println(result);
    }

    public static String test(String a , int b) {
        return "传入参数a："+ a +",传入参数b："+b;
    }
}
