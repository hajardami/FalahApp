import axios from "axios";
import { goto } from "./utils";



export function getAllCoaches(setCoaches, createData, setSuccess) {
    // alert("hh")
    console.log("hello")
    axios.get(`http://localhost:8080/api/superuser/listNotVerified`
        , {
            headers: {
                "Authorization": `${localStorage.getItem("currentUser")}`
            }
        }
    ).then(
        (res) => {
            let temp = [];
            for (let i of res.data) {
                temp.push(
                    createData(
                        i.nom_coach,
                        <a href={"http://localhost:8080/api/document/" + i.image}>cliquer ici</a>,
                        <a href={"http://localhost:8080/api/document/" + i.cin}>cliquer ici</a>,
                        <a href={"http://localhost:8080/api/document/" + i.certificate}>cliquer ici</a>,
                        i.id_coach
                    )
                );
            }
            setCoaches(temp);
            setSuccess(true);
            console.log(res.data);
            // alert("hh");
            // goto("/this_link_is_not_yet_defined");
        }
        ,
        (err) => {
            alert("erreur lors de l'acces à vos données, en cas de besoin contacter l'admin");
            console.error(err);
        }
    );
}
export function verifyCoach(id) {
    axios.get(`http://localhost:8080/api/superuser/verifyExpert`
        , {
            headers: {
                "expert_id": id,

                "Authorization": `${localStorage.getItem("currentUser")}`
            }
        }
    ).then(
        (res) => {
            window.location.reload();
        }
        ,
        (err) => {
            alert("veuillez contacter les dévellopeurs");
            console.error(err);
        }
    );
}
export function getId() {
    axios.get(`http://localhost:8080/api/superuser/me`
        , {
            headers: {
                "Authorization": `${localStorage.getItem("currentUser")}`
            }
        }
    ).then(
        (res) => {
            goto(`/NewPassword/${res.data.id}`);
        }
        ,
        (err) => {
            alert(err.response.data.error + "\nveuillez contacter les dévellopeurs");
            console.error(err.response.data);

        }
    );
}
export function getCoachData(setReceived, setFullName, setImage, setEmail, setSpeciality) {
    axios.get(`http://localhost:8080/api/coach/me`
        , {
            headers: {
                "Authorization": `${localStorage.getItem("currentUser")}`
            }
        }
    ).then(
        (res) => {
            setReceived(true);
            setFullName(res.data.firstName + " " + res.data.lastName);
            setImage(res.data.image);
            setEmail(res.data.email);
            setSpeciality(res.data.speciality);
            console.log("res");
            console.log(res.data);
            // alert("hh");
            // goto("/this_link_is_not_yet_defined");
        }
        ,
        (err) => {
            alert("erreur lors de l'acces à vos données, en cas de besoin contacter l'admin");
            console.error(err);
        }
    );
}