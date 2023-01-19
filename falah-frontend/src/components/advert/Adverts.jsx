import React, { useEffect, useState } from 'react';
import AdvertCard from './AdvertCard';
import Typography from '@mui/material/Typography';
import { styled, alpha } from '@mui/material/styles';
import {Stack, Box, Button, Grid} from '@mui/material'
import falahlogo from '../../res/images/falahlogo.png';
import InputBase from '@mui/material/InputBase';
import SearchIcon from '@mui/icons-material/Search';
import Search from '../shared/Search';
import EditIcon from '@mui/icons-material/Edit';
import { ThemeProvider } from "@mui/material/styles";
import theme from '../../style/theme';
import { Grid3x3 } from '@mui/icons-material';
import AddAdvertDialog from './AddAdvertDialog';
import AdCard from './AdCard';
import { getAllAdverts } from '../../service/advert';

const ads  = [
    {
        "title" : "Cherche Olivier",
        "type" : "Achat",
        "description" : "bonjour je recherche 200 oliviers de 4ans d'âges pour plantation oliveraie envoyez moi vos tarifs, espèces et modalités. merci Quantite : 200",
        "createdat" : "06/01/2022",
        "firstname" : "Ahmed Hassani"
    },

    {
        "title" : "Huile d'argan",
        "type" : "Vente",
        "description" : "je vends l'huile d'argan ou l'huile d'argane est une huile végétale produite à partir des fruits de l'arganier...",
        "createdat" : "19/01/2023",
        "firstname" : "Ahmed Hassani"
    }
]


const Adverts = () => {

    let [adverts, setAdverts] = useState({data : ""});
         useEffect(() => {
             return () => {
                    getAllAdverts(setAdverts);
             };
         },[adverts.data]);

    const [open, setOpen] = React.useState(false);

    const[shown, setShown] = useState(false);

    const [advert, setAdvert] = useState({})

    const handleClickOpen = () => {
        setOpen(true);
    };

    const handleClose = () => {
        setOpen(false);
    };

    const handleShowDetails = (ad) => {
        setShown(true)
        setAdvert(ad)
    }

    return (
        <ThemeProvider theme={theme}>
            <Box pb={10}>
            <Stack direction="row" justifyContent="flex-start" alignItems="center" spacing={25}>
            <img src={falahlogo} alt="logo" width={"200px"} />
            <Typography
                fontSize="30px"
                lineHeight="93px"
                fontWeight="bold"
            >
                Page des annonces
            </Typography>
            </Stack>
            <Stack direction="row" justifyContent="flex-start" alignItems="center" spacing={10}>
            <Search/>
            <Button variant="contained" size="small" color="primary" startIcon={<EditIcon />} onClick={handleClickOpen}>
        Déposer une annonce</Button>
        <AddAdvertDialog open={open} handleClose={handleClose}/>
            </Stack>
            </Box>
            <Box pl={1}>
            <Grid container alignItems="flex-start">
            <Grid container xs={12} sm={7} lg={6}>
            {adverts.data === "" ? <h1>loading</h1> : 
            <Stack spacing={2}>
                {adverts.data.map((advert) => <AdCard firstname={advert.firstname} lastname={advert.lastname} type={advert.type} description={advert.description} createdat={advert.createdat} title={advert.title} handleShowDetails={handleShowDetails}/>)}
            
            </Stack>
            }
            </Grid>
            <Grid container item xs={12} sm={5} lg={5}>
              {shown ? <AdvertCard firstname={advert.firstname} lastname={advert.lastname} type={advert.type} description={advert.description} createdat={advert.createdat} title={advert.title}/> : <div></div>}  
            </Grid>
            </Grid>
            
            </Box>
        </ThemeProvider>
    );
};

export default Adverts;

