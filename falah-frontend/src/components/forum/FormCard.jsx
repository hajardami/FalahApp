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
import { Button, CardActions, ButtonBase, Card, Box , CardContent} from '@mui/material';
import Link from '@mui/material/Link';
import FacebookIcon from '@mui/icons-material/Facebook';
import TwitterIcon from '@mui/icons-material/Twitter';
import InstagramIcon from '@mui/icons-material/Instagram';
import LinkedInIcon from '@mui/icons-material/LinkedIn';
import FavoriteBorderIcon from '@mui/icons-material/FavoriteBorder';
import ChatBubbleOutlineIcon from '@mui/icons-material/ChatBubbleOutline';

const FormCard = () => {
  return (
    <Card sx={{ display: 'inline-flex', width: 850}}>
      <Box sx={{ display: 'flex', flexDirection: 'column' }}>
      <CardContent sx={{ flex: '1 0 auto' , width: 800}}>
      <Typography  variant="h5" component="div" sx={{ wordBreak: "break-word" }}>
            
      <Box sx={{ fontWeight: 'bold', m: 1 }}>test</Box>
          </Typography>
          <Typography variant="body2" color="text.secondary" sx={{ wordBreak: "break-word" }}>
          test
          </Typography>
      </CardContent>
      <Stack direction="row" justifyContent="space-between"
  alignItems="center" sx={{ pl: 1, pb: 1, mr: 2}}>
        <Typography  variant="subtitle2" component="div" xs={{fontWeight:"bold"}}>
        <Box sx={{ fontWeight: 'bold', m: 1 }}>Ahmed Hassani 01/01/2023</Box>
          </Typography>
          <Stack direction="row" justifyContent="space-between"
  alignItems="center" spacing={1}>
    <FavoriteBorderIcon />
    <Typography  variant="body2" component="div" sx={{ wordBreak: "break-word" }}>
            
      <Box sx={{ fontWeight: 'bold', m: 1 }}>3 Likes</Box>
          </Typography>
    <ChatBubbleOutlineIcon />
    <Typography  variant="body2" component="div" sx={{ wordBreak: "break-word" }}>
            
      <Box sx={{ fontWeight: 'bold', m: 1 }}>0 Comments</Box>
          </Typography>
  </Stack>
          
        </Stack>
        </Box>
        </Card>
  );
};

export default FormCard;