import org.junit.*;

public class TestPayroll {

    PayRoll p;

    @Test
    public void test1CountEntriesAfterReadingData()
    {
        p=PayRoll.getInstance();
        Assert.assertEquals(3,p.readData().size());
    }
    @Test
    public void test2CheckUpdate()
    {
        p=PayRoll.getInstance();
        p.update("a",300000);
        Assert.assertEquals(300000,p.readData().get(0).basic_pay);
    }
    @Test
    public void test3CheckBetween()
    {
        p=PayRoll.getInstance();
        Assert.assertEquals(3,p.getBetween(1,3));
    }
    @Test
    public void test4CheckSum()
    {
        p=PayRoll.getInstance();
        Assert.assertEquals(1,p.getSum());
    }
    @Test
    public void test5CheckAdditionOfNewEmployee()
    {
        p=PayRoll.getInstance();
        Employee e=new Employee("BridgeLabz","Sales","Giri","67890","ABCDE",'F',50000);
        p.createEmployee(e);
        Assert.assertEquals(4,p.readData().size());
    }
    @Test
    public void test6CascadeDelete()
    {
        p=PayRoll.getInstance();
        p.cascadingDelete("Giri");
        Assert.assertEquals(3,p.readData().size());
    }
}
