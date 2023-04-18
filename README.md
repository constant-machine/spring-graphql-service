# spring-graphql-service project
This is GraphQL sandbox web server on Spring. Built with graphql-java-kickstart libraries, which are may be less suitable for real use than Netflix or Spring for GraphQL dependencies.

To run that project one needs to provide postgres instance and can configure connection with env variables:
${DB_HOST}, ${DB_USER}, ${DB_PASS}, ${DB_MAX_POOL_SIZE}

run and visit http://localhost:8080/graphiql to make queries
