package za.ac.nwu.as.translator;

import za.ac.nwu.as.domain.dto.AccountTypeDTO;
import za.ac.nwu.as.domain.dto.AccountTypeDto;

import java.util.List;

public interface AccountTypeTranslator {
    List<AccountTypeDTO> getAllAccountTypes();
    AccountTypeDto create(AccountTypeDto accountType);
    AccountTypeDto getAccountTypeByMnemonicNativeQuery(String mnemonic);
    AccountTypeDto getAccountTypeByMnemonic(String mnemonic);
    AccountTypeDto getAccountTypeDtoByMnemonic(String mnemonic);

}
