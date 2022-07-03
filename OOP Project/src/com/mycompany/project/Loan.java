package com.mycompany.project;

public class Loan {

    public float loanCalculator(float loanAmount, float percent) {
        float loan =  (loanAmount*percent)/100.0f;
        return loan;
    }

    public float installmentsCalculator(float loanGranted, int installmentTime) {
        float installmentAmount = loanGranted / installmentTime;
        return installmentAmount;
    }

}
