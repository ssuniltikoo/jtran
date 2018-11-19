import { IAccount } from "./IAccount";
import { AccountType } from "./AccountType";

abstract class Account implements IAccount{
    private accountno:number=0;
    private accountType:AccountType;
    private balance:number=0;
    private holderName:string="";

    constructor(accountno:number,accountType:AccountType, balance:number,holderName:string){
        this.accountno=accountno;
        this.accountType=accountType;
        this.balance=balance;
        this.holderName=holderName;
    }

    public getBalance():number{
        return this.balance;
    }

    public getAccountType():AccountType{
        return this.accountType;
    }

    
    public getAccountDetails():string{
        
        return "Account Holder Name:-> " + this.holderName + " balance is " + this.getBalance()+" Account type "+ this.getAccountType();
    }
    
}

export{
    Account
}