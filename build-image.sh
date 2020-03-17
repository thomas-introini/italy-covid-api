./mvnw clean install
mkdir "target/dependency"
(cd target/dependency || exit; jar -xf ../*.jar)

VERSION=$(xmllint --xpath "//*[local-name()='project']/*[local-name()='version']/text()" pom.xml)
docker build -t it.introini/covid-cpc-api:"$VERSION" .
docker tag it.introini/covid-cpc-api:"$VERSION" eu.gcr.io/covid-270517/covid-cpc-api:"$VERSION"
docker push eu.gcr.io/covid-270517/covid-cpc-api:"$VERSION"