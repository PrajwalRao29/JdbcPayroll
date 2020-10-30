public class Employee {
    int company_id;
    String company_name;
    int emp_id;
    String name;
    String phone;
    String address;
    char gender;
    int basic_pay;
    int deductions;
    int taxable_pay;
    int tax;
    int net_pay;

    @Override
    public String toString() {
        return "Employee{" +
                "company_id=" + company_id +
                ", company_name='" + company_name + '\'' +
                ", emp_id=" + emp_id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", gender=" + gender +
                ", basic_pay=" + basic_pay +
                ", deductions=" + deductions +
                ", taxable_pay=" + taxable_pay +
                ", tax=" + tax +
                ", net_pay=" + net_pay +
                '}';
    }
}
