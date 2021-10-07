package za.ac.nwu.as.repository.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.nwu.as.domain.persistence.AccountType;
import java.util.List;

public interface AccountTypeRepository extends JpaRepository<AccountType, Long> {

}
