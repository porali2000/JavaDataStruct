package retries;

import java.util.*;

public class MyCode {


/**
 Question 1:
 Given a dictionary that contains mapping of employee and his
 manager as a number of (employee, manager) pairs like below.

 { "A", "C" },
 { "B", "C" },
 { "C", "F" },
 { "D", "E" },
 { "E", "F" },
 { "F", "F" }

 In this example C is manager of A,
 C is also manager of B, F is manager
 of C and so on.

 Find the employee who is ceo meaning who has more number of reportees
 in this case: F would be CEO


 */
public static String findReportees(Map<String,String> map) {

    Map<String,Integer> reporteesMap = new HashMap<>();


    for (String employee: map.keySet()) {
        reporteesMap.put(employee, 0);
    }


        for (String employee: map.keySet()) {
            String manager = map.get(employee);
                if(!manager.equals(employee)) {
                    reporteesMap.put(manager, reporteesMap.get(employee) + reporteesMap.get(manager) + 1);
                }
        }
    System.out.println(reporteesMap);

      int count = -1;
    String ceo = "";

        for (String manager: reporteesMap.keySet()) {
            if(reporteesMap.get(manager) > count) {
                count = reporteesMap.get(manager);
                ceo = manager;
            }
        }
    return ceo;
}


}
