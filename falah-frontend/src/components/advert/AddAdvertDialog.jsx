import React, { useState } from 'react';
import {Button, Dialog,  DialogTitle, DialogContent, DialogContentText,MenuItem, TextField, DialogActions, ThemeProvider} from '@mui/material'
import { addAdvertService } from '../../service/advert';

const AddAdvertDialog = (props) => {

  const types = ['Achat', 'Vente', 'Autre']
  const [successful, setSuccessful] = useState(false);
  const [typeValue, setTypeValue] = useState("")

  const handleChange = (e) => {
    setTypeValue(e.target.value);
};

  const handleSubmit = (event) => {

    addAdvertService(event,setSuccessful);

    props.handleClose()
};

  return (
    <div>
      <Dialog open={props.open} onClose={props.handlecolse}>
        <DialogTitle>Déposer une annonce</DialogTitle>
        <DialogContent>
        <form id="my-form-id" onSubmit={handleSubmit}>
          <TextField
            autoFocus
            margin="dense"
            id="title"
            name="title"
            label="Titre de l'annonce"
            fullWidth
            variant="outlined"
          />
        c
          <TextField
            autoFocus
            margin="dense"
            id="type"
            name="type"
            //value={typeValue}
            //onChange={handleChange}
            label="Type de l'annonce"
            select
            fullWidth
            variant="outlined"
          >
            {types.map((type) => (
            <MenuItem key={type} value={type}>
              {type}
            </MenuItem>
          ))}
            </TextField>
            <div>Télécharger une image</div>
                        <input
                          className="form-control"
                          type="file"
                          id="image"
                          name="image"
                          accept="image/*,application/pdf"
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

export default AddAdvertDialog;


