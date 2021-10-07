package za.ac.nwu.as.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "TRANSACTION_TABLE", schema = "PROJECT1" )
public class AccountTransaction implements Serializable {

    @Id
    @SequenceGenerator(name = "TRANSACTION_TABLE_SEQ", sequenceName = "TRANSACTION_TABLE_SEQ.VIT_RSA_GENERIC_SEQ, allocationSize = 1")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TRANSACTION_TABLE_SEQ")

    private Long transactionId;
    private Long accTypeId;
    private Long memberId;
    private Long gainedMiles;
    private Long usedMiles;
    private LocalDate transactionDate;

    public AccountTransaction(Long transactionId, Long accTypeId, Long memberId, Long gainedMiles, Long usedMiles, LocalDate transactionDate) {
        this.transactionId = transactionId;
        this.accTypeId = accTypeId;
        this.memberId = memberId;
        this.gainedMiles = gainedMiles;
        this.usedMiles = usedMiles;
        this.transactionDate = transactionDate;
    }

    public AccountTransaction() {
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
    public Long getGainedMiles() {
        return gainedMiles;
    }
    public void setGainedMiles(Long gainedMiles) {
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
}
