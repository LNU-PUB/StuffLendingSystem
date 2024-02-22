<center><h1>Test Specification</h1></center>

## Test Cases

For tst results see the [Test Results](/testreport.md).

<pre>
  <code>
1.1 Create Member

Requirement: 1.1, 1.1.1, 1.4

    Create a member with name: "Allan Turing", email: "allan@enigma.com", phone: "123456"
    Check that the member is created correctly with an id according to the requirement by checking the members full information.
    Quit the application

1.2 Create Member - Duplicate Email and Phone

Requirement: 1.1, 1.1.1, 1.1.2, 1.4

    Create a member with name: "Allan", email: "allan@enigma.com", phone: "123456"
    Check that the member is created correctly with an id according to the requirement by checking the members full information.
    Create a member with name: "Turing", email: "allan@enigma.com", phone: "123"
    Check that the member is not created (duplicate email)
    Create a membner with name: "Turing", email: "turing@enigma.com", phone: "123456"
    Check that the member is not created (duplicate phone)
    Create a member with name "Turing" , email: "turing@enigma.com", phone: "123"
    Check that the member is created correctly with an id according to the requirement by checking the members full information.
    Quit the application

1.3 Delete Member

Requirement: 1.1, 1.1.1, 1.1.2, 1.4

    Create a member with name: "Allan", email: "allan@enigma.com", phone: "123456"
    Check that the member is created correctly with an id according to the requirement by checking the members full information.
    Delete the member
    Check that the member is deleted by listing all members (simple)
    Create a member with name: "Allan", email: "allan@enigma.com", phone: "123456"
    Check that the member is created correctly with an id according to the requirement by checking the members full information.
    Quit the application.

2.1 Create item

Requirement: 2.1, 2.1.1

    Create an item for a Member
    Check that the item is created and part of the Members items by inspecting the member's details.
    Check that the owner member has increased it's credits with 100

2.2 Delete item

Requirement: 2.2

    Select a member with one or several items
    Delete one of the member's items that is not involved in any contract
    Check that the item was deleted from the members owned items

2.3 Delete item

Requirement: 2.2

    Select a member with one or several items
    Delete one of the member's items that is booked (i.e. a future contract)
    Check that the item was deleted from the members owned items
    Check that the contract was cancelled

3.1 Create Contract

Requirement: 3.1, 3.1.1

    Create a contract for I2 lending to M2, 3 days of lending, day 1 to and including day 3
    Check that the contract was created
    Check that funds were transferred

3.2 Create Contract - not enough funds

Requirement: 3.1.2

    Create a contract for I1 lending to M2, 3 days of lending (e.g. day 1 to and including day 3)
    Check that the contract was not created due to lack of funds

3.3 Create Contract - conflicting time

Requirement: 3.1.3

    Create a contract for I2 lending to M2, 3 days of lending, day 4 to and including day 6
    Check that the contract was not created due to conflicting time

3.4 Create Contract - conflicting time

Requirement: 3.1.3

    Create a contract for I2 lending to M2, 3 days of lending, day 6 to and including day 9
    Check that the contract was not created due to conflicting time

3.5 Create Contract - conflicting time

Requirement: 3.1.3

    Create a contract for I2 lending to M2, 3 days of lending, day 4 to and including day 9
    Check that the contract was not created due to conflicting time

3.6 Create Contract - conflicting time

Requirement: 3.1.3

    Create a contract for I2 lending to M2, 3 days of lending, day 6 to and including day 6
    Check that the contract was not created due to conflicting time

4.1 Advance time

Requirement: 4.1, 4.2 3.1.1

    Advance the time 8 days.
    Check that the contract has been fulfilled and that funds have been deduced from M3 who now has 70 credits.

5.1 Member Data

Requirement: 5, (not specified in the functional requirements for the project)

    Check that there are at least 3 Members.
    Check that one member (M1) with 500 credits. M1 has two items for lending, I1 with cost 50 one cheap I2 cost 10
    Check that one member (M2) with 100 credits. M2 has no items for lending.
    Check that one member (M3) with 100 credits has an active lending contract for I2 that starts on day 5 and ends on day 7 (3 days).
  </code>
</pre>