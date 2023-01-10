$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/main/resources/Login.feature");
formatter.feature({
  "name": "Login Function Test",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@SmokeTest"
    }
  ]
});
formatter.scenario({
  "name": "",
  "description": "\tAs a Luma application user, must do successfully login with valid credential ",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@SmokeTest"
    },
    {
      "name": "@TC_1233"
    }
  ]
});
formatter.step({
  "name": "Open a browser",
  "keyword": "Given "
});
formatter.match({
  "location": "StepDef.open_a_browser()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "go to application URL",
  "keyword": "And "
});
formatter.match({
  "location": "StepDef.go_to_application_URL()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Click sign in button",
  "keyword": "When "
});
formatter.match({
  "location": "StepDef.click_sign_in_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "put email",
  "keyword": "And "
});
formatter.match({
  "location": "StepDef.put_email()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "put password",
  "keyword": "And "
});
formatter.match({
  "location": "StepDef.put_password()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click second sign in button",
  "keyword": "And "
});
formatter.match({
  "location": "StepDef.click_second_sign_in_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "validate login was successful",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDef.validate_login_was_successful()"
});
formatter.result({
  "status": "passed"
});
});