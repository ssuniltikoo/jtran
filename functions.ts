class Student{
    private studeid: number;
    private studName:string;

    get studentName():string{
        return this.studName;
    }

    get  studentId():number{
        return this.studeid;
    }
    
    constructor(id:number,sNaame:string){
        this.studeid=id;
        this.studName=sNaame;
    }
    
    
}

var s1 = new Student(52,'sunil');
//s1.studentId=52;

console.log(s1.studentId);

