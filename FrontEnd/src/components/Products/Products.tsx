import React, {useState, useEffect} from 'react'
import { useDispatch, useSelector } from "react-redux"
import { useNavigate } from "react-router-dom"
import axios from 'axios'

export const Products: React.FC<any> = () => {

    const [loading, setLoading] = useState(false);
    const [data, setData] = useState<any[]>([])

    useEffect(() => {
        setLoading(true);
        axios({
            method:"GET",
            url: "https://fakestoreapi.com/products"
            //when the promise is finished do the then statement
            //like an if then.
        }).then(res=> {
            console.log();
            setData(res.data)
            //the setState setData is setting the state of res being put into the function and the data grabbed from the axios call of the url using the GET method.


        }).catch(e=>console.log(e))
        .finally(()=> setLoading(false));
        //catching if an error appears via logging the error e, and then loading will be set to false and the url will NOT be grabbed.

    },[])




    return (
        <div className="products-container">Products
        
        
        
        
        
        {data.map((product)=> (
            <div key={product.id} className="card">
            <div><img src={product.image} alt="#"/></div> 
            <div className="card-description">
            <h6>{product.title}</h6>
            <h6>{`Price: ${product.price}`}</h6>
            <h6>{`Category: ${product.category}`}</h6>
            
            </div>
            </div>
        ))}
        </div> 

    


    );
};




