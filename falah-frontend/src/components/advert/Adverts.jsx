import React from 'react';
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

const Adverts = () => {
    const [open, setOpen] = React.useState(false);

    const handleClickOpen = () => {
        setOpen(true);
    };

    const handleClose = () => {
        setOpen(false);
    };

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
            <Stack spacing={2}>
                <AdCard/>
                <AdCard/>
            </Stack>
            </Box>
        </ThemeProvider>
    );
};

export default Adverts;

/*<Grid container spacing={2}>
                <Grid item>
                    <AdvertCard/>
                </Grid>
                <Grid item>
                    <AdvertCard/>
                </Grid>
                <Grid item>
                    <AdvertCard/>
                </Grid>
                <Grid item>
                    <AdCard/>
                </Grid>
            
            </Grid>*/