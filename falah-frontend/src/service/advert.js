import axios from "axios";

export function getAllAdverts( setAdverts){//
    axios.get(`http://localhost:8080/annonces/adverts`
        , {
            headers: {
                "Authorization": `${localStorage.getItem("currentUser")}`
            }
        }
    ).then(
        async (res) => {

            console.log("res");
            console.log(res.data);
            setAdverts({data: res.data});

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