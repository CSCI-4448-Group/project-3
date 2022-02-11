public class CashRegister {
    private double amount_; // Cash Register Amount
    private int num_sales_transactions; // Number of transactions we do
    private double bank_withdrawals; // Bank withdrawal amount

    public CashRegister() {
        amount_ = 0;
        num_sales_transactions = 0;
        bank_withdrawals = 0;
    }

    // Getters and Setters for data
    protected double get_amount() {return amount_;}
    protected int get_num_sales_transactions() {return num_sales_transactions;}
    protected double get_bank_withdrawals() {return bank_withdrawals;}

    protected void set_amount(double newAmount) {amount_ = newAmount;}
    protected void set_num_sales_transactions(int newNumSalesTransactions) {num_sales_transactions = newNumSalesTransactions;}
    protected void set_bank_withdrawal(double newBankWithdrawals) {bank_withdrawals = newBankWithdrawals;}
}
