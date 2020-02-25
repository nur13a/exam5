package com.Server;

import com.Dao.DB;
import com.Model.User;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/users")
public class Server {
    DB db = new DB();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getUsers_JSON() {
        return db.getAllUsers();
    }

    @GET
    @Path("/{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    public User getUserById(@PathParam("userId") Integer userId) {
        return db.getUserById(userId);
    }

    @GET
    @Path("/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public User getUserByName(@PathParam("name") String name) {
        return db.getUserByName(name);
    }

    @GET
    @Path("/{gender}")
    @Produces(MediaType.APPLICATION_JSON)
    public User getUserByGender(@PathParam("gender") String gender) {
        return db.getUserByGender(gender);
    }

@GET
    @Path("/delete{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public boolean getUserByGender(@PathParam("id") Integer id) {
        return db.deleteUser(id);
    }

}
