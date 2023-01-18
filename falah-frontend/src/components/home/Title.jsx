import React from 'react';
import { ThemeProvider } from "@mui/material/styles";
import Typography from '@mui/material/Typography';
import {Stack, Box, Button} from '@mui/material'
import img1 from '../../res/images/img1.png'
import img2 from '../../res/images/img2.png'
import img3 from '../../res/images/img3.png'
import img4 from '../../res/images/img4.png'
import ServiceCard from './ServiceCard';

const services = [
    {
        name: "Forum",
        icon: "forum",
        desc: "Vous trouvez Un forum ouvert pour communiquer et réseauter, demander de l’aide, poser des questions en relation avec l’agriculture"
    },
    {
        name: "Espace annonces",
        icon: "annonce",
        desc: "En Recherche de fournisseurs, partenaire,produit, matériels ,ressources postez votre annonces et vous trouverez ce que vous cherchez"
    },
    {
        name: "Nouveautés",
        icon: "new",
        desc: "Un service de consultation des dernières tendances dans le secteur agricole"
    },
    {
        name: "Expert",
        icon: "expert",
        desc: "Nos experts sont de grand calibre vous aurez la possibilité de prendre contact avec eux"
    }
]

const Title = () => {
    return (
        <ThemeProvider>
             <Stack direction='row' justifyContent='space-between'>
             <img src={img1} alt="logo" width={"200px"} />
            <Typography
                fontSize="70px"
                lineHeight="93px"
                fontWeight="bold"
                left="150px"
                width="630px"
                height="271px"
                align='center'
            >
                FALAH votre espace des annonces Agricole
            </Typography>
            <img src={img2} alt="logo" width={"250px"} />
            </Stack>

            <Typography variant="title" color="inherit" noWrap>
                &nbsp;
            </Typography>
            <Stack direction='row' justifyContent='center'>
            <Typography
                fontSize="25px"
                lineHeight="30px"
                left="150px"
                width="530px"
                align='center'
            >
                Agriculteur, producteurs, fabricants, fournisseurs expert..en agriculture 
            </Typography>
            </Stack>

            <Typography variant="title" color="inherit" noWrap>
                &nbsp;
            </Typography>

            <Stack direction='row' justifyContent='center'>
            <Typography
                fontSize="25px"
                lineHeight="30px"
                left="150px"
                width="530px"
                align='center'
                color="primary"
            >
                Vous cherchez, nous trouvons
            </Typography>
            </Stack>

            <Typography variant="title" color="inherit" noWrap>
                &nbsp;
            </Typography>

            <Stack direction='row' justifyContent='space-evenly' alignItems="flex-start">
                <img src={img3} alt="logo" width={"200px"} />
                <Button href='/signup'variant="contained" sx={{borderRadius : "10px", "&:hover": {backgroundColor: "white", color: "primary.main"}}}>Get Started</Button>
                <img src={img4} alt="logo" width={"200px"} />
            </Stack>

            <Stack direction='row' alignItems="flex-start">
            <Typography variant="title" fontSize="25px"
                lineHeight="30px"
                left="50px"
                width="330px"
                align='center'
                fontWeight="bold"
                color="primary">
                Nos Services
            </Typography>
            </Stack>

            <Stack direction='row' justifyContent='space-evenly' alignItems="flex-start" sx={{mt: -2}} backgroundColor="#F5F5F5">
            <Stack spacing={10} sx={{mt: 10}}>
                
                <ServiceCard name={services[0].name} desc = {services[0].desc} icon = {services[0].icon}/>
                <ServiceCard name={services[1].name} desc = {services[1].desc} icon = {services[1].icon}/>
            
            </Stack>

            <Stack spacing={10}>
            <ServiceCard name={services[2].name} desc = {services[2].desc} icon = {services[2].icon}/>
            <ServiceCard name={services[3].name} desc = {services[3].desc} icon = {services[3].icon}/>
            </Stack>
            </Stack>
            
        </ThemeProvider>
    );
};

export default Title;