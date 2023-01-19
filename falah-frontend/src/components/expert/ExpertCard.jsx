import React from 'react';
import Card from '@mui/material/Card';
import CardContent from '@mui/material/CardContent';
import CardMedia from '@mui/material/CardMedia';
import {CardHeader, Avatar} from '@mui/material'
import Typography from '@mui/material/Typography';
import { red } from '@mui/material/colors';
import MoreVertIcon from '@mui/icons-material/MoreVert';
import Paper from '@mui/material/Paper';
import { styled } from '@mui/material/styles';
import theme from '../../style/theme';
import PersonIcon from '@mui/icons-material/Person';
import { Button, CardActionArea, CardActions, IconButton, Stack } from '@mui/material';
import olive from '../../res/images/olive.png';
import { ThemeProvider } from "@mui/material/styles";
import ContactDialog from "./ContactDialog";
import { useEffect, useState } from 'react';

const Item = styled(Paper)(({ theme }) => ({
    backgroundColor: theme.palette.lightblack.main,
    ...theme.typography.body2,
    padding: theme.spacing(1),
    textAlign: 'center',
    color: theme.palette.white.main,
  }));

const ExpertCard = ({name, profession, description,contact,image,email,numero}) => {
  
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
    <Card sx={{ maxWidth: 545,minWidth:500 ,minHeight:400}}>
      <CardActionArea>
      <CardHeader
        avatar={
          <Avatar sx={{ bgcolor: red[500] }} aria-label="recipe">
            A
          </Avatar>
        }
        title={name}
       
      />
        <CardMedia
          component="img"
          image={image}
          alt="green iguana"
           height="360"
         width="360"

        />
        <CardContent>
            <Stack direction="row" justifyContent="space-between">
            <Typography  variant="h5" component="div">
            {profession}
          </Typography>
          <Item theme={theme}>{profession}</Item>
            </Stack>
          <Typography variant="body2" color="text.secondary">
          {description}
          </Typography>
        </CardContent>
      </CardActionArea>
      <CardActions>
      <Button variant="contained" size="small" color="primary"  startIcon={<PersonIcon /> } onClick={handleClickOpen}>
       Contactez-moi
      </Button>
      <ContactDialog open={open} handleClose={handleClose} email={email} numero={numero} />

        
      </CardActions>
    </Card>
    </ThemeProvider>
    );
};

export default ExpertCard;