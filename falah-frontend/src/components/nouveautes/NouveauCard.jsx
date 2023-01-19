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
import Link from '@mui/material/Link';
import FacebookIcon from '@mui/icons-material/Facebook';
import TwitterIcon from '@mui/icons-material/Twitter';
import InstagramIcon from '@mui/icons-material/Instagram';
import LinkedInIcon from '@mui/icons-material/LinkedIn';

const NouveauCard = ({photo, title, description, date}) => {
    return (
        <Card sx={{ display: 'inline-flex', width: 900}}>
             <CardMedia
                component="img"
                sx={{ width: 151 }}
                image={photo}
        alt="Live from space album cover"
      />
      <Box sx={{ display: 'flex', flexDirection: 'column' }}>
      <CardContent sx={{ flex: '1 0 auto' , width: 700}}>
      <Typography  variant="h5" component="div" sx={{ wordBreak: "break-word" }}>
            
      <Box sx={{ fontWeight: 'bold', m: 1 }}>{title}</Box>
          </Typography>
          <Typography variant="body2" color="text.secondary" sx={{ wordBreak: "break-word" }}>
          {description}
          </Typography>
      </CardContent>
      <Stack direction="row" justifyContent="space-between"
  alignItems="center" sx={{ pl: 1, pb: 1, mr: 2}}>
        <Typography  variant="subtitle2" component="div" xs={{fontWeight:"bold"}}>
        <Box sx={{ fontWeight: 'bold', m: 1 }}>{date}</Box>
          </Typography>
          <Stack direction="row" justifyContent="space-between"
  alignItems="center" spacing={1}>
    <FacebookIcon color="primary" />
    <TwitterIcon color="primary" />
    <InstagramIcon color="primary" />
    <LinkedInIcon color="primary" />
  </Stack>
          
        </Stack>
        </Box>
        </Card>
    );
};

export default NouveauCard;