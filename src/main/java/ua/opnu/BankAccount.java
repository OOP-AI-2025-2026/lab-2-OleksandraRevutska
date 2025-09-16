package ua.opnu;

public class BankAccount {
    String name;
    double balance;
    double transactionFee;

    // Порожній конструктор
    public BankAccount() {
        this.name = "";
        this.balance = 0;
        this.transactionFee = 0;
    }

    // Конструктор з ім'ям і балансом
    public BankAccount(String name, double balance) {
        this.name = name;
        this.balance = balance;
        this.transactionFee = 0;
    }

    // Додає гроші на рахунок, тільки якщо amount > 0
    void deposit(double amount) {
        if (amount > 0) balance += amount;
    }

    // Знімає гроші з рахунку з урахуванням комісії
    boolean withdraw(double amount) {
        if (amount <= 0) return false;
        if (balance >= amount + transactionFee) {
            balance -= amount + transactionFee;
            return true;
        }
        return false;
    }

    // Переказ грошей іншому рахунку
    boolean transfer(BankAccount receiver, double amount) {
        if (amount <= 0) return false;
        if (withdraw(amount)) {  // знімає гроші з комісією
            receiver.deposit(amount);  // додає гроші на інший рахунок
            return true;
        }
        return false;
    }

    // Повертає баланс
     double getBalance() {
        return balance;
    }

    // Встановлює комісію
    void setTransactionFee(double fee) {
        if (fee >= 0) transactionFee = fee;
    }
}
