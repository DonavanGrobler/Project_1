package za.ac.nwu.as.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "ACCOUNTTRANSACTION", schema = "PROJECT1" )
public class AccountTransaction implements Serializable {
    private static final long serialVersionUID = 1199041377884282633L;

    @Id
    @SequenceGenerator(name = "ACCOUNTTRANSACTION_SEQ", sequenceName = "ACCOUNTTRANSACTION_SEQ.VIT_RSA_GENERIC_SEQ, allocationSize = 1")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ACCOUNTTRANSACTION_SEQ")


    private Long transactionId;
    private Long accTypeId;
    private Long memberId;
    private Integer gainedMiles;
    private Long usedMiles;
    private LocalDate transactionDate;

    public AccountTransaction(Long transactionId, Long accTypeId, Long memberId, Integer gainedMiles, Long usedMiles, LocalDate transactionDate) {
        this.transactionId = transactionId;
        this.accTypeId = accTypeId;
        this.memberId = memberId;
        this.gainedMiles = gainedMiles;
        this.usedMiles = usedMiles;
        this.transactionDate = transactionDate;
    }

    public AccountTransaction(Long accountTypeId, Long memberId, Integer gainedMiles, LocalDate transactionDate) {
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
    public Long getAccTypeId() {
        return accTypeId;
    }
    public void setAccTypeId(Long accTypeId) {
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
    public Integer getGainedMiles() {
        return gainedMiles;
    }
    public void setGainedMiles(Integer gainedMiles) {
        this.gainedMiles = gainedMiles;
    }

    @Column(name = "USED_MILES")
    public Long getUsedMiles() {
        return usedMiles;
    }
    public void setUsedMiles(Long usedMiles) {
        this.usedMiles = usedMiles;
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
