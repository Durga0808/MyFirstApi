package com.testAPI.MyFirstAPI;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class APIEndPoints {
    HashMap<Integer,User> userDB=new HashMap<>();
    @GetMapping("/getWeatherDetails")
    public String getWeatherInfo(){
        return "Today's weather was very hot and rainy";
    }
    
    
    @GetMapping("/calculateSum")
    public String getCalculateSum(@RequestParam("n1") Integer n1,@RequestParam("n2") Integer n2){
        int sum=n1+n2;
        return "The sum is "+sum;
    }
    @PostMapping("/signUpUser")
    public String signUpUser(@RequestBody User user){
        //I have got user objet
        // I need to save it inside DB for that get key

        int primaryKey=user.getUserId();
        userDB.put(primaryKey,user);

        return "User with the name "+user.getName()+" has been added to DB successfully";

    }
    @GetMapping("/getUserByID")

    public User findUserById(@RequestParam("UserId") Integer UserId){
        if(userDB.containsKey(UserId)){
            User user=userDB.get(UserId);

            return user;
        }else{
            System.out.print("User not found");
            return null;
        }

    }

    @GetMapping("/getListOfPeople/{city}")
    public List<User>getListOfUsers(@PathVariable("city")String city){
        List<User> ansList=new ArrayList<>();
        for(User user:userDB.values()){
            if(user.getCity().equals(city)){
                ansList.add(user);
            }
        }
        return ansList;
    }
    @GetMapping("/getListOfPeoplewithname/{name}")
    public List<User>getListOfUser(@PathVariable("name")String name){
        List<User> ansList=new ArrayList<>();
        for(User user:userDB.values()){
            if(user.getName().equals(name)){
                ansList.add(user);
            }
        }
        return ansList;
    }
    @PutMapping("/updateUserInfo")
    public String updateUser(@RequestBody User updatedUserDetails, @RequestParam("UserId") Integer userId){
        int primaryKey=userId;
        userDB.put(primaryKey,updatedUserDetails);
        return "new user Details Updated with usedId"+primaryKey;
    }

    @DeleteMapping("/deleteUser/{name}")
    public String deleteUser(@PathVariable("name")String name){
        System.out.print(name);
//        userDB.entrySet().removeIf(entry -> userDB.containsValue(entry.getKey()));
        List<Integer>keys=new ArrayList<>();
        for(int Key: userDB.keySet()){
            if(userDB.get(Key).getName().equals(name)){
                keys.add(Key);
            }
        }
        for(int k:keys){
            userDB.remove(k);
            System.out.println ("userid "+k+" deleted");
        }

        return "Users having name "+name+" is removed from DB";
    }
}
