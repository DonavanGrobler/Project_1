package za.ac.nwu.as.repository.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import za.ac.nwu.as.domain.persistence.AccountType;

import java.time.LocalDate;

@Repository
public interface AccountTypeRepository extends JpaRepository<AccountType, Long> {  // JPARepository<Type,ID_TYPE>

    @Query( // uses hibernate sql. Refers to database entities in application. More optimal for use on single tables
            value = "SELECT "+"at "+"FROM "+"AccountType at "+"WHERE at.mnemonic = :mnemonic"
    )
    AccountType getAccountTypeByMnemonic(String mnemonic);

    @Query( // Use this if you're working with multiple tables, joins etc.
            value = "SELECT new za.ac.nwu.ac.domain.dto.AccountTypeDto("+
                    "at.mnemonic,"+"at.accName,"+"at.startDate) "+
                    "FROM "+"AccountType at "+"WHERE at.mnemonic = :mnemonic"
    )
    AccountType getAccountTypeDtoByMnemonic(String mnemonic);

    @Query( // NB! Not recommended to use, since query won't work if you change databases, due to native nature
            value = "SELECT "+"ACC_TYPE_ID,"+"ACC_NAME,"+"START_DATE,"+"MNEMONIC "+
                    "FROM "+"PROJECT1 "+"WHERE MNEMONIC = :mnemonic", nativeQuery = true
    )
    AccountType getAccountTypeByMnemonicNativeQuery(String mnemonic);

    @Modifying
    @Query(value = "DELETE FROM "+ "AccountType at"+ " WHERE at.mnemonic = :mnemonic ")
    void deleteAccountTypeByMnemonic( String mnemonic);

    @Modifying
    @Query(value = "UPDATE " + "AccountType at " + "SET at.accName = :newAccName, " +
            "at.startDate = :newStartDate " + "WHERE " + "at.mnemonic = :mnemonic")
    void updateAccountType(String mnemonic, String newAccountTypeName, @Param("newStartDate") LocalDate newStartDate);

}
