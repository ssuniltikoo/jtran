function add(temp:number=0,...num:string[]){
    let result =0;
    // num.forEach(num1){
    //     
    // }
    for(var a of num){
        //result+=a;
        console.log(a)
    }
    console.log(result);
    if(temp!=undefined){
        console.log(temp);
    }

}

add(2,'sunil','t','rt');