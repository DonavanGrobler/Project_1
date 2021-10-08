package za.ac.nwu.as.repository.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import za.ac.nwu.as.domain.persistence.AccountType;

import javax.persistence.criteria.From;
import java.util.List;

public interface AccountTypeRepository extends JpaRepository<AccountType, Long> {

    @Query(value = "SELECT" +
                    "ACC_TYPE_ID" +
                    "MNEMOIC" +
                    "ACC_NAME" +
                    "USER_NAME" +
                    "USER_LASTNAME" +
                    "MILES" +
                    "START_DATE" +
            "FROM" +
                    "ACC_TYPE_TABLE" +
            "WHERE +" +
                    "MNEMOIC = :mnemonic", nativeQuery = true)
    AccountType getAccountTypeByMnemonicNativeQuery(String mnemonic);


}
