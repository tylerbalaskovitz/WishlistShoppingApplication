//the types file in our store is going to store all the possible types (objects) we will need

//declaring some types with default values as interfaces
export interface IUser {
    id: number;
    username: string;
    password: string;
}
export interface NUser {
   // ; May need to be deleted
   
   username: string;
    password: string;
    firstname: string;
    lastname: string;
    email: string;

}

//AppState object that will store one of each interface.
//note the type keyword... it's like calling something an object in java
export type AppState = {
    user: IUser, //one empty user object
    nUser: NUser,
}

//separating values by commas here, because it's an object not an interface