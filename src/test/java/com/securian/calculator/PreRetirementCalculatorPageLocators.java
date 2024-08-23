package com.securian.calculator;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@Getter
@Setter
public class PreRetirementCalculatorPageLocators {

    String currentAge = "#current-age";
    String retirementAge = "#retirement-age";
    String currentIncome = "#current-income";
    String spousesAnnualIncome = "//*[@id=\"spouse-income\"]";
    String currentRetirementSavingBalance = "#current-total-savings";
    String currentlySavingForRetirementEachYear = "#current-annual-savings";
    String rateOfIncreaseInSavingsEachYear = "#savings-increase-rate";
    String socialSecurityIncomeRadioButton = "#social-security-benefits";
    String maritalStatusSingleRadioButton = "//*[@id=\"marital-status-ul\"]/li[1]/label";
    String maritalStatusMarriedRadioButton = "//*[@id=\"marital-status-ul\"]/li[2]/label";
    String calculateButton = "Calculate";
    String socialSecurityOverride = "#social-security-override";
    String resultConfirmation = "#result-message";

    String additionalIncome = "#additional-income";
    String yearsRetirementNeedsToLast = "#years-retirement-needs-to-last";
    String postRetirementIncomeInflation = "#post-retirement-income-inflation";
    String percentFinalAnnualIncomeDesired = "#percent-final-annual-income-desired";
    String preRetirementInvestmentReturn = "#pre-retirement-investment-return";
    String postRetirementInvestmentReturn = "#post-retirement-investment-return";

    String socialSecuirtyIncome_yes = "//*[@id=\"include-social-container\"]/ul/li[1]/label";
    
    String socialSecuirtyIncome_no = "//*[@id=\"include-social-container\"]/ul/li[2]/label";

    String editInfo = "Edit Info";
    

}
