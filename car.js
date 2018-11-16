var car = /** @class */ (function () {
    function car(engine) {
        this.engine = engine;
    }
    car.prototype.disp = function () {
        console.log("Function display engine" + this.engine);
    };
    return car;
}());
var obj = new car("Honda");
obj.disp();
