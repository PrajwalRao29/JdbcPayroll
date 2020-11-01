public class Employee {
    int company_id;
    String company_name;
    int emp_id;
    int department_id;
    String department_name;
    String name;
    String phone;
    String address;
    char gender;
    int basic_pay;
    int deductions;
    int taxable_pay;
    int tax;
    int net_pay;

    public Employee()
    {

    }
    public Employee(String company_name, String department_name, String name, String phone, String address, char gender, int basic_pay, int deductions, int taxable_pay, int tax, int net_pay) {
        this.company_name = company_name;
        this.department_name = department_name;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.gender = gender;
        this.basic_pay = basic_pay;
        this.deductions = deductions;
        this.taxable_pay = taxable_pay;
        this.tax = tax;
        this.net_pay = net_pay;
    }

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
