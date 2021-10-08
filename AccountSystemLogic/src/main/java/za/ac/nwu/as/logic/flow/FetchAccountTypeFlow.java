package za.ac.nwu.as.logic.flow;

import java.util.List;

public class FetchAccountTypeFlow {
    List<AccountTypeDto>getAllAccountTypes();

    AccountTypeDto getAccountTypeMnemonic(String mnemonic);
}
