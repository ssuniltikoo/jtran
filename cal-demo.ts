function calculator(x:number=0,y:number=1):number{
    if(x!=undefined && y!=undefined){
        return (x+y);
    }else{
        return 0;
    }
    
}

var a = calculator(5,7);
console.log(a);