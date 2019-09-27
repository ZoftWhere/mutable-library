Release Notes v1.2.1

- Maven POM updated to module-info.java in source artifact.
- Maven POM updated to fix/remove maven-javadoc-plugin not creating package-list.
- Maven POM updated for known issue with maven-surefire-plugin; exceptions occurring when module-info.java file is in the path and/or reuseForks is false.
- Updated archived artifact entries in production jar file (including fields in manifest file).
- Updated read me with correct Maven execution for creating/installing artifacts to local repository.