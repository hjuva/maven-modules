To run this example:

cd to "delivery-maven-plugin" and run "mvn install".
cd to "example" and run "mvn initialize". This will execute the global
build.

Change the versions in the POMs and run the global build again. Try the
scenarios described in the blog posts.


mvn versions:use-next-versions versions:commit -Dincludes=com.acme:service-api -DallowSnapshots=true