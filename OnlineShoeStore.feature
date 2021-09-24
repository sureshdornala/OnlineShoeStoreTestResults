@OnlineShoeStore
Feature: Shoe Store Feature File 
Scenario: Launch Website 
	When I Launch OnlineShoeStore 
		|  |  |  |

Scenario: Verify labels on Home Page		
	Then I Verify HomePage
		| label1 |  |  Welcome to Shoe Store! |
		| label2 |  | Pre-Order your shoes today | 
		| label3 |  | Choose a brand |
		| label4|	| Remind me of new shoes |
		| label5| 	| Promotional Code| 

Scenario: Search By Brand and Verify Results
	When I Seach By Brand
		| label1 |  | Valentino |
		
	Then I Verify Results By Brand
				| label1 |  | Valentino Camo Rockstud Pump |
				| label2 |  | $1,595.00  |