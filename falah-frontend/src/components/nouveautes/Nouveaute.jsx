import React, { useEffect, useState } from 'react';
import Layout from '../sidebar/Layout';
import { ThemeProvider } from "@mui/material/styles";
import theme from '../../style/theme';
import {Stack, Box, Button, Grid, Typography} from '@mui/material'
import falahlogo from '../../res/images/falahlogo.png';
import Search from '../shared/Search';
import { news } from './news';
import NouveauCard from './NouveauCard';
import { getAllNews } from '../../service/nouveautes';

const Nouveaute = () => {

    let [nouveautes, setNouveautes] = useState({data : ""});
         useEffect(() => {
             return () => {
                    getAllNews(setNouveautes);
             };
         },[nouveautes.data]);

    return (
        <><Layout>
        <ThemeProvider theme={theme}>
        <Box pb={10}>
            <Stack direction="row" justifyContent="flex-start" alignItems="center" spacing={25}>
            <img src={falahlogo} alt="logo" width={"200px"} />
            <Typography
                fontSize="30px"
                lineHeight="93px"
                fontWeight="bold"
            >
                Nouveautés
            </Typography>
            </Stack>
            <Search/>
            {nouveautes.data === "" ? <h1>loading</h1> :
            <Stack spacing={2} sx={{mt : 2, ml : 4, width: 900}}>
            {nouveautes.data.map((news) => <NouveauCard photo={"http://localhost:8080/api/document/"+news.image} title={news.title} description={news.description} date = {news.createdat.slice(0,10)}/>)}
            </Stack>
}
        </Box>
        </ThemeProvider>
        </Layout>
        </>
    );
};

export default Nouveaute;