class car{
    engine:string;
    constructor(engine:string){
        this.engine=engine;
    }
    disp():void{
        console.log("Function display engine"+this.engine);
    }
}

var obj = new car("Honda");
obj.disp();