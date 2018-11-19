"use strict";
exports.__esModule = true;
var Account = /** @class */ (function () {
    function Account(accountno, accountType, balance, holderName) {
        this.accountno = 0;
        this.balance = 0;
        this.holderName = "";
        this.accountno = accountno;
        this.accountType = accountType;
        this.balance = balance;
        this.holderName = holderName;
    }
    Account.prototype.getBalance = function () {
        return this.balance;
    };
    Account.prototype.getAccountType = function () {
        return this.accountType;
    };
    Account.prototype.getAccountDetails = function () {
        return "Account Holder Name:-> " + this.holderName + " balance is " + this.getBalance() + " Account type " + this.getAccountType();
    };
    return Account;
}());
exports.Account = Account;
