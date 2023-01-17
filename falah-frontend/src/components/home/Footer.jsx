import React from 'react';
import Grid from "@mui/material/Grid";
import Copyright from "./Copyright"

const Footer = () => {
    return (
        <footer >
        <Grid container backgroundColor="#F5F5F5">
            <Grid item md={5} xs={5}/>
            <Grid item md={3} xs={3}><Copyright title="FALAH"/></Grid>
            <Grid item md={4} xs={4}/>
        </Grid></footer>
    );
};

export default Footer;