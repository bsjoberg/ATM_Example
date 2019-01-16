Feature: Cash Withdrawal
	Scenario: Successful withdrawal from an account in credit
		Given my acccount has been credited with $100.00
		When I withdraw $20
		Then $20 should be dispensed
		And the balance of my account should be $80.00
		
	Scenario: Insufficient when withdraw from a low balance account
		Given my acccount has been credited with $50.00
		When I withdraw $100
		Then $0 should be dispensed