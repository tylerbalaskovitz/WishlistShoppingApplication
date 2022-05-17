 //This is the file where our actual business logic will occur (like calls to an API)

 import axios from "axios";
 import { IUser } from "../store/types"
 import { NUser } from "../store/types"
 import { LOGIN_USER } from "./actionTypes";
 import { ADD_USER } from "./actionTypes";
 //There will be functionality here that use or change our User state object
 
 //interface that models the user's login credentials, we'll send in our POST request
 //second interface for new users
 
 
 interface CreateUser {
     username: string,
     password: string,
     firstname: string,
     lastname: string,
     email: string
 }
 
 
 //newuser functionality
 export const createUser = (createCreds:CreateUser) => async (dispatch:any) => {
 
     //create an empty object of type IUser - this will get filled on successful login
     let loggedInUser: NUser;
 
     try {
 
         //send my HTTP request with axios, and put it into a variable we can use
         const response = await axios.post('http://localhost:5000/createuser', createCreds);
 
         if(response.status === 202) { //if the login was successful...
             
             console.log(response)
             //populate our loggedInUser variable
             loggedInUser = {
                 id: response.data.id,
                 username: response.data.username,
                 password: response.data.password,
                 firstname: response.data.firstname,
                 lastname: response.data.lastname,
                 email: response.data.email
             }
 
             //now we actually DISPATCH (send) this data to the store
             //notice in the reducers, this is the type of data we need for the Action object
             return dispatch({
                 type: ADD_USER,
                 payload: createCreds
             })
 
         }
 
     } catch (e) {
         console.log("LOGIN FAILED!")
     }
 
 }
 