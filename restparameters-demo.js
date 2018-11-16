function add(temp) {
    if (temp === void 0) { temp = 0; }
    var num = [];
    for (var _i = 1; _i < arguments.length; _i++) {
        num[_i - 1] = arguments[_i];
    }
    var result = 0;
    // num.forEach(num1){
    //     
    // }
    for (var _a = 0, num_1 = num; _a < num_1.length; _a++) {
        var a = num_1[_a];
        //result+=a;
        console.log(a);
    }
    console.log(result);
    if (temp != undefined) {
        console.log(temp);
    }
}
add(2, 'sunil', 't', 'rt');
