import axios from "axios";
import {goto} from "./utils";

const signUpService = (event,setSuccessful,isExpert) => {
    event.preventDefault();
    const data = new FormData(event.currentTarget);
    if (isExpert)
        createExpert(data,setSuccessful);
    else createClient(data,setSuccessful);
}
const createClient = (data,setSuccessful) => {
    let tempData = new FormData();
    tempData.append("firstName", data.get('firstName'));
    tempData.append("lastName", data.get('lastName'));
    tempData.append("email", data.get('email'));
    tempData.append("password", data.get('password'));
    tempData.append("profession", data.get('profession'));
    tempData.append("image", data.get('image'));
    axios.post(`http://localhost:8080/api/account/create/client`, tempData
    ).then(
        (res) => {

            setSuccessful(true);
            console.log(res);
            goto("/signin");
        }
        ,
        (err) => {
            alert("erreur lors de l'authentification, veuillez reentrer vos données, en cas de besoin contacter l'admin");
            console.error(err);
        }
    );



   
};

const createExpert = (data,setSuccessful) => {
    let tempData = new FormData();
    tempData.append("firstName", data.get('firstName'));
    tempData.append("lastName", data.get('lastName'));
    tempData.append("email", data.get('email'));
    tempData.append("password", data.get('password'));
    tempData.append("profession", data.get('profession'));
    tempData.append("image", data.get('image'));
    tempData.append("expertCertificate", data.get('certificate'));
    tempData.append("identityDocument", data.get('cin'));
    axios.post(`http://localhost:8080/api/account/create/expert`, tempData
    ).then(
        (res) => {

            setSuccessful(true);
            console.log(res);
            goto("/signin");
        }
        ,
        (err) => {
            alert("erreur lors de l'authentification, veuillez reentrer vos données, en cas de besoin contacter l'admin");
            console.error(err);
        }
    );

};



export {signUpService};