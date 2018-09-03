INRO- Recommended IDE for the project is Intellij. Project has been developed and tested on a windows platform

PROJECT STRUCTURE:
Under the SRC lies 2 directories; I) main and II) test

I) main has Pages and Support packages. Pages house all the classes that pertain to web pages of the particular project the Support has 3 classes 1) BaseClass, 2) ElementUtils and 3) WebModel

1)BaseClass has @Before and @After methods that run before and after each scenario. @Before has methods to open the browser, expand it and pass the url. the url comes from config.properties file that lies under text/resources. @After has methods that capture a screenshot upon scenario failure. it also has methods to tear down the browser after each scenario execution.

ElementUtils houses all the custom written generic methods used in the project. the ElementUtils class has getProperty method that fetches data from the config.properties file based on the key-value pattern. the browser to execute the tests on is also supplied from here. browsers supported: Chrome and PhantomJS (headless browser)

WebModel class has objects created for all the classes in Pages and Support packages and are called via return type methods

II) test has 1) JAVA and 2) Resources

JAVA has Step definitions to the featureFiles. RunnerTest (the main trigger to fire up the tests) lies here. Tests could be cherry picked based on the tags provided in the RunnerTest class.
Resources has feature files and config.properties file.

REPORT GENERATION extant reports are generated under the output directory that lies on the top of the src. upon test execution a .html file is created which could be opened in any browser of choice. the report look quite similar to the JENKINS generated Cucumber reports. the .png format screenShots captured upon scenario failure are also stored here.

TEST EXECUTION Rightclick on the runnerTest and click Run. feature files could also be run based on the tags in RunnerTest class. 