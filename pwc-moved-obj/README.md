## Example of LeanFT Application Model

Simple example how using the LeanFT Application Model along with Maven save time and effort when testing multiple versions of the same app.


The following steps you will need to have access to the following jar files that are a part of this project for convenience:

The following jar files need to be added to your Nexus repo or you can add them to your local Maven .m2 cache:

Execute the following from your IDE or from the command line if maven is installed on the native machine.  **YOU WILL** need to make sure you have the correct path to the jar files.
mvn install:install-file -Dfile=/home/hpe/IdeaProjects/AOSModel/target/AOSModel-1.1.66.jar -DgroupId=net.hpe -DartifactId=AOSModel -Dversion=1.1.66 -Dpackaging=jar
mvn install:install-file -Dfile=/home/hpe/IdeaProjects/AOSModel/target/AOSModel-1.1.99.jar -DgroupId=net.hpe -DartifactId=AOSModel -Dversion=1.1.99 -Dpackaging=jar
mvn install:install-file -Dfile=/home/hpe/IdeaProjects/AOSModel/target/AOSModel-1.1.99.1.jar -DgroupId=net.hpe -DartifactId=AOSModel -Dversion=1.1.99.1 -Dpackaging=jar

AOSModel-1.1.66.jar - English version of "PUT IN CART"
AOSModel-1.1.99.jar   - English version of "ADD TO CART"
AOSModel-1.1.99.1.jar - Spanish version of button "PUT IN CART" says "PONER EN CARRITO"