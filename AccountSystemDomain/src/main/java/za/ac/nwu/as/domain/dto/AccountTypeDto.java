package za.ac.nwu.as.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import za.ac.nwu.as.domain.persistence.AccountType;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@ApiModel(value = "AccountType", description = "A DTO that represents the AccountType")
public class AccountTypeDto implements Serializable {
    private static final long serialVersionUID = -5346853206480289868L;

    private Long accTypeId;
    private String mnemonic;
    private String accName;
    private LocalDate startDate;

    public AccountTypeDto(String mnemonic, String accName, LocalDate startDate) {
        this.mnemonic = mnemonic;
        this.accName = accName;
        this.accName = startDate;
    }

    public AccountTypeDto(Long accountTypeID, String mnemonic, String accName, LocalDate startDate) {
        this.accountTypeId = accountTypeId;
        this.mnemonic = mnemonic;
        this.accountTypeName = accName;
        this.creationDate = startDate;
    }

    public AccountTypeDto(AccountType accountType) {
        this.setAccName(accountType.getAccName());
        this.setStartDate(accountType.getStartDate());
        this.setMnemonic(accountType.getMnemonic());
    }

    public AccountTypeDto() {

    }

    @ApiModelProperty(
            position = 1,
            value = "AccountType Mnemonic",
            name = "Mnemonic",
            notes = "Uniquely identifies the account type",
            dataType = "java.lang.String",
            example = "MILES",
            required = true
    )
    public String getMnemonic() {
        return mnemonic;
    }

    public void setMnemonic(String mnemonic) {
        this.mnemonic = mnemonic;
    }

    @ApiModelProperty(
            position = 2,
            value = "AccountType Name",
            name = "Name",
            notes = "The name of the account type",
            dataType = "java.lang.String",
            example = "Miles",
            allowEmptyValue = false,
            required = true
    )
    public String getAccName() {
        return accName;
    }

    public void setAccName(String accName) {
        this.accName = accName;
    }

    @ApiModelProperty(
            position = 3,
            value = "AccountType Creation Date",
            name = "CreationDate",
            notes = "This is the date on which the account type was created",
            dataType = "java.lang.String",
            example = "2021-01-01",
            allowEmptyValue = true
    )
    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    @JsonIgnore
    public Long getAccountTypeId() {
        return accountTypeId;
    }
    @JsonIgnore
    public void setAccountTypeId(Long accountTypeId) {
        this.accountTypeId = accountTypeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountTypeDto that = (AccountTypeDto) o;
        return Objects.equals(mnemonic, that.mnemonic) && Objects.equals(accountTypeName, that.accountTypeName) && Objects.equals(creationDate, that.creationDate);
    }

    @JsonIgnore
    public AccountType getAccountType() {
        return new AccountType(getMnemonic(),getAccountTypeName(),getCreationDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(mnemonic, accountTypeName, creationDate);
    }

    @Override
    public String toString() {
        return "AccountTypeDto{" +
                "mnemonic='" + mnemonic + '\'' +
                ", accountTypeName='" + accountTypeName + '\'' +
                ", creationDate=" + creationDate +
                '}';
    }
}
