import React from 'react';
import Layout from '../sidebar/Layout';
import { ThemeProvider } from "@mui/material/styles";
import theme from '../../style/theme';
import {Stack, Box, Button, Grid, Typography} from '@mui/material'
import falahlogo from '../../res/images/falahlogo.png';
import Search from '../shared/Search';
import FormCard from './FormCard';
import HelpIcon from '@mui/icons-material/Help';
import AddQuestionDialog from './AddQuestionDialog';

const Forum = () => {


    const [open, setOpen] = React.useState(false);
    const handleClickOpen = () => {
        setOpen(true);
    };

    const handleClose = () => {
        setOpen(false);
    };

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
                Forum
            </Typography>
            </Stack>
            <Stack direction="row" justifyContent="flex-start" alignItems="center" spacing={10}>
            <Search/>
            <Button variant="contained" size="small" color="primary" onClick={handleClickOpen} startIcon={<HelpIcon />}>
        Poser une question</Button>
        <AddQuestionDialog open={open} handleClose={handleClose}/>
            </Stack>
            <Stack spacing={2} sx={{mt : 2, ml : 4, width: 900}}>
            <FormCard/>
            </Stack>
        </Box>
        </ThemeProvider>
        </Layout>
        </>
    );
};

export default Forum;