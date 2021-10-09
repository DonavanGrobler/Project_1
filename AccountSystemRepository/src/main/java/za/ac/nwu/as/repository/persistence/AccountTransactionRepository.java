package za.ac.nwu.as.repository.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.nwu.as.domain.dto.AccountTransactionDto;
import za.ac.nwu.as.domain.persistence.AccountTransaction;
import org.springframework.data.jpa.repository.Query;
import za.ac.nwu.as.domain.persistence.AccountType;

@Repository
public interface AccountTransactionRepository extends JpaRepository<AccountTransaction, Long> {

}