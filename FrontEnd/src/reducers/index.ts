//this file is going to combine our UserReducer and PokeReducer
//it'll act as a one stop shop for new data coming in that needs to be dispatched

import { combineReducers } from "redux";

import { NewUserReducer } from "./NewUserReducer";

import { UserReducer } from "./UserReducer";

import { NewItemReducer } from "./NewItemReducer";
import { DeleteItemReducer } from "./DeleteItemReducer";

export default combineReducers({
    user:UserReducer,
    nUser:NewUserReducer,
    nItem:NewItemReducer,
    dItem:DeleteItemReducer
})

//this isn't a necessary step for this all to work, but it'll be great for sanity
//imagine we had 50 reducers for 50 different possible object...
//better just store them all in a combineReducer so you only ever have to call one thing