var Student = /** @class */ (function () {
    function Student(id, sNaame) {
        this.studeid = id;
        this.studName = sNaame;
    }
    Object.defineProperty(Student.prototype, "studentName", {
        get: function () {
            return this.studName;
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(Student.prototype, "studentId", {
        get: function () {
            return this.studeid;
        },
        enumerable: true,
        configurable: true
    });
    return Student;
}());
var s1 = new Student(52, 'sunil');
//s1.studentId=52;
console.log(s1.studentId);
