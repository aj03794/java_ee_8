package restservice;

import models.Todo;
import scopes.RequestScope;
import scopes.SessionScope;
import services.TodoService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/todo")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TodoRest {

    @Inject
    TodoService todoService;

    @Inject
    RequestScope requestScope;

    @Inject
    SessionScope sessionScope;

    // Could also just make return type Todo in the method definition
    // To hit this endpoint
    // /api/v1/todo/new
    @Path("/new")
    @POST
    public Response createTodo(Todo todo) {
        todoService.createTodo(todo);
        return Response.ok(todo).build();
    }

    @Path("/update")
    @PUT
    public Response updateTodo(Todo todo) {
        todoService.updateTodo(todo);
        return Response.ok(todo).build();
    }

    @Path("/{id}")
    @GET
    public Todo getTodo(@PathParam("id") Long id) {
        return todoService.findTodoById(id);
    }

    @Path("/list")
    @GET
    public List<Todo> getTodo() {
        System.out.println("Request scope" + requestScope.getHashCode());
        System.out.println("Session scope" + sessionScope.getHashCode());
        return todoService.getTodos();
    }


    @Path("/ping")
    @GET
    public String ping() {
        return "Hello world";
    }

    @Path("/status")
    @POST
    public Response markAsComplete(@QueryParam("id") Long id) {
        var todo = todoService.findTodoById(id);
        todo.setCompleted(true);
        todoService.updateTodo(todo);
        return Response.ok(todo).build();
    }
}
