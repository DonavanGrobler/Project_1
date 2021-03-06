package za.ac.nwu.as.translator;

import za.ac.nwu.as.domain.dto.AccountTypeDto;

import java.util.List;

public interface AccountTypeTranslator {
    List<AccountTypeDto> getAllAccountTypes();

    AccountTypeDto create(AccountTypeDto accountType);

    AccountTypeDto getAccountTypeByMnemonic(String mnemonic);

    AccountTypeDto getAccountTypeDtoByMnemonic(String mnemonic);

    AccountTypeDto deleteAccountTypeByMnemonic(String mnemonic);

    AccountTypeDto updateAccountType(AccountTypeDto accountType);
}