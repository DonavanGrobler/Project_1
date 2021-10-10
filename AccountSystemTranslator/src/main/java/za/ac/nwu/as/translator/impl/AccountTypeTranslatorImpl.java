package za.ac.nwu.as.translator.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.as.domain.dto.AccountTypeDto;
import za.ac.nwu.as.domain.persistence.AccountType;
import za.ac.nwu.as.repository.persistence.AccountTypeRepository;
import za.ac.nwu.as.translator.AccountTypeTranslator;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Component
public class AccountTypeTranslatorImpl implements AccountTypeTranslator {
    private final AccountTypeRepository accountTypeRepository;

    @Autowired
    public AccountTypeTranslatorImpl(AccountTypeRepository accountTypeRepository) {
        this.accountTypeRepository = accountTypeRepository;
    }

    @Override
    public List<AccountTypeDto> getAllAccountTypes() {
        List<AccountTypeDto> accountTypeDtos = new ArrayList<>();
        try {
            for (AccountType accountType: accountTypeRepository.findAll()) {
                accountTypeDtos.add(new AccountTypeDto(accountType));
            }
        } catch (Exception e) {
            throw new RuntimeException("Unable to read from the database",e);
        }
        return accountTypeDtos;
    }

    @Override
    public AccountTypeDto create(AccountTypeDto accountTypeDto) {
        try {
            AccountType accountType = accountTypeRepository.save(accountTypeDto.getAccountType());
            return new AccountTypeDto(accountType);
        } catch (Exception e) {
            throw new RuntimeException("Unable to save to the database",e);
        }
    }

    @Override
    public AccountTypeDto getAccountTypeByMnemonic(String mnemonic) {
        try {
            AccountType accountType = accountTypeRepository.getAccountTypeByMnemonic(mnemonic);
            return new AccountTypeDto(accountType);
        } catch (Exception e) {
            throw new RuntimeException("Unable to read from the database",e);
        }
    }

    @Override
    public AccountTypeDto getAccountTypeDtoByMnemonic(String mnemonic) {
        try {
            AccountType accountType = accountTypeRepository.getAccountTypeDtoByMnemonic(mnemonic);
            return new AccountTypeDto(accountType);
        } catch (Exception e) {
            throw new RuntimeException("Unable to read from the database",e);
        }
    }


    @Override
    @Transactional
    public AccountTypeDto deleteAccountTypeByMnemonic(String mnemonic) {
        try{
            AccountType accountType = accountTypeRepository.getAccountTypeByMnemonic(mnemonic);
            accountTypeRepository.deleteAccountTypeByMnemonic(mnemonic);
            return new AccountTypeDto(accountType);
        }catch (Exception e){
            throw new RuntimeException("Unable to read from the DB ", e);
        }
    }

    @Override
    @Transactional
    public AccountTypeDto updateAccountType(AccountTypeDto accountType) {
        try{
            accountTypeRepository.updateAccountType(accountType.getMnemonic(), accountType.getAccName(),
                    accountType.getStartDate());
            return accountType;
        }catch (Exception e){
            throw new RuntimeException( "Unable to update the DB ", e);
        }
    }
}
