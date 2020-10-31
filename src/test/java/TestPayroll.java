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
}
