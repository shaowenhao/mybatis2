import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;


public class Demo {
    @Test
    public void test1() {
        String s1 = "";
        boolean r1 = StringUtils.isEmpty(s1);
        System.out.println(r1);
    }

    @Test
    public void test2() {
        String s1 = "";
        boolean r1 = StringUtils.isBlank(s1);
        System.out.println(r1);
    }

    @Test
    public void test3() {
        StringUtils.trim("aa");
        StringUtils.indexOfAny("a", "abc");

        System.out.println(StringUtils.swapCase("abcEDF"));
    }

    @Test
    public void testMap() {
        //String queryString="{SensorData {Siid type value}}";
        String queryString="{Project(cond:\"{id:{_eq:\\\"23\\\"}}\",order:\"\") {invert_Customer{cname}}}";
        String headStr = queryString.substring(0, queryString.indexOf(" {"));
        String fieldStr = queryString.substring(queryString.indexOf(" {"));
        String entityStr = headStr;

//        System.out.println(headStr);
//        System.out.println(fieldStr);
//        System.out.println(entityStr);

        entityStr = queryString.substring(0, queryString.indexOf('('));
        String conditionStr = queryString.substring(queryString.indexOf('('), queryString.indexOf(')')+1);
        fieldStr = queryString.substring(queryString.indexOf(')')+1);

        conditionStr = conditionStr.replace("(cond:", "");
        conditionStr = conditionStr.substring(0, conditionStr.lastIndexOf(')'));

//        System.out.println(entityStr);
//        System.out.println(fieldStr);
        System.out.println("1:" + conditionStr);


        if ((conditionStr).contains(",order:"))
        {
            String orderStr = conditionStr.substring(conditionStr.indexOf(",order:"));
            System.out.println("2:" + conditionStr);
            orderStr = orderStr.replace(",order:", "");
            orderStr = orderStr.replace("\"", "");
            conditionStr = conditionStr.substring(0, conditionStr.indexOf(",order:"));
            System.out.println("3:"+orderStr);
            System.out.println("4:"+conditionStr);
        }

    }
}
