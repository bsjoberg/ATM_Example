Feature: Cash Withdrawal
	Scenario: Successful withdrawal from an account in credit
		Given my account has been credited with $100.00
		When I withdraw $20
		Then $20 should be dispensed
		And the balance of my account should be $80.00
		
	Scenario: Insufficient funds for withdrawal
		Given my account has been credited with $40.00
		When I withdraw $50
		Then $0 should be dispensed
		And the balance of my account should be $40.00
		And I should be notified of insufficient funds