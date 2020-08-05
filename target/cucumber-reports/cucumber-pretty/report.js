$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("LoginPage.feature");
formatter.feature({
  "line": 1,
  "name": "Log In feature",
  "description": "",
  "id": "log-in-feature",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 2,
  "name": "Log in with valid username and password",
  "description": "",
  "id": "log-in-feature;log-in-with-valid-username-and-password",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "I open URL",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "enter username and password",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "user on homepage",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginStepDef.i_open_URL()"
});
formatter.result({
  "duration": 23635884290,
  "status": "passed"
});
formatter.match({
  "location": "LoginStepDef.enter_username_and_password()"
});
formatter.result({
  "duration": 5653693353,
  "status": "passed"
});
formatter.match({
  "location": "LoginStepDef.user_on_homepage()"
});
formatter.result({
  "duration": 46662,
  "status": "passed"
});
});