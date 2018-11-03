Feature: Cash Withdrawal
	Scenario: Successful withdrawal from an account in credit
		Given I have deposited $100.00 in my account
		When I withdraw $20
		Then $20 should be dispensed
		And the balance of my account should be $80.00
		
	Scenario: Insufficient funds for withdrawal
		Given I have deposited $40.00 in my account
		When I withdraw $50
		Then $0 should be dispensed
		And I should be notified of insufficient funds