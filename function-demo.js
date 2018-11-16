function calculate(num1, num2, operation) {
    if (operation != undefined) {
        switch (operation.toUpperCase()) {
            case 'SUB':
                console.log(num1 - num2);
                break;
            case 'SUM':
                console.log(num1 + num2);
                break;
            default:
                console.log("error");
                break;
        }
    }
    else {
        console.log(num1 + num2);
    }
}
calculate(2, 3, 'sub');
