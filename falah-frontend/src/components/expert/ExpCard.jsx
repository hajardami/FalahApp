import * as React from 'react';
import { useTheme } from '@mui/material/styles';
import Box from '@mui/material/Box';
import Card from '@mui/material/Card';
import CardContent from '@mui/material/CardContent';
import Grid from '@mui/material/Grid';
import CardMedia from '@mui/material/CardMedia';
import IconButton from '@mui/material/IconButton';
import Typography from '@mui/material/Typography';
import SkipPreviousIcon from '@mui/icons-material/SkipPrevious';
import PlayArrowIcon from '@mui/icons-material/PlayArrow';
import SkipNextIcon from '@mui/icons-material/SkipNext';
import Stack from '@mui/material/Stack'
import olive from '../../res/images/olive.png';
import Paper from '@mui/material/Paper';
import { styled } from '@mui/material/styles';
import { Button, CardActions, ButtonBase } from '@mui/material';
import Link from '@mui/material/Link'
import ExpertCard from './ExpertCard';

const Item = styled(Paper)(({ theme }) => ({
    backgroundColor: "#007155",
    ...theme.typography.body2,
    padding: theme.spacing(1),
    textAlign: 'center',
    color: theme.palette.white.main,
  }));

export default function ExpCard({name, profession, description,contact,image, email,numero,handleShowDetails,}) {
  const theme = useTheme();


  return (
      <Card sx={{ display: 'flex', maxWidth: 590 ,minWidth:500}}>
        <ButtonBase
          onClick={() => handleShowDetails({name, profession, description,contact,image,email,numero})}
      >

        <CardMedia
        component="img"
        sx={{ width: 151 }}
        image={image}
        alt="Expert"
      />
       
      <Box sx={{ display: 'flex', flexDirection: 'column' }}>
      <CardContent sx={{ flex: '1 0 auto' }}>
            <Stack direction="row" justifyContent="space-between"   spacing={12}
>
            <Typography  variant="h5" component="div">
            {name} 
          </Typography>
          <Item theme={theme}>{profession}</Item>
            </Stack>
          <Typography variant="body2" color="text.secondary">

         </Typography>
        </CardContent>

        <Stack direction="row" justifyContent="space-between"
  alignItems="center" sx={{ pl: 1, pb: 1, mr: 2}}>
        <Typography  variant="subtitle2" component="div">
        N'hésitez pas à me contacter!
          </Typography>
          <Typography  variant="subtitle2" component="div">
          </Typography>
        </Stack>
      </Box>
      </ButtonBase>
    </Card>

    
  );
}