**SOFTWARE TESTING PROJECT : CLIENT SIDE TESTING (BYPASS TESTING)**<br /><br />
Values that violate constraints on the inputs, as defined by client-side information.<br />
Client-side script validation: Programs run on the client to check the syntax of input data before
sending it to the server. Uses explicit attributes associated with HTML form fields. Example, a text
box can be set to only allow strings up to a maximum length.<br />
Bypass testing creates inputs that intentionally violate these validation rules and constraints. Created
inputs are directly submitted to the web application without letting the web page validate them.
<br />

**TOOL USED FOR TESTING:**<br />
**Burp Suite Community Edition:** https://portswigger.net/burp/releases/professional-community-2023-10-3-6?requestededition=community&requestedplatform=
<br />
This involved strategically enabling the intercept feature at specific points within the system where we aimed to assess its resilience.
<br />
By activating the intercept, we were able to pause the communication flow at desired junctures, allowing us
to modify and inspect values before allowing the traffic to proceed.
<br />
This approach provided valuable insights into the system’s behavior and allowed us to identify potential
vulnerabilities by assessing its response to manipulated inputs.
<br />

**SELENIUM**:<br />
In order to conduct thorough client-side testing, we leveraged the Selenium framework, utilizing the
ChromeDriver to automate the web browser for testing purposes. This approach allowed us to simulate user
interactions with the application’s graphical user interface. By programmatically opening browser windows,
we systematically navigated through the application, interacting with various fields and submitting data.
<br />
Our test scenarios were implemented using Java, taking advantage of Selenium’s capabilities to locate web
elements, perform actions such as inputting data into fields, and navigating through different pages. This
comprehensive testing methodology not only verified the correctness of user inputs but also assessed the
application’s responsiveness to diverse user interactions.
<br />

**TEAM MEMBER WISE CONTRIBUTIONS:**
<br />

Customer and Bookings managed by TUSHAR NAGPAL.<br />
Owner and Properties managed by UTKARSH SHRIVASTAVA <br />

**Backend:**
<br />
 <table>
  <tr>
    <th>CONTRIBUTOR NAME</th>
    <th>API</th>
    <th>API DESCRIPTION</th>
  </tr>
  <tr>
    <td>TUSHAR NAGPAL<td>
    <td>/api/customers/</td>
    <td>register new customer</td>
  </tr>
  <tr>
    <td>TUSHAR NAGPAL<td>
    <td>/api/customers/login</td>
    <td>customer login using phone and password</td>
  </tr>
</table> 