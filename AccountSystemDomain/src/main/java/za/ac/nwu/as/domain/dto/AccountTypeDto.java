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
        this.startDate = startDate;
    }

    public AccountTypeDto(Long accTypeId, String mnemonic, String accName, LocalDate startDate) {
        this.accTypeId = accTypeId;
        this.mnemonic = mnemonic;
        this.accName = accName;
        this.startDate = startDate;
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
            value = "AccountType Start Date",
            name = "StartDate",
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
    public Long getAccTypeIdcTypeId() {
        return accTypeId;
    }
    @JsonIgnore
    public void setAccTypeId(Long accountTypeId) {
        this.accTypeId = accTypeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountTypeDto that = (AccountTypeDto) o;
        return Objects.equals(mnemonic, that.mnemonic) && Objects.equals(accName, that.accName) && Objects.equals(startDate, that.startDate);
    }

    @JsonIgnore
    public AccountType getAccountType() {
        return new AccountType(getMnemonic(),getAccName(),getStartDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(mnemonic, accName, startDate);
    }

    @Override
    public String toString() {
        return "AccountTypeDto{" +
                "mnemonic='" + mnemonic + '\'' +
                ", accName='" + accName + '\'' +
                ", startDate=" + startDate +
                '}';
    }
}
