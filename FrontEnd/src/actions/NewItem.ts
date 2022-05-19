import axios from "axios";
 import { nItem } from "../store/types"
 import { ADD_ITEM } from "./actionTypes";

 interface addItem {
    id: string,
    title: string,
    price: string,
    description: string,
    category: string,
    image: string,
}

//newuser functionality
export const addNewItem = (addItemCreds:addItem) => async (dispatch:any) => {
    //create an empty object of type IUser - this will get filled on successful login
    let newItem: nItem;

    try {
        //send my HTTP request with axios, and put it into a variable we can use
        const response = await axios.post('http://localhost:5000/addnewitem', addItemCreds);

        if(response.status === 202) { //if the login was successful...
            
            console.log(response)
            //populate our loggedInUser variable
            addItemCreds = {
                id: response.data.id,
                title: response.data.title,
                price: response.data.price,
                description: response.data.description,
                category: response.data.category,
                image: response.data.image
            }

            //now we actually DISPATCH (send) this data to the store
            //notice in the reducers, this is the type of data we need for the Action object
            return dispatch({
                type: ADD_ITEM,
                payload: addItemCreds
            })

        }

    } catch (e) {
        console.log("LOGIN FAILED!")
    }

}