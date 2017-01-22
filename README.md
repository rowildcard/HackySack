# HackySack
Pendo Automation Challenge
01-22-2017
Rhonda Oglesby

Java 1.8
Selenium 3.0.1
Maven 3.5.1
TestNG 6.9.6
Eclipse Neon

CHALLENGE:
1. In a Chrome browser, navigate to www.google.com and search for the term "hacky sack" (pass)
2. On the results page, click Shopping (pass)
3. Click into the 4th shopping result (pass)
4. Click 'Save to Shortlist' (pass)
5. Add a Note, saying "Please buy me" (fail) - could not figure out how to click the "Add Note" button on the alertdialog

BROWSER
Chrome 45 (run incognito)

DATA
Stirng - Google user and password
String - Product search string
int    - Nth product result

GOAL
To see what I could accomplish in the alotted 24 hour time frame and submit that for code review. 
I think this gives you a good overview of my experience with automation, staying within the same bounds as other applicants. 

RESULTS
The test runs successfully but the last challenge, Add a Note saying "Please buy me", was attempted but not accomplished.

NOTES
1. Clean up needs to be done at the end of the test to delete all products or the most recent product from the test user's 
shortlist. If, per chance, the 4th product result is exactly the same as the last time the test was run, the 
"Save to Shortlist" button changes to "Saved to Shortlist". When clicked, it removes the product from the Shortlist 
and the rest of the test will fail. 

2. If the test suite expands, the page objects and other utilities should be broken out.

3. Although the xpath worked consistenatly for selecting the Nth product on the Shopping page, more research should be
done to ensure this is not too tenuous a solution. 

4. Could not figure out how to click the "Add Note" link on the alertdialog that appears after "Save to Shortlist" click.
Using a RegEx cssSelector resulted in selenium.ElementNotVisibleException. A wait did not resolve this issue.

5. A work around for 2 was to click "Show Shortlist" and add the note on that page but I think the presence of the 
alertdialog prevented this click from working. No errors. Just nothing happened. 
