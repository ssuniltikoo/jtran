"use strict";
var __extends = (this && this.__extends) || (function () {
    var extendStatics = function (d, b) {
        extendStatics = Object.setPrototypeOf ||
            ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
            function (d, b) { for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p]; };
        return extendStatics(d, b);
    }
    return function (d, b) {
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
exports.__esModule = true;
var Account_1 = require("./Account");
var AccountType_1 = require("./AccountType");
var SavingAccount = /** @class */ (function (_super) {
    __extends(SavingAccount, _super);
    function SavingAccount(accountno, balance, holderName) {
        var _this = _super.call(this, accountno, AccountType_1.AccountType.Saving, balance, holderName) || this;
        _this.InterestRate = 6;
        return _this;
    }
    SavingAccount.prototype.calculateInterest = function () {
        var totalInteresetAmount = 0;
        totalInteresetAmount = this.getBalance() * (this.InterestRate / 100) + this.getBalance();
        return totalInteresetAmount;
    };
    return SavingAccount;
}(Account_1.Account));
exports.SavingAccount = SavingAccount;
