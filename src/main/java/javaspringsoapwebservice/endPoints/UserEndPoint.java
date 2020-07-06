package javaspringsoapwebservice.endPoints;

import javaspringsoapwebservice.services.UserService;
import   javaspringsoapwebservice.userGeneratedFromXML.GetUserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import javaspringsoapwebservice.userGeneratedFromXML.GetUserRequest;
import javaspringsoapwebservice.userGeneratedFromXML.User;


@Endpoint
public class UserEndPoint {

    @Autowired
   private UserService userService;

    @PayloadRoot(
            namespace = "http://www.hilalaissani.com/spring-soap-example",
            localPart = "getUserRequest"
    )
    @ResponsePayload
    GetUserResponse getUserRequest(@RequestPayload GetUserRequest getUserRequest){
        System.out.println("request ==> "+ getUserRequest.getName());

        User user =   userService.getUserByName(getUserRequest.getName());
     GetUserResponse userResponse = new GetUserResponse();
        userResponse.setUser(user);
        System.out.println("response   ==> "+  userResponse);
      return userResponse;
   }

}
