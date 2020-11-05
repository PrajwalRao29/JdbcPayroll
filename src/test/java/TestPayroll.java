import org.junit.*;
import java.time.*;
import java.util.*;

public class TestPayroll {

    PayRoll p;

    @Test
    public void test1CountEntriesAfterReadingData() {
        p = PayRoll.getInstance();
        Assert.assertEquals(5, p.readData().size());
    }

    @Test
    public void test2CheckUpdate() {
        p = PayRoll.getInstance();
        p.update("a", 300000);
        Assert.assertEquals(300000, p.readData().get(0).basic_pay);
    }

    @Test
    public void test3CheckBetween() {
        p = PayRoll.getInstance();
        Assert.assertEquals(3, p.getBetween(1, 3));
    }

    @Test
    public void test4CheckSum() {
        p = PayRoll.getInstance();
        Assert.assertEquals(1, p.getSum());
    }

    @Test
    public void test5CheckAdditionOfNewEmployee() {
        p = PayRoll.getInstance();
        int count=p.readData().size();
        Employee emp = new Employee("BridgeLabz", "Sales", "Giri", "67890", "ABCDE", 'F', 50000);
        p.createEmployee(emp);
        Assert.assertEquals(count+1, p.readData().size());
    }

    @Test
    public void test6CascadeDelete() {
        p = PayRoll.getInstance();
        int count=p.readData().size();
        p.cascadingDelete("Giri");
        Assert.assertEquals(count-1, p.readData().size());
    }

    @Test
    public void test7AddMultipleEmployees() {
        p = PayRoll.getInstance();
        Employee e1 = new Employee("BridgeLabz", "Sales", "Giri", "67890", "ABCDE", 'F', 50000);
        Employee e2 = new Employee("Capgemini", "HR", "Hari", "54321", "hijkl", 'M', 35000);
        int count=p.readData().size();
        Instant start = Instant.now();
        p.createEmployee(e1);
        p.createEmployee(e2);
        Instant end=Instant.now();
        System.out.println("Duration Without Thread: " + Duration.between(start, end));
        Assert.assertEquals(count+ 2, p.readData().size());
        p.cascadingDelete("Giri");
        p.cascadingDelete("Hari");
    }
    @Test
    public void test8AddMultipleEmployeesThread()  {
        p = PayRoll.getInstance();
        ArrayList<Employee> arr=new ArrayList<>();
        int count=p.readData().size();
        System.out.println(count);
        Instant start = Instant.now();
        Employee e1 = new Employee("BridgeLabz", "Sales", "Giri", "67890", "ABCDE", 'F', 50000);
        Employee e2 = new Employee("Capgemini", "HR", "Hari", "54321", "hijkl", 'M', 35000);
        arr.add(e1);
        arr.add(e2);
        p.addEmployeesWithThread(arr);
        Instant end=Instant.now();
        System.out.println("Duration With Thread: " + Duration.between(start, end));
        Assert.assertEquals(count+ 2, p.readData().size());
        System.out.println(p.readData().size());
        p.cascadingDelete("Giri");
        p.cascadingDelete("Hari");
    }
    @Test
    public void test9UpdateMultipleEmployeesThread() {
        p = PayRoll.getInstance();
        String[] name = {"a", "b", "c"};
        int[] salary = {10000, 20000, 30000};
        p.updateSalaryWithThread(name, salary);
        Assert.assertEquals(10000, p.readData().get(0).basic_pay);
    }
}
