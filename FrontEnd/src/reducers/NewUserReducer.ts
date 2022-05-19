import { ADD_USER } from "../actions/actionTypes";
import { NUser } from "../store/types";
//reducers are responsible for calculating and sending new state data to the store
//this is the user reducer, which will help us calculate changes in the User

let initialState:NUser = {

    username:"",
    password:"",
    firstName:"",
    lastName:"",
    userEmail:""
} 

//this is an object that will determine what actions to take
type Action = {type:string, payload:any};

//the reducer will take in an IUser object, which is meant to update intialState^
//it will also take in an Action that contains what action to take, and what data it has (payload)
export const NewUserReducer = (state:NUser = initialState, action: Action) => {
    //switch based on the type in the Action object
    //look at loginUser in the UserACtions to see where this is coming from
    switch(action.type){
        case ADD_USER:
            initialState = action.payload
            return {
                ...initialState
            }
        default:
            return state
    }
}