## Running Tests

### Regular Tests

```shell
mvn test
```

### Mutation Testing

```shell
mvn -DwithHistory test org.pitest:pitest-maven:mutationCoverage
```

`test` is not required _every_ time, but has to be ran at least once prior to launch of PIT, otherwise coverage report
will be all red.

Reference: [PIT - Maven Quick Start](https://pitest.org/quickstart/maven/).