import React, { useEffect, useState } from "react"
import { useDispatch, useSelector } from "react-redux"
import { useNavigate } from "react-router-dom"
import { createUser } from "../../actions/NewUserAction"

import "./CreateUser.css"

export const CreateUser: React.FC<any> = (post:any) => {

    //this is how we access the state in the store. The data in the universal data file.
    const appState = useSelector<any, any>((state) => state);

    //we need this object to actually dispatch data to our store
    const dispatch = useDispatch();
    
    //useState hooks to declare a state object, a mutator (which changed state), and a default value
    let [username, setUsername] = useState('');
    let [password, setPassword] = useState('');
    let [firstname, setFirstName] = useState ('');
    let [lastname, setLastName] = useState ('');
    let [email, setEmail] = useState ('');
    //we'll use this object to switch components whenever appropriate
    //this is what lets us navigate through the application through button clicks, etc.
    const navigate = useNavigate();

    //when user updates the username/password field, this function is called
    //when user updates the values whichever is being updated changes
    //this is how we can send a username/password object to the CreateUser Action
    const handleChange = (e:any) => {
        if(e.target.name === "username"){ //if the input is name=username...
            setUsername(e.target.value) //set username to be the value that was inserted
            console.log(username)
        } else if (e.target.name === "password"){
            setPassword(e.target.value)
            console.log(password)
        } else if (e.target.name === "firstname"){
            setFirstName(e.target.value)
        } else if (e.target.name === "lastname"){
            setLastName(e.target.value)
        }else {
            setEmail(e.target.value)
            console.log(email)
        }
    }

    //login functionality. we take the state objects and send them to the creatueUser Action
    //sending the data, aka dispatching the data
    console.log("outside createuser")
    const newUser = async () => {
        console.log("inside createuser")
        await dispatch(
            //we were calling nothing here so no action was taken,
            //even though dispatch expected one
            createUser({username, password, firstname, lastname, email}) as any
            //these are the states that were changed with handleChange
            //we need "as any" to make it so that the return type can be any type
        )
        console.log("after dispatch")
    }

    //useEffect hook that runs when appState changes
    //based on whether the user successfully logged in, change the page or do nothing
    useEffect(() => {
        if(appState.user.id > 0){
            navigate("/home"); //thanks to Routing in the App.tsx, this will switch the component.
        }
    }, [appState])


    return(
        <div className="createNewUser">

            <div className="text-container">
               
                <div className="input-container">
                    <input type="text" name="username" placeholder="username" onChange={handleChange}/>
                </div>
                <div className="input-container">
                    <input type="password" name="password" placeholder="password" onChange={handleChange}/>
                </div>
                <div className="input-container">
                    <input type="text" name="firstname" placeholder="firstname" onChange={handleChange}/>
                </div>
                <div className="input-container">
                    <input type="text" name="lastname" placeholder="lastname" onChange={handleChange}/>
                </div>
                <div className="input-container">
                    <input type="text" name="email" placeholder="email" onChange={handleChange}/>
                </div>
            
                <button className="createUSerbutton" onClick={newUser}>Create New User</button> 

                </div>  

        </div>
       
       
    )
}