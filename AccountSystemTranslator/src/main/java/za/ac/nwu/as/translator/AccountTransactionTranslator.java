package za.ac.nwu.as.translator;

import za.ac.nwu.as.domain.dto.AccountTransactionDto;
import za.ac.nwu.as.domain.persistence.AccountTransaction;

import java.util.List;

public interface AccountTransactionTranslator {
    List<AccountTransactionDto> getAllTransactions();

    AccountTransactionDto create(AccountTransactionDto accountTransaction);
}