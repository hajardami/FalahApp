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

            //console.log("res");
            //console.log(res.data);
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

export function addAdvertService(event, setSuccessful) {
    event.preventDefault();
    const tempData = new FormData(event.currentTarget);
    for (let i of tempData.entries())
        console.log(i);
    let data =  new FormData();
    data.append('title', tempData.get('title'));
    data.append('description', tempData.get('description'));
    data.append('type', tempData.get('type'));
    data.append('emailUser', localStorage.getItem("currentEmail"))
    data.append('image', tempData.get('image'));


    axios.post(`http://localhost:8080/annonces/save.ad`, data
        , {
            headers: {
                "Authorization": `${localStorage.getItem("currentUser")}`
            }
        }
    ).then(
        (res) => {

            setSuccessful(true);
            console.log(res);
            //goto("/offers");
        }
        ,
        (err) => {
            alert(err.response.data.error + "\nerreur lors de l'ajout de l'offre, veuillez reentrer vos données, en cas de besoin contacter l'admin\n" );
            console.error(err);
        }
    );
}