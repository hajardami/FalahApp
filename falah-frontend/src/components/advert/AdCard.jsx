import * as React from 'react';
import { useTheme } from '@mui/material/styles';
import Box from '@mui/material/Box';
import Card from '@mui/material/Card';
import CardContent from '@mui/material/CardContent';
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
import { Button, CardActions } from '@mui/material';
import Link from '@mui/material/Link'

const Item = styled(Paper)(({ theme }) => ({
    backgroundColor: theme.palette.lightblack.main,
    ...theme.typography.body2,
    padding: theme.spacing(1),
    textAlign: 'center',
    color: theme.palette.white.main,
  }));

export default function AdCard() {
  const theme = useTheme();

  return (
    
    <Card sx={{ display: 'flex', maxWidth: 600}}>
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
            
            Cherche Olivier
          </Typography>
          <Item theme={theme}>Achat</Item>
            </Stack>
          <Typography variant="body2" color="text.secondary">
          bonjour je recherche 200 oliviers de 4ans d'âges pour plantation oliveraie envoyez moi vos tarifs, espèces et modalités. merci Quantite : 200
          </Typography>
        </CardContent>

        <Stack direction="row" justifyContent="space-between"
  alignItems="center" sx={{ pl: 1, pb: 1, mr: 2}}>
        <Typography  variant="subtitle2" component="div">
            Ahmed Hassani
          </Typography>
          <Typography  variant="subtitle2" component="div">
            06 / 01 / 2022
          </Typography>
        </Stack>
      </Box>
    </Card>
  );
}