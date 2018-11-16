function calculator(x, y) {
    if (x === void 0) { x = 0; }
    if (y === void 0) { y = 1; }
    if (x != undefined && y != undefined) {
        return (x + y);
    }
    else {
        return 0;
    }
}
var a = calculator(5, 7);
console.log(a);
