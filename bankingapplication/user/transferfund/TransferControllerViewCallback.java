package console.bankingapplication.user.transferfund;

import console.bankingapplication.dto.Account;

public interface TransferControllerViewCallback {
    void checkTransferAccount(int accNo);

    void checkAmount(long amount, int accNo, Account account);
}
