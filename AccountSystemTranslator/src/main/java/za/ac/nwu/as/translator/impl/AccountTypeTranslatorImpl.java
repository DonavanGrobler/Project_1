package za.ac.nwu.as.translator.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.as.domain.dto.AccountTypeDto;
import za.ac.nwu.as.domain.persistence.AccountType;
import za.ac.nwu.as.repository.persistence.AccountTypeRepository;
import za.ac.nwu.as.translator.AccountTypeTranslator;

import java.util.List;

@Component
public class AccountTypeTranslatorImpl implements AccountTypeTranslator {

    private final AccountTypeRepository accountTypeRepository;

    @Autowired
    public AccountTypeTranslatorImpl(AccountTypeRepository accountTypeRepository) {
        this.accountTypeRepository = accountTypeRepository;
    }

    @Override
    public List<AccountTypeDto> getAllAccountTypes(){
        try {
            for (AccountType accountType : accountTypeRepository.findAll()) {
                accountTypeDto.add(new AccountTypeDto(accountType));
            }
        } catch (Exception e){
            throw  new RuntimeException("Unable to read from the DB", e);
        }
        return accountTypeDto;
    }



}
