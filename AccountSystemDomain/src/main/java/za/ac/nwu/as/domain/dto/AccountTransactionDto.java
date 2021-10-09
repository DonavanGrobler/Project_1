package za.ac.nwu.as.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import za.ac.nwu.as.domain.persistence.AccountTransaction;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@ApiModel(value = "AccountTransaction", description = "A DTO that represents the AccountTransaction")
public class AccountTransactionDto implements Serializable {

    private static final long serialVersionUID = -7819344808062462808L;

    private Long AccountTypeId;
    private Long memberId;
    private Integer gainedMiles;
    private LocalDate transactionDate;

    public AccountTransactionDto(Long memberId, Integer gainedMiles, LocalDate transactionDate) {
        this.memberId = memberId;
        this.gainedMiles = gainedMiles;
        this.transactionDate = transactionDate;
    }

    public AccountTransactionDto(Long memberID, Long AccountTypeId, Integer gainedMiles) {
        this.memberId = memberId;
        this.AccountTypeId = AccountTypeId;
        this.gainedMiles = gainedMiles;
        this.transactionDate = LocalDate.now();
    }

    public AccountTransactionDto(AccountTransaction accountTransaction) {
        this.setMemberId(accountTransaction.getMemberId());
        this.setGainedMiles(accountTransaction.getGainedMiles());
        this.setTransactionDate(accountTransaction.getTransactionDate());
    }

    public AccountTransactionDto() {

    }

    @ApiModelProperty(position = 1,
            value = "Account Type ID fo the account transaction",
            name = "accountTypeId",
            notes = "Uniquely identifies the account type of the account on which a transaction was performed",
            dataType = "java.lang.Long",
            example = "3",
            required = true)
    public Long getAccountTypeId() {
        return AccountTypeId;
    }

    public void setAccountTypeId(Long accountTypeId) {
        AccountTypeId = accountTypeId;
    }


    @ApiModelProperty(
            position = 2,
            value = "Member ID",
            name = "memberId",
            notes = "Uniquely identifies a member",
            dataType = "java.lang.String",
            example = "1001",
            required = true
    )
    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    @ApiModelProperty(
            position = 3,
            value = "Gained Miles",
            name = "gainedMiles",
            notes = "Amount of gained miles on the member's account",
            dataType = "java.lang.String",
            example = "200",
            required = true
    )
    public Integer getGainedMiles() {
        return gainedMiles;
    }

    public void setGainedMiles(Integer gainedMiles) {
        this.gainedMiles = gainedMiles;
    }

    @ApiModelProperty(
            position = 4,
            value = "Transaction Date",
            name = "transactionDate",
            notes = "The date the transaction occurred",
            dataType = "java.lang.String",
            example = "2021-02-01",
            required = true
    )
    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }

    @JsonIgnore
    public AccountTransaction getTransaction() {
        return new AccountTransaction(getAccountTypeId(),getMemberId(),getGainedMiles(),getTransactionDate());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountTransactionDto that = (AccountTransactionDto) o;
        return Objects.equals(AccountTypeId, that.AccountTypeId) && Objects.equals(memberId, that.memberId) && Objects.equals(gainedMiles, that.gainedMiles) && Objects.equals(transactionDate, that.transactionDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(AccountTypeId, memberId, gainedMiles, transactionDate);
    }

    @Override
    public String toString() {
        return "AccountTransactionDto{" +
                "AccountTypeId=" + AccountTypeId +
                ", memberId=" + memberId +
                ", gainedMiles=" + gainedMiles +
                ", transactionDate=" + transactionDate +
                '}';
    }
}
