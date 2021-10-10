package za.ac.nwu.as.repo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import za.ac.nwu.as.domain.persistence.AccountType;
import java.time.LocalDate;


@Repository
public interface AccountTypeRepository extends JpaRepository<AccountType, Long> {

    @Query(value = "SELECT " +
            "       accTypeId," +
            "       accName,"+"startDate,"+"MNEMONIC "+
            "   FROM " +
            "       AccountType " +
            "  WHERE MNEMONIC = :mnemonic", nativeQuery = true)
    AccountType getAccountTypeByMnemonicNativeQuery(String mnemonic);

    @Query(
            value = "SELECT " +
                    "at " +
                    "FROM " +
                    "AccountType at "
                    + "WHERE at.mnemonic = :mnemonic"
    )
    AccountType getAccountTypeByMnemonic(String mnemonic);

    @Query(
            value = "SELECT new za.ac.nwu.as.domain.dto.AccountTypeDto(" +
                    "at.mnemonic," +
                    "at.accName," +
                    "at.startDate) " +
                    "FROM " +
                    "AccountType at " +
                    "WHERE at.mnemonic = :mnemonic"
    )
    AccountType getAccountTypeDtoByMnemonic(String mnemonic);

    void deleteAccountTypeByMnemonic(String mnemonic);

    void updateAccountType(String mnemonic, String accName, LocalDate startDate);
}
