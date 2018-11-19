import { AccountType } from "./AccountType";

interface IAccount{    
    getBalance() :number;
    getAccountType():AccountType;
}
export{
    IAccount
}