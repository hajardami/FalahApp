import React from 'react';
import {Container} from '@mui/material'
import { ThemeProvider } from "@mui/material/styles";
import theme from '../../style/theme';
import Button from '@mui/material/Button';
import Appbar from './Appbar';
import Title from './Title';
import Footer from './Footer';

const Home = () => {
    return (
        <ThemeProvider theme={theme}>
            <Container maxWidth="xl">
            <Appbar/>
            <Title/>
            <Footer/>
            </Container>
        </ThemeProvider>
        
    );
};

export default Home;