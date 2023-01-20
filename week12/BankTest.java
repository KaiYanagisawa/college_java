import java.io.*;

class DepositAccountManager extends Thread {

  String name;
  Account targetAccount;

  public DepositAccountManager(String name, Account ac) {
    this.name = name;
    this.targetAccount = ac;
  }

  public void run() {
    for (int i = 0; i < 10; i++) {
      try {
        Thread.sleep(10000);
        targetAccount.deposit(5000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}

class WithdrawAccountManager extends Thread {

  String name;
  Account targeAccount;

  public WithdrawAccountManager(String name, Account ac) {
    this.name = name;
    this.targeAccount = ac;
  }

  public void run() {
    for (int i = 0; i < 10; i++) {
      try {
        Thread.sleep(3000);
        targeAccount.drawer(3000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}

class Account {

  private int amount = 10000;

  public synchronized void deposit(int money) {
    while (amount >= 3000) {
      try {
        wait();
      } catch (InterruptedException e) {}
    }
    notifyAll();
    System.out.println(Thread.currentThread().getName() + ":入金がありました");
    amount += money;
    System.out.println(
      Thread.currentThread().getName() +
      ":預金額:" +
      money +
      " 新規残額:" +
      amount
    );
    System.out.println(
      Thread.currentThread().getName() + ":預金を完了しました"
    );
  }

  public synchronized void drawer(int money) {
    while (amount < 3000) {
      try {
        System.out.println(
          Thread.currentThread().getName() + ":引き出し待機中"
        );
        wait();
      } catch (InterruptedException e) {}
    }
    notifyAll();

    System.out.println(
      Thread.currentThread().getName() + ":引き出し依頼がありました"
    );
    amount -= money;
    System.out.println(
      Thread.currentThread().getName() +
      ":出金額:" +
      money +
      " 新規残額:" +
      amount
    );
    System.out.println(
      Thread.currentThread().getName() + ":引き出しを完了しました"
    );
  }
}

public class BankTest {

  public static void main(String[] args) {
    Account testAccount = new Account();
    DepositAccountManager cam1 = new DepositAccountManager("cam1", testAccount);
    WithdrawAccountManager cam2 = new WithdrawAccountManager(
      "cam2",
      testAccount
    );

    cam1.start();
    cam2.start();
  }
}
