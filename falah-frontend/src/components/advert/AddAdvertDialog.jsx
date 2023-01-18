import React from 'react';
import {Button, Dialog, DialogTitle, DialogContent, DialogContentText,MenuItem, TextField, DialogActions, ThemeProvider} from '@mui/material'

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
            variant="outlined"
          />
          <TextField
            autoFocus
            margin="dense"
            id="name"
            label="Description de l'annonce"
            type="email"
            multiline
            fullWidth
            variant="outlined"
          />
          <TextField
            autoFocus
            margin="dense"
            id="name"
            label="Type de l'annonce"
            type="email"
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
                          class="form-control"
                          type="file"
                          id="cin"
                          name="cin"
                          accept="image/*,application/pdf"
                        />
        </DialogContent>
        <DialogActions>
          <Button onClick={props.handleClose} >Annuler</Button>
          <Button onClick={props.handleClose} variant="contained">Publier</Button>
        </DialogActions>
      </Dialog>
    </div>
  );
};

export default AddAdvertDialog;