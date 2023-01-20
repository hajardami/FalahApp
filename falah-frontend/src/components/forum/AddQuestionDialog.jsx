import React, { useState } from 'react';
import {Button, Dialog,  DialogTitle, DialogContent, DialogContentText,MenuItem, TextField, DialogActions, ThemeProvider} from '@mui/material'
import { addAdvertService } from '../../service/advert';

const AddQuestionDialog = (props) => {

  const types = ['Achat', 'Vente', 'Autre']
  const [successful, setSuccessful] = useState(false);
  const [typeValue, setTypeValue] = useState("")


  const handleSubmit = (event) => {

    addAdvertService(event,setSuccessful);

    props.handleClose()
};

  return (
    <div>
      <Dialog open={props.open} onClose={props.handlecolse}>
        <DialogTitle>Poser une Question</DialogTitle>
        <DialogContent>
        <form id="my-form-id" onSubmit={handleSubmit}>
          <TextField
            autoFocus
            margin="dense"
            id="title"
            name="title"
            label="Titre"
            fullWidth
            variant="outlined"
          />
          <TextField
            autoFocus
            margin="dense"
            id="description"
            name="description"
            label="Description"
            multiline
            rows={4}
            fullWidth
            variant="outlined"
          />
        </form>
        </DialogContent>
        <DialogActions>
          <Button onClick={props.handleClose} >Annuler</Button>
          <Button type="submit" form="my-form-id" variant="contained">Publier</Button>
        </DialogActions>
      </Dialog>
    </div>
  );
};

export default AddQuestionDialog;


