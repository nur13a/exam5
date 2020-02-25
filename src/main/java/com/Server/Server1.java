package com.Server;

import com.Dao.DB;
import com.GetMessage;
import com.Model.User;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("/users1")
public class Server1 {
DB db=new DB();
    @POST
    @Consumes("application/json")
    public String add(User u) throws Exception {
        db.addUser(u);
        if(u.getBirthDate()>2000)
            throw new Exception();
        return GetMessage.getMessage(u);

    }
}
