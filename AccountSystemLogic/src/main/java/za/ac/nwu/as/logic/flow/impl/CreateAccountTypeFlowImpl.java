package za.ac.nwu.as.logic.flow.impl;

import org.springframework.stereotype.Component;
import za.ac.nwu.as.logic.flow.CreateAccountTypeFlow;
import za.ac.nwu.as.translator.AccountTypeTranslator;
import javax.transaction.Transactional;
import java.time.LocalDate;

@Transactional
@Component("createAccountTypeFlowName")
public class CreateAccountTypeFlowImpl implements CreateAccountTypeFlow {

    private final AccountTypeTranslator accountTypeTranslator;

    public CreateAccountTypeFlowImpl(AccountTypeTranslator accountTypeTranslator) {
        this.accountTypeTranslator = accountTypeTranslator;
    }

    @Override
    public AccountTypeDto create(AccountTypeDto accountType) {
        if (null == accountType.getStartDate()) {
            accountType.setStartDate(LocalDate.now());
        }
        return accountTypeTranslator.create(accountType);
    }
}
