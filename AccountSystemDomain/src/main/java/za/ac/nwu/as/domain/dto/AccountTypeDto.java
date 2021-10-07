package za.ac.nwu.as.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import za.ac.nwu.as.domain.persistence.AccountType;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@ApiModel(value = "AccountType", description = "A DTO that represents the AccountType")

public class AccountTypeDto implements Serializable{

    private String mnemonic;
    private String accName;
    private LocalDate startDate;

    public AccountTypeDto(){
    }

    public AccountTypeDto(String mnemonic, String accName, LocalDate startDate){

    }
}
