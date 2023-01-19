import React from 'react';
import Layout from '../sidebar/Layout';
import { ThemeProvider } from "@mui/material/styles";
import theme from '../../style/theme';
import {Stack, Box, Button, Grid, Typography} from '@mui/material'
import falahlogo from '../../res/images/falahlogo.png';
import Search from '../shared/Search';
import { news } from './news';
import NouveauCard from './NouveauCard';

const Nouveaute = () => {
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
            <Stack spacing={2} sx={{mt : 2, ml : 4, width: 900}}>
            {news.map((news) => <NouveauCard photo={news.image} title={news.title} description={news.description} date = {news.date}/>)}
            </Stack>
        </Box>
        </ThemeProvider>
        </Layout>
        </>
    );
};

export default Nouveaute;