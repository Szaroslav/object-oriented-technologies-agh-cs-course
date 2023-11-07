package command;

import model.Account;
import model.Transaction;

public class RemoveTransactionCommand implements Command {
    private final Transaction[] transactionsToRemove;
    private final Account account;

    public RemoveTransactionCommand(Transaction[] transactionsToRemove, Account account) {
        this.transactionsToRemove = transactionsToRemove;
        this.account = account;
    }

    @Override
    public String getName() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Transaction transaction : transactionsToRemove) {
            stringBuilder.append("Removed transaction: ")
                .append(transaction.toString())
                .append(System.getProperty("line.separator"));
        }
        return stringBuilder.toString();
    }

    @Override
    public void execute() {
        for (Transaction transaction : transactionsToRemove)
            account.removeTransaction(transaction);
    }
}
