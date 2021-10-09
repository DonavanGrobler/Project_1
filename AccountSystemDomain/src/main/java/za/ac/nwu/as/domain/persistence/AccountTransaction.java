package za.ac.nwu.as.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "ACCOUNTTRANSACTION", schema = "PROJECT1" )
public class AccountTransaction implements Serializable {
    private static final long serialVersionUID = 1199041377884282633L;

    @Id
    @SequenceGenerator(name = "ACCOUNTTRANSACTION_SEQ", sequenceName = "ACCOUNTTRANSACTION_SEQ.VIT_RSA_GENERIC_SEQ, allocationSize = 1")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ACCOUNTTRANSACTION_SEQ")


    private Long transactionId;
    private AccountType accTypeId;
    private Long memberId;
    private Long gainedMiles;
    private LocalDate transactionDate;

    public AccountTransaction(Long accountTypeId, Long memberId, Long gainedMiles, LocalDate transactionDate) {
    }
    public AccountTransaction(Long transactionId, AccountType accTypeId, Long memberId, Long gainedMiles, LocalDate transactionDate) {
        this.transactionId = transactionId;
        this.accTypeId = accTypeId;
        this.memberId = memberId;
        this.gainedMiles = gainedMiles;
        this.transactionDate = transactionDate;
    }

    @Column(name = "TRANSACTION_ID")
    public Long getTransactionId() {
        return transactionId;
    }
    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn (name = "ACC_TYPE_ID")
    public AccountType getAccTypeId() {
        return accTypeId;
    }
    public void setAccTypeId(AccountType accTypeId) {
        this.accTypeId = accTypeId;
    }

    @Column(name = "MEMBER_ID")
    public Long getMemberId() {
        return memberId;
    }
    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    @Column(name = "GAINED_MILES")
    public Long getGainedMiles() {
        return gainedMiles;
    }
    public void setGainedMiles(Long gainedMiles) {
        this.gainedMiles = gainedMiles;
    }

    @Column(name = "TRANSACTION_DATE")
    public LocalDate getTransactionDate() {
        return transactionDate;
    }
    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountTransaction that = (AccountTransaction) o;
        return Objects.equals(transactionId, that.transactionId) && Objects.equals(accTypeId, that.accTypeId) && Objects.equals(memberId, that.memberId) && Objects.equals(gainedMiles, that.gainedMiles) && Objects.equals(transactionDate, that.transactionDate);
    }

    public void setAccountType(AccountType accountType) {
        this.accTypeId = accountType;
    }
    @Override
    public int hashCode() {
        return Objects.hash(transactionId, accTypeId, memberId, gainedMiles, transactionDate);
    }

    @Override
    public String toString() {
        return "AccountTransaction{" +
                "transactionId=" + transactionId +
                ", accTypeId=" + accTypeId +
                ", memberId=" + memberId +
                ", gainedMiles=" + gainedMiles +
                ", transactionDate=" + transactionDate +
                '}';
    }
}
