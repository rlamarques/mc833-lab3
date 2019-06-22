based on:
https://www.tutorialspoint.com/java_rmi

### Dependencies
Install and import the library `SQLite JDBC Driver`

### Config
You need to provide your SQLite database path in the file JDBCUtil.java at the variable `db_name`

### Running
compile the .java files: `javac *.java`  
run the rmiregistry in the default port `rmiregistry &`  
start the server `java Server`  
start the client `java Client`
the server should print the message