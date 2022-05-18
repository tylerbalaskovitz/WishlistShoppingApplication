import React, { useState } from "react"
import { useDispatch, useSelector } from "react-redux";

import "./Home.css"

export const Home: React.FC<any> = () => {

    const appState = useSelector<any, any>((state) => state)

    const dispatch = useDispatch();


    return(

        <>
        <div className="home-page">
            <div className="home-container">
               <h3> HOME</h3>
            </div>
        </div>
       

       
        </>
    );
}