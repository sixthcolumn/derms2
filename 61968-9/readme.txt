Due to a problem with compatability of the axiom commons library, you must
now do the following command to generate sources. If you attempt to build
generate-sources without the profile, the library steps on something and
the wsdl2java fails.

csh: mvn generate-sources -Pwsdl


other commands :

csh: mvn compile
csh: mvn package // builds the epriConnect.war file


generate new database html files :

safe because it genereates to target/hibernate3

csh : mvn hibernate3:hbm2java


All other mvn commands are fine and do not require the profile wsdl.
