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
import AdvertCard from './AdvertCard';

const Item = styled(Paper)(({ theme }) => ({
    backgroundColor: theme.palette.lightblack.main,
    ...theme.typography.body2,
    padding: theme.spacing(1),
    textAlign: 'center',
    color: theme.palette.white.main,
  }));

export default function AdCard({firstname, lastname, title, description, createdat, type, handleShowDetails}) {
  const theme = useTheme();


  return (
      <Card sx={{ display: 'flex', maxWidth: 590}}>
        <ButtonBase
          onClick={() => handleShowDetails({firstname, lastname, title, description, createdat, type})}
      >
        <CardMedia
        component="img"
        sx={{ width: 151 }}
        image={olive}
        alt="Live from space album cover"
      />
      <Box sx={{ display: 'flex', flexDirection: 'column' }}>
      <CardContent sx={{ flex: '1 0 auto' }}>
            <Stack direction="row" justifyContent="space-between">
            <Typography  variant="h5" component="div">
            
            {title}
          </Typography>
          <Item theme={theme}>{type}</Item>
            </Stack>
          <Typography variant="body2" color="text.secondary">
          {description}
          </Typography>
        </CardContent>

        <Stack direction="row" justifyContent="space-between"
  alignItems="center" sx={{ pl: 1, pb: 1, mr: 2}}>
        <Typography  variant="subtitle2" component="div">
            {firstname}  {lastname}
          </Typography>
          <Typography  variant="subtitle2" component="div">
            {createdat}
          </Typography>
        </Stack>
      </Box>
      </ButtonBase>
    </Card>

    
  );
}