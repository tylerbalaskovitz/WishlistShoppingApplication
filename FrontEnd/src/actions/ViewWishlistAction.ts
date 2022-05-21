 //This is the file where our actual business logic will occur (like calls to an API)

 import axios from "axios";
import { useSelector } from "react-redux";
 import { ViewWishlist } from "../components/ViewWishlist/ViewWishlist";
 import { nItem } from "../store/types"
 import { VIEW_WISHLIST } from "./actionTypes";
 //There will be functionality here that use or change our User state object
 
 //interface that models the user's login credentials, we'll send in our POST request
 //second interface for new users
 
 
 
 export const viewWishList = () => async (dispatch:any) => {
    console.log("got here")
    const appState = useSelector<any, any>((state) => state);
    
 
     try {
        console.log("got here2")
         //send my HTTP request with axios, and put it into a variable we can use
         const response = await axios.get('http://localhost:5000/userwishlist' + appState.user_id);
 
         if(response.status === 202) { //if the login was successful...
             
             console.log(response)
             //populate our loggedInUser variable
 
             //now we actually DISPATCH (send) this data to the store
             //notice in the reducers, this is the type of data we need for the Action object
             return dispatch({
                 type: VIEW_WISHLIST,
             })
 
         }
 
     } catch (e) {
         console.log("Error")
     }
 
 }