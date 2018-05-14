# packlinkPro
The proposed solution has been implemented with cucumber, selenium and java.

Three features have been included:
Register.feature
Search.feature
DraftShipments.feature

You can execute directly in the IDE from the TestRunner file (in Intellij for instance) changing the tag of the test or feature that you want to execute.

Also you can excute the instruction below including the tag of the scenario that want to run.

Eg:
mvn clean install -Dcucumber.options="-t @Register-ValidateFields"
(maven will be required)
