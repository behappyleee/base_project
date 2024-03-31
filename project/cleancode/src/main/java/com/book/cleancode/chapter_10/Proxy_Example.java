package com.book.cleancode.chapter_10;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Proxy_Example {

}

class BankImpl implements Bank {
    private List<String> accounts;

    public Collection<String> getAccounts() {
        return accounts;
    }

    public void setAccounts(Collection<String> accounts) {
        this.accounts = new ArrayList<String>();
        for(String account: accounts) {
            this.accounts.add(account);
        }
    }
}

// 은행을 추상화 시킴
interface Bank {
    Collection<String> getAccounts();
    void setAccounts(Collection<String> accounts);
}

// 프록시 API가 필요한 "InvocationHandler"
//public class BankProxyHandler implements InvocationHandler {
//    private Bank bank;
//
//    public BankHandler (Bank bank) {
//        this.bank = bank;
//    }
//
//    // InvocationHandler에 정의된 메서드
//    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//        String methodName = method.getName();
//        if (methodName.equals("getAccounts")) {
//            bank.setAccounts(getAccountsFromDatabase());
//
//            return bank.getAccounts();
//        } else if (methodName.equals("setAccounts")) {
//            bank.setAccounts((Collection<Account>) args[0]);
//            setAccountsToDatabase(bank.getAccounts());
//            return null;
//        } else {
//            ...
//        }
//    }
//
//    //세부사항은 여기에 이어진다.
//    protected Collection<Account> getAccountsFromDatabase() { ... }
//    protected void setAccountsToDatabase(Collection<Account> accounts) { ... }
//}
//
//// 다른 곳에 위치하는 코드
//
//    Bank bank = (Bank) Proxy.newProxyInstance(
//            Bank.class.getClassLoader(),
//            new Class[] { Bank.class },
//            new BankProxyHandler(new BankImpl())
//    );
//}