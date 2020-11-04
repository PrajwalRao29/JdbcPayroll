import org.junit.*;

import java.time.*;
import java.util.*;

public class TestPayroll {

    PayRoll p;

    @Test
    public void test1CountEntriesAfterReadingData() {
        p = PayRoll.getInstance();
        Assert.assertEquals(3, p.readData().size());
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
        Employee emp = new Employee("BridgeLabz", "Sales", "Giri", "67890", "ABCDE", 'F', 50000);
        p.createEmployee(emp);
        Assert.assertEquals(4, p.readData().size());
    }

    @Test
    public void test6CascadeDelete() {
        p = PayRoll.getInstance();
        p.cascadingDelete("Giri");
        Assert.assertEquals(3, p.readData().size());
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
    }
}
