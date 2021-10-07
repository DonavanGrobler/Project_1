package za.ac.nwu.as.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "ACC_TYPE_TABLE", schema = "PROJECT1" )
public class AccountType implements Serializable {

    @Id
    @SequenceGenerator(name = "ACC_TYPE_TABLE_SEQ", sequenceName = "ACC_TYPE_TABLE_SEQ.VIT_RSA_GENERIC_SEQ, allocationSize = 1")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ACC_TYPE_TABLE_SEQ")


    private Long accTypeId;
    private String mnemoic;
    private String accName;
    private String userName;
    private String userLastName;
    private Long miles;
    private LocalDate startDate;

    public AccountType(Long accTypeId, String mnemoic, String accName, String userName, String userLastName, Long miles, LocalDate startDate) {
        this.accTypeId = accTypeId;
        this.mnemoic = mnemoic;
        this.accName = accName;
        this.userName = userName;
        this.userLastName = userLastName;
        this.miles = miles;
        this.startDate = startDate;
    }

    public AccountType() {
    }

    @Column(name = "ACC_TYPE_ID")
    public Long getAccTypeId() {
        return accTypeId;
    }
    public void setAccTypeId(Long accTypeId) {
        this.accTypeId = accTypeId;
    }

    @Column(name = "MNEMOIC")
    public String getMnemoic() {
        return mnemoic;
    }
    public void setMnemoic(String mnemoic) {
        this.mnemoic = mnemoic;
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
