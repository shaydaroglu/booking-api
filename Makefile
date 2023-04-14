dist: clean
	gradle build -x test --stacktrace

clean:
	rm -rf build

test-ci:
	gradle test --info
