import React from 'react';
import {Button, Grid,Dialog, DialogTitle, DialogContent, DialogContentText,MenuItem, TextField, DialogActions, ThemeProvider} from '@mui/material'

const ContactDialog = (props) => {


  return (
    <div>
      <Dialog open={props.open} onClose={props.handlecolse}>
        <DialogTitle>Bienvenue Contact moi pour plus d'information</DialogTitle>
        <DialogContent>
      <Grid> <Grid xs={6}> 
      <Button >{props.email}</Button>
</Grid><Grid xs={6}>
<Button  >{props.numero}</Button>

    </Grid></Grid>
        </DialogContent>
        <DialogActions>
          <Button onClick={props.handleClose} >Annuler</Button>
        </DialogActions>
      </Dialog>
    </div>
  );
};

export default ContactDialog;