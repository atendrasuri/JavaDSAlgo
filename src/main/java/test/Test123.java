package test;

public class Test123 {

    /*

    Print the latest employee data

i/p:

emp_id    emp_name  sal     Date
1          emp1     5000  2024-05-01
2          emp2     6000  2024-06-01
3          emp3     7000  2024-07-01
1          emp1     8000  2024-08-01
4          emp4     9000  2024-09-01
5          emp5     7000  2024-10-01



o/p:

emp_id    emp_name  sal     Date
1          emp1     8000  2024-08-01
2          emp2     6000  2024-06-01
3          emp3     7000  2024-07-01
4          emp4     9000  2024-09-01
5          emp5     7000  2024-10-0
     */



    /*

     SELECT e1.amp_id, e1.emp_name, e1.sal, e1.Date from Employee e1 where e1_emp_id  = (Select e2.emp_id from employee e2 ORDER BY e2.DATE LIMIT 1)



     */

}
