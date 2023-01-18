import React from 'react';
import {Button, Dialog, DialogTitle, DialogContent, DialogContentText,MenuItem, TextField, DialogActions} from '@mui/material'

const AddAdvertDialog = (props) => {

  const types = ['Achat', 'Vente', 'Autre']

  return (
    <div>
      <Dialog open={props.open} onClose={props.handlecolse}>
        <DialogTitle>Déposer une annonce</DialogTitle>
        <DialogContent>
          <TextField
            autoFocus
            margin="dense"
            id="name"
            label="Titre de l'annonce"
            type="email"
            fullWidth
            variant="standard"
          />
          <TextField
            autoFocus
            margin="dense"
            id="name"
            label="Description de l'annonce"
            type="email"
            multiline
            fullWidth
            variant="standard"
          />
          <TextField
            autoFocus
            margin="dense"
            id="name"
            label="Type de l'annonce"
            type="email"
            select
            fullWidth
            variant="standard"
          >
            {types.map((type) => (
            <MenuItem key={type} value={type}>
              {type}
            </MenuItem>
          ))}
            </TextField>
        </DialogContent>
        <DialogActions>
          <Button onClick={props.handleClose}>Annuler</Button>
          <Button onClick={props.handleClose}>Publier</Button>
        </DialogActions>
      </Dialog>
    </div>
  );
};

export default AddAdvertDialog;