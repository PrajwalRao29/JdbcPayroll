import org.junit.*;

public class TestPayroll {

    @Test
    public void test1CountEntriesAfterReadingData()
    {
        PayRoll p=new PayRoll();
        Assert.assertEquals(3,p.readData().size());
    }
    @Test
    public void test2CheckUpdate()
    {
        PayRoll p=new PayRoll();
        p.update("a",300000);
        Assert.assertEquals(300000,p.readData().get(0).basic_pay);
    }
}
