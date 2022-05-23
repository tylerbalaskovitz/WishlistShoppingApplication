import React, {useState, useEffect} from 'react'
import { useDispatch, useSelector } from "react-redux"
import { useNavigate } from "react-router-dom"
import { deleteItem} from "../../actions/DeleteAction"
import axios from 'axios'
import "./ViewWishlist.css"
import { dItem } from '../../store/types'
import { AppState } from '../../store/types'


export const ViewWishlist: React.FC<any> = (get:any) => {
    //instantiating a new dispatch object so we can send data to the database.
    let dispatch = useDispatch();
    const appState = useSelector<any, any>((state) => state);
    const [loading, setLoading] = useState(false);
    //When constructing set data, and doing a useState for data coming in an array
    //make sure that the useState is ALSO in an array with ANY type of data to go into it.
    const [data, setData] = useState<any[]>([])

    
    
    useEffect(() => {
        setLoading(true);
        axios({
            method:"GET",
            url: "http://localhost:5500/userwishlist/" + appState.user.id
            //when the promise is finished do the then statement
            //like an if then.
        }).then(res=> {
            console.log(appState.user.id);
            setData(res.data)
            //the setState setData is setting the state of res being put into the function and the data grabbed from the axios call of the url using the GET method.


        }).catch(e=>console.log(e))
        .finally(()=> setLoading(false));
        //catching if an error appears via logging the error e, and then loading will be set to false and the url will NOT be grabbed.

    },[])



    
    const navigate = useNavigate();

    
    let deleteProduct =async (productId: any) => {
        //this is where we'll call appstate
        let dItem = {
            product_id: productId, 
        }
        console.log(dItem.product_id);
    await dispatch(
        deleteItem(dItem) as any
        //these are the states that were changed with handleChange
        //we need "as any" to make it so that the return type can be any type
    )
   }

   let logout= () => {
    appState.user.id = 0
    navigate("/")
   }
   
    return (
       <>
       <div className = "background">
       <div className="Navigation bar">
       <button onClick={logout}>Log Out</button>
       </div>
        <div className = "banner-image"></div>
       <div className="products-container">

        {data.map((product)=> (
            
            <div key={product.id} className="card">
            <div><img src={product.image} alt="#"/></div> 
            <div className="card-description">
            <h6>{product.title}</h6>
            <h6>{`Price: ${product.price}`}</h6>
            <h6>{`Category: ${product.category}`}</h6>
            <button className = "deleteButton" onClick={() => deleteProduct(product.product_id)}>Remove From Wishlist</button>
            
            </div>
            </div>
        ))} 
        </div> 
        </div>
    
            </>
    );
};

