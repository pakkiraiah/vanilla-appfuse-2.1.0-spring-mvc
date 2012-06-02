vanilla-appfuse-2.1.0-spring-mvc
================================

Vanilla Appfuse 2.1.0 project (Spring MVC + Hibernate), including full-source, templates and eclipse project files

mvn archetype:generate -B -DarchetypeGroupId=org.appfuse.archetypes -DarchetypeArtifactId=appfuse-basic-spring-archetype -DarchetypeVersion=2.1.0 -DgroupId=foo.bar -DartifactId=baz -DarchetypeRepository=http://oss.sonatype.org/content/repositories/appfuse

# use maven 2.2.1 not 3.0.4 for full-source
cd baz
/opt/apache-maven-2.2.1/bin/mvn appfuse:full-source

mvn appfuse:copy-templates
cd src/test/resources/appfuse/model/
sed -i -e "s/generateJoinColumnsAnnotation(property/generateJoinColumnsAnnotation(property,cfg/" Ejb3PropertyGetAnnotation.ftl 
cd ../../../../..

mvn org.apache.maven.plugins:maven-eclipse-plugin:2.6:eclipse
