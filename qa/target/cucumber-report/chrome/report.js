$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("test.feature");
formatter.feature({
  "line": 2,
  "name": "Lead Testing",
  "description": "I want to test Various leads used in Project",
  "id": "lead-testing",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@First"
    }
  ]
});
formatter.background({
  "line": 5,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 6,
  "name": "user is on Homepage",
  "keyword": "Given "
});
formatter.match({
  "location": "StepDef.user_is_on_Homepage()"
});
formatter.result({
  "duration": 169455302,
  "status": "passed"
});
formatter.scenario({
  "line": 9,
  "name": "Verify Get updates form",
  "description": "",
  "id": "lead-testing;verify-get-updates-form",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 10,
  "name": "user clicks on Get updates Link",
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "user verifies Golf form",
  "keyword": "Then "
});
formatter.step({
  "line": 12,
  "name": "user enters details",
  "keyword": "And "
});
formatter.step({
  "line": 13,
  "name": "user click on submit button",
  "keyword": "And "
});
formatter.match({
  "location": "StepDef.user_clicks_on_Get_updates_Link()"
});
formatter.result({
  "duration": 915220241,
  "status": "passed"
});
formatter.match({
  "location": "StepDef.user_verifies_Golf_form()"
});
formatter.result({
  "duration": 44131946,
  "status": "passed"
});
formatter.match({
  "location": "StepDef.user_enters_details()"
});
formatter.result({
  "duration": 4355488061,
  "status": "passed"
});
formatter.match({
  "location": "StepDef.user_click_on_submit_button()"
});
formatter.result({
  "duration": 18302196156,
  "status": "passed"
});
});