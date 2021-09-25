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
	When I Search By Brand
		| label1 |  | Valentino |
		
	Then I Verify Results By Brand
				| label1 |  | Valentino Camo Rockstud Pump |
				| label2 |  | $1,595.00  |
				
				

Scenario: Search By Month and Verify Results
	
	When I Search By Month
		| label1 |  | February |
	
	Then I Verify Results By Month
				| label1 |  | Valentino Camo Rockstud Pump |
				| label2 |  | $1,595.00  |
	
	Then I Verify Results By Month
				| label1 |  | Jimmy Choo Kera Platform Sandal |
				| label2 |  | $2,195.00  |			
	
	When I Search By Month
		| label1 |  | June |			
		
	Then I Verify Results By Month
				| label1 |  | Old Gringo Diego Swarovski Boot |
				| label2 |  | $1,889.95  |
		Then I Verify Results By Month
				| label1 |  | Lanvin Pointy Toe Python Pump |
				| label2 |  | $1,550.00  |
				

Scenario: Search By All Shoes  - Force Failed Test with Incorrect Expected Results 
	
	When I Search By Month
		| label1 |  | All Shoes |			
	
	Then I Verify Results By Month
				| label1 |  | Valentino Camo Rockstud Pump |
				| label2 |  | $1,595.00  |
	
	Then I Verify Results By Month
				| label1 |  | Jimmy Choo Kera Platform Sandal |
				| label2 |  | $2,195.00  |			
	Then I Verify Results By Month
				| label1 |  | Old Gringo Diego Swarovski Boot |
				| label2 |  | $1,889.95  |
	Then I Verify Results By Month
				| label1 |  | Lanvin Pointy Toe Python Pump |
				| label2 |  | $1,5599999999999999999999.00  |					