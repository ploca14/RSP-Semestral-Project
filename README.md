#Postgresql
1) Create database with name "musicals" with owner 'postgres'
2) Add password "12345" to "postgres" role

#Tomcat
After running application, tomcat server should be started on "http://localhost:8080/musicals"

#GraphQL
1) Run application
2) Go to "http://localhost:8080/musicals/graphiql"

* Tip: use 'Ctrl + space' for hint, while creating queries and mutations.

##GraphQL query and mutation examples:
###Query that finds by id 
query
{
    post(id: 0) 
    {
        title,
        author
    }
}

###Query that finds all
query 
{
    posts 
    {
        id,
        title,
        author,
        type,
        createdDate
    }
}

###Mutation that creates
mutation
{
    createPost(title: "CreatedPost", author:"Tester", type: "Test")
    {
        id,
        title,
        author,
        type,
        createdDate
    }
}