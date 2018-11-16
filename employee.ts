var num = 2;

class employee{
    private empName:string;
    private num=13;
    static sval = 10;
    constructor(empName:string){
        this.empName=empName;
        num=-4;
    }
     
    public printNum():void{
        
        console.log("global variable"+num);
        console.log("local variable"+this.num);
        console.log("static value"+employee.sval);
    }
    
    display():void{
        console.log("hello GM"+this.empName);
    }
}

let e = new employee("sunil");
e.display();
e.printNum();
