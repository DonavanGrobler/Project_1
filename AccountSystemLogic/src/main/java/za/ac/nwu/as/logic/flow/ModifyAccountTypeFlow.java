package za.ac.nwu.as.logic.flow;

import za.ac.nwu.as.domain.dto.AccountTypeDto;

public interface ModifyAccountTypeFlow {
    AccountTypeDto deleteAccountTypeByMnemonic(String mnemonic);
    AccountTypeDto updateAccountType(AccountTypeDto accountType);
}
