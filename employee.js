var num = 2;
var employee = /** @class */ (function () {
    function employee(empName) {
        this.num = 13;
        this.empName = empName;
        num = -4;
    }
    employee.prototype.printNum = function () {
        console.log("global variable" + num);
        console.log("local variable" + this.num);
        console.log("static value" + employee.sval);
    };
    employee.prototype.display = function () {
        console.log("hello GM" + this.empName);
    };
    employee.sval = 10;
    return employee;
}());
var e = new employee("sunil");
e.display();
e.printNum();
