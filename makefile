default:
	javac common/*.java
	javac server/*.java
	javac client/*.java

runServer:
	java server/Server

runClient:
	java client/FrontController

clean:
	rm -rf common/*.class
	rm -rf server/*.class
	rm -rf client/*.class
