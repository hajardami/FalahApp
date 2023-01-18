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

const Item = styled(Paper)(({ theme }) => ({
    backgroundColor: theme.palette.lightblack.main,
    ...theme.typography.body2,
    padding: theme.spacing(1),
    textAlign: 'center',
    color: theme.palette.white.main,
  }));

const AdvertCard = () => {
    return (
    <ThemeProvider theme={theme}>
    <Card sx={{ maxWidth: 345, mt: 5, ml:10}}>
      <CardActionArea>
      <CardHeader
        avatar={
          <Avatar sx={{ bgcolor: red[500] }} aria-label="recipe">
            A
          </Avatar>
        }
        title="Ahmed Hassani"
        subheader="September 14, 2016"
      />
        <CardMedia
          component="img"
          height="160"
          image={olive}
          alt="green iguana"
        />
        <CardContent>
            <Stack direction="row" justifyContent="space-between">
            <Typography  variant="h5" component="div">
            Cherche Olivier
          </Typography>
          <Item theme={theme}>Achat</Item>
            </Stack>
          <Typography variant="body2" color="text.secondary">
          bonjour je recherche 200 oliviers de 4ans d'âges pour plantation oliveraie envoyez moi vos tarifs, espèces et modalités. merci Quantite : 200
          </Typography>
        </CardContent>
      </CardActionArea>
      <CardActions>
      <Button variant="contained" size="small" color="primary" startIcon={<PersonIcon />}>
        Voir ses coordonnées
      </Button>
        
      </CardActions>
    </Card>
    </ThemeProvider>
    );
};

export default AdvertCard;