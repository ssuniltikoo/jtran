import { Account } from "./Account";
import { AccountType } from "./AccountType";

class SavingAccount extends Account{
    private InterestRate:number = 6;

    constructor(accountno:number,balance:number,holderName:string){
        super(accountno,AccountType.Saving, balance,holderName);
    }
    public calculateInterest():number{
        let totalInteresetAmount:number =0;
        totalInteresetAmount = this.getBalance()*(this.InterestRate/100)+this.getBalance();
        return totalInteresetAmount;
    }
}


export{
    SavingAccount
}