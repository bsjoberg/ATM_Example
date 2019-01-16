Feature: Cash Withdrawal
	Scenario: Successful withdrawal from an account in credit
		Given I have deposited $100.00 in my account
		When I withdraw $20
		Then $20 should be dispensed
		And the balance of my account should be $80.00
		
	Scenario: Insufficient when withdraw from a low balance account
		Given I have deposited $50.00 in my account
		When I withdraw $100
		Then $0 should be dispensed