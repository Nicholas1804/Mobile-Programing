package com.Myapp.ezzyfoodv2.Repository;

public class BalanceRepository {
    private static int Balance = 100000;

    public static int topupBalance(int add){
        Balance += add;
        return Balance;
    }

    public static int buyItem(int min){
        Balance -= min;
        return Balance;
    }

    public static int getBalance(){
        return Balance;
    }
}
