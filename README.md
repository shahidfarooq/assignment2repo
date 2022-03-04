# assignment2repo

Configuration are located in package com.shahid.mercans.assignment2.configuration.config.properties as shown below

# Properties for connecting to database and pooling configuration
mysql.url=
mysql.username=
mysql.password=
mysql.maximumPoolSize=

#file path for CSV
file.path=

Adjust the configuration as per your environment. 

# Executing the application
To execute the application main class is located in com.shahid.mercans.assignment2 package. Run it as java application or you can use maven to generate build execute in any environment using java- jar <build_name.jar>. 

# Testing application
Once application is started you will be able to use Rest endpoints verify the application

http://localhost:8080/parser/csv/{filename}

Url takes filename as input which is to be processed and has to be placed on path set in configuration.
