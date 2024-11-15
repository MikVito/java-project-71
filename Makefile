clean:
	cd app && ./gradlew clean

build:
	cd app && ./gradlew clean build

run:
	cd app && ./gradlew run --args="-h"

lint:
	cd app && ./gradlew checkstyleMain checkstyleTest

test:
	cd app && ./gradlew test

report:
	cd app && ./gradlew jacocoTestReport

install:
	cd app && ./gradlew clean install

check-updates:
	cd app && ./gradlew dependencyUpdates

.PHONY: build

run-dist:
	cd app && build\install\app\bin\App.bat

