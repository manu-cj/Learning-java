package org.manu.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
public class FidelityCard {
    private UUID id;
    private String firstname;
    private String lastname;
    private LocalDate birthday;
    private String email;
    private LocalDate createdDate;
    private long pointsBalance;
    private BigDecimal totalSpent;


    // Method for add points and update total spent
    public void addPurchase(BigDecimal amount, long pointsEarned) {
        if (amount.compareTo(BigDecimal.ZERO) > 0) {
            this.totalSpent = this.totalSpent.add(amount);
        }
        if (pointsEarned > 0) {
            this.pointsBalance += pointsEarned;
        }
    }

    // Method for use points
    public boolean redeemPoints(long pointsToRedeem) {
        if (pointsToRedeem > 0 && this.pointsBalance >= pointsToRedeem) {
            this.pointsBalance -= pointsToRedeem;
            return true; // Points use with success
        }
        return false; // Need more points or invalid value
    }

}
