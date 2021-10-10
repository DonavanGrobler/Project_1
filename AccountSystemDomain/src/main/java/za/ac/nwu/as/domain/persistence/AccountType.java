package za.ac.nwu.as.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "ACCOUNTTYPE", schema = "DONAVAN" )
public class AccountType implements Serializable {

    private Long accTypeId;
    private String mnemonic;
    private String accName;
    private String userName;
    private String userLastName;
    private Long miles;
    private LocalDate startDate;

    private Set<AccountTransaction> accountTransactions;

    public AccountType(Long accTypeId, String mnemonic, String accName, String userName, String userLastName, Long miles, LocalDate startDate) {
        this.accTypeId = accTypeId;
        this.mnemonic = mnemonic;
        this.accName = accName;
        this.userName = userName;
        this.userLastName = userLastName;
        this.miles = miles;
        this.startDate = startDate;
    }

    public AccountType(String mnemonic, String accName, LocalDate startDate) {
    }

    @Id
    @SequenceGenerator(name = "ACCOUNTTYPE_SEQ", sequenceName = "DONAVAN.ACCOUNTTYPE_SEQ, allocationSize = 1")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ACCOUNTTYPE_SEQ")
    @Column(name = "ACC_TYPE_ID")
    public Long getAccTypeId() {
        return accTypeId;
    }
    public void setAccTypeId(Long accTypeId) {
        this.accTypeId = accTypeId;
    }

    @Column(name = "MNEMONIC")
    public String getMnemonic() {
        return mnemonic;
    }
    public void setMnemonic(String mnemonic) {
        this.mnemonic = mnemonic;
    }

    @Column(name = "ACC_NAME")
    public String getAccName() {
        return accName;
    }
    public void setAccName(String accName) {
        this.accName = accName;
    }
    @Column(name = "USER_NAME")
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Column(name = "USER_LASTNAME")
    public String getUserLastName() {
        return userLastName;
    }
    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    @Column(name = "MILES")
    public Long getMiles() {
        return miles;
    }
    public void setMiles(Long miles) {
        this.miles = miles;
    }

    @Column(name = "START_DATE")
    public LocalDate getStartDate() {
        return startDate;
    }
    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    @OneToMany(targetEntity = AccountTransaction.class, fetch = FetchType.LAZY, mappedBy = "accTypeId", orphanRemoval = true, cascade = CascadeType.PERSIST)
    public Set<AccountTransaction> getAccountTransaction(){
        return getAccountTransaction();
    }
}
