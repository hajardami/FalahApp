import React from 'react';
import {Card, CardContent, Button} from '@mui/material'
import Typography from '@mui/material/Typography';
import QuestionAnswerIcon from '@mui/icons-material/QuestionAnswer';
import CampaignIcon from '@mui/icons-material/Campaign';
import FiberNewIcon from '@mui/icons-material/FiberNew';
import HowToRegIcon from '@mui/icons-material/HowToReg';



const ServiceCard = (props) => {

    function renderSwitch(param) {
        switch (param) {
            case "forum":
                return <QuestionAnswerIcon color="primary" style={{ fontSize: 50 }}/>
            case "annonce":
                return <CampaignIcon color="primary" style={{ fontSize: 50 }}/>
            case "new":
                return <FiberNewIcon color="primary" style={{ fontSize: 50 }}/>
            case "expert":
                return <HowToRegIcon color="primary" style={{ fontSize: 50 }}/>
            default:
                break;
        }
    }

    return (
    <Card sx={{ minWidth: 275, maxWidth: 300, p:2}}>
      <CardContent >
      {renderSwitch(props.icon)}
        <Typography variant="h5" component="div" color="primary">
          {props.name}
        </Typography>
        <Typography variant="body2">
        {props.desc}
        </Typography>
      </CardContent>
    </Card>
    );
};

export default ServiceCard;